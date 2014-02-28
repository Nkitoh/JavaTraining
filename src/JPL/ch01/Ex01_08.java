package ch01;

public class Ex01_08 {

	public static void main(String[] args) {
		Point src = new Point();
		Point dist = new Point();

		src.move(200.0, 1000.0);

		dist.Copy(src);

		System.out.println("src.x :" + src.x + "src.y :" + src.y);
		System.out.println("dist.x:" + dist.x + "dist.y:" + dist.y);
	}
}

class Point {
	public double x, y;

	public void Copy(Point that) {
		this.x = that.x;
		this.y = that.y;
	}

	public void move(double x, double y) {

		this.x = x;
		this.y = y;
	}
}
