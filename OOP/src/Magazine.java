public class Magazine extends LibraryResource{
    private String publisher;
    private String topic; // scientific , fashion ,news,etc..

    public Magazine(String title,int publicationYear, String description,String publisher,String topic)
    {
        super(title,publicationYear,description);
        this.publisher=publisher;
        this.topic=topic;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "publisher='" + publisher + '\'' +
                ", topic='" + topic + '\'' +
                 super.toString();
    }
}
