import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBconn {
	private static boolean exists=false;
	private final String conn="jdbc:mysql://axess.inc.gs:3310/game?"+"user=cs370&password=FIN@LPr0ject";
	private Connection db;
	
	private DBconn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.db=DriverManager.getConnection(this.conn);
	}
	public void close() {
		if(this.db!=null) {
			try {
				this.db.close();
				DBconn.exists=false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static DBconn makeConn() {
		if(!DBconn.exists) {
			DBconn.exists=true;
			try {
				return new DBconn();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else {return null;}
	}
	public ResultSet query(String que) {
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	preparedStatement=this.db.prepareStatement(que);
        	rs=preparedStatement.executeQuery();
        } catch (Exception e) {
    		try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  	}
        return rs;
	}
	public boolean isClosed() {
		try {
			return this.db.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}