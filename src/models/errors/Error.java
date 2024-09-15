package models.errors;

import models.Position;
import utils.Utils;

public class Error {

    private final String errorName;
    private final String details;
    private final Position posStart;
    private final Position posEnd;

    public Error(String errorName, String details, Position posStart, Position posEnd) {
        this.posEnd = posEnd;
        this.posStart = posStart;
        this.errorName = errorName;
        this.details = details;
    }

    public String getErrorName() {
        return errorName;
    }
    public String getDetails() {
        return details;
    }
    public Position getPosStart() {
        return posStart;
    }
    public Position getPosEnd() {
        return posEnd;
    }

    @Override
    public String toString() {
        return errorName + ": " + details +
                "\nFile:" + posStart.getFileName() + " - Line: " + getPosStart().getLine() +
                "\n\n" + Utils.stringWithArrows(posStart.getFileText(), posStart, posEnd);
    }
}
