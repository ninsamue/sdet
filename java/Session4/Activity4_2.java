package Session4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity4_2 {
	public static void main(String[] args) throws IOException {
		String fileName="Activity4_2.txt";
		File file = new File(fileName);
		//Create a new file
		boolean fStatus = file.createNewFile();
		
		if(fStatus) 
			System.out.println("New File Created");
		else
			System.out.println("Issue with New File Creation");
		
		//Write to the File created
		FileWriter myWriter = new FileWriter(fileName);
	    myWriter.write("Hello World!!");
	    myWriter.close();
		
		
		//get the file Object
		File fileUtil = FileUtils.getFile("Activity4_2.txt");
		//Read file
		System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
		
		
		//Create directory
		File destDir = new File("resources");
		//Copy file to directory
		FileUtils.copyFileToDirectory(file, destDir);
		
		//Get file from new directory
		File newFile = FileUtils.getFile(destDir, "Activity4_2.txt");
		//Read data from file
		String newFileData = FileUtils.readFileToString(newFile, "UTF8");
		
		//Print it
        System.out.println("Data in new file: " + newFileData);
	}

}
