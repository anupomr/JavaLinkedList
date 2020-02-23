package doublely.linked.ist.assignment1.q2;

public class DoublelyLinkedList <E>{
	//nested Node class
		private static class Node<E>{
			private E element;
			private Node<E> prev;
			private Node<E> next;
			public Node (E e, Node<E> p, Node<E> n){
				element = e;
				prev = p;
				next = n;
			}
		    //public methods
			public E getElement() {return element;}
			public Node<E> getPrev() {return prev;}
			public Node<E> getNext() {return next;}
			public void setPrev(Node<E> p) {prev = p;}
			public void setNext(Node<E> n) {next = n;}
		}
}
