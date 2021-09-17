/**
 * 
 */
package JavaBasics4;

/**
 * This Class demonstrates a Singleton structure with double check locking.
 * 
 * @author mattb
 *
 */
public class SingleDCheckLock {

	volatile public static SingleDCheckLock instance = null;

	private SingleDCheckLock() {

	}

	public static SingleDCheckLock getInstance() {
		if (instance == null) {
			synchronized (SingleDCheckLock.class) {
				if (instance == null) {
					instance = new SingleDCheckLock();
				}
			}
		}
		return instance;
	}
}
