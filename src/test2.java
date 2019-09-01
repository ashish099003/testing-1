import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test2 {
	
	
	
	 static void printEverySec() {
		//WFWIHBB// search box
		 short currentTime = (short) System.currentTimeMillis();
		 short lastTime = currentTime;
		 int diff;
		 while(true) {
			 currentTime = (short)System.currentTimeMillis();
			 
			 diff = ((currentTime >= lastTime) ? (currentTime - lastTime) : 
				 ((Short.MAX_VALUE - lastTime) + (currentTime - Short.MIN_VALUE)));

			 if(diff > 1000) {
				 System.out.print(currentTime);
				 System.out.println(" "+lastTime);
				 lastTime = currentTime;
				 System.out.println("hello");
			 }
			 
		} 
		
	 }
	static void overflow_chk() {
		 short curr_count=1;
		 short last_count = 0;
		 
		 while(curr_count > last_count) {
			 last_count = curr_count;
			 System.out.println(" "+curr_count);
			 curr_count++;
		 }
		System.out.println(curr_count);
		System.out.println(last_count);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
	} 
	 
	 public static void main(String [] agrs) {
		// overflow_chk();
		 printEverySec();
	 }

}
