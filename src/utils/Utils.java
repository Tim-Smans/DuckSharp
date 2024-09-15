package utils;

import models.Position;

public class Utils {

    public static String stringWithArrows(String text, Position posStart, Position posEnd) {
        StringBuilder result = new StringBuilder();

        // Calculate indices
        int idxStart = Math.max(text.lastIndexOf('\n', posStart.getIndex()), 0);
        int idxEnd = text.indexOf('\n', idxStart + 1);
        if (idxEnd < 0) {
            idxEnd = text.length();
        }

        // Generate each line
        int lineCount = posEnd.getLine() - posStart.getLine() + 1;
        for (int i = 0; i < lineCount; i++) {
            // Calculate line columns
            String line = text.substring(idxStart, idxEnd);
            int colStart = (i == 0) ? posStart.getColumn() : 0;
            int colEnd = (i == lineCount - 1) ? posEnd.getColumn() : line.length() - 1;

            // Append to result
            result.append(line).append('\n');
            result.append(" ".repeat(colStart)).append("^".repeat(colEnd - colStart)).append('\n');

            // Re-calculate indices
            idxStart = idxEnd;
            idxEnd = text.indexOf('\n', idxStart + 1);
            if (idxEnd < 0) {
                idxEnd = text.length();
            }
        }

        return result.toString().replace("\t", "");  // Remove tabs from the result
    }
}
