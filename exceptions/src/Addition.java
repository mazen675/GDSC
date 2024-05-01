import java.util.Scanner;
public class Addition {

    public static void main(String[] args) {
        System.out.print(addIntegers());
    }

    static int scanInt() {
        Scanner input = new Scanner(System.in);
        int x=0;
        //boolean flag=true;
        while(true)
        {
            try {
                System.out.println("please insert an integer");
                x = input.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Wrong Input ,Try Again");
                input.next();
            }
        }
        return x;
    }

    static int addIntegers() {
        int x = scanInt();
        int y = scanInt();
        return (x + y);
    }
}