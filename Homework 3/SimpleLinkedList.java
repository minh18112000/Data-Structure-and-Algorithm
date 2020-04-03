package hw3_18001163;

public class SimpleLinkedList<T> {
	class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
			this.next = next;
		}

	}

	private Node top = null;
	private Node bot = null;
	private int n = 0;

	public void add(T data) {
// Thêm phần tử vào đầu danh sách
		Node newNode = new Node(data);
		newNode.next = null;
		n++;
		if (top == null && bot == null) {
			top = newNode;
			bot = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	public void addBot(T data) {

// Thêm phần tử vào cuối danh sách
		Node newNode = new Node(data);
		newNode.next = null;
		n++;
		if (top == null && bot == null) {
			top = newNode;
			bot = newNode;
		} else {
			bot.next = newNode;
			bot = newNode;
		}
	}

	public T get(int i) {
		if (i < 0 || i >= n)
			return null;
		Node currentNode = top;
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	public void set(int i, T data) {
// Gán giá trị ở vị trí i bằng data
		if (i < 0 || i >= n)
			return;
		Node currentNode = top;
		int count = 0;
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.next;
		}
		currentNode.data = data;
	}

	public boolean isContain(T data) {
// Kiểm tra trong danh sách có chứa phần tử data hay không?
		if (n == 0)
			return false;
		Node currentNode = top;
		while (currentNode != null) {
			if (currentNode.data.equals(data)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	public int size() {
// Trả lại thông tin số phần tử có trong danh sách
		return n;
	}

	public boolean isEmpty() {

// Kiểm tra danh sách có rỗng hay không?
		if (n == 0)
			return true;
		return false;

	}

	public T removeTop() {
// Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
		if (n == 0)
			return null;
		else {
			T data = top.data;
			top = top.next;
			n -= 1;
			return data;
		}
	}

	public T removeBot() {
// Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
		if (n == 0)
			return null;
		Node temp = top;
		if (n == 1) {
			top = null;
			bot = null;
			n = 0;
			return temp.data;
		}
		for (int i = 0; i < n - 2; i++) {
			temp = temp.next;
		}
		T data = temp.next.data;
		temp.next = null;
		n -= 1;
		return data;

	}

	public void remove(T data) {
// Xóa tất cả các phần tử có giá trị bằng data
		Node currentNode = top;
		while (currentNode.data.equals(data)) {
			removeTop();
			currentNode = top;
		}
		if (currentNode != null) {
			while (currentNode.next != null) {
				if (currentNode.next.data.equals(data)) {
					if (currentNode.next == bot) {
						bot = currentNode;
					}
					currentNode.next = currentNode.next.next;
					n--;
				} else {
					currentNode = currentNode.next;
				}
			}
		}
	}

	public void printList() {
		if (n == 0)
			return;
		Node currentNode = top;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}
}