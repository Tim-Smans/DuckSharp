package models.tokens;

import models.Position;

public class Token {

    private final String type;
    private final Object value;
    private Position startPos;
    private Position endPos;

    public Token(String type, Object value, Position startPos, Position endPos) {
        this.type = type;
        this.value = value;
        if(startPos != null) {
            this.startPos = startPos.copy();
            this.endPos = endPos.copy();
            this.endPos.advance(null);
        }
        if(endPos != null) {
            this.endPos = endPos;
        }
    }

    public Token(String type) {
        this(type, null, null, null);
    }


    public String getType() {
        return type;
    }
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        if(getValue() != null) return getType() + ":" + getValue();

        else return getType();
    }
}
