package hw3_18001163;

public class Circle extends Shape {
	private double radius = 0;

	public Circle() {

	}

	public Circle(double radius) {
// Hàm khởi tạo
		this.radius = radius;
	}

	@Override
	protected double getVolume() {
		return 0;
	}

	@Override
	protected double getArea() {
// Hoàn thành thân hàm
		return (double) Math.PI * Math.pow(this.radius,2);
	}

	@Override
	protected double getPerimeter() {
// Hoàn thành thân hàm
		return (double) 2 * this.radius * Math.PI;
	}
}