package arrays;

public class MaxIntersectionSum {

	public static long maximumSumPath(int[] input1, int[] input2) {
		long max_sum = 0;
        int i=0, j=0;
        
        while(i<input1.length && j<input2.length) {
            int sum1 = 0, sum2=0;
            while(input1[i] > input2[j]) {
                sum2 += input2[j];
                j++;
            }
            while(input1[i] < input2[j]) {
                sum1 += input1[i];
                i++;
            }
            if(input1[i] == input2[j]) {
                sum1 += input1[i];
                sum2 += input2[j];
                i++; j++;
            }
            if(sum1 > sum2) {
                max_sum += sum1;
            }
            else {
                max_sum += sum2;
            }
        }
        while(i < input1.length) {
            max_sum += input1[i];
            i++;
        }
        while(j < input2.length) {
            max_sum += input2[j];
            j++;
        } 
        return max_sum;
	}
	
	public static void main(String[] args) {
		
		int input1[] = {1,5,10,15,20,25};
		int input2[] = {2,4,5,9,15};
		
		System.out.println(maximumSumPath(input1, input2));

	}

}
