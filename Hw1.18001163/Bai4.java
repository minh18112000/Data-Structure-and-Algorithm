package DSAA;

import java.util.Scanner;

public class Bai4 {
	public static void print(float r, float x, float y, float z) {
		System.out.println("(" + x + "," + y + "," + z + ")" + " va ban kinh: " + r);
	}

	public static void dienTich(float r) {
		System.out.println(4 * Math.PI * r * r);
	}

	public static void theTich(float r) {
		System.out.println((double) (4 / 3) * Math.PI * r * r * r);
	}

	public static void viTri(float r1, float x1, float y1, float z1, float r2, float x2, float y2, float z2) {
		double khoangCachTam = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
		float tongBanKinh = r1 + r2;
		float hieuBanKinh = Math.abs(r1 - r2);
		System.out.print("Vi tri cua hai hinh cau: ");
		if (khoangCachTam > tongBanKinh)
			System.out.println("2 hinh cau khong giao nhau");
		if (khoangCachTam == tongBanKinh)
			System.out.println("2 hinh cau tiep xuc ngoai");
		if (khoangCachTam < tongBanKinh)
			System.out.println("2 hinh cau giao nhau tai 2 diem");
		if (hieuBanKinh == khoangCachTam)
			System.out.println("2 hinh cau tiep xuc trong");
		if (khoangCachTam < hieuBanKinh)
			System.out.println("2 hinh cau chua nhau");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap cac tham so cua hinh cau thu 1 theo thu tu r, x, y, z: ");
		float r1 = sc.nextFloat();
		float x1 = sc.nextFloat();
		float y1 = sc.nextFloat();
		float z1 = sc.nextFloat();
		System.out.println("Nhap cac tham so cua hinh cau thu 2 theo thu tu r, x, y, z: ");
		float r2 = sc.nextFloat();
		float x2 = sc.nextFloat();
		float y2 = sc.nextFloat();
		float z2 = sc.nextFloat();
		System.out.print("Hinh cau 1 co toa do tam:");
		print(r1, x1, y1, z1);
		System.out.print("Dien tich mat cau 1: ");
		dienTich(r1);
		System.out.print("The tich hinh cau 1: ");
		theTich(r1);
		System.out.print("Hinh cau 2 co toa do tam:");
		print(r2, x2, y2, z2);
		System.out.print("Dien tich mat cau 2: ");
		dienTich(r2);
		System.out.print("The tich hinh cau 2: ");
		theTich(r2);
		viTri(r1, x1, y1, z1, r2, x2, y2, z2);
	}
}
