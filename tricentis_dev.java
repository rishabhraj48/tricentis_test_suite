package MA3_Tricentis_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class tricentis_dev {
    private WebDriver w;
    private WebDriverWait wait;
    private String email = "rishabhraj2406@gmail.com";

    @BeforeTest
    public void setup() {
        w = new ChromeDriver();
        w.manage().window().maximize();
        wait = new WebDriverWait(w, Duration.ofSeconds(10));
        System.out.println("Browser launched.");
    }
    

    @Test(priority = 0)
    public void registerUser() throws InterruptedException {
        w.get("https://demowebshop.tricentis.com/register");
        w.findElement(By.id("gender-male")).click();
        w.findElement(By.id("FirstName")).sendKeys("Rishabh");
        w.findElement(By.id("LastName")).sendKeys("Raj");
        w.findElement(By.id("Email")).sendKeys(email);
        w.findElement(By.id("Password")).sendKeys("Hello@1234");
        w.findElement(By.id("ConfirmPassword")).sendKeys("Hello@1234");
        w.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        System.out.println("Registration completed.");
    }
    

    @Test(priority = 1)
    public void loginUser() {
        w.get("https://demowebshop.tricentis.com/login");
        w.findElement(By.id("Email")).sendKeys(email);
        w.findElement(By.id("Password")).sendKeys("Hello@1234");
        w.findElement(By.cssSelector("input.login-button")).click();
        WebElement accountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        Assert.assertTrue(accountLink.isDisplayed(), "Login failed!");
        System.out.println("Login successful!");
    }

    
    @Test(priority = 2)
    public void addDesktopToCart() throws InterruptedException {
        w.findElement(By.linkText("Computers")).click();
        w.findElement(By.linkText("Desktops")).click();
        w.findElements(By.cssSelector(".product-item")).get(1).click(); // Selecting the second desktop
        System.out.println("Selected second desktop.");
        
        //Select ramDropdown = new Select(w.findElement(By.id("product_attribute_2")));
        //ramDropdown.selectByIndex(1);
        System.out.println("RAM Selected");
        
        w.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[6]/dl/dd[3]/ul/li[1]/label")).click();
        //w.findElement(By.id("product_attribute_16_3_6_18")).click();
        System.out.println("HDD Selected");
        Thread.sleep(4000);
        
        w.findElement(By.id("add-to-cart-button-16")).click();
        System.out.println("Desktop added to cart.");
        Thread.sleep(2000);
    }
    

    @Test(priority = 3)
    public void checkoutProcess() throws InterruptedException{
        w.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        System.out.println("Shopping Cart Clicked.");
        
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice")));
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
        System.out.println("Terms and Condition ticked.");
        
        w.findElement(By.id("checkout")).click();
        System.out.println("Checkout initiated.");
    }

    @Test(priority = 4)
    public void fillPBillingDetails() throws InterruptedException{
    	 System.out.println("Filling billing details.");
    	    
    	    WebElement billingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"billing-buttons-container\"]/input")));
    	    billingButton.click();
    	    System.out.println("Billing Address Filled");
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shipping-buttons-container\"]/input"))).click();
    	    System.out.println("Shipping Address Filled");
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input"))).click();
    	    System.out.println("Shipping Method Selected");
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input"))).click();
    	    System.out.println("Payment Method Selected");
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input"))).click();
    	    System.out.println("Payment Information Submitted");
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input"))).click();
    	    System.out.println("Order Confirmed.");
    	
    }

       
    @Test(priority = 5)
    public void logoutUser() throws InterruptedException{
    	Thread.sleep(3000);
        w.findElement(By.linkText("Log out")).click();
        System.out.println("Logout successful.");
    }

    
    @AfterTest
    public void tearDown() {
        w.quit();
        System.out.println("Browser closed.");
    }
}



