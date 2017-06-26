package bst;

import java.util.Scanner;




class Node {
	int data  = 0;
	Node right = null;
	Node left = null;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class BST {
	Node root = null;
	public void insert(int e){
		root = insert(root,e);
	}
	public Node insert(Node root,int e) {
		if(e >0){
			if(root == null){
//				System.out.println(e);
				Node nd = new Node(e);
				root = nd;
				return root;
			}else if(e <= root.data){
//				System.out.println("--------left");
				root.left = insert(root.left,e);
			}else{
//				System.out.println("---------right");
				root.right = insert(root.right,e);
			}
		}
		return root;
	}
	
	public void inorder(){
		System.out.println("----------");
		root=inorder(root);
	}
	public Node inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
		return root;
	}
	public void lca(int n1, int n2){
		System.out.println(lca(root,n1,n2));
	}
	public int lca(Node root,int n1,int n2) {// lowest common ancestor
		if(root.data > Math.max(n1, n2)){
			return lca(root.left,n1,n2);
		}else if(root.data < Math.min(n1,n2)){
			return lca(root.right,n1,n2);
		}
		else {
			return root.data;
		}
	}
	public void size(){
		System.out.println(size(root));
	}
	public int size(Node root){
		if(root == null){
			return 0;
		}
		return size(root.left)+size(root.right)+1;
	}
	int max_level = 0;
	public void printleftview(Node root, int level){
		if(root == null) {
			return;
		}
		if(max_level < level){
			System.out.print(root.data + " ");
			max_level = level;
		}
		printleftview(root.left, level+1);
		printleftview(root.right, level+1);
	}
	public void leftview() {
		max_level = 0;

		printleftview(root, 1);
	}
	public void printrightview(Node root, int level){
		if(root == null) {
			return;
		}
		if(max_level < level){
			System.out.print(root.data + " ");
			max_level = level;
		}
		printrightview(root.right, level+1);
		printrightview(root.left, level+1);
	}
	public void rightview() {
		max_level = 0;

		printrightview(root, 1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BST bst = new BST();
		bst.insert(5);
		bst.insert(10);
		bst.insert(6);
		bst.insert(1);
		bst.insert(8);
		bst.insert(7);
		bst.insert(3);
		bst.insert(4);
		bst.insert(2);
		bst.insert(9);
		bst.insert(11);
		
//		bst.inorder();
//		bst.lca(2,9);
//		bst.size();
		bst.leftview();
		System.out.println();
		bst.rightview();
		
	}
}
