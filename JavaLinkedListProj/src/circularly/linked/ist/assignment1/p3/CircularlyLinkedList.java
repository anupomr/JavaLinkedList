package circularly.linked.ist.assignment1.p3;

public class CircularlyLinkedList<E> implements Cloneable {

	// nested Node class
	private static class Node<E> {
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
	private Node<E> tail = null;
	private int size = 0;

	// constructor
	public CircularlyLinkedList() {
	}

	// public methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E e) {
		if (size == 0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}

	// Main Method for test the code
	public static void main(String[] args) {

	}

}
