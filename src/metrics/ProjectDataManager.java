package metrics;

import list.List;

public class ProjectDataManager {
	
	private List<ProjectData> testdata_4a;
	private List<ProjectData> actualdata_4a;
	
	private List<ProjectData> exercisedata;
	
	public ProjectDataManager() {
		// Table D8
		this.testdata_4a = new List<ProjectData>();
		
		ProjectData p01 = new ProjectData(130, 163, 186, 0, 0);
		ProjectData p02 = new ProjectData(650, 765, 699, 0, 0);
		ProjectData p03 = new ProjectData(99, 141, 132, 0, 0);
		ProjectData p04 = new ProjectData(150, 166, 272, 0, 0);
		ProjectData p05 = new ProjectData(128, 137, 291, 0, 0);
		ProjectData p06 = new ProjectData(302, 355, 331, 0, 0);
		ProjectData p07 = new ProjectData(95, 136, 199, 0, 0);
		ProjectData p08 = new ProjectData(945, 1206, 1890, 0, 0);
		ProjectData p09 = new ProjectData(368, 433, 788, 0, 0);
		ProjectData p10 = new ProjectData(961, 1130, 1601, 0, 0);
		
		this.testdata_4a.add(p01);
		this.testdata_4a.add(p02);
		this.testdata_4a.add(p03);
		this.testdata_4a.add(p04);
		this.testdata_4a.add(p05);
		this.testdata_4a.add(p06);
		this.testdata_4a.add(p07);
		this.testdata_4a.add(p08);
		this.testdata_4a.add(p09);
		this.testdata_4a.add(p10);
		
		// Collected Data on Programs 2A, 3A and 4A
		this.actualdata_4a = new List<ProjectData>();
		
		ProjectData ad01 = new ProjectData(null, 100, 49, null, null);
		ProjectData ad02 = new ProjectData(null, 100, 85, null, null);
		ProjectData ad03 = new ProjectData(null, 180, 156, null, null);
		
		this.actualdata_4a.add(ad01);
		this.actualdata_4a.add(ad02);
		this.actualdata_4a.add(ad03);
		
		// Collected Data on all programs so far
		this.exercisedata = new List<ProjectData>();
		
		// Contructor params new ProjectData(eoloc, encloc, ancloc, etime, atime)
		ProjectData a01 = new ProjectData(null, null, null, 57, 108);
		ProjectData a02 = new ProjectData(null, 100, 49, 120, 80);
		ProjectData a03 = new ProjectData(null, 100, 85, 67, 95);
		ProjectData a04 = new ProjectData(378, 239, 156, 358, 190);
		ProjectData a05 = new ProjectData(204, 204, 115, 99, 182);
		ProjectData a06 = new ProjectData(134, 114, 169, 124, 210);
		
		this.exercisedata.add(a01);
		this.exercisedata.add(a02);
		this.exercisedata.add(a03);
		this.exercisedata.add(a04);
		this.exercisedata.add(a05);
		this.exercisedata.add(a06);
	}
	
	public List<ProjectData> getTestdata_4a() {
			return this.testdata_4a;
	}
	
	public List<ProjectData> getActualdata_4a() {
		return this.actualdata_4a;
	}
	
	public List<ProjectData> getExerciseData() {
		return this.exercisedata;
	}

}
