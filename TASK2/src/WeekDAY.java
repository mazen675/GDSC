import java.util.Scanner;

public class WeekDAY {
    public static void main(String[] args) {
        System.out.println(weekday());
    }

    static String weekday()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("please enter a number corresponding to WEEKDAY");
        int x=input.nextInt();
        String day;
        if (x==1)
            day= "Monday";
        else if (x==2)
            day= "Tuesday";
        else if (x==3)
            day= "Wednesday";
        else if (x==4)
            day= "Thursday";
        else if (x==5)
            day= "Friday";
        else if (x==6)
            day= "Saturday";
        else
            day="Sunday";
        return day;
    }

}

