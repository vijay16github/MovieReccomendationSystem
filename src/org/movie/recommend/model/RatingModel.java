package org.movie.recommend.model;

public class RatingModel extends GenresModel{
	private int usermovid;
	private int revid;
	private String revstars;
	private String feedback;
	public int getUsermovid() {
		return usermovid;
	}
	public void setUsermovid(int usermovid) {
		this.usermovid = usermovid;
	}
	public int getRevid() {
		return revid;
	}
	public void setRevid(int revid) {
		this.revid = revid;
	}
	public String getRevstars() {
		return revstars;
	}
	public void setRevstars(String revstars) {
		this.revstars = revstars;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

}
