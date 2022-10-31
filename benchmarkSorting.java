package benchmark;
import java.util.Arrays;
import java.util.Random;

public class benchmarkSorting {

	public static void QuickSort(int[] numbers, int[] flySwapper) {
		int low = 0;
		int high = numbers.length - 1;
		
		partition(numbers,low,high,flySwapper);
	}
	
	public static void partition(int[] numbers, int low, int high, int[] flySwapper) {
		if (low >= high) {
			return;
			
		} else {
			int middle = Partition(numbers, low, high, flySwapper);
			partition(numbers, low, middle, flySwapper);
			partition(numbers, middle +1 ,high ,flySwapper);
		}
	}
		
	public static int Partition(int [] numbers, int lower, int upper, int[] flySwapper) {
	  int midpoint = lower + (upper - lower) / 2;
	  int pivot = numbers[midpoint];

	  boolean finished = false;
	  while (!finished) {
	     while (numbers[lower] < pivot) {
	    	 lower += 1;
	     }
	     while (pivot < numbers[upper]) {
	    	 upper -= 1;
	     }
 
	     if (lower >= upper) {
	    	 finished = true;
	     }
	     else {
	        int temp = numbers[lower];
	        numbers[lower] = numbers[upper];
	        numbers[upper] = temp;
	        
	        flySwapper[0]++;

	        lower += 1;
	        upper -= 1;
	     }
	  }
	  return upper;
	}
	
	public static int numSquared(int n) {
		if (n == 0) {
			return 1;
		}
		return 2 * numSquared(n-1);
	}
	
	public static void main(String[] args) {
		int[] number = new int[10000];
		
		Random rand = new Random();
		for (int i = 0; i < 10000; i++) {
			number[i] = rand.nextInt(10000);
		}
		System.out.println(Arrays.toString(number));
		
		int[] flySwapper = {0};
		QuickSort(number, flySwapper);
		
		System.out.println(Arrays.toString(number));
		System.out.println(flySwapper[0]);
		
	}
}