package metrics;

import list.List;
import file.StorageManager;

public class ProjectMetrics {
	
	private String projectPath;
	private List<String> files;
	private List<ObjectMetrics> metrics;
	
	public ProjectMetrics(String path, String filetype) {
		this.files = StorageManager.listFiles(path, filetype);
		this.projectPath = path;
		collectMetrics();
	}
	
	private void collectMetrics() {
		this.metrics = new List<ObjectMetrics>();
		
		while(files.hasNext()) {
			ObjectMetrics m = new ObjectMetrics((String) files.getNext());
			metrics.add(m);
		}
	}
	
	public void printMetrics() {
		int totalLOC = 0;
		int totalMethods = 0;
		int totalComments = 0;
		
		String line = "";
		for(int i = 0; i < 80; i++) {
			line = line + "-";
		}
		
		System.out.println(line);
		
		while(metrics.hasNext()) {
			ObjectMetrics m = (ObjectMetrics) metrics.getNext();
			String filepath = m.getObjectPath().replace(this.projectPath, "");
			String spacing = "";
			
			while((filepath.length() + spacing.length()) < 35) {
				spacing = spacing + " ";
			}
			
			String locspacing = getSpacing(m.getLOC());
			String methodspacing = getSpacing(m.getMethods());
			String commentspacing = getSpacing(m.getComments());
			
			totalLOC += m.getLOC();
			totalMethods += m.getMethods();
			totalComments += m.getComments();
			
			System.out.println(filepath + " " + spacing + "| LOC: " + locspacing + m.getLOC() + " | Methods: " + methodspacing + m.getMethods() + " | Comments: " + commentspacing + m.getComments());			
		}
		
		System.out.println(line);
		
		String totalSpacer = "";
		for(int i = 0; i < 31; i++) {
			totalSpacer = totalSpacer + " ";
		}
		
		String locspacing = getSpacing(totalLOC);
		String methodspacing = getSpacing(totalMethods);
		String commentspacing = getSpacing(totalComments);
		
		System.out.println("TOTAL" + totalSpacer + "| LOC: " + locspacing + totalLOC + " | Methods: " + methodspacing + totalMethods + " | Comments: " + commentspacing + totalComments);
	}
	
	private String getSpacing(int value) {
		String spacing = "";
		if(value < 10) {
			spacing = "   ";
		}
		else if(value < 100) {
			spacing = "  ";
		}
		else if(value < 1000) {
			spacing = " ";
		}	
		
		return spacing;
	}
	
	public List<ObjectMetrics> getMetrics() {
		return this.metrics;
	}
}
