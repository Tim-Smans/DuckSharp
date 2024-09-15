package models.errors;

import models.Position;

public class InvalidSyntaxError extends Error {

    public InvalidSyntaxError(Position posStart, Position posEnd, String details) {
        super("Invalid Syntax", details, posStart, posEnd);
    }
}
