package ex;

/**
 * Created by screspi on 3/21/15.
 */
public class MaxSumArray {

    public static int maxSumArray(int[] i) {
        int sum = 0;
        int sumStart = 0;
        int maxSum = 0;
        int maxSumStart = -1;
        int maxSumEnd = -1;

        for (int j = 0; j < i.length; j++) {
            sum += i[j];
            if (sum > maxSum) {
                maxSum = sum;
                maxSumStart = sumStart;
                maxSumEnd = j;
            } else if (sum < 0) {
                sum = 0;
                sumStart = j+1;
            }
        }

        System.out.println(maxSumStart + " - " + maxSumEnd);

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumArray(new int[]{1,-2,5,-9,6,-2,3,-4,1,-20,8}));
    }
}
