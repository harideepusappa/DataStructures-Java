package subsetsum;

import java.util.PriorityQueue;

public class SubSet {

	boolean subsetSum(int[] arr) {
	    int sum = 0;
	    int n = arr.length;
	    for(int i = 0; i < n; i++) {
	        sum+=arr[i];
	    }
	    sum = sum/2;
	    System.out.println(sum);
	    boolean T[][] = new boolean[arr.length + 1][sum + 1];
	        for (int i = 0; i <= arr.length; i++) {
	            T[i][0] = true;
	        }

	        for (int i = 1; i <= arr.length; i++) {
	            for (int j = 1; j <= sum; j++) {
	                if (j - arr[i - 1] >= 0) {
	                    T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
	                } else {
	                    T[i][j] = T[i-1][j];
	                }
	            }
	            
	        }
	        for (int i = 0; i <= arr.length; i++) {
	            for (int j = 0; j <= sum; j++) {
	            	System.out.print(T[i][j]+" ");
	            }
	            System.out.println();
	        }
	return T[arr.length][sum];
	}
	public static void main(String[] args) {
		SubSet s = new SubSet();
		int[] array = {3,5,16,8};
		System.out.println(s.subsetSum(array));
	}

}
