package models.nodes;

import models.tokens.Token;

public class NumberNode extends Node {

    private final Token token;

    public NumberNode(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token.toString();
    }
}
