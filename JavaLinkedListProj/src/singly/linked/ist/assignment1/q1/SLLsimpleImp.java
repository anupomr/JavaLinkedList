package singly.linked.ist.assignment1.q1;

public class SLLsimpleImp {

	private static class Node {
		int data;
		Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	public Node head;

	public void addFirst(int data) {
		Node nNode = new Node(data);
		if (head == null) {
			head = nNode;
			return;
		}
		Node cur = head;
		while (cur != null) {
			cur = cur.next;
		}
		cur = nNode;
	}

	public void display() {
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		System.out.println("\nList is as bellow");
		Node cur = head;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}

	}

	public static void main(String[] args) {
		SLLsimpleImp sList = new SLLsimpleImp();
		sList.display();
		sList.addFirst(44);
		sList.display();
	}

}
