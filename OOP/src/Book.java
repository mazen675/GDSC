public class Book extends LibraryResource{
    private String author;
    private int numOfpages;

    public Book(String title,int publicationYear, String description,String author,int numOfpages){
        super(title,publicationYear, description);
        this.author=author;
        this.numOfpages=numOfpages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumOfpages() {
        return numOfpages;
    }

    public void setNumOfpages(int numOfpages) {
        this.numOfpages = numOfpages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", numOfpages=" + numOfpages +
                 super.toString();
    }
}
