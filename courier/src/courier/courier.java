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
		System.out.println("====Please Select A Transaction====");
		System.out.println("====Display===");
		System.out.println("[1] Receiver Information");
		System.out.println("[2] Sender Information");
		System.out.println("====Create===");
		System.out.println("[3] Add New Receiver");
		System.out.println("[4] Add New Sender");
		System.out.println("====Update===");
		System.out.println("[5] Edit Receiver Information");
		System.out.println("[6] Edit Sender Information");
		System.out.println("====Delete===");
		System.out.println("[7] Remove Receiver");
		System.out.println("[8] Remove Sender");
		System.out.println("==================================");
		System.out.println("[0] Exit");
	}
	
	public static void handleUserRequest() throws SQLException{
		Scanner s = new Scanner(System.in);
		int choice = 0;
		String buffer = "";
		
		while(true){
			displayMenu();
			System.out.print("Enter the number of your transaction: ");
			buffer = s.next();
			
			try{
				choice=Integer.parseInt(buffer);
				break;
				
			}catch (Exception e){
				System.out.println("You have made an invalid transaction.");
				continue;
			}
		}
		
		switch(choice){
			case 0:
				System.out.println("Goodbye");
				app.disconnectFromDatabase();
				System.exit(0);
				break;
				
			case 1:
				app.showReceiver();
				break;
			
			case 2:
				app.showSender();
				break;
				
			case 3:
				app.addNewReceiver();
				break;
				
			case 4:
				app.addNewSender();
				break;
				
			case 5:	
				app.editReceiver();
				break;
				
			case 6:
				app.editSender();
				break;
				
			case 7:
				app.removeReceiver();
				break;
				
			case 8:
				app.removeSender();
				break;
		}
	
}
