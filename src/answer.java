

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class answer
 */
@WebServlet("/answer")
public class answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void addRight(String user,String rank) {
    	int score;
    	ResultSet u=Servlet.que("SELECT score FROM users WHERE user_id=" + user);
    	if(u!=null) {
    		try {
    			u.next();
				score=Integer.parseInt(u.getString(1));
				score+=15;
				Servlet.que("UPDATE users SET score=" + Integer.toString(score) + " WHERE user_id=" + user);
				if(rank=="1") {
					ResultSet s=Servlet.que("SELECT 1_credits FROM users WHERE user_id=" + user);
					if(s!=null) {
						try {
							if(s.next()) {
								int creds=Integer.parseInt(s.getString(1));
								if(creds<300) {
									creds+=15;
									if(creds>300) {
										creds=300;
									}
									Servlet.que("UPDATE users SET 1_credits=" + Integer.toString(creds) + " WHERE user_id=" + user);
								}
							}
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if(rank=="2") {
					ResultSet s=Servlet.que("SELECT 2_credits FROM users WHERE user_id=" + user);
					if(s!=null) {
						try {
							if(s.next()) {
								int creds=Integer.parseInt(s.getString(1));
								if(creds<300) {
									creds+=15;
									if(creds>300) {
										creds=300;
									}
									Servlet.que("UPDATE users SET 2_credits=" + Integer.toString(creds) + " WHERE user_id=" + user);
								}
							}
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if(rank=="3") {
					ResultSet s=Servlet.que("SELECT 3_credits FROM users WHERE user_id=" + user);
					if(s!=null) {
						try {
							if(s.next()) {
								int creds=Integer.parseInt(s.getString(1));
								if(creds<300) {
									creds+=15;
									if(creds>300) {
										creds=300;
									}
									Servlet.que("UPDATE users SET 3_credits=" + Integer.toString(creds) + " WHERE user_id=" + user);
								}
							}
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else {
					
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    protected void addWrong(String user,String rank) {
    	int score;
    	ResultSet u=Servlet.que("SELECT score FROM users WHERE user_id=" + user);
    	if(u!=null) {
    		try {
    			if(u.next()) {
					score=Integer.parseInt(u.getString(1));
					score-=10;
					if(score<0) {
						score=0;
					}
					Servlet.que("UPDATE users SET score=" + Integer.toString(score) + " WHERE user_id=" + user);
					ResultSet s=Servlet.que("SELECT 3_credits FROM users WHERE user_id=" + user);
					if(s!=null) {
						int creds;
						try {
							if(s.next()) {
								creds=Integer.parseInt(s.getString(1));
								if(creds<=0) {
									s=Servlet.que("SELECT 2_credits FROM users WHERE user_id=" + user);
									try {
										if(s.next()) {
											creds=Integer.parseInt(s.getString(1));
											if(creds<=0) {
												s=Servlet.que("SELECT 1_credits FROM users WHERE user_id=" + user);
												try {
													if(s.next()) {
														creds=Integer.parseInt(s.getString(1));
														creds-=10;
														if(creds<0) {
															creds=0;
														}
														Servlet.que("UPDATE users SET 1_credits=" + Integer.toString(creds) + " WHERE user_id=" + user);
													}
												} catch (NumberFormatException | SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												creds-=10;
												if(creds<0) {
													creds=0;
												}
												Servlet.que("UPDATE users SET 2_credits=" + Integer.toString(creds) + " WHERE user_id=" + user);
											}
										}
									} catch (NumberFormatException | SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								else {
									creds-=10;
									if(creds<0) {
										creds=0;
									}
									Servlet.que("UPDATE users SET 1_credits=" + Integer.toString(creds) + " WHERE user_id=" + user);
								}
							}
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
    			}
    		} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("ID");
		String choice=request.getParameter("answer");
		String question=request.getParameter("questionID");
		String correct="";
		String rank="";
		if(user==null || choice==null || question==null) {
			response.getWriter().write("Error: Missing parameters");
		}
		ResultSet a=Servlet.que("SELECT answer FROM questions WHERE id=" + question);
		ResultSet r=Servlet.que("SELECT rank FROM questions WHERE id=" + question);
		if(a!=null && r!=null) {
			try {
				a.next();
				r.next();
				correct=a.getString(1);
				rank=r.getString(1);
				if(choice.contentEquals(correct)) {
					addRight(user,rank);
					response.getWriter().write("Correct");
				}
				else {
					addWrong(user,rank);
					response.getWriter().write("Incorrect");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
