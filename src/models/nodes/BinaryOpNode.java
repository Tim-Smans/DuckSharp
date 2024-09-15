package models.nodes;

import models.tokens.Token;

public class BinaryOpNode extends Node {

    private final Node leftNode, rightNode;
    private final Token operatorToken;

    public BinaryOpNode(Node leftNode, Token operatorToken, Node rightNode) {
        this.operatorToken = operatorToken;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "(" + leftNode.toString() + ", " + operatorToken.toString() + ", " + rightNode.toString() + ")";
    }
}
