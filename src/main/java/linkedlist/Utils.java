package linkedlist;

public class Utils {

	public static Node reverse(final Node head) {
		
		if (head == null) return null;
		Node current = head;
		Node save = null;
		while (current.getNext() != null) {
			Node next = current.getNext();
			current.setNext(save);
			save = current;
			current = next;
		}
		
		current.setNext(save);
		
		return current;
	}
	
	public static Node reverse2(Node head) {
		
		Node current = head;
		head = null;
		while (current != null) {
			Node next = current.getNext();
			current.setNext(head);
			head = current;
			current = next;
		}

		return head;
	}
	
	public static Node reverseRec(Node head) {
		
		if (head == null) return null;
		
		if (head.getNext() == null) return head;
		
		Node newHead = reverseRec(head.getNext());
		
		head.getNext().setNext(head);
		head.setNext(null);
		
		return newHead;
	}
	
	public static Node reverseTailRec(Node pre, Node first) {
		if (first == null) return null;
		
		if (first.getNext() == null) {
			first.setNext(pre);
			return first;
		} 
		
		Node tmp = first.getNext();
		first.setNext(pre);
		
		return reverseTailRec(first, tmp);
	}
	
}
