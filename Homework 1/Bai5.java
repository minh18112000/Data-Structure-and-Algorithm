package DSAA;

public class Bai5<T> {
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
		newNode.next = top;
		top = newNode;
		n += 1;
	}

	public void addBot(T data) {
// Thêm phần tử vào cuối danh sách
		Node newNode = new Node(data);
		newNode.next = null;
		bot.next = newNode;
		bot = newNode;
		n += 1;

	}

	public T get(int i) {
// Lấy phần tử ở vị trí thứ i
		Node current = top;
		int count = 0;
		while (current != null) {
			if (count == i)
				return current.data;
			count++;
			current = current.next;
		}
		return null;
	}

	public void set(int i, T data) {
// Gán giá trị ở vị trí i bằng data
		Node current = top;
		int count = 0;
		while (current != null) {
			if (count == i) {
				current.data = data;

			}
			count++;
			current = current.next;
		}
	}

	public boolean isContain(T data) {
// Kiểm tra trong danh sách có chứa phần tử data hay không?
		Node current = top;
		while (current != null) {
			if (current.data == data)
				return true;
			current = current.next;
		}
		return false;
	}

	public int size() {
// Trả lại thông tin số phần tử có trong danh sách
		Node current = top;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public boolean isEmpty() {
// Kiểm tra danh sách có rỗng hay không?
		if (top.next == null)
			return false;
		return true;
	}

	public T removeTop() {
// Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
		if (top == null)
			return null;
		else {
			top = top.next;
			n -= 1;
		}
		return null;
	}

	public T removeBot() {
// Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
		if (top == null || top.next == null)
			return null;
		Node temp = top;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return null;
	}

	public void remove(T data) {
// Xóa tất cả các phần tử có giá trị bằng data

	}
}