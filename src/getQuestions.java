

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getQuestions
 */
@WebServlet("/getQuestions")
public class getQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected String comPose(HttpServletRequest rq) {
		String[] ranks=rq.getParameterValues("ranks");
		String que="SELECT id,text,a,b,c,d FROM questions";
		if(ranks!=null) {
			if(ranks.length<3) {
				que+=" WHERE rank=";
				for(int i=0;i<ranks.length;i++) {
					que+=ranks[i];
					if(i!=ranks.length-1) {
						que+=" OR rank=";
					}
				}
			}
		}
		return que;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter res=response.getWriter();
		response.setContentType("text/html");
		Servlet.out(comPose(request),res);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
