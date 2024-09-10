package models.nodes;

import models.Token;

public class NumberNode {

    private final Token token;

    public NumberNode(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token.toString();
    }
}
