package bubblesort;

import java.util.Scanner;

public class Bubble {

	private static void sort(int[] array) {
		int n = array.length;
		for(int i = 0; i < n; i++) {
			boolean flag = true;
			for(int j=0;j<n-i-1;j++){
				if(array[j] > array[j+1]){
					flag = false;
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			if(flag)
				break;
		}
		for(int i = 0; i < array.length;i++){
			System.out.print(array[i] + " ");
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split(",");
		int[] array = new int[str.length];
		for(int i = 0; i< array.length; i++){
			array[i] = Integer.parseInt(str[i]);
		}
		sort(array);	
		
	}


}
