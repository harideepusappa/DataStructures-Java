package insertionsort;

import java.util.Scanner;

public class Insertion {

	private static void sort(int[] array){
		int value = 0;
		for(int i = 1; i <array.length; i++) {
			int j = i;
			value = array[i];
			while(j > 0&& array[j-1]>value){
				array[j]=array[j-1];
				j--;
			}
			array[j] = value;
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
