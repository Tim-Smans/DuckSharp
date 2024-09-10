package models.errors;

import models.Position;

public class IllegalCharError extends Error {

    public IllegalCharError(Position posStart, Position posEnd, String details) {
        super("Illegal Character", details, posStart, posEnd);
    }
}
