package quicksortalgo;

import java.util.Scanner;

public class QuickSort {

	public int[] quickSort(int[] array,int start, int end) {
		
		if(start < end) {
			int piviot = partition(array, start, end);
			quickSort(array, start, piviot-1);
			quickSort(array, piviot+1, end);
		}
		
		return array;
	}
	public int partition(int[] array,int start, int end) {
		int piviot = array[end];
		int pIndex = start;
		for(int i = start; i < end; i++) {
			if(array[i] <= piviot) {
				int temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				pIndex++;
			}
		}
		System.out.println(pIndex);
		for(int i = 0; i < 8; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		int temp = array[end];
		array[end] = array[pIndex];
		array[pIndex] = temp;
		return pIndex;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split(",");
		int[] array = new int[str.length];
		for(int i = 0; i < str.length; i++) {
			array[i] = Integer.parseInt(str[i]);
		}
		QuickSort qs = new QuickSort();
		array = qs.quickSort(array, 0, str.length-1);
		for(int i = 0; i < str.length; i++) {
			System.out.print(array[i] + " ");
		}
		sc.close();
	}

}
//2,6,3,5,1,4,9,10