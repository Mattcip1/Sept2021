/**
 * 
 */
package JavaBasics2;

/**
 * @author mattb
 *
 */
public class Rectangle implements Shape {
	
	int length;
	int width;
	int area;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		rect.length = 10;
		rect.width = 6;
		
		rect.area = rect.calculateArea();
		rect.display();
	}
	
	public int calculateArea() {
		return this.length * this.width;
	}
	
	public void display() {
		System.out.println("The area of this Rectangle is: " + this.area);
	}
}
