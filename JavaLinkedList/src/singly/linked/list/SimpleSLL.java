package singly.linked.list;

public class SimpleSLL {
	
	// Nested Node class
	private class Node {
		private Node nextNode;
		private int data;

		// 0-arg constructor, 1-arg constructor, 2-arg constructor
		private Node() {
		}

		private Node(int val) {
			data = val;
		}

		private Node(int val, Node next) {
			data = val;
			nextNode = next;
		}

		private void setData(int val) {
			this.data = val;
		}

		private int getData() {
			return this.data;
		}

		private void setNextNode(Node n) {
			this.nextNode = n;
		}

		private Node getNextNode() {
			return this.nextNode;
		}
	}
	public static void main(String[] args) {
		

	}

}
