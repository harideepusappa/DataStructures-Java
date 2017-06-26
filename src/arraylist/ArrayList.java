package arraylist;

import java.util.Arrays;

public class ArrayList {
	int[] array = null;
	int size = 0;
	int noOfEle =0;
	public  ArrayList(){
		size = 4;
		array = new int[size];
		noOfEle =0;
	}

	public boolean add(int e){
		if(noOfEle >= size/2){
			resize();
		}
		else if(noOfEle-1 == size/2) {
			resize();
		}
		array[noOfEle++] = e;
		display();
		return true;
	}
	public void add(int index, int e){
		resize();
		if(index < noOfEle) {
			for(int i = noOfEle; i > index; i--) {
					array[i] = array[i-1];
			}
			array[index] = e;
		}
		noOfEle++;
	}
	public void remove(){
		if(noOfEle>=1){
		array[--noOfEle]= 0;
		System.out.println(noOfEle);
		resize();
		display();
		}
	}
	public int get(int index){
		if(index < noOfEle) {
		return array[index];
		}
		return 0;
		
	}
	public boolean remove(int index){
		for(int i = index; i < noOfEle; i++){
			array[i] = array[i+1];
		}
		noOfEle--;
		resize();
		return true;
	}
	public void display(){
		System.out.println(size);
		for(int i = 0; i < noOfEle; i++){
			System.out.print(array[i] + " ");
			
		}
		System.out.println("\n-----------------");
	}
	public int[] resize(){
		int[] dummy = null;
		if(noOfEle >= size/2 ) {
			System.out.println("a");
			size = 2*size;
			dummy = new int[size];
			for(int i = 0; i < noOfEle; i++) {
				dummy[i] = array[i];
			}
		}else if(noOfEle < size/2){
			System.out.println("b");
			size = size/2;
			dummy = new int[size];
			for(int i = 0; i < noOfEle; i++) {
				dummy[i] = array[i];
			}
		}
		array = Arrays.copyOf(dummy, size);
		return array;
	}
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
//		al.remove();
//		al.remove();
//		al.remove();
		al.add(10);
		al.add(2, 4);
		al.add(2, 5);
		al.display();
		System.out.println(al.get(0));
		al.remove(2);
		al.display();

	}

}
