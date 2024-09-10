import models.Position;
import models.Token;
import models.errors.Error;
import models.errors.IllegalCharError;
import tokens.TokenResult;
import utils.Constants;
import tokens.TokenTypes;

import java.util.ArrayList;
import java.util.Arrays;

public class Lexer {

    private final String text;
    private Position pos;
    private Character currentChar;

    public Lexer(String text, String fileName) {
        this.text = text;
        this.pos = new Position(0, 0, -1, fileName, text);
        this.currentChar = null;
        advance();
    }

    public TokenResult makeTokens() {
        ArrayList<Token> tokens = new ArrayList<>();

        while(currentChar != null){
            if(currentChar == ' ' || currentChar == '\t'){
                advance();


            } else if (inDigits()) {
                tokens.add(makeNumbers());
            } else if (currentChar == '+') {
                tokens.add(new Token(TokenTypes.TT_PLUS));
                advance();
            }else if (currentChar == '-') {
                tokens.add(new Token(TokenTypes.TT_MINUS));
                advance();
            }else if (currentChar == '*') {
                tokens.add(new Token(TokenTypes.TT_MUL));
                advance();
            }else if (currentChar == '/') {
                tokens.add(new Token(TokenTypes.TT_DIV));
                advance();
            }else if (currentChar == '(') {
                tokens.add(new Token(TokenTypes.TT_LPAREN));
                advance();
            }else if (currentChar == ')') {
                tokens.add(new Token(TokenTypes.TT_RPAREN));
                advance();
            }else{
                //Catch the error
                Position posStart = pos.copy();
                String character = String.valueOf(currentChar);
                advance();
                Error error = new IllegalCharError(posStart, pos,"'" + character + "' is not a valid character");
                return new TokenResult(new ArrayList<>(), error);
            }
        }

        return new TokenResult(tokens, null);
    }

    private void advance() {
        pos.advance(currentChar);

        if (pos.getIndex() < text.length()) {
            currentChar = text.charAt(pos.getIndex());
        } else {
            currentChar = null;
        }
    }
    private Token makeNumbers(){
        StringBuilder numStr = new StringBuilder();
        int dotCount = 0;

        while(currentChar != null && (inDigits() || currentChar == '.')){
            if(currentChar == '.'){
                if(dotCount == 1) {
                    break;
                }
                dotCount++;
                numStr.append(".");
            }else{
                numStr.append(currentChar);
            }

            advance();
        }
        if(dotCount == 1){
            return new Token(TokenTypes.TT_FLOAT, Float.parseFloat(numStr.toString()));
        }else{
            return new Token(TokenTypes.TT_INT, Integer.parseInt(numStr.toString()));
        }
    }
    private boolean inDigits(){
        return Arrays.asList(Constants.DIGITS).contains(currentChar);
    }
}
