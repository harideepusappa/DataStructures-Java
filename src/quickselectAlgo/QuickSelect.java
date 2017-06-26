package quickselectAlgo;

import java.util.Scanner;

public class QuickSelect {

	public int[] kThSmallestElement(int[] array, int start, int end, int k) {
		if(start <= end) {
			
			int piviot = partition(array, start, end);
//			System.out.println(piviot);
			if(piviot == k-1) {
				System.out.println(array[piviot]);
				return array;
			}
			else if (piviot >= k)
			kThSmallestElement(array, start, piviot-1, k);
			else if(piviot < k)
			kThSmallestElement(array, piviot+1,end, k);
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
		QuickSelect qs = new QuickSelect();
		array = qs.kThSmallestElement(array,0,str.length-1,4);
		for(int i = 0; i < str.length; i++) {
			System.out.print(array[i] + " ");
		}
		sc.close();

	}

}
