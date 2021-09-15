/**
 * 
 */
package JavaBasics2;

/**
 * @author mattb
 *
 */
public class Triangle implements Shape {

	int base;
	int height;
	int area;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Triangle tria = new Triangle();
		tria.base = 26;
		tria.height = 13;
		
		tria.area = tria.calculateArea();
		tria.display();
	}
	
	public int calculateArea() {
		return (this.height*this.base)/2;
	}
	
	public void display() {
		System.out.println("The area of this Triangle is: " + this.area);
	}
}
