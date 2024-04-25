public class LibraryResource {
    private String title;
    private int publicationYear;
    private String description;

    public LibraryResource() {
    }

    public LibraryResource(String title, int publicationYear, String description)
    {
        this.title=title;
        this.publicationYear=publicationYear;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", description='" + description + '\'' +
                '}';
    }
}
