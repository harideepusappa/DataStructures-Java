package mergesort;

import java.util.Scanner;

public class Merge {
	static int[] array = null;
	private static int[] mergeSort(int[] left,int[] right,int[] array) {
		int nl = left.length;
		int nr = right.length;
		int i = 0;
		 int j = 0;
		 int k = 0;
		while(i<nl&&j<nl){
			if(left[i]<=right[j]){
				array[k] = left[i];
				i++;
			}else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<nl){
			array[k] = left[i];
			i++;k++;
		}
		while(j<nr){
			array[k] = right[j];
			j++;k++;
		}
		return array;
	}
	private static void merge(int[] array){
		int n = array.length;
		if(n<2)
			return;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		for(int i = 0; i < mid; i++){
			left[i] = array[i];
		}
		for(int i = mid; i < n; i++){
			right[i-mid] = array[i];
//			System.out.println(i+" "+(i-mid) +" " + mid);
		}
		
		merge(left);
		merge(right);
		mergeSort(left, right, array);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	//3,2,7,4,1,5
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String[] str = sc.next().split(",");
			array = new int[str.length];
			for(int i = 0; i< array.length; i++){
				array[i] = Integer.parseInt(str[i]);
			}
			merge(array);	
		
			
		}

}
