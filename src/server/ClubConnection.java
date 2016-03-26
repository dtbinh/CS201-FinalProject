package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClubConnection {
	
	private Connection conn;
	private String URI;
	
	public ClubConnection(String server, String club)
	{
		URI = "jdbc:mysql://"+server+"/"+club+"?user=root&password=root";
		conn = null;
	}
	
	private Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URI);
	}
	
	public ResultSet getMembers() throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		conn = connect();
		Statement st = conn.createStatement();
		rs =  st.executeQuery("SELECT * FROM Members");
		return rs;
	}
	
	public ResultSet getFinances() throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		conn = connect();
		Statement st = conn.createStatement();
		rs =  st.executeQuery("SELECT * FROM Finances");
		return rs;
	}
	
	public ResultSet getPosts() throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		conn = connect();
		Statement st = conn.createStatement();
		rs =  st.executeQuery("SELECT * FROM Posts");
		return rs;
	}
	
	public void close() throws SQLException{
		conn.close();
	}
}
