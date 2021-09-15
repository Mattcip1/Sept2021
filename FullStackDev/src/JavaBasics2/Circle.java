/**
 * 
 */
package JavaBasics2;

/**
 * @author mattb
 *
 */
public class Circle implements Shape {

	int radius;
	double pi = 3.14;
	int area;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle circ = new Circle();
		circ.radius = 9;
		
		circ.area = circ.calculateArea();
		circ.display();
	}
	
	public int calculateArea() {
		return (int) (this.pi*(this.radius*this.radius));
	}
	
	public void display() {
		System.out.println("The area of this Circle is: " + this.area);
	}
}
