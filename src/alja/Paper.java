package alja;

public class Paper {

    private int paperSheets;

    public Paper() {
        this.paperSheets = 20;
    }

    public int getPaperSheets() {
        return paperSheets;
    }

    public void setPaperSheets(int paperSheets) {
        this.paperSheets = paperSheets;
    }

    public void fillPaperSheets(int paperSheets) {
        this.paperSheets += paperSheets;
    }

    public void printUsingPaper(int paperSheets) {
        this.paperSheets -= paperSheets;
    }
}