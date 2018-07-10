import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainConsole {
	private static Scanner scan = new Scanner(System.in);
	private static DBController control;
	
	public static void main(String[] args) {
		control = new DBController();
		//Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?useSSL=false","root", null);
		try {
			control.dbaseConnect("jdbc:mysql://localhost:3306/store?useSSL=false","root",null);
			//ps = connect.prepareStatement("Insert into dongerino.personinfo values (?, ?)");
			tableMenu();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}	
	
	public static void tableMenu() {
		int choice = 0;
		System.out.println("                       ");
		System.out.println("-------Table MENU-------");
		System.out.println("Choose a transaction: ");
		System.out.println("| 1.  Send Money");
		System.out.println("| 2.  Receive Money");
		System.out.println("| 3.  Exit");
		while(choice != 3) {
		System.out.println("Input your choice: ");
		choice = scan.nextInt();
		choices(choice);
		}
	}
	
	public static void sendMenu() {
		System.out.println("-------Send Money MENU-------");
		System.out.println("| 0.  Go back to table menu");
		System.out.println("| 1.  Enter amount of money to be sent");
		System.out.println("| 2.  Check receiver ID"); //check receiver/status?
		System.out.println("| 3.  Show all transactions"); //status?
		System.out.println("| 4.  Update a transaction");
		System.out.println("| 5.  Delete a transaction");
	}
	
	public static void receiveMenu() {
		System.out.println("--------Receive Money MENU---------");
		System.out.println("| 0.  Go back to table menu");
		System.out.println("| 6.  Enter amount of money to be received");
		System.out.println("| 7.  Check senderID");
		System.out.println("| 8.  Show all transactions");
		System.out.println("| 9.  Update a transaction");
		System.out.println("| 10.  Delete a transaction");
	}
	
	public static void choiceExecute(int choice) {
		try {
		switch (choice) {
			case 1:
				sendMoney();
				TimeUnit.SECONDS.sleep(3);
				tableMenu();
				break;
			case 2:
				receiveMoney();
				TimeUnit.SECONDS.sleep(3);
				tableMenu();
				break;
			case 3:
				System.out.println("Exit");
				System.exit(0);
				break;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void choices(int choice) {
		switch (choice) {
		case 1:
			sendMenu();
			choiceInput();
			break;
		case 2:
			receiveMenu();
			choiceInput();
			break;
		case 3:
			System.out.println("Closed");
			System.exit(0);
			break;
		}
	}
	
	public static void choiceInput() {
			System.out.println("Input your choice: ");
			Integer choice = scan.nextInt();
			scan.nextLine();
			if (choice == 0) {
				tableMenu();
			}else {
				choiceExecute(choice);
			}
				
	}

	//----------------------------------------------------/
	
	//-------------------SEND MENU---------------------/
	public static void newTransaction() {	// new transaction
		System.out.println("Input senderID: ");
		String sID = scan.nextLine();
		System.out.println("Input receiverID: ");
		String rID = scan.nextLine();
		System.out.println("Input amount: ");
		String amount = scan.nextLine();
		
		try {
			control.newTransaction(sID, rID, amount);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void checkreceiverID() {  // check a receiver if it exists in the database
		System.out.println("Enter receiver ID: ");
		Integer rID = scan.nextInt();
		scan.nextLine();
		try {
			ResultSet rs = control.verifyID(sID);
			if(rs.next()) {
				System.out.println("Receiver ID does exist in the database");
			}else {
				System.out.println("Receiver ID does not exist in the dabatase");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	/*
	 
	public static void showProductInfo(Integer id) {	// show 
		try {
			ResultSet result = control.getProductInfo(id);
			ResultSetMetaData rsmd = result.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			System.out.println();
			while (result.next()) {
				for (int i = 1; i <= columnNumber; i++) {
					if (i > 1) System.out.print(",   ");
					String columnValue = result.getString(i);
					System.out.print(columnValue + "  ");
				}
				System.out.println("");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	*/
	
	public static void showAllTransactions() { //Shows all transactions
	try {
		ResultSet result = control.getAllTransactions();
		ResultSetMetaData rsmd = result.getMetaData();
		int columnNumber = rsmd.getColumnCount();
		System.out.println();
		while (result.next()) {
			for (int i = 1; i <= columnNumber; i++) {
				if (i > 1) System.out.print(",   ");
				String columnValue = result.getString(i);
				System.out.print(columnValue + "  ");
			}
			System.out.println("");
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void updateTransaction() {
		System.out.println("Input the Tracking No. of the transaction: ");
		Integer TrackingNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Input the new amount for the transaction: ");
		Integer amount = scan.nextInt();
		try {
			control.updateTransactionAmount(TrackingNo,amount);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTransaction() { 	//Deletes a transaction
		System.out.println("Input the Tracking No. of the transaction that you want to delete: ");
		Integer TrackingNo = scan.nextInt();
		try{
			control.deleteTransaction(TrackingNo);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//----------------------------------------------------/
	
	//-------------------RECEIVE MENU---------------------/
	public static void showAllTransactions() { //Shows all products
	try {
		ResultSet result = control.getAllTransactions();
		ResultSetMetaData rsmd = result.getMetaData();
		int columnNumber = rsmd.getColumnCount();
		System.out.println();
		while (result.next()) {
			for (int i = 1; i <= columnNumber; i++) {
				if (i > 1) System.out.print(",   ");
				String columnValue = result.getString(i);
				System.out.print(columnValue + "  ");
			}
			System.out.println("");
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void newTransaction() {
		System.out.println("Input amount to be received: ");
		Integer amount = scan.nextInt();
		scan.nextLine();
		System.out.println("Input the status(RECEIVED or NOT YET RECEIVED): ");
		String status = scan.nextLine();
		System.out.println("Input the ID of the sender: ");
		Integer sID = scan.nextInt();
		scan.nextLine();
		System.out.println("Input the ID of the receiver: ");
		Integer rID = scan.nextInt();
		scan.nextLine();
		System.out.println("Input the Tracking No. : ");
		Integer TrackingNo = scan.nextInt();
		scan.nextLine();
		try {
			control.newTransaction(amount,status,sID,rID,TrackingNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void checkStatus() {
		System.out.println("Enter the Tracking No. of the transaction you want to check: ");
		Integer TrackingNo = scan.nextInt();
		try {
			ResultSet rs = control.checkTransactionStatus(TrackingNo);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <= columnNumber; i ++) {
					if (i > 1) System.out.print(",   ");
					String columnValue = rs.getString(i);
					System.out.print("The current status: ");
					System.out.print(columnValue + " ");
				}
				System.out.println("");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public static void updateStatus() {
		System.out.println("Enter Tracking No.: ");
		Integer TrackingNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new product status(Pending or Claimed): ");
		String status = scan.nextLine();
		try {
			control.updateOrderStatus(status,ID);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteOrder() {
		System.out.println("Enter the ID of the order to be deleted: ");
		Integer id = scan.nextInt();
		try {
			control.deleteOrder(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	
	//----------------------------------------------------/
	//--------------------CUSTOMER MENU-------------------/
	
	public static void showAllCustomers() { //Shows all products
	try {
		ResultSet result = control.getAllCustomers();
		ResultSetMetaData rsmd = result.getMetaData();
		int columnNumber = rsmd.getColumnCount();
		System.out.println();
		while (result.next()) {
			for (int i = 1; i <= columnNumber; i++) {
				if (i > 1) System.out.print(",   ");
				String columnValue = result.getString(i);
				System.out.print(columnValue + "  ");
			}
			System.out.println("");
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void newCustomer() {
		System.out.println("Enter customer name: ");
		String name = scan.nextLine();
		System.out.println("Enter customer address: ");
		String address = scan.nextLine();
		System.out.println("Enter customer contact no: ");
		Integer contact = scan.nextInt();
		try {
			control.newCustomer(name,address,contact);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showCustomerContact() {
		System.out.println("Input customer ID: ");
		Integer id = scan.nextInt();
		try {
			ResultSet rs = control.getCustomerContact(id);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i <= columnNumber; i++) {
				if(i > 1) System.out.print(",   ");
				String columnValue = rs.getString(i);
				System.out.print("Customer contact: ");
				System.out.print(columnValue + " ");
			}
			System.out.println("");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCustomerAddress() {
		System.out.println("Input customer ID: ");
		Integer ID = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new address: ");
		String address = scan.nextLine();
		try {
			control.updateCustomerAddress(ID, address);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteCustomer() {
		System.out.println("Input customer ID: ");
		Integer ID = scan.nextInt();
		scan.nextLine();
		try {
			control.deleteCustomer(ID);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------/	
	
}
*/