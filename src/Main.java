import models.tokens.TokenResult;

public class Main {
    public static void main(String[] args) {

        DuckSharp duck = new DuckSharp();

        while(true){
            System.out.print("DuckSharp: ");
            String input = System.console().readLine();

            TokenResult tokenResult = duck.run(input, "test");
        }
    }
}