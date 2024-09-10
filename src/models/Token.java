package models;

public class Token {

    private final String type;
    private final Object value;

    public Token(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Token(String type) {
        this(type, null);
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
