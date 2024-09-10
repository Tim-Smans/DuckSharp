package models;

public class Position {

    private int index;
    private int line;
    private int col;
    private String fileName;
    private String fileText;

    public Position(int index, int line, int col, String fileName, String fileText) {
        this.index = index;
        this.line = line;
        this.col = col;
        this.fileName = fileName;
        this.fileText = fileText;
    }

    public int getIndex() {
        return index;
    }

    public int getLine() {
        return line;
    }

    public String getFileName() {
        return fileName;
    }

    public Position advance(Character currentCharacter){
        if(currentCharacter == null){
            return this;
        }
        index++;
        col++;
        if(currentCharacter.equals('\n')){
            line++;
            col = 0;
        }

        return this;
    }

    public Position copy(){
        return new Position(index, line, col, fileName, fileText);
    }
}
