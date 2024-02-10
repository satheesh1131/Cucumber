package com.resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static Actions act;
	public static WebDriverWait wait;
	protected static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	/**
	 * Returns the driver of ThreadLocal Class.
	 * @return
	 */
	public static WebDriver getDriver(){
		return driver.get();
	}
	/**
	 * It opens any one of the browser by the given input browser name.
	 * @param browserName
	 */
	public static WebDriver openBrowser(String browserName) {
		switch(browserName.toLowerCase()) {
		case("chrome"):{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));
			break;
		}
		case("edge"):{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			driver.set(new EdgeDriver(options));
			break;
		}
		default:{
			System.out.println("UnIdentified Browser");
		}
		}
		return getDriver();
	}
	/***
	 * It closes the current focused window of the browser.
	 */
	public static void closeWindow() {
		getDriver().close();
	}
	/**
	 * It closes entire browser. In other words, it kills the browser session.
	 */
	public static void closeBrowser() {
		getDriver().quit();
	}
	/**
	 * It gets to the page by the given URL.
	 * @param url
	 */
	public static void loadUrl(String url) {
		getDriver().get(url);
	}
	/**
	 * Opens new window.
	 */
	public static void newWindow() {
		getDriver().switchTo().newWindow(WindowType.WINDOW);
	}
	/**
	 * Opens new tab in the same window.
	 */
	public static void newTab() {
		getDriver().switchTo().newWindow(WindowType.TAB);
	}
	/**
	 * Opens new window and loads given URL.
	 * @param url
	 */
	public static void newWindow(String url) {
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		getDriver().get(url);
	}
	/**
	 * Opens new tab in the same window and loads given URL.
	 * @param url
	 */
	public static void newTab(String url) {
		getDriver().switchTo().newWindow(WindowType.TAB);
		getDriver().get(url);
	}
	/**
	 * It navigates to the page by the given URL.
	 * @param url
	 */
	public static void navigateUrl(String url) {
		getDriver().navigate().to(url);
	}
	/**
	 * Go to the previous page.
	 */
	public static void back() {
		getDriver().navigate().back();
	}
	/**
	 * Go to next page.
	 */
	public static void forward() {
		getDriver().navigate().forward();
	}
	/**
	 * Reload the current page.
	 */
	public static void reload() {
		getDriver().navigate().refresh();
	}
	/**
	 * Get the current page URL and return in String.
	 * @return
	 */
	public static String getPageUrl() {
		return getDriver().getCurrentUrl();
	}
	/**
	 * Get the current page title and return in String.
	 * @return
	 */
	public static String getPageTitle() {
		return getDriver().getTitle();
	}
	/**
	 * Implicitly waits for the 10 seconds.
	 * It applies for all WebElements in the webpage.
	 */
	public static void implicityWait() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * Wait until the page loads completely.
	 */
	public static void pageLoadTimeout() {
		getDriver().manage().timeouts().getPageLoadTimeout();
	}
	/**
	 * Get the Window Handle of the current window and return in String.
	 * @return
	 */
	public static String getCurrentWindowHandle() {
		return getDriver().getWindowHandle();
	}
	/**
	 *  Get the All Window Handles and return in Set<String>.
	 * @return
	 */
	public static Set<String> getAllWindowHandle() {
		return getDriver().getWindowHandles();
	}
	/**
	 * Get the All Window Handles and return in List<String>.
	 * @return
	 */
	public static List<String> getAllWindowHandleList() {
		List<String> li=new ArrayList<>(getDriver().getWindowHandles());
		return li;
	}
	/**
	 * Switch the focus to the given Window Handle.
	 * @param handle
	 */
	public static void switchToWindow(String handle) {
		getDriver().switchTo().window(handle);
	}
	/**
	 * Switch the focus to Alert and accept it.
	 */
	public static void alertAccept() {
		getDriver().switchTo().alert().accept();
	}
	/**
	 * Switch the focus to Alert and dismiss it.
	 */
	public static void alertDismiss() {
		getDriver().switchTo().alert().dismiss();
	}
	/**
	 * Switch the focus to Alert and get the text in it.
	 * @return
	 */
	public static String alertGetText() {
		return getDriver().switchTo().alert().getText();
	}
	/**
	 * Switch the focus to Alert and enter the given value in the textbox.
	 * @param inputValue
	 */
	public static void alertInputText(String inputValue) {
		getDriver().switchTo().alert().sendKeys(inputValue);
	}
	/**
	 * Take screenshot of the entire webpage display area and saves the file in given path.
	 * @param pathName
	 */
	public static void screenShotPage(String pathName) {
		TakesScreenshot ts=(TakesScreenshot) getDriver();
		try {
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(pathName));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Take screenshot of the page and returns it in Byte[].
	 * @return 
	 */
	public static byte[] screenShot() {
		TakesScreenshot ts=(TakesScreenshot) BaseClass.getDriver();
		return (ts.getScreenshotAs(OutputType.BYTES));
	}
	/**
	 * Right click on the given WebElement.
	 * @param targetElement
	 */
	public static void rightClick(WebElement targetElement) {
		act=new Actions(getDriver());
		act.contextClick(targetElement).perform();
	}
	/**
	 * Double click on the given WebElement.
	 * @param targetElement
	 */
	public static void doubleClick(WebElement targetElement) {
		act=new Actions(getDriver());
		act.doubleClick(targetElement).perform();
	}
	/**
	 * Move the mouse pointer to the target WebElement. 
	 * @param targetElement
	 */
	public static void mouseHover(WebElement targetElement) {
		act=new Actions(getDriver());
		act.moveToElement(targetElement).perform();
	}
	/**
	 * Right click using mouse.
	 */
	public static void rightClick() {
		act=new Actions(getDriver());
		act.contextClick().perform();
	}
	/**
	 * Click using mouse.
	 */
	public static void mouseClick() {
		act=new Actions(getDriver());
		act.click().perform();
	}
	/**
	 * Double click using mouse.
	 */
	public static void doubleClick() {
		act=new Actions(getDriver());
		act.doubleClick().perform();
	}
	/**
	 * Drag the source WebElement and drop it in the target WebElement. 
	 * @param sourceElement
	 * @param targetElement
	 */
	public static void dragAndDropElement(WebElement sourceElement,WebElement targetElement) {
		act=new Actions(getDriver());
		act.dragAndDrop(sourceElement, targetElement).perform();
	}
	/**
	 * Press down arrow key once using Action class.
	 */
	public static void downArrowPress() {
		new Actions(getDriver()).sendKeys(Keys.DOWN).perform();
	}
	/**
	 * Keyboard action- down key pressed once by Robot class.
	 */
	public static void downKeyPress() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Keyboard action- Enter key pressed once by Robot class.
	 */
	public static void enterKeyPress() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Explicitely wait 10 seconds for alerts to appear.
	 */
	public static void waitForAlert() {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * Explicitly wait 10 seconds until the visibility of given element.
	 * @param element
	 */
	public static void waitForElementVisible(WebElement element) {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Explicitly wait 10 seconds until the visibility of all given elements.
	 * @param elements
	 */
	public static void waitForElementVisible(List<WebElement> elements) {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	/**
	 * Explicitly wait 10 seconds until the invisibility of given element.
	 * @param element
	 */
	public static void waitForElementInvisible(WebElement element) {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * Explicitly wait 10 seconds until the invisibility of all given elements.
	 * @param elements
	 */
	public static void waitForElementInvisible(List<WebElement> elements) {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	/**
	 * Explicitly wait 10 seconds until the given element to be clickable.
	 * @param element
	 */
	public static void waitForElementClickable(WebElement element) {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Explicitly wait 10 seconds until the given element's text is to be given text.
	 * @param element
	 * @param textValue
	 */
	public static void waitForTextChange(By elementLocator,String textValue) {
		wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBe(elementLocator,textValue));
	}
	/**
	 * Switch the focus to the parent frame.
	 */
	public static void frameParent() {
		getDriver().switchTo().parentFrame();
	}
	/**
	 * Switch the focus to the default WebPage from the frame.
	 */
	public static void frameDefault() {
		getDriver().switchTo().defaultContent();
	}
	/**
	 * Switch the focus to the frame which has given Id or Name Value.
	 * @param idOrNameValue
	 */
	public static void frameByIdOrName(String idOrNameValue) {
		getDriver().switchTo().frame(idOrNameValue);
	}
	/**
	 * Switch the focus to the frame which has the given frame element.
	 * @param frameElement
	 */
	public static void frameByElement(WebElement frameElement) {
		getDriver().switchTo().frame(frameElement);
	}
	/**
	 * Switch the focus to the frame by index value of the frame.
	 * @param index
	 */
	public static void frameByIndex(int index) {
		getDriver().switchTo().frame(index);
	}
	/**
	 * Click the WebElement. 
	 * @param element
	 */
	public static void click(WebElement element) {
		element.click();
	}
	/**
	 * Clear the text in the WebElement. 
	 * @param element
	 */
	public static void clear(WebElement element) {
		element.clear();
	}
	/**
	 * Send the given value to the specified WebElement.
	 * @param element
	 * @param inputValue
	 */
	public static void sendText(WebElement element,String inputValue) {
		element.sendKeys(inputValue);
	}
	/**
	 * Get the text of the specified element and return in string value.
	 * @param element
	 * @return
	 */
	public static String getText(WebElement element) {
		return element.getText();
	}
	/**
	 * Get the tagName of the element and return in String type.
	 * @param element
	 * @return
	 */
	public static String getTagName(WebElement element) {
		return element.getTagName();
	}
	/**
	 * Get the any of the given attribute value and return in string.
	 * @param element
	 * @param attribute
	 * @return
	 */
	public static String getAttributeValue(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}
	/**
	 * Get the any of the given css property and return in String type.
	 * @param element
	 * @param propertyName
	 * @return
	 */
	public static String getCssValue(WebElement element,String propertyName) {
		return element.getCssValue(propertyName);
	}
	/**
	 * Take the ScreenShot of the given particular WebElement and saves in the given pathName.
	 * @param element
	 * @param pathName
	 */
	public static void screenShotElement(WebElement element,String pathName) {
		try {
			FileHandler.copy(element.getScreenshotAs(OutputType.FILE),new File(pathName));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Check the element is displayed or not.And return the value in boolean.
	 * @param element
	 * @return
	 */
	public static boolean checkDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	/**
	 * Check the element is selected or not.And return the value in boolean.
	 * @param element
	 * @return
	 */
	public static boolean checkSelected(WebElement element) {
		return element.isSelected();
	}
	/**
	 * Check the element is enabled or not.And return the value in boolean.
	 * @param element
	 * @return
	 */
	public static boolean checkEnabled(WebElement element) {
		return element.isEnabled();
	}
	/**
	 * Check the dropDown whether it is multiple and return in boolean value.
	 * @param dropDownElement
	 * @return
	 */
	public static boolean checkMultiple(WebElement dropDownElement) {
		return new Select(dropDownElement).isMultiple();
	}
	/**
	 * Get all the options in the dropDown and return in List of WebElement.
	 * @param dropDownElement
	 * @return
	 */
	public static List<WebElement> getAllOptions(WebElement dropDownElement){
		return new Select(dropDownElement).getOptions();
	}
	/**
	 * Get all the selected options in the dropDown and return in List of WebElement.
	 * @param dropDownElement
	 * @return
	 */
	public static List<WebElement> getAllSelectedOptions(WebElement dropDownElement){
		return new Select(dropDownElement).getAllSelectedOptions();
	}
	/**
	 * Get the first selected option in the dropDown and return in WebElement.
	 * @param dropDownElement
	 * @return
	 */
	public static WebElement getFirstSelectedOptions(WebElement dropDownElement){
		return new Select(dropDownElement).getFirstSelectedOption();
	}
	/**
	 * Select the element of the dropDown by given indexValue.
	 * @param dropDownElement
	 * @param indexValue
	 */
	public static void selectByIndex(WebElement dropDownElement,int indexValue) {
		new Select(dropDownElement).selectByIndex(indexValue);
	}
	/**
	 * Select the element of the dropDown by given Value.
	 * @param dropDownElement
	 * @param value
	 */
	public static void selectByValue(WebElement dropDownElement,String value) {
		new Select(dropDownElement).selectByValue(value);
	}
	/**
	 * Select the element of the dropDown by given VisibleText.
	 * @param dropDownElement
	 * @param visibleText
	 */
	public static void selectByVisibleText(WebElement dropDownElement,String visibleText) {
		new Select(dropDownElement).selectByVisibleText(visibleText);
	}
	/**
	 * Deselect the element of the dropDown by given indexValue.
	 * @param dropDownElement
	 * @param indexValue
	 */
	public static void deselectByIndex(WebElement dropDownElement,int indexValue) {
		new Select(dropDownElement).deselectByIndex(indexValue);
	}
	/**
	 * Deselect the element of the dropDown by given Value.
	 * @param dropDownElement
	 * @param value
	 */
	public static void deselectByValue(WebElement dropDownElement,String value) {
		new Select(dropDownElement).deselectByValue(value);
	}
	/**
	 * Deselect the element of the dropDown by given VisibleText.
	 * @param dropDownElement
	 * @param visibleText
	 */
	public static void deselectByVisibleText(WebElement dropDownElement,String visibleText) {
		new Select(dropDownElement).deselectByVisibleText(visibleText);
	}
	/**
	 * Deselect all the elements in the dropDown.
	 * @param dropDownElement
	 */
	public static void deselectAll(WebElement dropDownElement) {
		new Select(dropDownElement).deselectAll();
	}
	/**
	 * Scroll the window until the view of the given WebElement.
	 * @param element
	 */
	public static void jsScrollByElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * Click the given WebElement using JavaScriptExecutor.
	 * @param element
	 */
	public static void jsClickElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click()",element);
	}
	/**
	 * Enter the given input text value in the given WebElement using JavaScriptExecutor.
	 * @param element
	 * @param inputValue
	 */
	public static void jsSendText(WebElement element,String inputValue) {
		JavascriptExecutor js=(JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].setAttribute('value','"+inputValue+"')",element);
	}
	
	
}
