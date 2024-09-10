package tokens;

import models.Token;
import models.errors.Error;

import java.util.ArrayList;

public class TokenResult {
    private final ArrayList<Token> tokens;
    private final Error error;

    public TokenResult(ArrayList<Token> tokens, Error error) {
        this.tokens = tokens;
        this.error = error;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public Error getError() {
        return error;
    }
}
