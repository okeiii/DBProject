package courier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;
import java.io.IOException;

public class courier {

	private String DBName="courier";
	private String DBURL="jdbc://mysql://localhost:3306/" + DBName;
	private String DBUser="client";
	private String DBPass="pass";
	
	private Connection connect;
	private Statement sqlStatement;
	private PreparedStatement ps;
	
	private static courierApp app;
	private static Scanner kbd=new Scanner(System.in);
	
	public void courierApp(){
		
		try{
			connectToDatabase();
			sqlStatement=connect.createStatement();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void connectToDatabase() throws SQLException{
		
		try{
			Class.forName("com.sql.jdbc.Driver");
			connect = DriverManager.getConnection(DBURL, DBUser, DBPass);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	public void disconnectFromDatabase() throws SQLException{
		connect.close();
		
	}
	
	public static void main(String[] args){
		app = new courierApp();
		displayMenu();
		Scanner s = new Scanner(System.in);
		
		while(true){
			
			try{
				handleUserRequest();
			} catch(Exception e) {
				System.err.println(e.getMessage());
				System.err.println("There was an error\nPress enter to continue...");
				app.pauseStream();
				continue;
				
			}
		}
	}
	
	public static void displayMenu(){
		System.out.println("----Please Select A Transaction----");
		System.out.println("[1] Send Money");
		System.out.println("[2] Receive Money");
		System.out.println("Exit");
	}
	
	public void 
	
	
}
