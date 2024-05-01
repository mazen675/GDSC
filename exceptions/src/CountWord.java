import java.io.FileInputStream;
import java.util.Scanner;

public class CountWord {
    public static void main(String[] args) {
        int count=0;
        try{
            FileInputStream fin=new FileInputStream(System.getProperty("user.dir") + "\\src\\" + "Lincoln.txt");
            Scanner input=new Scanner(fin);
            while(input.hasNext()){
                String word = input.next();
                count++;
            }
            System.out.println("Total Words= "+count);
            fin.close();
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
