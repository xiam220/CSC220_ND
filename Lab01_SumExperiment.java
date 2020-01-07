package lab01;

public class SumExperiment {
	
	public static int check_sum(int[] array){
		int sum = 0, noPair = -1;
		int pos1 = 0, pos2 = array.length-1;
		sum = array[pos1] + array[pos2];
		while(pos1 != pos2) {
			sum = array[pos1] + array[pos2];
			if(sum > 20) {
				pos2--;
				sum = array[pos1] + array[pos2];
			} else if(sum < 20) {
				pos2 =  array.length-1;
				pos1++;
				sum = array[pos1] + array[pos2];
			} else if(sum == 20) {
				return pos1;
			}
		}
		
		
		// This function will inspect the input to find any pair of values that add up to 20
		// if it find such a pair, it will return the *index* of the smallest value
		// if it does not find such as pair, it will return -1;
		
		// remove the following line after you are done writing the function
		return noPair;
	}
	
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (check_sum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (check_sum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (check_sum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (check_sum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
