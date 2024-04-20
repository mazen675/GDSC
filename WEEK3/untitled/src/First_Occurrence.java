//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class First_Occurrence {
    public static void main(String[] args) {

        int []myarr={1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        System.out.println(first_occurrence(myarr,4));

        }

    static int first_occurrence(int []arr,int element) {
    int temp=-1;
        for(int i=0;i<arr.length;i++) {
            if ((arr[i]==element) && i>=5)
            {
                temp=i;
                break;
            }
        }
        return temp;
    }

}

