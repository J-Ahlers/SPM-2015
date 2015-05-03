package file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import list.List;

public class StorageManager {
	
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
	
	public static List<String> listFiles(String path) {
		return listFiles(path, "");
	}
    
    public static List<String> listFiles(String path, String filetype) {
		List<String> result = new List<String>();
		
		File root = new File( path );
        File[] list = root.listFiles();

        if(list == null) {
			return result;
		}

        for(File f : list) {
			String current = f.getAbsolutePath();
            if(f.isDirectory()) {
                result.add(listFiles(current, filetype));
            }
            else if(current.endsWith(filetype) || filetype.equals("")) {
                result.add(current);
            }
        }
		
		return result;
    }

}
