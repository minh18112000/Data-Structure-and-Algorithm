package hw3_18001163;

import java.util.ArrayList;

public class TestShape {
	public static void main(String[] args) {
		double radius = 5.0;
		double width = 2.0, height = 4.0;
		Shape circle = new Circle(radius);
		Shape sphere = new Sphere(radius);
		Shape rectangle = new Rectangle(width, height);
		circle.setName("Hinh tron");
		sphere.setName("Hinh cau");
		rectangle.setName("Hinh chu nhat");
		ArrayList<Shape> listShape = new ArrayList<Shape>();
		listShape.add(circle);
		listShape.add(rectangle);
		listShape.add(sphere);
		for (int i = 0; i < listShape.size(); i++) {
			System.out.println(listShape.get(i).getName());
			System.out.println("Dien tich: " + listShape.get(i).getArea());
			System.out.println("The tich: " + listShape.get(i).getVolume());
			System.out.println("Chu vi: " + listShape.get(i).getPerimeter());
			System.out.println("==================");
		}
	}

}
