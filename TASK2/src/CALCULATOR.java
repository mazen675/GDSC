import java.util.Scanner;

public class CALCULATOR {
    public static void main(String[] args) {
       int [] result=calculator();
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }
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
}
