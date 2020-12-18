package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_8_1 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser with https://training-support.net/selenium/tables using get() method.
		driver.get("https://training-support.net/selenium/tables");
		
		//Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]//tr"));
		System.out.println("The number of rows : "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class,'striped')]//tr[1]/td"));
		System.out.println("The number of columns : "+columns.size());
		
		//Find and print the all the cell values of the third row of the table.
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class,'striped')]//tr[3]/td"));
		
		System.out.println("Third row elements");
		for(WebElement cellValue : thirdRow)
			System.out.println(cellValue.getText());
		
		//Find and print the cell value at the second row and second column.
		System.out.println("Second Row, Second Column");
	    WebElement secondRowColumn = driver.findElement(By.xpath("//table[contains(@class,'striped')]//tr[2]/td[2]"));
	    System.out.println(secondRowColumn.getText());
	    
	    //Close the browser.
	    driver.close();
		
	}

}

