import java.util.Arrays;


public class Kadane {

	public static void main(String[] args) {
		double[] array = new double[]{-4,2,-7,2,2,2,2,2,2,2};
		double[] kad = maxSubarray(array);
		for (int i = 0; i < kad.length; i++) {
			System.out.println(kad[i]);
		}
	}
	
	public static double[] maxSubarray(double[] a) {
		    double max_so_far = 0;
		    double max_ending_here = 0;
		    int max_start_index = 0;
		    int startIndex = 0;
		    int max_end_index = -1;

		    for(int i = 0; i < a.length; i++) {
		      if(0 > max_ending_here +a[i]) {
		        startIndex = i+1;
		        max_ending_here = 0;
		      }
		      else {
		        max_ending_here += a[i];
		      }

		      if(max_ending_here > max_so_far) {
		        max_so_far = max_ending_here;
		        max_start_index = startIndex;
		        max_end_index = i;
		      }
		    }

		    if(max_start_index <= max_end_index) {
			return Arrays.copyOfRange(a, max_start_index, max_end_index+1);
		    }

		    return null;
		  }
}
