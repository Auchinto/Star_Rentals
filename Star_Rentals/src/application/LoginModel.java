package application;
import java.sql.*;
public class LoginModel {
	Connection conn;
	public LoginModel()
	{
		conn = sqliteConnection.Connector();
		if(conn == null) System.exit(1);
	}
	
	
	public boolean isLoginAdmin(String user, String pass) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from Users_Admin where Username = ? and Password = ?";
		try
		{
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1,user);
			preparedStatement.setString(2,pass);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
				return false;
			
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			preparedStatement.close();
			resultSet.close();
		}
	}
	
	public boolean isLoginCustomer(String user, String pass) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from Users_Customer where Username = ? and Password = ?";
		try
		{
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1,user);
			preparedStatement.setString(2,pass);
			 
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
				return false;
			
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			preparedStatement.close();
			resultSet.close();
		}
	}
	
	public void Register(String email , String user, String pass, boolean access) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		String query_customer = "INSERT INTO Users_Customer(Email, Username, Password) VALUES ( ? , ? , ? )";
		String query_admin = "INSERT INTO Users_Admin(Email, Username, Password) VALUES ( ? , ? , ? )";
		try
		{
			if(email.equals("")) email  = null;
			if(user.equals("")) user  = null;
			if(pass.equals("")) pass  = null;
			if(access) preparedStatement = conn.prepareStatement(query_admin);
			else preparedStatement = conn.prepareStatement(query_customer);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,user);
			preparedStatement.setString(3,pass);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			preparedStatement.execute();
			preparedStatement.close();
		}
	}
}
