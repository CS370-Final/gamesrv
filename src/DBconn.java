import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBconn {

	public String query(String que) {
		Connection db = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs;
        String result="";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	db =DriverManager.getConnection("jdbc:mysql://axess.inc.gs:3310/game?"+"user=cs370&password=FIN@LPr0ject");
        	preparedStatement = db.prepareStatement(que);
        	rs=preparedStatement.executeQuery();
        	if (rs.next()){
	            result = rs.getString(1);
	            rs.close();
	            preparedStatement.close();
        	}
        	else {
        		result = "No Results";
        	}
        } catch (Exception e) {
    		try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  	} finally {
		      if (preparedStatement != null) {
			        try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  }	      

		      if (db != null) {
		        try {
					db.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
	    }
        return result;
	}
}