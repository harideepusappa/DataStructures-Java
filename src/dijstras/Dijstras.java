package dijstras;

import java.util.Arrays;

public class Dijstras {

	static int[] dijkstraDistances(int[][] matrix, int startVertex) {

		  boolean[] used = new boolean[matrix.length];
		  int[] distance = new int[matrix.length];
		  Arrays.fill(distance, Integer.MAX_VALUE);
		  distance[startVertex] = 0;

		  for (int i = 0; i < matrix.length; i++) {
		    int chosenIndex = -1;
		    for (int j = 0; j < matrix.length; j++) {
		      if (!used[j] && (chosenIndex == -1 || distance[j]<distance[chosenIndex]))
		        chosenIndex = j;
		      }
		    
		    used[chosenIndex] = true;
		    for (int j = 0; j < matrix.length; j++) {
		      if (matrix[chosenIndex][j] != -1 &&
		          distance[j] > distance[chosenIndex] + matrix[chosenIndex][j]) {
		        distance[j] = distance[chosenIndex] + matrix[chosenIndex][j];
		      }
		    }
		  }

		  return distance;
		}


	public static void main(String[] args) {
		int[][] matrix = {{-1,1,2}, 
				 {0,-1,3}, 
				 {0,0,-1}};
		int[] arr= dijkstraDistances(matrix, 1);
		for(int i:arr){
			System.out.print(i+" ");
		}


	}

}
