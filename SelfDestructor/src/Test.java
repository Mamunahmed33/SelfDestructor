import java.util.Timer;
import java.util.TimerTask;

public class Test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on: ");
	        }
	    };
	    
		timer.schedule(task, 10000);
		
		System.out.println(123);
	}
}
	