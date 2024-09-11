import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginFunctionality {

	   WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        // Set the correct path to ChromeDriver, not the Chrome browser
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\drivers\\chromedriver.exe");

	        // Initialize ChromeDriver
	        driver = new ChromeDriver();

	        // Maximize the browser window
	        driver.manage().window().maximize();
	    }
	    
	    @Test(priority = 1)
		public void testvalidCredentials() {
		
//		Navigating To Login Page
		driver.navigate().to("https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F");
		
//		Locating email and password fields and sending Valid Credentials.
		driver.findElement(By.id("username")).sendKeys("nandanm2022@gmail.com");//Valid Email
		driver.findElement(By.id("password")).sendKeys("Demo@123");//valid Password
		
//		Click on Login Button
		driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
		
//		Expected title
		String expected_title ="Upload your CV | Germany Is Calling";
//		getting actual title
		String actual_title = driver.getTitle();
		
//		Comparing actual and expected title
		Assert.assertEquals(actual_title,expected_title);
		
//		Clicking on dropdown button
		driver.findElement(By.id("dropdownUser1")).click();
		
//		Click on Logout
		driver.findElement(By.cssSelector("a[class='text-decoration-none text-danger dropdown-item']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	    
    @Test(priority = 2)
    public void testInvalidPassword() {

//         Locating email and password fields and sending incorrect password
        driver.findElement(By.id("username")).sendKeys("nandanm2022@gmail.com"); // Valid email
        driver.findElement(By.id("password")).sendKeys("Demo@1241"); // Invalid password

//         Click on Login Button
        driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();

//      Verify if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li"));
        if(errorMessage.isDisplayed()) {
        	System.out.println("Invalid Password Test Case Passed: "+errorMessage.getText());
        }
        	else 
        	{
        		System.out.println("Test case Failed: "+errorMessage.getText());
        	}     	
        }
    
    @Test(priority = 3)
    public void testInvalidEmail() {
    	
//    	Locating email and password fields and sending InValid Email.
        driver.findElement(By.id("username")).sendKeys("nandanm236@gmail.com"); // InValid email
        driver.findElement(By.id("password")).sendKeys("Demo@123"); //Valid password
        
//      Click on Login Button
        driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
        
//         Verify if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li"));
        if(errorMessage.isDisplayed()) {
        	System.out.println("Invalid Email Test Case Passed: "+errorMessage.getText());
        }
        	else 
        	{
        		System.out.println("Test case Failed: "+errorMessage.getText());
        	}        	
        }
    
    @Test(priority = 4)
    public void testBothInvalidCredentials() {
      
//         Locating email and password fields and sending both invalid credentials
        driver.findElement(By.id("username")).sendKeys("nandn@123@gmail.com"); // Invalid email
        driver.findElement(By.id("password")).sendKeys("Try@123"); // Invalid password

//         Click on Login Button
        driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
        
        
//      Verify if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li"));
        if(errorMessage.isDisplayed()) {
        	System.out.println("Both Invalid Credentials Test Case Passed: "+errorMessage.getText());
        }
        	else 
        	{
        		System.out.println("Test case Failed: "+errorMessage.getText());
        	}        	
        }
    
    
    @Test(priority = 5)
    public void testEmptyEmail() {
       
//         Locating email and password fields and leaving email empty
        driver.findElement(By.id("username")).sendKeys(""); // Empty email
        driver.findElement(By.id("password")).sendKeys("Demo@123"); // Valid password

//         Click on Login Button
        driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
        
//      Verify if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li"));
        if(errorMessage.isDisplayed()) {
        	System.out.println("Empty Email Test Case Passed: "+errorMessage.getText());
        }
        	else 
        	{
        		System.out.println("Test case Failed: "+errorMessage.getText());
        	}        	
        }
    
    @Test(priority = 6)
    public void testEmptyPassword() {

//         Locating email and password fields and leaving password empty
        driver.findElement(By.id("username")).sendKeys("nandanm2022@gmail.com"); // Valid email
        driver.findElement(By.id("password")).sendKeys(""); // Empty password

//         Click on Login Button
        driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
//         Verify if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li"));
        if(errorMessage.isDisplayed()) {
        	System.out.println("Empty Password Test Case Passed: "+errorMessage.getText());
        }
        	else 
        	{
        		System.out.println("Test case Failed: "+errorMessage.getText());
        	}        	
        }
    
    @Test(priority = 7)
    public void testBothEmptyFields() {

//         Leaving both fields empty
        driver.findElement(By.id("username")).sendKeys(""); // Empty email
        driver.findElement(By.id("password")).sendKeys(""); // Empty password

//         Click on Login Button
        driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
        
//         Verify if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li"));
        if(errorMessage.isDisplayed()) {
        	System.out.println("Empty Email & Password Test Case Passed: "+errorMessage.getText());
        }
        	else 
        	{
        		System.out.println("Test case Failed: "+errorMessage.getText());
        	}   
        driver.quit();
        }
}