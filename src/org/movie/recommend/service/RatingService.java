package org.movie.recommend.service;

import org.movie.recommend.model.GenresModel;
import org.movie.recommend.model.RatingModel;
import org.movie.recommend.repository.RatingRepository;
import java.util.*;
public class RatingService {
	RatingRepository Rrepo=new RatingRepository();
	genresservice gs=new genresservice();
	Scanner xyz = new Scanner(System.in);
	public boolean isGiveRating(RatingModel Rmodel)
	{
		boolean b=Rrepo.isGiveRating(Rmodel);
		return b;
	}
	
	public Map<String,Float> getCumPer(int gid){
		return Rrepo.getCummPer(gid);
	}
	
	//

	public void predict() {
		System.out.println("Choose Genres ID");
		List<GenresModel> gl=gs.getAllGenres();
		for (GenresModel gM : gl) {
			System.out.println(gM.getGenid()+"\t"+gM.getGentitle());
		}
		int gid=xyz.nextInt();          // Genres ID 
		int total=Rrepo.getTotal()*5;		
//		System.out.println(total);		
		
		Map<String,Float> getC=Rrepo.getCummPer(gid);
//		System.out.println(getC);		
		Set<Map.Entry<String,Float>> map=getC.entrySet();	
		System.out.println("Recommended movie are: ");
		System.out.println("---------------------------------------");
		for (Map.Entry<String, Float> en : map) {
			if(en.getValue()>=30.0f) {
				System.out.println(en.getKey());
			}
//			System.out.println(en.getKey()+"\t"+en.getValue());
		}
		System.out.println("-----------------------------------------");
		gl.clear();
		getC.clear();
	}
//	xyz.close();
	
}
