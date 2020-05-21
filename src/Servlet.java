
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.httprpc.io.JSONEncoder;
import org.httprpc.sql.ResultSetAdapter;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
@MultipartConfig()
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBconn db=null;
		ResultSetAdapter rs=null;
		try {
			db=DBconn.makeConn();
			rs=new ResultSetAdapter(db.query("Select * FROM users"));
			JSONEncoder json=new JSONEncoder();
			PrintWriter res=response.getWriter();
			response.setContentType("text/html");
			if(rs!=null) {
				json.write(rs,res);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
