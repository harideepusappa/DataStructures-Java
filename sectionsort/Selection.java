package sectionsort;

import java.util.Scanner;

public class Selection {

	private static void sort(int[] array) {
		int n  = array.length;
		for(int i = 0; i < n; i++) {
			int min = i;
			for(int j = i; j < n; j++){
				
				if(array[i]>array[j]){
					
					min = j;
				}
			}
			int temp = array[min];
			System.out.println(temp);
			array[min] = array[i];
			array[i] = temp;
		}
		for(int i = 0; i < array.length;i++){
			System.out.print(array[i] + " ");
		}
	}
	//3,2,7,4,1,5
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
