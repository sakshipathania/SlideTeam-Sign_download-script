package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Sign_In extends Set {
	
	WebDriverWait wait = new WebDriverWait(driver,10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Website Home Page pp$")
	public void user_is_already_on_Website_Home_Page_pp() throws Throwable {
		
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
	    
	}

	@Then("^user navigates to sign up page pp$")
	public void user_navigates_to_sign_up_page_pp() throws Throwable {
		Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^user create a new ac count pp$")
	public void user_create_a_new_ac_count_pp() throws Throwable {
		
		// create new email for sign up
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	    
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.findElement(By.id("email_address")).sendKeys(full_email);
		

		Thread.sleep(2000);
	    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/form/fieldset/div[4]/div/input")));
		Thread.sleep(2000);
	    new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);
		
		// enter name

	    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
		Thread.sleep(2000);
	    new_fname_signup.sendKeys("Selenium");
		Thread.sleep(2000);

	    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
		Thread.sleep(2000);
	    new_lname_signup.sendKeys("Testing");
		Thread.sleep(2000);
		
		//enter password
		 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			Thread.sleep(2000);
		    new_pwd_signup.sendKeys("selenium@123");
			Thread.sleep(2000);

		    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
			Thread.sleep(2000);
		    new_pwd1_signup.sendKeys("selenium@123");
			Thread.sleep(2000);
			
			// enter captcha
			WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
			Thread.sleep(2000);
		    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
			Thread.sleep(2000);
		    
		    // sign  up button
		    WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
			Thread.sleep(2000);
		    new_btn_signup.click();
			Thread.sleep(2000);
	    
	}

	@Then("^user is redirected to pricing page and choose a plan to pay pp$")
	public void user_is_redirected_to_pricing_page_and_choose_a_plan_to_pay_pp() throws Throwable {
	   
		
		driver.get("https://www.slideteam.net/pricing?utm_expid=.ob6CI18MTrailD_9AQRC-g.0&utm_referrer=https%3A%2F%2Fwww.slideteam.net%2Fpricing");
		Thread.sleep(4000);
		// choose a plan
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]//div[3]//span[1]//form[1]//button[1]//span[1]")));
		js.executeScript("arguments[0].scrollIntoView();",join_now_btn);	
		Thread.sleep(2000);
		    join_now_btn.click();
			Thread.sleep(5000);

	}

	@Then("^user is redirected to checkout page pp$")
	public void user_is_redirected_to_checkout_page_pp() throws Throwable {
		Thread.sleep(2000);
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
		
		Thread.sleep(1000);
	}

	@Then("^user proceed to pay with paypal pp$")
	public void user_proceed_to_pay_with_paypal_pp() throws Throwable {
		Thread.sleep(2000);
		
		// place order button 
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
	}

	@Then("^paypal popup appears and user navigates back to my account pp$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_pp() throws Throwable {
	    
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
			   driver.manage().window().maximize();
		   }
		  }
		  
		 
		  
		// page title
		  String pp_page_title=driver.getTitle();
			Thread.sleep(3000);
		    System.out.println("Title of the Page is --> "+pp_page_title);
		    
		 // place order button 
			 WebElement cancel_order_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(.,'Cancel and return to Slideteam Pte. Ltd.')])[2]")));
				js.executeScript("arguments[0].scrollIntoView();",cancel_order_btn);
		Thread.sleep(2000);
			    cancel_order_btn.click();
				Thread.sleep(5000);

				 // Switch To Default Window
				  
				  driver.switchTo().window(currentWindow);
		    
	}

	@Then("^user deleted the account pp$")
	public void user_deleted_the_account_pp() throws Throwable {
	   
		Thread.sleep(2000);
		

		 driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		 Thread.sleep(3000);
		 
		


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



		 WebElement delete_account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div/div[2]/div[2]/div[2]/ul/li/a")));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/form/button[1]")));
		js.executeScript("arguments[0].scrollIntoView();",continue_delete);
		continue_delete.click();
		 Thread.sleep(3000);
		
	}


}
