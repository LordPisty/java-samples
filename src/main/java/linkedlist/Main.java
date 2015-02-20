package linkedlist;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node list = new Node(0, new Node(1, new Node(2, new Node(3, null))));
		System.out.println(list.toString());
		System.out.println(Utils.reverseTailRec(null,list).toString());
	}

}
