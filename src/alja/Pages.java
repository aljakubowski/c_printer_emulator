package alja;

public class Pages {

    private int pagesPrinted = 0;

    public Pages(int pagesPrintedInit) {
        this.pagesPrinted = pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public void setPagesPrinted(int pagesPrinted) {
        this.pagesPrinted = pagesPrinted;
    }

    public void print(int numberOfPages) {
        this.pagesPrinted = pagesPrinted + numberOfPages;
        System.out.print(" page number " + this.pagesPrinted);
    }
}
