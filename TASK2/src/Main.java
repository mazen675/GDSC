import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        //variable declarations
              int age_person=22;
              double height_building=122;
              boolean raining_status=true;
              String city="alexandria";


        int []result=calculator();
        for (int i = 0; i <= 3; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println(result[i]);
        }
        System.out.println("-----------------------------------");
        print_even();
        System.out.println("-----------------------------------");
        System.out.println(weekday());
    }
     static int[] calculator ()
    {
        Scanner input=new Scanner(System.in);
        int x,y;
        System.out.println("please enter the first number ");
        x=input.nextInt();
        System.out.println("please enter the second number");
        y=input.nextInt();

        int[] result= new int[4];
        result[0]=x+y;
        result[1]=x-y;
        result[2]=x*y;
        result[3]=x/y;
        return result;
    }
    static void print_even()
    {
        for(int i=1;i<=20;i++)
        {
            if(i%2==0)
                System.out.println(i);
        }
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

