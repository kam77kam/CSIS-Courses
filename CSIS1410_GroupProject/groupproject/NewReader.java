/**
 * Assignment: A10_FileSystem
 * Program: NewReader
 * Created: Apr 23, 2019
 * @Author Zachary Funk
 *
 * Notes:
 *
 *
 **/



package groupproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class NewReader {
	public static void main(String[] args) {
		NewReader myReader = new NewReader();
		myReader.fileReader();
	}
	public void fileWriter() {
		
	}
	public List<String> fileReader(){
		File file = new File("src");
		for(String fileNames : file.list()) System.out.println(fileNames);
		
		List<String> list = null;
		list.add("Zachary");
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("./src/groupProject/Users.txt/");
		} catch (IOException e) {
			System.err.println("There was an error writing to your file");
		}
		//Making the printer for the file
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    //Writing each line to the file
	    for (int i = 0; i < list.size(); i++) {
	    	printWriter.println(list.get(i));
		}
	    printWriter.close();
		
		
		return null;
	}
}
