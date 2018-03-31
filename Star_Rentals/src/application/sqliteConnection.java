package application;
import java.sql.*;
public class sqliteConnection {
	public static Connection Connector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:SR_DB.sqlite");
			return conn;
		}
		catch(Exception e) 
		{
			System.out.print(e);
			return null;
		}
	}
}

/*
String query = "insert into Users values (?,?,?,?,?)"
ps = conn.prepareStatement(query);
ps.setString(1,para_1);

...
rs = ps.executeQuery();
*/