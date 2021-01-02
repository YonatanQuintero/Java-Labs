import java.util.ArrayList;
import java.util.Arrays;

public class Lab6 {


    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList(2);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);

        //System.out.println(arrayList.size());

        /*solution(1);
        solution(54321);
        solution(10011);*/
        //System.out.println(20/100);//
        int total = 0;
        int n = 10000;
        n = n - 1;
        while (n != 0) {
            total = total + n;
            n--;
        }
/*for(int i=0;i<n;i++){
    for(int)
}*/
        // return total;
System.out.println(total);
    }


    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            } else if (enable_print > 0) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
        System.out.println("");
    }

}
