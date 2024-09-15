import models.parser.Parser;
import models.tokens.Token;
import models.errors.Error;
import models.nodes.Node;
import models.tokens.TokenResult;

import java.util.ArrayList;

public class DuckSharp {

    public TokenResult run(String text, String fileName){
        Lexer lexer = new Lexer(text, fileName);

        TokenResult tokenResult = lexer.makeTokens();
        ArrayList<Token> tokens = tokenResult.getTokens();
        Error error = tokenResult.getError();

        //Generate the AST:
        Parser parser = new Parser(tokens);
        Node ast = parser.parse();

        if(error != null){
            System.out.println(error);
            return null;
        }

        System.out.println(ast.toString());

        return tokenResult;
    }
}
