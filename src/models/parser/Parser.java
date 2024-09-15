package models.parser;

import models.tokens.Token;
import models.nodes.BinaryOpNode;
import models.nodes.Node;
import models.nodes.NumberNode;
import models.tokens.TokenTypes;

import java.util.ArrayList;
import java.util.Objects;

public class Parser {

    private final ArrayList<Token> tokens;
    private int tokenIndex;
    private Token currentToken;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.tokenIndex = -1;
        advance();
    }


    public Node parse(){
        Node result = expression();

        return result;
    }

    /**
    * Advances the parser to the next token in the list of models.tokens, each token represents a part of an expression
    * @return the current token that is selected.
    * */
    private Token advance() {
        tokenIndex++;
        if (tokenIndex < tokens.size()) {
            currentToken = tokens.get(tokenIndex);
        } else {
            // No more models.tokens left
            currentToken = null;
        }
        return currentToken;
    }

    /**
     * Responsible for handling numbers (int and float)
     * @return a numberNode (representing a number in the syntax tree)
     * */
    private Node factor(){
        if(currentToken == null) {
            return null;
        }
        if(Objects.equals(currentToken.getType(), TokenTypes.TT_FLOAT) || Objects.equals(currentToken.getType(), TokenTypes.TT_INT)) {
            Token token = currentToken;
            advance();
            return new NumberNode(token);
        }
        return null;
    }

    /**
     * Handles multiplication and division operations.
     * @return a Node representing the term.
     * If no multiplication or division is present, it returns a simple NumberNode. Otherwise, it returns a BinaryOpNode that represents the multiplication or division operation.
     * */
    private Node term() {
        Node left = factor();  // Start with a factor (e.g., a number)

        while (currentToken != null && (Objects.equals(currentToken.getType(), TokenTypes.TT_MUL) ||
                Objects.equals(currentToken.getType(), TokenTypes.TT_DIV))) {
            Token operatorToken = currentToken;
            advance();
            Node right = factor();

            if (right == null) {
                break;
            }

            left = new BinaryOpNode(left, operatorToken, right);
        }

        return left;
    }

    /**
     * Handles addition and subtraction operations.
     * @return a Node representing the expression.
     * If no addition or subtraction is present, it returns the result of <b>term()</b>. Otherwise, it returns a BinaryOpNode that represents the entire expression.
     * */
    private Node expression() {
        Node left = term();

        while (currentToken != null && (Objects.equals(currentToken.getType(), TokenTypes.TT_PLUS) ||
                Objects.equals(currentToken.getType(), TokenTypes.TT_MINUS))) {
            Token operatorToken = currentToken;
            advance();
            Node right = term();

            if (right == null) {
                break;
            }

            left = new BinaryOpNode(left, operatorToken, right);
        }

        return left;
    }
}
