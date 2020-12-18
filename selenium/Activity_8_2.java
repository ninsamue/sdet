package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_8_2 {
	
	public static void main(String[] args){
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser with https://training-support.net/selenium/tables using get() method.
		driver.get("https://training-support.net/selenium/tables");
		
		//Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']//tr"));
		System.out.println("The number of Rows : "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']//tr[1]/td"));
		System.out.println("The number of Columns : "+columns.size());		
		
		//Find and print the cell value at the second row and second column.
		WebElement secondRowColumn = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
		System.out.println("Second Row, Second Column Value : "+secondRowColumn.getText());
		
		//Click the header of the first column to sort by name.
		WebElement firstHeader = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr[1]/th[1]"));
		System.out.println(firstHeader.getText());
	
		firstHeader.click();
		
		//Find and print the cell value at the second row and second column again.
		secondRowColumn = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
		System.out.println("Second Row, Second Column Value : "+secondRowColumn.getText());
		
		//Print the cell values of the table footer.
		List<WebElement> footer = driver.findElements(By.xpath("//tfoot//th"));
		
		System.out.println("Footer Values : ");
		for(WebElement footerVal:footer)
			System.out.println(footerVal.getText());
		
		//Close the browser
		driver.close();
		
		
	}

}
