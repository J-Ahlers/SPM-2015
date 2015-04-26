package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Counts the LOC of the given file according to the 'Size Counting Standard'
 * 
 * @author J. Ahlers
 *
 */
public class Aufgabe2A {

    public static void main(String[] args) {
		if(args.length == 1) {
			String file = readFile(args[0]);        
			int loc = 0;
			
			if(file != null) {
				String[] lines = file.split("\n");
				 
				for(int i = 0; i < lines.length; i++) {
					String line = lines[i];
					// Remove spaces and tabs - otherwise comments and some blank lines will not be counted properly
					line = line.replaceAll(" ", "");
					line = line.replaceAll("\t", "");
					
					boolean empty = line.startsWith("\n") || line.startsWith("\r\n") || line.startsWith("\r");
					boolean comment = line.startsWith("//") || line.startsWith("/*") || line.startsWith("*");
					
					if(empty || comment) {
						continue;
					}
					else {
						loc++;
					}
					
				}
				System.out.println("File [" + args[0] + "] has " + loc + " LOC");
			}
			else {
				System.out.println("Error: Couldn't load file.");
			}
		}
		else {
			System.out.println("Error: Please pass exactly one filename / path as arguement.");
		}	
    }
    
    /**
     * Loads the given file into a String
     * 
     * @param filename Filename - with path - to the file to be loaded
     * @return file-content as String
     */
    public static String readFile(String filename) {
	   String content = null;
	   File file = new File(filename);
	   
	   try {
		   FileReader reader = new FileReader(file);
		   char[] chars = new char[(int) file.length()];
		   reader.read(chars);
		   content = new String(chars);
		   reader.close();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	   
	   return content;
	}
}
