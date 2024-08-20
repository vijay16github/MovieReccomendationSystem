package org.movie.recommend.model;

public class GenresModel extends MovieMasterModel {
     private int genid;
     private String gentitle;
	public int getGenid() {
		return genid;
	}
	public void setGenid(int genid) {
		this.genid = genid;
	}
	public String getGentitle() {
		return gentitle;
	}
	public void setGentitle(String gentitle) {
		this.gentitle = gentitle;
	}
     
}
