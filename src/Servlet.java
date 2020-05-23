import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import org.httprpc.io.JSONEncoder;
import org.httprpc.sql.ResultSetAdapter;

public class Servlet {
	private static DBconn db=DBconn.makeConn();
	private static ResultSetAdapter rs;
	private static JSONEncoder json=new JSONEncoder();
	
	private static void setConn() {
		if (Servlet.db.isClosed()) {
			Servlet.db=DBconn.makeConn();
		}
	}
	public static void out(String query,PrintWriter writer) {
		Servlet.setConn();
		Servlet.rs=new ResultSetAdapter(Servlet.db.query(query));
		try {
			Servlet.json.write(rs,writer);
			Servlet.db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet que(String q) {
		Servlet.setConn();
		return Servlet.db.query(q);
	}
}
