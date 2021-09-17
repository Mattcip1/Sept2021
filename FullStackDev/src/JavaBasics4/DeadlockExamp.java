/**
 * 
 */
package JavaBasics4;

/**
 * This class demonstrates a deadlock between two threads.
 * 
 * @author mattb
 *
 */
public class DeadlockExamp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String lock1 = "abcdef";
		final String lock2 = "fedcba";

		Thread t1 = new Thread() {

			@Override
			public void run() {
				synchronized (lock2) {
					System.out.println("Thread 1: lock 2");
					try {
						Thread.sleep(100);
					}
						catch (Exception e) {
					}

					synchronized (lock1) {
						System.out.println("Thread 1: lock 1");
					}
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				synchronized (lock1) {
					System.out.println("Thread 2: lock 1");

					try {
						Thread.sleep(100);
					} 
						catch (Exception e) {
					}

					synchronized (lock2) {
						System.out.println("Thread 2: lock 2");
					}
				}
			}
		};
		t1.start();
		t2.start();
	}
}
