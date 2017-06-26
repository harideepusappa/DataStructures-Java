package trees;

class Node {
	BinaryTreeNode data = null;
	Node address = null;
	public Node(BinaryTreeNode data) {
		this.data = data;
		this.address = null;
	}
	public BinaryTreeNode getData() {
		return data;
	}
	public void setData(BinaryTreeNode data) {
		this.data = data;
	}
	public Node getAddress() {
		return address;
	}
	public void setAddress(Node address) {
		this.address = address;
	}
	
}
class Queue {
	Node front = null;
	Node rear = null;
	
	public void enqueue(BinaryTreeNode data) {
		Node nd = new Node(data);
		if(front == null) {
			front = nd;
			rear = nd;
		}
		else {
			rear.setAddress(nd);
			rear = nd;
		}
	}
	public BinaryTreeNode deQueue() {
	
		if(front == rear) {
			BinaryTreeNode temp = front.getData();
			front = null;
			rear = null;
			return temp;
		}
		else if(front == null && rear == null) {
			return null;
		}
		else {
			Node temp = front;
			front = front.getAddress();
			return temp.getData();
		}
	}
	public boolean isEmpty(){
		if(front == null && rear == null) {
			return true;
		}
		return false;
	}
	public void deleteQueue() {
		front = null;
		rear = null;
	}
}
class BinaryTreeNode {
	
	BinaryTreeNode left = null;
	BinaryTreeNode right = null;
	int data = 0;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public int getData() {
		return this.data;
	}
	public String toString() {
		return this.data + "";
	}
}

public class BinayTree {
	BinaryTreeNode root = null;
	public BinayTree(){
		
	}
	public BinaryTreeNode insertion(int data){
		root = insertion(root, data);
		return root;
	}
	public BinaryTreeNode insertion(BinaryTreeNode root,int data){
//		System.out.println("1");	
		if(root == null) {
				root = new BinaryTreeNode(data);
//				System.out.println("-----");
				return root;
			}
			if(root.getData() >= data) {
				root.setLeft(insertion(root.getLeft(),data));
			}
			else if(root.getData() < data) {
				root.setRight(insertion(root.getRight(),data));
			}
			return root;
		}
	public void inorder(){
		root = inorder(root);
	}
	public BinaryTreeNode inorder(BinaryTreeNode root){
		if(root != null) {
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
		return root;
	}
	public void levelOrder() {
		BinaryTreeNode temp = null;
		if(root == null) {
			return;
		}
		Queue Q = new Queue();
		Q.enqueue(root);
		while(!Q.isEmpty()){
			temp = Q.deQueue();
			System.out.println(temp.getData());
			if(temp.getLeft() != null) {
				Q.enqueue(temp.getLeft());
			}
			if(temp.getRight() != null){
				Q.enqueue(temp.getRight());
			}
		}
		Q.deleteQueue();
		
	}
	public void findHeight(){
		System.out.println(findHeight(root));
	}
	public int findHeight(BinaryTreeNode root) {
		if(root == null || (root.getLeft() == null && root.getRight() == null)) {
			return 0;
		}
		return 1+Math.max(findHeight(root.getLeft()), findHeight(root.getRight()));
	}
	
	public void kthdistanceNodeDown(int k){
			kthdistanceNodeDown(root, k);
	}
	public void kthdistanceNodeDown(BinaryTreeNode root, int k){
		if(root == null || k < 0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.getData());
		}
		kthdistanceNodeDown(root.getLeft(), k-1);
		kthdistanceNodeDown(root.getRight(), k-1);
		
	}
	
	public static void main(String[] args) {
		BinayTree bt = new BinayTree();
		BinaryTreeNode root = null;
//		for(int i = 0; i < 6; i++) {
//			bt.insertion(i);
//		}
		bt.insertion(20);
		bt.insertion(8);
		bt.insertion(22);
		bt.insertion(4);
		bt.insertion(12);
		bt.insertion(10);
		bt.insertion(14);
//		bt.inorder();
//		bt.levelOrder();
//		bt.findHeight();
		bt.kthdistanceNodeDown(1);
		
	}
}
