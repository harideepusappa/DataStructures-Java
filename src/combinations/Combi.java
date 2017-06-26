package combinations;

import java.util.Scanner;

public class Combi {

	/**
	 * @param args
	 */
	public static void  getcomb(String s){
		getcomb("", s);
	}
	public static void getcomb(String prefix, String s) {
		if(prefix.length()>0)
		System.out.println(prefix);
		for(int i = 0; i < s.length(); i++) {
			getcomb(prefix+s.charAt(i), s.substring(i+1));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		getcomb(s);

	}

}
