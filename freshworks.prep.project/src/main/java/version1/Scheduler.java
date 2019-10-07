package version1;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class Scheduler {

static class Reminder {
	    static Timer timer;
	    static Map<String, Product> map; 
	    static String key; 
	    int timeToLive;
	    Reminder(Map<String, Product> map, String key, int timeToLive) {
	    	this.map=map;
	    	this.key=key;
	    	this.timeToLive=timeToLive;
	    	timer = new Timer();
	        timer.schedule(new RemindTask(), timeToLive*1000);
		}

	    class RemindTask extends TimerTask {
	        public void run() {
	            System.out.println("Time's up!");
	            Reminder.delete();
	            timer.cancel(); //Terminate the timer thread
	        }

			
	    }
	    public static void delete() {
			// TODO Auto-generated method stub
	    	Iterator<Map.Entry<String, Product>> itr = map.entrySet().iterator();
			boolean check=false;
	    	while(itr.hasNext()) {
				Map.Entry<String, Product> entry = itr.next();
			    if(entry.getKey().equals(key)) {
			        System.out.println("Removed Key:"+key);
			        check=true;
			        itr.remove();
			    }
			}
			if(check==false)
				System.out.println("key is not available");
		}
	}
	    
	public void deleteKeyAfter(Map<String, Product> map, String key, int timeToLive) {
		// TODO Auto-generated method stub
		System.out.println("Task is scheduled");
		new Reminder(map, key, timeToLive);
		
	}

	

}
