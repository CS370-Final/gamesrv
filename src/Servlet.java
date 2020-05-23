import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import org.httprpc.io.JSONEncoder;
import org.httprpc.sql.ResultSetAdapter;

public class Servlet {
	private static DBconn db=DBconn.makeConn();
	private static ResultSetAdapter rs;
	private static JSONEncoder json=new JSONEncoder();
	
	public static void out(String query,PrintWriter writer) {
		Servlet.rs=new ResultSetAdapter(Servlet.db.query(query));
		try {
			Servlet.json.write(rs,writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet que(String q) {
		return Servlet.db.query(q);
	}
}
