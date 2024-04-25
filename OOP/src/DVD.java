public class DVD extends LibraryResource{
    private String musician;
    private int duration;
    private static int count=0;

    public DVD(String title,int publicationYear, String description,String musician,int duration)
    {
        super(title,publicationYear,description);
        this.musician=musician;
        this.duration=duration;
        this.count++;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "musician='" + musician + '\'' +
                ", duration=" + duration +
                  super.toString();
    }
}
