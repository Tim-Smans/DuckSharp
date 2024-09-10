import tokens.TokenResult;

public class DuckSharp {

    public TokenResult run(String text, String fileName){
        Lexer lexer = new Lexer(text, fileName);

        return lexer.makeTokens();
    }
}
