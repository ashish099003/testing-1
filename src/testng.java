import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testng {
	
	@BeforeMethod( description="This testcase will verify login fucntionality")
	public void loginPage() {
		
		System.out.println("THis is my first testng");
	}
	
	@Test( description="This testcase will succesfully application launched" )
	public void loginPageApplication() {
		Assert.assertEquals(12, 12);
		 System.out.println("Item Selected not done");
	}
	
	@Test(description="This testcase will verify checkout" )
	public void loginPageCheckOut() {
		
		System.out.println("Item checkout");
	}
}
