package hw3_18001163;

public class Rectangle extends Shape {
	private double width = 0;
	private double height = 0;

	public Rectangle() {

	}

	public Rectangle(double width, double height) {
// Hàm khởi tạo
		this.width = width;
		this.height = height;
	}

	@Override
	protected double getVolume() {
		return 0;
	}

	@Override
	protected double getArea() {
// Hoàn thành thân hàm
		return this.width * this.height;
	}

	@Override
	protected double getPerimeter() {
// Hoàn thành thân hàm
		return 2 * (this.height + this.width);
	}
}