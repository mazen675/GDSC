public class SUM_AVERAGE {

    public static void main(String[] args) {
        int []myarr={1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        sum_average(myarr);

    }

    static void sum_average(int [] arr)
    {
        int sum=0;
        double avg=0;

        for (int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        avg=(double)sum/ arr.length;
        System.out.println("sum= "+ sum +" & average= "+avg);
    }
}
