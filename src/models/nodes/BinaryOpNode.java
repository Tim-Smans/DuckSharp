package models.nodes;

import models.Token;

public class BinaryOpNode {

    private final NumberNode leftNode, rightNode;
    private final Token operatorToken;

    public BinaryOpNode(Token operatorToken, NumberNode leftNode, NumberNode rightNode) {
        this.operatorToken = operatorToken;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "(" + leftNode.toString() + ", " + operatorToken.toString() + ", " + rightNode.toString() + ")";
    }
}
