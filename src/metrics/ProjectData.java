package metrics;

public class ProjectData {


	private Integer eoloc;
	private Integer encloc;
	private Integer ancloc;
	private Integer etime;
	private Integer atime;
	
	/**
	 * 
	 * param: Integer eoloc     Estimated Object LOC 
	 * param: Integer encloc    Estimated and New and Changed Object LOC 
	 * param: Integer ancloc    Actual and New and Changed Object LOC 
	 */
	public ProjectData(Integer eoloc, Integer encloc, Integer ancloc, Integer etime, Integer atime) {
			setEOLOC(eoloc);
			setENCLOC(encloc);
			setANCLOC(ancloc);
			setEtime(etime);
			setAtime(atime);
	}
	
	
	/**
	 * 
	 * param: Integer eoloc     Estimated Object LOC 
	 */
	public void setEOLOC(Integer eoloc) {
			this.eoloc = eoloc;
	}
	
	/**
	 * 
	 * return: Integer eoloc     Estimated Object LOC 
	 */
	public Integer getEOLOC() {
			return this.eoloc;
	}
	
	/**
	 * 
	 * param: Integer encloc    Estimated and New and Changed Object LOC 
	 */
	public void setENCLOC(Integer encloc) {
			this.encloc = encloc;
	}
	
	/**
	 * 
	 * return: Integer encloc    Estimated and New and Changed Object LOC 
	 */
	public Integer getENCLOC() {
			return this.encloc;
	}
	
	/**
	 * 
	 * param: Integer ancloc    Actual and New and Changed Object LOC 
	 */
	public void setANCLOC(Integer ancloc) {
			this.ancloc = ancloc;
	}
	
	/**
	 * 
	 * return: Integer ancloc    Actual and New and Changed Object LOC 
	 */
	public Integer getANCLOC() {
			return this.ancloc;
	}


	public Integer getEtime() {
		return etime;
	}


	public void setEtime(Integer etime) {
		this.etime = etime;
	}


	public Integer getAtime() {
		return atime;
	}


	public void setAtime(Integer atime) {
		this.atime = atime;
	}
	
	
}
