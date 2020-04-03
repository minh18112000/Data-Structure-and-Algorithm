package hw3_18001163;

public class Sphere extends Shape {
	private double radius = 0;

	public Sphere() {

	}

	public Sphere(double radius) {
// Hàm khởi tạo
		this.radius = radius;
	}

	@Override
	protected double getVolume() {
// Hoàn thành thân hàm
		return (double) (4 / 3) * Math.PI * Math.pow(this.radius,3);
	}

	@Override
	protected double getArea() {
		return (double) 4 * Math.PI * Math.pow(this.radius,2);
	}

	@Override
	protected double getPerimeter() {
		return 0;
	}
}