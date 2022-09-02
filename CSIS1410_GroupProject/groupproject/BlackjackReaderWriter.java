/**
 * Assignment: A10-Pre_Changes
 * Program: BlackjackReaderWriter
 * Created: Apr 23, 2019
 *
 * @Author Zachary Funk
 *
 * Notes:
 *
 *
 *
 */
package groupproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlackjackReaderWriter {
	
	

    public void writeCsv(String filePath, String name) throws FileNotFoundException {
        List<String> users = new ArrayList<>();
        users = readFile(filePath);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
        } catch (IOException ex) {
            Logger.getLogger(BlackjackReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            for (int i = 0; i < users.size(); i++) {
                fileWriter.append(users.get(i).toString() + "\n");
            }
            fileWriter.append(name + "\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("");
	}

	public static List<String> readFile(String filePath) {
		//Creating the List for the end result
		List<String> returnFile = new ArrayList<>();
		//Creating all that is needed to read the file
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
		} catch (FileNotFoundException e1) {
			System.err.println("File could not be located");
		}
		BufferedReader bufr = new BufferedReader(fr);
		

		//Reading the file and adding it to returnFile
		String line = "";
		try {
			line = bufr.readLine();
		} catch (IOException e) {
			System.err.println("IO Exeception with the buffer");
		}
		while(line != null) {
			System.out.println(line);
			returnFile.add(line);
			try {
				line = bufr.readLine();
			} catch (IOException e) {
				System.err.println("IO Exeception with line");
			}
		}
		return returnFile;
	}
}
