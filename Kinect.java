package extend;
import java.sql.*;

public class Kinect {
	
	public static Connection con;
	private static String url = "jdbc:postgresql://localhost:5432/PubHub";
	private static String user = "postgres";
	private static String pass = "Shik@i456";
	
	
	public static Connection getConnection() throws Exception {
		if(con==null) {
		try {
		Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not register driver: "
			+ Class.forName("org.postgresql.Driver").toString());
			e.printStackTrace();
		}
		con = DriverManager.getConnection(url,user,pass);
		} 
		if(con.isClosed()) {
			System.out.println("Opening new connection");
			con=null;
			getConnection();
		}
		return con;
	}
	
}
