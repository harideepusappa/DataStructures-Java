package permutation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Permution {
	String pat = "bac";
	boolean flag = true;
	static int a = 10;
	static TreeSet<String> ts = new TreeSet<String>();
	public void getPermution(char[] array, int n) {
//		System.out.println(a);
		if(n == 1) {
			String s ="";
			for(int i = 0; i < array.length; i++) {
				s+=array[i];
			}
//			if(pat.contains(s)) {
//				System.out.println("YES");
//			}
//			System.out.println(array);
			ts.add(s);
		}
		else {
			for (int i = 0; i < n; i++) {
				swap(array,i,n-1);
				getPermution(array, n-1);
				swap(array, i, n-1);
			}
		}
	}
	public void swap(char[]array,int i,int j){
		char t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	char[] array = sc.next().toCharArray();
	Permution pr = new Permution();
	pr.getPermution(array, array.length);
	Iterator<String> itr = ts.iterator();
	while(itr.hasNext()){
		System.out.println(itr.next());
	}
//	for (int i = 0; i < 2; System.out.println("hi")) {
//		System.out.println("hello");
//		i++;
//	}
	
}
}

