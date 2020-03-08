package singly.linked.ist.assignment1.q1;

public class SinglyLinkedList<E> {

	// nested Node class
	protected static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		// public methods
		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	// instance variables
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	// constructor
	public SinglyLinkedList() {
	}

	// access methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return answer;
	}

	// print all nodes
	public void printAll() {
		System.out.println("Below is all the elements of the SinglyLinkedList");
		Node<E> current = head;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	// get node
	public Node<E> getNode(E e) {
		Node<E> current = head;
		while (current.getElement() != e && current != null) {
			current = current.getNext();
		}
		if (current == null) {
			System.out.println("Node with element " + e + " can NOT be found");
		}
		return current;
	}

	// swap nodes
	public void swapNodes(Node<E> left, Node<E> right) {
		// compare two nodes, both element and next
		if (left.getElement() == right.getElement() && left.getNext() == right.getNext()) {
			// same node, no need to swap
			System.out.println("No need to swap, two nodes are same");
			return;
		} else // different node
		{
			Node<E> leftnext = left.getNext();
			Node<E> rightnext = right.getNext();

			// find leftprev
			Node<E> current = head;
			Node<E> leftprev = null;
			while (current != null) {
				if (current.getNext() == left) {
					leftprev = current;
					break;
				}
				current = current.getNext();
			}

			// find rightprev
			current = head;
			Node<E> rightprev = null;
			while (current != null) {
				if (current.getNext() == right) {
					rightprev = current;
					break;
				}
				current = current.getNext();
			}

			// check whether find prev
			if (leftprev == null || rightprev == null) {
				throw new IllegalArgumentException("Node prev can NOT be found!");
			} else {
				// swap
				leftprev.setNext(right);
				right.setNext(leftnext);
				rightprev.setNext(left);
				;
				left.setNext(rightnext);
				System.out.println("Successfully swap two nodes!");
			}
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList<String> sList = new SinglyLinkedList<>();
		sList.addFirst("Anupom");
		sList.addLast("Left");
		sList.addLast("COMP126");
		sList.addLast("and");
		sList.addLast("COMP254");
		sList.printAll();

		//test swap
		SinglyLinkedList.Node<String> leftNode = sList.getNode("COMP126");
		SinglyLinkedList.Node<String> rightNode = sList.getNode("COMP126");
		System.out.println("Test-1: test swap two same nodes");
		sList.swapNodes(leftNode, rightNode);

		System.out.println("Test-2: test swap two different nodes");
		rightNode = sList.getNode("COMP254");
		sList.swapNodes(leftNode, rightNode);
		sList.printAll();
	}

}
