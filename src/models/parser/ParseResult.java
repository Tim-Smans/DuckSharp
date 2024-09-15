package models.parser;

import models.nodes.Node;

public class ParseResult {

    private final Error error;
    private final Node node;

    public ParseResult(Error error, Node node) {
        this.error = error;
        this.node = node;
    }

    public void register() {

    }
    public void success(){

    }

    public void failure(){

    }
}
