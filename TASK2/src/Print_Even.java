public class Print_Even {
    public static void main(String[] args) {
        print_even();
    }

    static void print_even()
    {
        for(int i=1;i<=20;i++)
        {
            if(i%2==0)
                System.out.println(i);
        }
    }
}
