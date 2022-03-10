package org.BaseClass;


	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		public static WebDriver driver;

//		public static WebDriver browserLaunch(String browserName) {
//			
//			if (browserName.equalsIgnoreCase("chrome")) {
//				
//				//WebDriverManager.chromedriver().version("97").setup();
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				
//			}
//			
//			else if (browserName.equalsIgnoreCase("firefox")) {
//				
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				
//			}	
//			
//			else if (browserName.equalsIgnoreCase("edge")) {
//				
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				
//			}	
//			
//			else {
//				
//				System.err.println("Invalid Browser Name");
//				
//			}
//			
//			return driver;
//			
//		}
		
		public static WebDriver browserLaunch(String browserName) {
			
			switch (browserName) {
			
			case "Chrome" :
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "chrome" :
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "Firefox" :
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "firefox" :
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "Edge" :
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			case "edge" :
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			
			default :
				
				System.err.println("Invalid Browser Name");
				
			}
				
			return driver;
			
		}
		
		public static void urlLaunch(String url) {
			
			driver.manage().window().maximize();
			driver.get(url);
			
		}
		
		public static void  implicitWait(long sec) {
			
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			
		}
		
		public static void quit() {
			
			driver.quit();
			
		}
		
		public static String getCurrentUrl() {
			
			return driver.getCurrentUrl();
			
		}
		
		public static String getTitle() {
			
			return driver.getTitle();
			
		}
		
		public static WebElement findElement(String locator, String locValue) {
			
			WebElement e = null;
			
			if (locator.equals("id"))
				e = driver.findElement(By.id(locValue));  
				
			else if (locator.equals("name")) 
				e = driver.findElement(By.name(locValue));
			
			else if (locator.equals("xpath"))
				e = driver.findElement(By.xpath(locValue));
			
			else if (locator.equals("tagname"))
				e = driver.findElement(By.tagName(locValue));
			
			else if (locator.equals("className"))
				e = driver.findElement(By.className(locValue));
			
			else if (locator.equals("linkText"))
				e = driver.findElement(By.linkText(locValue));
			
			else if (locator.equals("partialLinkText"))
				e = driver.findElement(By.partialLinkText(locValue));
			
			else if (locator.equals("cssSelector"))
				e = driver.findElement(By.cssSelector(locValue));
			
			return e;
			
		}
		
		public static String getAttribute( WebElement e ) {
			
			return e.getAttribute("value");
			
		}
		
		public static String getText(WebElement e) {
			
			System.out.println(e.getText());
			return e.getText();
			
		}
		
		public static void sendKeys(WebElement e, String value ) {
			
			e.sendKeys(value);
			
		}
		
		public static void btnClick(WebElement e) {
			
			e.click();
			
		}
		
		public static void moveToElement(WebElement target) {
			
			Actions a = new Actions(driver);
			a.moveToElement(target).perform();
			
		}
		
		public static void dragAndDrop(WebElement source, WebElement target) {
			
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).perform();
			
		}
		
		public static void selectByIndex(WebElement e, int index) {
			
			Select s = new Select(e);
			
		}
		
		public static void takeScreenshot(String imageName) throws IOException {
			
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File des = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + imageName + ".png");
			FileUtils.copyFile(src, des);
			
		}
		
		public static void jsSendKeys(WebElement e, String input) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value', '" + input + "')", e);
			
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
