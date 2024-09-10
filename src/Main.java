import models.Token;
import models.errors.Error;
import tokens.TokenResult;

import java.io.Console;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DuckSharp duck = new DuckSharp();

        while(true){
            System.out.print("DuckSharp: ");
            String input = System.console().readLine();

            TokenResult tokenResult = duck.run(input, "test");
            ArrayList<Token> tokens = tokenResult.getTokens();
            Error error = tokenResult.getError();

            if(error != null){
                System.out.println(error);
                return;
            }

            System.out.println(tokens);
        }
    }
}