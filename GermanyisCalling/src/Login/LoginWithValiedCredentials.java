package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@Test
public class LoginWithValiedCredentials {

//	public static void main(String[] args) {
		
		//Lunching Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximizing Window
		driver.manage().window().maximize();
		
		//Navigating To Login Page
		driver.navigate().to("https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F");
		
		//
		driver.findElement(By.id("username")).sendKeys("nandanm2022@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("Demo@123");
		
		driver.findElement(By.cssSelector("button[class='btn btn-danger mt-3']")).click();
		
		String expected_title ="Upload your CV | Germany Is Calling";
		String actual_title = driver.getTitle();
		
		Assert.assertEquals(expected_title, actual_title);
		
		driver.close();
}

}
