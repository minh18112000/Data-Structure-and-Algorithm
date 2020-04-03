package hw3_18001163;

//Tạo đối tượng Complex
public class Complex {
	private float real; // phần thực
	private float image; // phần ảo

	public Complex(float r, float i) {
		this.real = r;
		this.image = i;
	}

	public float getReal() {
		return real;
	}

	public void setReal(float real) {
		this.real = real;
	}

	public float getImage() {
		return image;
	}

	public void setImage(float image) {
		this.image = image;
	}

	public Complex add(Complex c) {
//Cộng số phức hiện tại với số phức c
		float sumReal = c.real + this.real;
		float sumImage = c.image + this.image;
		Complex sumComplex = new Complex(sumReal, sumImage);
		return sumComplex;
	}

	public Complex minus(Complex c) {
//Trừ số phức hiện tại cho số phức c
		float sumReal = this.real - c.real;
		float sumImage = this.image - c.image;
		Complex sumComplex = new Complex(sumReal, sumImage);
		return sumComplex;
	}

	public Complex time(Complex c) {
//Nhân số phức hiện tại với số phức c
		float sumReal = this.real * c.real - this.image * c.image;
		float sumImage = this.real * c.real + this.image * c.image;
		Complex sumComplex = new Complex(sumReal, sumImage);
		return sumComplex;
	}

	public float realpart() {
		return real;
	}

	public float imagepart() {
		return image;
	}

	@Override
	public String toString() {
		return "Complex [real=" + real + ", image=" + image + "]";
	}

}