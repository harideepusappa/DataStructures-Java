package longestCommonSequence;

import java.util.Scanner;

public class Lcs {

	public static void sequence(char[] ip1,char[] ip2) {
		int n = ip1.length;
		int m = ip2.length;
		int[][] matrix = new int[n+1][m+1];
		for(int i = 1; i < n+1; i++){
			for(int j = 1;  j< m+1; j++){
				if(ip1[i-1]== ip2[j-1]){
					matrix[i][j] = matrix[i-1][j-1]+1;
				} else{
					matrix[i][j] =  Math.max(matrix[i][j-1],matrix[i-1][j]);
				}
			}
		}
		System.out.println(matrix[n][m]);
		char[] seq = new char[matrix[n][m]];
		int index = 0;
		int i = n; int j = m;
		while(i > 0 && j > 0)  {
			if(ip1[i-1] == ip2[j-1]){
				seq[index++] = ip1[i-1];
				i--;j--;
			}else if(matrix[i-1][j] > matrix[i][j-1]){
				i--;
			}else {
				j--;
			}
		}
//		System.out.println(index);
		for(i = index-1; i >=0; i--){
			System.out.print(seq[i]);
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
		char[] ip1 = sc.next().toCharArray();
		char[] ip2 = sc.next().toCharArray();
//		int[] ip1 = new int[n];
//		char[] ip2 = new char[ip1.length];
//		for(int i = 0,j = n-1; i < n&& j >=0; i++,j--){
////			ip1[i] = sc.nextInt();
//			ip2[j]=ip1[i];
//		}
		
//		Lcs lcs = new Lcs();
		sequence(ip1, ip2);
	}

}
/* 
 LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
12341
341213
 */