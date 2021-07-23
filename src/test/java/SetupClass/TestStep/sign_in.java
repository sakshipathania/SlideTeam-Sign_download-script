package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sign_in extends Set{
	

	WebDriverWait wait = new WebDriverWait(driver,8);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Website Home Page (\\d+)CO$")
	public void user_is_already_on_Website_Home_Page_CO(int arg1) throws Throwable {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	    Thread.sleep(2000);
	    try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	    Thread.sleep(1000);
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}
		Thread.sleep(1000);
	    
	    
	}

	@Then("^user navigates to sign up page (\\d+)CO$")
	public void user_navigates_to_sign_up_page_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^user logins by existing ac count (\\d+)CO$")
	public void user_create_a_new_ac_count_CO(int arg1) throws Throwable {
		Thread.sleep(1000);
		WebElement old_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='email']")));
		Thread.sleep(1000);
	    old_email.sendKeys("Qwerty120@gmail.com");
	    Thread.sleep(1000);
	    WebElement old_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pass']")));
	    Thread.sleep(1000);
	    old_pass.sendKeys("Qwerty@1");
	    Thread.sleep(1000);
		
		 WebElement old_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
		 Thread.sleep(1000);
		    old_login_btn.click();
		
		
		
	}

	@Then("^user clicks on Most Popular$")
	public void user_clicks_on_Most_Popular throws Throwable {
		
		
		Thread.sleep(1000);
		WebElement Popular_ppt= driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.panel.wrapper > div > nav > div > div > ul > li:nth-child(3) > a"));
	     Thread.sleep(1000);
		Popular_ppt.click();
	
		Thread.sleep(2000);
		WebElement Popular_product= driver.findElement(By.cssSelector("/html/body/div[2]/main/div[2]/div/div[4]/div[2]/ol/li[2]/div/a/img"));
		Thread.sleep(3000);
		Popular_product.click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#clicking")).click();
		Thread.sleep(8000);
		
		
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Join now')])[8]")));
			Thread.sleep(2000);
		    join_now_btn.click();
			Thread.sleep(6000);

	}

	@Then("^user is redirected to checkout page (\\d+)CO$")
	public void user_is_redirected_to_checkout_page_CO(int arg1) throws Throwable {
		Thread.sleep(6000);
	}

	@Then("^user selects another plan$")
	public void user_selects_another_plan throws InterruptedException {
	     try {
		     WebElement Pricing=driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.panel.wrapper > div > nav > div > div > ul > li:nth-child(1) > a"));
		     Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn1  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div[4]/div[3]/span/form/button/span")));
			Thread.sleep(2000);
		    join_now_btn1.click();
			Thread.sleep(6000);
	     } catch( NoSuchElementException popup) { 
	     }
	}

	@Then("^User clicks on Place Order Button$")
	public void user_clicks_on_Place_Order_Button throws Throwable {
		
		try
		{
			WebElement cp_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='paypal_express']")));
			Thread.sleep(2000);
		    cp_btn.click();
		    Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		  Thread.sleep(3000);
		try
		{
			  WebElement place_order_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Place Order')]")));
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			Thread.sleep(3000);
		          place_order_btn.click();
			  Thread.sleep(5000);
		}
		 catch (Exception e) {
			 //TODO: handle exception	 
	        } 
		
		  Thread.sleep(3000);
	    // Maximize Window
		  driver.manage().window().maximize();
		
		  // Store the CurrentWindow for future reference
		 // String handle = " ";
		  String currentWindow = driver.getWindowHandle();
		  String popupWindowHandle = null;
		   
		  // Switch To Popup Window
		  
		  for(String handle : driver.getWindowHandles()){
		   if(!handle.equals(currentWindow)){
		    
		    popupWindowHandle = handle;
		     driver.switchTo().window(popupWindowHandle);
		   }
		  }
		  
		 
		  
		// page title
		  String pp_page_title=driver.getTitle();
			Thread.sleep(3000);
		    System.out.println("Title of the Page is --> "+pp_page_title);
		    
		 // place order button 
			// WebElement cancel_order_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(.,'Cancel and return to Slideteam Pte. Ltd.')])[2]")));
			//	js.executeScript("arguments[0].scrollIntoView();",cancel_order_btn);
		//Thread.sleep(2000);
		//	    cancel_order_btn.click();
		//		Thread.sleep(5000);

				 // Switch To Default Window
		driver.get("https://www.slideteam.net/checkout/");
		Thread.sleep(2000);		  
				  driver.switchTo().window(currentWindow);
		
	}

	@Then("^user deleted the account (\\d+)CO$")
	public void user_deleted_the_account_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
	   WebElement my_account = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.panel.wrapper > div > div > ul > li:nth-child(1) > a")));
	    Thread.sleep(4000);
	   my_account.click();
	    Thread.sleep(4000);
	    
	
		 Thread.sleep(3000);
		 WebElement sign_out = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.panel.wrapper > div > div > ul > li.authorization-link > a")));
		 Thread.sleep(3000);
		 sign_out.click();
		 Thread.sleep(3000);
	}


	
}
