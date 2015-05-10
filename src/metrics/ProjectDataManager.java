package metrics;

import list.List;

public class ProjectDataManager {
	
	private List<ProjectData> testdata_4a;
	private List<ProjectData> actualdata_4a;
	
	public ProjectDataManager() {
		// Table D8
		this.testdata_4a = new List<ProjectData>();
		
		ProjectData p01 = new ProjectData(130, 163, 186);
		ProjectData p02 = new ProjectData(650, 765, 699);
		ProjectData p03 = new ProjectData(99, 141, 132);
		ProjectData p04 = new ProjectData(150, 166, 272);
		ProjectData p05 = new ProjectData(128, 137, 291);
		ProjectData p06 = new ProjectData(302, 355, 331);
		ProjectData p07 = new ProjectData(95, 136, 199);
		ProjectData p08 = new ProjectData(945, 1206, 1890);
		ProjectData p09 = new ProjectData(368, 433, 788);
		ProjectData p10 = new ProjectData(961, 1130, 1601);
		
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
		
		ProjectData a01 = new ProjectData(0, 100, 49);
		ProjectData a02 = new ProjectData(0, 100, 85);
		ProjectData a03 = new ProjectData(0, 180, 156);
		
		this.actualdata_4a.add(a01);
		this.actualdata_4a.add(a02);
		this.actualdata_4a.add(a03);
	}
	
	public List<ProjectData> getTestdata_4a() {
			return this.testdata_4a;
	}
	
	public List<ProjectData> getActualdata_4a() {
		return this.actualdata_4a;
}

}
