import javax.annotation.Resource;
import java.util.Scanner;
public class Library {
   public static final int MAX_RESOURCES = 20;          // Maximum number of a specific resource
   private Book[] books;
   private Magazine[] magazines;
   private DVD[] DVDs;

   private static int booksNum;                         //assuming we have separate shelf (section) for every resource
   private static int magazinesNum;
   private static int DVDsNum;


    public Library()
    {
        this.books=new Book[MAX_RESOURCES];
        this.magazines=new Magazine[MAX_RESOURCES];
        this.DVDs=new DVD[MAX_RESOURCES];
        this.booksNum=0;
        this.magazinesNum=0;
        this.DVDsNum=0;
    }

    public void add(LibraryResource resource)
    {
        if(resource instanceof Book)
            {
                books[booksNum]=(Book)resource;
                booksNum++;
            }
        else if(resource instanceof Magazine)
            {
                magazines[magazinesNum]=(Magazine)resource;
                magazinesNum++;
            }
        else
            {
                DVDs[DVDsNum]=(DVD) resource;
                DVDsNum++;
            }
    }
    public void delete(LibraryResource resource)
    {
        if(resource instanceof Book)
        {
            books[booksNum]=null;
            booksNum--;
        }
        else if(resource instanceof Magazine)
        {
            magazines[magazinesNum]=null;
            magazinesNum--;
        }
        else
        {
            DVDs[DVDsNum]=null;
            DVDsNum--;
        }
    }
    public void update(LibraryResource resource , int resourceNum)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("please insert title");
        resource.setTitle(input.nextLine());
        System.out.println("please insert publication year");
        resource.setPublicationYear(input.nextInt());
        input.nextLine();
        System.out.println("please insert Description");
        resource.setDescription(input.nextLine());
        if(resource instanceof Book)
        {
            System.out.println("please insert author name");
            ((Book) resource).setAuthor(input.nextLine());
            System.out.println("please insert number of pages");
            ((Book) resource).setNumOfpages(input.nextInt());

        }
        else if (resource instanceof Magazine)
        {
            System.out.println("please insert publisher name");
            ((Magazine) resource).setPublisher(input.nextLine());
            System.out.println("please insert topic");
            ((Magazine) resource).setTopic(input.nextLine());
        }
        else
        {
            System.out.println("please insert Musician's Name");
            ((DVD)resource).setMusician(input.nextLine());
            System.out.println("please insert Duration");
            ((DVD)resource).setDuration(input.nextInt());
        }
    }
    void displayInfo()
    {
        System.out.println("Current Number of Books= "+ (booksNum) );
        System.out.println("Current Number of Magazines= "+ (magazinesNum) );
        System.out.println("Current Number of DVDs= "+ (DVDsNum) );
    }
    void displayResources()
    {
        System.out.println("=>BOOKS:");
        for(int i=0;i<booksNum;i++)
        {
            System.out.println(books[i].toString());
        }
        System.out.println("=>MAGAZINES:");
        for(int i=0;i<magazinesNum;i++)
        {
            System.out.println(magazines[i].toString());
        }
        System.out.println("=>DVDS:");
        for(int i=0;i<DVDsNum;i++)
        {
            System.out.println(DVDs[i].toString());
        }
    }

    void checkAvailability(String type,String title)
    {
        if(type=="book")
        {
            for(int i=0;i<booksNum;i++)
            {
                if(title==books[i].getTitle())
                {
                    System.out.println("book is available");
                    break;
                }
                System.out.println("book is not available");
            }
        }
        else if (type=="magazine")
        {
            for(int i=0;i<magazinesNum;i++)
            {
                if(title==magazines[i].getTitle())
                {
                    System.out.println("magazine is available");
                    break;
                }
                System.out.println("magazine is not available");
            }
        }
        else
        {
            for(int i=0;i<DVDsNum;i++)
            {
                if(title==DVDs[i].getTitle())
                {
                    System.out.println("DVD is available");
                    break;
                }
                System.out.println("DVD is not available");
            }
        }

    }
}
