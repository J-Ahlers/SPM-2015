package metrics;

public class ProjectData {


	private int eoloc;
	private int encloc;
	private int ancloc;
	
	/**
	 * 
	 * param: int eoloc     Estimated Object LOC 
	 * param: int encloc    Estimated and New and Changed Object LOC 
	 * param: int ancloc    Actual and New and Changed Object LOC 
	 */
	public ProjectData(int eoloc, int encloc, int ancloc) {
			setEOLOC(eoloc);
			setENCLOC(encloc);
			setANCLOC(ancloc);
	}
	
	
	/**
	 * 
	 * param: int eoloc     Estimated Object LOC 
	 */
	public void setEOLOC(int eoloc) {
			this.eoloc = eoloc;
	}
	
	/**
	 * 
	 * return: int eoloc     Estimated Object LOC 
	 */
	public int getEOLOC() {
			return this.eoloc;
	}
	
	/**
	 * 
	 * param: int encloc    Estimated and New and Changed Object LOC 
	 */
	public void setENCLOC(int encloc) {
			this.encloc = encloc;
	}
	
	/**
	 * 
	 * return: int encloc    Estimated and New and Changed Object LOC 
	 */
	public int getENCLOC() {
			return this.encloc;
	}
	
	/**
	 * 
	 * param: int ancloc    Actual and New and Changed Object LOC 
	 */
	public void setANCLOC(int ancloc) {
			this.ancloc = ancloc;
	}
	
	/**
	 * 
	 * return: int ancloc    Actual and New and Changed Object LOC 
	 */
	public int getANCLOC() {
			return this.ancloc;
	}
	
	
}
