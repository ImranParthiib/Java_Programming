import java.util.Scanner;
public class UsingArrayFib {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int nthTerm = 
        int[] A = new int[nthTerm];

        int firstNum = 0;
        int secondNum = 1;

        System.out.print(firstNum + ","+ secondNum );
 
        int nextNum = firstNum + secondNum;
        for (int i = 0; i < nthTerm; i++) {
            A[i] = nextNum;
            
            firstNum = secondNum;
            secondNum = nextNum;
            nextNum = firstNum + secondNum;
        }

        for (int i = 0; i < nthTerm; i++) {
            System.out.print(","+A[i] );
        }
    }
}
