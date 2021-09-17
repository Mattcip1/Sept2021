/**
 * 
 */
package JavaBasics4;

/**
 * This class represents one thread which produces ints and puts them in an array, and another thread that takes them out.
 * @author mattb
 *
 */
public class ProducerNConsumer {

	static int[] buffer = {0, 0, 0, 0, 0, 0, 0};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread producer = new Thread() {
			
			@Override
			public void run() {
				synchronized (buffer) {
					try {
						for(int i = 0; i < 7; i++) {
							buffer[i] = i+1;
							System.out.println("added " + (i+1) + " to buffer.");
						}
					} 
						catch (Exception e) {
					}
					System.out.println("Producer finished, lock released");
				}
			}
		};
		Thread consumer = new Thread() {
			
			@Override
			public void run() {
				synchronized (buffer) {
					try {
						for(int i = 6; i > -1; i--) {
							int val = buffer[i];
							System.out.println(val + " removed from buffer.");
							buffer[i] = 0;
						}
					} 
						catch (Exception e) {
					}
					System.out.println("consumer finished, lock released");
				}
			}
		};
		producer.run();
		consumer.run();
	}
}
