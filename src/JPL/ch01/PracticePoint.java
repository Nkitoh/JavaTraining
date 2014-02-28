package ch01;

public class PracticePoint {

	public static Point_test origin = new Point_test();
	public static void main(String[] args) {

		Point_test lowerLeft = new Point_test();
		Point_test upperRight = new Point_test();
		Point_test middlePoint = new Point_test();

		double dist;
		
	//	lowerLeft.x = 0.0;
	//	lowerLeft.y = 0.0;

		upperRight.x = 1280.0;
		upperRight.y = 1024.0;

		middlePoint.x = (upperRight.x + lowerLeft.x) / 2;
		middlePoint.y = (upperRight.y + lowerLeft.y) / 2;

		//origin.x =  12.0;
		//middlePoint.clear();
		
		dist = upperRight.distance(middlePoint);
		
		middlePoint.move(900.0, 480.0);
		
		System.out.println("lowerLeft" + "x:" + lowerLeft.x + "y:" + lowerLeft.y);
		System.out.println("upperRight" + "x:" + upperRight.x + "y:" + upperRight.y);
		System.out.println("middlePoint" + "x:" + middlePoint.x + "y:" + middlePoint.y);
		
		System.out.println("x:"+origin.x +"y:"+origin.y);
		
		System.out.println(dist);
		

	}

}
class Point_test{
	public double x, y;

	public void clear(){
		x=0.0;
		y=0.0;
	}
	
	public double distance(Point_test that){
		double xdiff = x - that.x;
		double ydiff = y - that.y;
	
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	
	public void move(double x,double y){
		
		this.x=x;
		this.y=y;
	}
	
}


