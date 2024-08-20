package org.movie.recommend.client;
import java.util.*;

import org.movie.recommend.model.GenresModel;
import org.movie.recommend.model.MovieMasterModel;
import org.movie.recommend.model.RatingModel;
import org.movie.recommend.model.UserModel;
import org.movie.recommend.service.RatingService;
import org.movie.recommend.service.UserService;
import org.movie.recommend.service.adminservice;
import org.movie.recommend.service.genresservice;
import org.movie.recommend.service.moviemasterservice;

public class MovieRecommendationClient {
	
	/**
	 * @param x
	 */
	/**
	 * @param x
	 */
	/**
	 * @param x
	 */
	public static void main(String x[])
	{
		adminservice as=new adminservice();
		moviemasterservice mms=new moviemasterservice();
		genresservice gs=new genresservice();
		RatingService rs=new RatingService();
		UserService us=new UserService();
		
		
		
		Scanner xyz=new Scanner(System.in);
		do
		{
			System.out.println("1: for Admin Login");
			System.out.println("2: for user login");
			
			System.out.println("Enter your choice");
			int choice=xyz.nextInt();
			
			switch(choice)
			{
			case 1:
				 xyz.nextLine();
				 System.out.println("ADMIN LOGIN");
				 System.out.println("Enter the username");
				 String id=xyz.nextLine();
				 System.out.println("Enter the password");
				 String pass=xyz.nextLine();
				 boolean b=as.isAdminValid(id, pass);
				 if(b)
				 {
					 System.out.println("Admin Login Successfull");
					 do
					 {
						 System.out.println("1:Add movie in app");
						 System.out.println("2:Display all movies in app");
						 System.out.println("3:Add bulk movie genre in app");
						 System.out.println("4:Add movies genres in app");
						 System.out.println("5:Display genre in app");
						 System.out.println("6:Assign genre to movie");
						 System.out.println("7:Add user in app");
						 System.out.println("8:MOVIE GENRE JOIN");
						 System.out.println("9:joining movie and genre into one table");
						 System.out.println("10:Movies with Multiple Genres");
						 System.out.println("Enter your choice");
						 int choice1=xyz.nextInt();            
						 switch(choice1)
						 {
						 case 1:
							 
							 System.out.println("Enter movie title");
							 xyz.nextLine();
							 String movtitle=xyz.nextLine();
							 System.out.println("Enter movie year");
							 int movyear=xyz.nextInt();
							 System.out.println("Enter movie Screening time");
							 int movtime=xyz.nextInt();
							 xyz.nextLine();
							 System.out.println("Enter movie language");
							 String movlang=xyz.nextLine();
							 System.out.println("Enter movie release date");
							 String movdtrel=xyz.nextLine();
							 System.out.println("Enter movie release country");
							 String movrelcountry=xyz.nextLine();
							 MovieMasterModel model=new MovieMasterModel();
							 model.setMovtitle(movtitle);
							 model.setMovyear(movyear);
							 model.setMovtime(movtime);
							 model.setMovlang(movlang);
							 model.setMovdtrel(movdtrel);
							 model.setMovrelcountry(movrelcountry);
							 boolean b1=mms.isAddMovie(model);
							 if(b1)
							 {
								 System.out.println("Movie Added Successfully in App");
							 }
							 else
							 {
								 System.out.println("Movie Not Added");
							 }
							 break;
						 case 2:
							 
							 List<MovieMasterModel> list=mms.getAllMovies();
							 if(list!=null)
							 {
								 list.forEach((m)->System.out.println(m.getMovid()+"\t"+m.getMovtitle()+"\t"+m.getMovyear()+"\t"+m.getMovtime()+"\t"+m.getMovlang()+"\t"+m.getMovdtrel()+"\t"+m.getMovrelcountry()));
								 
							 }
							 else
							 {
								 System.out.println("Some Problem is there");
							 }
							 break;
						 case 3:
							 b1=gs.isBulkAddGenres();
							 if(b1)
							 {
								 System.out.println("Genres Added Successfully");
							 }
							 else
							 {
								 System.out.println("some problem is there");
							 }
							 break;
						 case 4:
							    System.out.println("Enter genres title");
							    xyz.nextLine();
							    String Gentitle=xyz.nextLine();
							    GenresModel gModel=new GenresModel();
							    gModel.setGentitle(Gentitle);
							    boolean b2=gs.isAddGenres(gModel);
							    if(b2)
							    {
							    	System.out.println("Genres added successfully");
							    }
							    else
							    {
							    	System.out.println("Some problem is there");
							    }
							    break;
						 case 5:
							 List<GenresModel> list1=gs.getAllGenres();
							 if(list1!=null)
							 {
								 list1.forEach((g)->System.out.println(g.getGenid()+"\t"+g.getGentitle()));
							 }
							 else
							 {
								 System.out.println("Some problem is there");
							 }
							break;
						 case 6:
							 List<GenresModel> list2=gs.getAllMovieGenres();
                             if(list2!=null)
                             {
                            	 list2.forEach((mg)->System.out.println(mg.getMovid()+"\t"+mg.getMovtitle()+"\t"+mg.getMovyear()+"\t"+mg.getMovtime()+"\t"+mg.getMovlang()+"\t"+mg.getMovdtrel()+"\t"+mg.getMovrelcountry()+"\t"+mg.getGentitle()));
                            	 
                             }
                             else
                             {
                            	 System.out.println("some problem is there");
                             }
                             break;
//						 case 7:
//							 xyz.nextLine();
//							 System.out.println("Enter movie name");
//							 String movtitle1=xyz.nextLine();
//							 int movId=mms.getMovId(movtitle1);
//							 System.out.println(movId);
//							 if(movId!=-1)
//							 {
//								 System.out.println("Enter username");
//								 String username=xyz.nextLine();
//								 System.out.println("enter user password");
//								 String upassword=xyz.nextLine();
//								 System.out.println("Enter user contact number");
//								 String ucontact=xyz.nextLine();
//								 System.out.println("Enter user age");
//								 int uage=xyz.nextInt();
//								 int userid=mms.getUserIdAutomatic();
//								 System.out.println(userid);
//								 xyz.nextLine();
//								 UserModel umodel=new UserModel();
//								 umodel.setMovid(movId);
//								 umodel.setUsername(username);
//								 umodel.setUpassword(upassword);
//								 umodel.setUcontact(ucontact);
//								 umodel.setUage(uage);
//								 umodel.setUserid(userid);
//								 System.out.println(movId+"\t"+username+"\t"+upassword+"\t"+ucontact+"\t"+uage+"\t"+userid);
//								 b=mms.isAddUser(umodel);
//								 if(b)
//								 {
//									 System.out.println("user added Successfully");
//								 }
//								 else
//								 {
//									 System.out.println("user not added");
//								 }
//								 
//								 
//							 }
//							 else
//							 {
//								 System.out.println("movie not present in database");
//								 System.out.println("Do you want to add this movie in database");
//								 String msg=xyz.nextLine();
//								 if(msg.equals("yes"))
//								 {
//									 System.out.println("Enter movie title");
//									 xyz.nextLine();
//									  movtitle=xyz.nextLine();
//									 System.out.println("Enter movie year");
//									  movyear=xyz.nextInt();
//									 System.out.println("Enter movie Screening time");
//									  movtime=xyz.nextInt();
//									 xyz.nextLine();
//									 System.out.println("Enter movie language");
//									  movlang=xyz.nextLine();
//									 System.out.println("Enter movie release date");
//									  movdtrel=xyz.nextLine();
//									 System.out.println("Enter movie release country");
//									  movrelcountry=xyz.nextLine();
//									  model=new MovieMasterModel();
//									 model.setMovtitle(movtitle);
//									 model.setMovyear(movyear);
//									 model.setMovtime(movtime);
//									 model.setMovlang(movlang);
//									 model.setMovdtrel(movdtrel);
//									 model.setMovrelcountry(movrelcountry);
//									  b1=mms.isAddMovie(model);
//									 if(b1)
//									 {
//										 System.out.println("Movie Added Successfully in App");
//									 }
//									 else
//									 {
//										 System.out.println("Movie Not Added");
//									 }
//									 break;
//									 
//									 
//								 }
//								 else
//								 {
//									 System.out.println("thank you");
//								 }
//							 }
//							 break;
//							 
						 case 8:
							 xyz.nextLine();
							List<GenresModel>list3 =gs.getAllGenres();
							if(list3 !=null)
							{
								list3.forEach((g)-> System.out.println(g.getGenid()+"\t"+g.getGentitle()));
								
							}
							else
							{
								System.out.println("THERE IS NO GENRES PRESENT");
							}
							System.out.println("Enter the movie genre");
							String mgenre=xyz.nextLine();
							
							 int genreId = gs.getgenreid(mgenre);
							 System.out.println(genreId);
							 if(genreId!=-1)
							 {
								 int movid=gs.getAutomMovID();
								 System.out.println("Enter movie title");
//								 xyz.nextLine();
								  movtitle=xyz.nextLine();
								 System.out.println("Enter movie year");
								  movyear=xyz.nextInt();
								 System.out.println("Enter movie Screening time");
								  movtime=xyz.nextInt();
								 xyz.nextLine();
								 System.out.println("Enter movie language");
								  movlang=xyz.nextLine();
								 System.out.println("Enter movie release date");
								  movdtrel=xyz.nextLine();
								 System.out.println("Enter movie release country");
								  movrelcountry=xyz.nextLine();
								  gModel=new GenresModel();
								  gModel.setMovid(movid);
								 gModel.setGenid(genreId);
								 gModel.setMovtitle(movtitle);
								 gModel.setMovyear(movyear);
								 gModel.setMovtime(movtime);
								 gModel.setMovlang(movlang);
								 gModel.setMovdtrel(movdtrel);
								 gModel.setMovrelcountry(movrelcountry);
								  b1=gs.isAddMovGen(gModel);
								 if(b1)
								 {
									 System.out.println("Movie Added Successfully in App");
								 }
								 else
								 {
									 System.out.println("Movie Not Added");
								 }
								 break;
														 
							 }
						 case 9:
							 System.out.println("Select movid from below list");
							 List<MovieMasterModel> list4=mms.getAllMovies();
							 if(list4!=null)
							 {
								 list4.forEach((m)->System.out.println(m.getMovid()+"\t"+m.getMovtitle()+"\t"+m.getMovyear()+"\t"+m.getMovtime()+"\t"+m.getMovlang()+"\t"+m.getMovdtrel()+"\t"+m.getMovrelcountry()));
								 
							 }
							 else
							 {
								 System.out.println("Some Problem is there");
							 }
							 System.out.println("select genid from below list");
							 List<GenresModel> list5=gs.getAllGenres();
							 if(list5!=null)
							 {
								 list5.forEach((g)->System.out.println(g.getGenid()+"\t"+g.getGentitle()));
							 }
							 else
							 {
								 System.out.println("Some problem is there");
							 }
							  System.out.println("ENTER MOVIE ID");
							  int movid=xyz.nextInt();
							  System.out.println("Enter genre Id");
                              int genid=xyz.nextInt();
                  		     gModel=new GenresModel();
                  		     gModel.setMovid(movid);
                  		     gModel.setGenid(genid);
                  		     b1=gs.isJoinMovGen(gModel);
                  		     if(b1)
                  		     {
                  		    	 System.out.println("Movie and Genres join Successfully");
                  		     }
                  		     else
                  		     {
                  		    	 System.out.println("Movie and Genres join UnSuccessfully");
                  		     }
                  		     list4.clear();
                  		     list5.clear();
                  		     break;
						 case 10:
							 xyz.nextLine();
							 System.out.println("Enter movie name");
							 String movtit=xyz.nextLine();
							 GenresModel mm=mms.getConcat(movtit);
							 System.out.println(mm.getMovtitle()+"\t"+mm.getMovyear()+"\t"+mm.getMovtime()+"\t"+mm.getMovlang()+"\t"+mm.getMovdtrel()+"\t"+mm.getGentitle());
							 break;
						 
						 }
						 
						 
					 }while(true);
				 }
				 else
				 {
					 System.out.println("Admin login Unsuccessfull");
				 }
			case 2:
				xyz.nextLine();
				System.out.println("USER LOGIN");
				System.out.println("Enter the username");				
				String userame=xyz.nextLine();
				System.out.println("Enter the user password");
				String upassword=xyz.nextLine();			
				b=us.isUserValid(userame, upassword);
				if(b)
				{
					System.out.println("User Login Successfull");
					do
					{
						System.out.println("1:Which Movie you want to Watch");
						System.out.println("2:Movie Watched by user");
						System.out.println("3:User Gives Ratings and Revstars");
						System.out.println("4:Search movie by genres");
						System.out.println("5:Assignng Movie To User");
						System.out.println("6:Naive Bayes Algorithm");
						int choice1=xyz.nextInt();
						switch(choice1)
						{
						case 1:

							 List<MovieMasterModel> list3=mms.getAllMovies();
							 if(list3!=null)
							 {
								 list3.forEach((m)->System.out.println(m.getMovid()+"\t"+m.getMovtitle()+"\t"+m.getMovyear()+"\t"+m.getMovtime()+"\t"+m.getMovlang()+"\t"+m.getMovdtrel()+"\t"+m.getMovrelcountry()));
								 
							 }
							 else
							 {
								 System.out.println("Some Problem is there");
							 }
							 List<UserModel> list4=us.GetAllUsers();
							 if(list4!=null)
							 {
								 list4.forEach((u)->System.out.println(u.getUserid()+"\t"+u.getUsername()+"\t"+u.getUpassword()+"\t"+u.getUcontact()+"\t"+u.getUage()));
							 }
							 else
							 {
								 System.out.println("some problem is there");
							 }
							
							 xyz.nextLine();
							 System.out.println("Enter movie name");
							 String movtitle1=xyz.nextLine();
							 int movId=mms.getMovId(movtitle1);
							 System.out.println(movId);
							 if(movId!=-1)
							 {
								 System.out.println("Enter username");
								 String username=xyz.nextLine();
								 System.out.println("enter user password");
								 String upassword1=xyz.nextLine();
								 System.out.println("Enter user contact number");
								 String ucontact=xyz.nextLine();
								 System.out.println("Enter user age");
								 int uage=xyz.nextInt();
								 int userid=mms.getUserIdAutomatic();
								 System.out.println(userid);
								 xyz.nextLine();
								 UserModel umodel=new UserModel();
								 umodel.setMovid(movId);
								 umodel.setUsername(username);
								 umodel.setUpassword(upassword1);
								 umodel.setUcontact(ucontact);
								 umodel.setUage(uage);
								 umodel.setUserid(userid);
								 System.out.println(movId+"\t"+username+"\t"+upassword+"\t"+ucontact+"\t"+uage+"\t"+userid);
								 b=mms.isAddUser(umodel);
								 if(b)
								 {
									 System.out.println("user added Successfully");
								 }
								 else
								 {
									 System.out.println("user not added");
								 }
								 
								 
							 }
							 else
							 {
								 System.out.println("movie not present in database");
								 System.out.println("Do you want to add this movie in database");
								 String msg=xyz.nextLine();
								 if(msg.equals("yes"))
								 {
									 System.out.println("Enter movie title");
									 xyz.nextLine();
									 String  movtitle=xyz.nextLine();
									 System.out.println("Enter movie year");
									  int movyear=xyz.nextInt();
									 System.out.println("Enter movie Screening time");
									 int  movtime=xyz.nextInt();
									 xyz.nextLine();
									 System.out.println("Enter movie language");
									 String  movlang=xyz.nextLine();
									 System.out.println("Enter movie release date");
									 String  movdtrel=xyz.nextLine();
									 System.out.println("Enter movie release country");
									 String movrelcountry=xyz.nextLine();
									 MovieMasterModel  model=new MovieMasterModel();
									 model.setMovtitle(movtitle);
									 model.setMovyear(movyear);
									 model.setMovtime(movtime);
									 model.setMovlang(movlang);
									 model.setMovdtrel(movdtrel);
									 model.setMovrelcountry(movrelcountry);
									 boolean b1=mms.isAddMovie(model);
									 if(b1)
									 {
										 System.out.println("Movie Added Successfully in App");
									 }
									 else
									 {
										 System.out.println("Movie Not Added");
									 }
									 break;
									 
									 
								 }
								 else
								 {
									 System.out.println("thank you");
								 }
							 }
							 list3.clear();
							 list4.clear();
							 break;

							
					
						case 2:
							List<UserModel> list=us.getAllUserWatchHistory();
							if(list!=null)
							{
								list.forEach((u)->System.out.println(u.getUsermovid()+"\t"+u.getMovid()+"\t"+u.getMovtitle()+"\t"+u.getGenid()+"\t"+u.getGentitle()));
								
							}
							else
							{
								System.out.println("Else Some Problem Is There");
							}
							
							break;
							
						case 3:

							 List<UserModel> list5=us.GetAllUsers();
							 if(list5!=null)
							 {
								 list5.forEach((u)->System.out.println(u.getUserid()+"\t"+u.getUsername()+"\t"+u.getUpassword()+"\t"+u.getUcontact()+"\t"+u.getUage()));
							 }
							 else
							 {
								 System.out.println("some problem is there");
							 }
							
							xyz.nextLine();
							System.out.println("Enter the usermovid");
							int usermovid=xyz.nextInt();
							xyz.nextLine();
							System.out.println("Give Revstars to movie");
							String revstars=xyz.nextLine();
	     					System.out.println("Give Feedback to movie");
							String feedback=xyz.nextLine();
							RatingModel Rmodel=new RatingModel();
							Rmodel.setUsermovid(usermovid);
			                Rmodel.setRevstars(revstars);
							Rmodel.setFeedback(feedback);
							b=rs.isGiveRating(Rmodel);
							if(b)
							{
								System.out.println("Thank you for Giving Review");
							}
							else
							{
								System.out.println("Some Problem is there");
							}
							list5.clear();
							 break;
						case 4:

							 List<GenresModel> list1=gs.getAllGenres();
							 if(list1!=null)
							 {
								 list1.forEach((g)->System.out.println(g.getGenid()+"\t"+g.getGentitle()));
							 }
							 else
							 {
								 System.out.println("Some problem is there");
							 }
							 xyz.nextLine();
							 System.out.println("Enter Genres Name to search movie");
							 String gentitle=xyz.nextLine();
							 GenresModel mg=mms.SearchByGenres(gentitle);
							 System.out.println(mg.getMovtitle()+"\t"+mg.getMovyear()+"\t"+mg.getMovtime()+"\t"+mg.getMovlang()+"\t"+mg.getMovdtrel()+"\t"+mg.getMovrelcountry()+"\t"+mg.getGentitle());
							break;
							
                      case 5:
							 List<MovieMasterModel> list6=mms.getAllMovies();
							 if(list6!=null)
							 {
								 list6.forEach((m)->System.out.println(m.getMovid()+"\t"+m.getMovtitle()+"\t"+m.getMovyear()+"\t"+m.getMovtime()+"\t"+m.getMovlang()+"\t"+m.getMovdtrel()+"\t"+m.getMovrelcountry()));
								 
							 }
							 else
							 {
								 System.out.println("Some Problem is there");
							 }
							 List<UserModel> list7=us.GetAllUsers();
							 if(list7!=null)
							 {
								 list7.forEach((u)->System.out.println(u.getUserid()+"\t"+u.getUsername()+"\t"+u.getUpassword()+"\t"+u.getUcontact()+"\t"+u.getUage()));
							 }
							 else
							 {
								 System.out.println("some problem is there");
							 }
							

                    	  System.out.println("Enter the userid");
                    	  int userid=xyz.nextInt();
                    	  System.out.println("Enter the movid");
                    	  int movid=xyz.nextInt();
                    	  UserModel umodel=new UserModel();
                    	  umodel.setUserid(userid);
                    	  umodel.setMovid(movid);
                    	  b=us.isAssignMovieToUser(umodel);
                    	  if(b)
                    	  {
                    		  System.out.println("movie assign to uXXXXJser successfully");
                    	  }
                    	  else
                    	  {
                    		  System.out.println("some problem is there");
                    	  }
                    	  break;
                    	  
                      case 6:
                    	  rs.predict();
                    	  break;
						
						}
					}while(true);
				}
				else
				{
					System.out.println("user login not successfull");
				}
				
			
			}
			
		}while(true);
	}
}


