package linkedlist;

public class Node {

	private Integer data;
	
	private Node next;

	public Node(Integer data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data + (next != null ? next.toString() : ""));
	}
}
