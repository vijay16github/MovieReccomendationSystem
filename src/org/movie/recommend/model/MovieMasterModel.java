package org.movie.recommend.model;



public class MovieMasterModel{
	private int movid;
	private String movtitle;
	private int movyear;
	private int movtime;
	private String movlang;
	private String movdtrel;
	private String movrelcountry;

	public int getMovid() {
		return movid;
	}
	public void setMovid(int movid) {
		this.movid = movid;
	}
	public String getMovtitle() {
		return movtitle;
	}
	public void setMovtitle(String movtitle) {
		this.movtitle = movtitle;
	}

	public int getMovyear() {
		return movyear;
	}
	public void setMovyear(int movyear) {
		this.movyear = movyear;
	}
	public int getMovtime() {
		return movtime;
	}
	public void setMovtime(int movtime) {
		this.movtime = movtime;
	}
	public String getMovlang() {
		return movlang;
	}
	public void setMovlang(String movlang) {
		this.movlang = movlang;
	}

	public String getMovdtrel() {
		return movdtrel;
	}
	public void setMovdtrel(String movdtrel) {
		this.movdtrel = movdtrel;
	}
	public String getMovrelcountry() {
		return movrelcountry;
	}
	public void setMovrelcountry(String movrelcountry) {
		this.movrelcountry = movrelcountry;
	}
	
	

}
