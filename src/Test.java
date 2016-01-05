import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Test {
	
	@FindBy(how=How.ID, using="memberId")
	private static WebElement element;
	
	public static void main(String[] args) {
		
		System.out.println("Main method starts");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://account.netzero.net");
		PageFactory.initElements(driver, Test.class);
		
		
		
		driver.navigate().refresh();
		
		element.sendKeys("Sathish");
		
		
		
		System.out.println("Main method end");

	}

}
