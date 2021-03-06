package doubly.linked.ist.assignment1.q2;

public class DoublyLinkedList<E> {
	// nested Node class
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		// public methods
		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	// constructs
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return header.getNext().getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	public E removeFirst(){
		if (isEmpty()) return null;
		return remove(header.getNext());
	}

	public E removeLast(){
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}

	public void printAll()
	{
		System.out.println("All the elements of the DoublyLinkedList");
		Node<E> current = header.getNext();
		while (current.getElement() != null)
		{
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}
	//concatenate two doubly linked list
		public static <E> DoublyLinkedList<E> concatDoublyLinkdList(DoublyLinkedList<E> firstList, DoublyLinkedList<E> secondList)
		{
			if (firstList.isEmpty() || secondList.isEmpty())
			{
				System.out.println("No need to concat because the list is empty");
				return (firstList == null) ? secondList : firstList;
			}

			//concatenate
			firstList.trailer.getPrev().setNext(secondList.header.getNext());
			return firstList;

		}
	
	public static void main(String[] args) {
		DoublyLinkedList<String> dLLCars = new DoublyLinkedList<>();
		dLLCars.addFirst("Honda 2006");
		dLLCars.addLast("Honda 2007");
		dLLCars.addLast("Honda 2008");
		dLLCars.addLast("Honda 2009");
		dLLCars.addLast("Honda 2011");
		dLLCars.printAll();
		
		
		DoublyLinkedList<String> dLL2 = new DoublyLinkedList<>();
		dLL2.addLast("Honda 2020 be concatenated");

		DoublyLinkedList<String> dLL3 = DoublyLinkedList.concatDoublyLinkdList(dLLCars, dLL2);
		dLL3.printAll();
	}

}
