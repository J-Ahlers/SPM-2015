package metrics;

import file.StorageManager;

public class ObjectMetrics {
	
	private String path;
	
	private int loc;
	private int methods;
	private int comments;
	
	public ObjectMetrics(String path) {
		this.path = path;
		collectMetrics();		
	}
	
	private void collectMetrics() {
		this.loc = 0;
		this.methods = 0;
		this.comments = 0;
			
		String file = StorageManager.readFile(path);
		if(file != null) {
			String[] lines = file.split("\n");
			 
			for(int i = 0; i < lines.length; i++) {
				String line = lines[i];
				// Remove spaces and tabs - otherwise comments and some blank lines will not be counted properly
				line = line.replaceAll(" ", "");
				line = line.replaceAll("\t", "");
				
				boolean empty = line.startsWith("\n") || line.startsWith("\r\n") || line.startsWith("\r");
				boolean comment = line.startsWith("//") || line.startsWith("/*") || line.startsWith("*");
				
				boolean endsWithParenthesis = line.endsWith("{") || line.endsWith("{\r\n") || line.endsWith("{\n") || line.endsWith("{\r");
				boolean isClass = line.startsWith("publicclass") || line.startsWith("privateclass");
				boolean method = (line.startsWith("public") || line.startsWith("private")) && endsWithParenthesis && !isClass;
				
				if(empty) {
					continue;
				}
				else if(comment) {
					this.comments++;
				}
				else if(method) {
					this.methods++;
					this.loc++;
				}
				else {
					this.loc++;
				}
			}
		}
		else {
			System.out.println("Error: Couldn't load file.");
		}
	}
	
	public String getObjectPath() {
		return this.path;
	}

	public int getLOC() {
		return this.loc;
	}
	
	public int getComments() {
		return this.comments;
	}
	
	public int getMethods() {
		return this.methods;
	}
	
	/**
	 * Does not exclude class variables, imports etc.!
	 * 
	 */
	public double LOCperMethod() {
		return (double) this.loc / (double) this.methods;
	}
}
