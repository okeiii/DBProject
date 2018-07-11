import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class MainConsole {
	private static Scanner scan = new Scanner(System.in);
	private static DBController control;

	public static void main(String[] args) {
		control = new DBController();
		//Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?useSSL=false","root", null);
		try {
			control.dbConnect("jdbc:mysql://localhost:3306/store?useSSL=false","root",null);
			//ps = connect.prepareStatement("Insert into dongerino.personinfo values (?, ?)");
			tableMenu();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

	public static void displayMenu() {
		int choice = 0;
		System.out.println("                    ");
		System.out.println("--------MENU--------");
		System.out.println("Select a transaction : ");
		System.out.println("-------DISPLAY------");
		System.out.println("[1] Show Receiver Information");
		System.out.println("[2] Show Sender Information");
		System.out.println("[3] Show Transactions");
		System.out.println("[4] Show All Money Express Information");
		System.out.println("[5] Show Transactions");
		System.out.println("-------CREATE-------");
		System.out.println("[6] Add Receiver");
		System.out.println("[7] Add Sender");
		System.out.println("[8] Add Transaction");
		System.out.println("[9] Add Money Express");
		System.out.println("-------UPDATE-------");
		System.out.println("[10] Edit Receiver");
		System.out.println("[11] Edit Sender");
		System.out.println("[12] Edit Transaction");
		System.out.println("[13] Edit Money Express");
		System.out.println("-------REMOVE-------");
		System.out.println("[14] Delete Receiver");
		System.out.println("[15] Delete Sender");
		System.out.println("[16] Delete Transaction");
		System.out.println("[17] Delete Money Express");
		System.out.println("[0] Exit");

		while(choice > 17) {
			System.out.println("That is an invalid choice.");
			choice = scan.nextInt();
			choices(choice);

		}

	}

	public static void choiceExecute(int choice) {
		try {
		switch (choice) {
			case 1:
				showReceiver();
				displayMenu();
				break;

			case 2:
				showSender();
				displayMenu();
				break;

			case 3:
				showTransaction();
				displayMenu();
				break;

			case 4:
				showMoneyExpress();
				displayMenu();
				break;

			case 5:
				addReceiver();
				displayMenu();
				break;

			case 6:
				addSender();
				displayMenu();
				break;

			case 7:
				addTransaction();
				displayMenu();
				break;

			case 8:
				addMoneyExpress();
				displayMenu();
				break;

			case 9:
				editReceiver();
				displayMenu();
				break;

			case 10:
				editSender();
				displayMenu();
				break;

			case 11:
				editTransaction();
				displayMenu();
				break;

			case 12:
				editMoneyExpress();
				displayMenu();
				break;

			case 13:
				removeReceiver();
				displayMenu();
				break;

			case 14:
				removeSender();
				displayMenu();
				break;

			case 15:
				removeTransaction();
				displayMenu();
				break;

			case 16:
				removeMoneyExpress();
				displayMenu();
				break;

			case 17:
				displayMenu();
				break;

			case 0:
				System.out.println("Bye :(");
				System.exit(0);
				break;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void showReceiver() {
		try {
			ResultSet result = control.showReceiver();
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

	public static void showSender() {
		try {
			ResultSet result = control.showSender();
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

	public static void showTransaction() {
		try {
			ResultSet result = control.showTransaction();
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

	public static void showMoneyExpress() {
		try {
			ResultSet result = control.showMoneyExpress();
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

	public static void addReceiver() {
		System.out.println("Enter receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter receiver last name: ");
		String lastname = scan.nextLine();
		System.out.println("Enter receiver address: ");
		String address = scan.nextLine();
		System.out.println("Enter receiver contact number: ");
		String contactNo = scan.nextLine();

		try {
			control.addReceiver(receiverID, lastname, firstname, address, contactNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addSender() {
		System.out.println("Enter sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter receiver last name: ");
		String lastname = scan.nextLine();
		System.out.println("Enter receiver address: ");
		String address = scan.nextLine();
		System.out.println("Enter receiver contact number: ");
		String contactNo = scan.nextLine();

		try {
			control.addSender(senderID, lastname, firstname, address, contactNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addTransaction() {
		System.out.println("Enter tracking no.: ");
		int trackingNo = scan.nextInt();
		System.out.println("Enter sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter transaction date: ");
		String senderID = scan.nextLine();
		System.out.println("Enter courier fee: ");
		int courierFee = scan.nextInt();

		try {
			control.addTransaction(trackingNo, senderID, receiverID, transactionDate, courierFee);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addMoneyExpress() {
		System.out.println("Enter tracking no.: ");
		int trackingNo = scan.nextInt();
		System.out.println("Enter sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter amount: ");
		int senderID = scan.nextInt();
		System.out.println("Enter status: ");
		String courierFee = scan.nextLine();

		try {
			control.addMoneyExpress(trackingNo, senderID, receiverID, amount, status);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editReceiver() {
		System.out.println("Enter new receiver ID: ");
		int receiverID = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new receiver last name: ");
		String lastname = scan.nextLine();
		System.out.println("Enter new receiver first name: ");
		String firstname = scan.nextLine();
		System.out.println("Enter new receiver contact no: ");
		String contactNo = scan.nextLine();

		try {
			control.editReceiver(receiverID, lastname, firstname, address, contactNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editSender() {
		System.out.println("Enter new sender ID: ");
		int senderID = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new sender last name: ");
		String lastname = scan.nextLine();
		System.out.println("Enter new sender first name: ");
		String firstname = scan.nextLine();
		System.out.println("Enter new sender contact no: ");
		String contactNo = scan.nextLine();

		try {
			control.editSender(senderID, lastname, firstname, address, contactNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editTransaction() {
		System.out.println("Enter new transaction tracking no: ");
		int trackingNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new transaction sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter new transaction receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter new transaction date: ");
		String transactionDate = scan.nextLine();
		System.out.println("Enter new transaction courier fee: ");
		int courierFee = scan.nextInt();

		try {
			control.editTransaction(trackingNo, senderID, receiverID, transactionDate, courierFee);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editMoneyExpress() {
		System.out.println("Enter money express tracking no: ");
		int trackingNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter money express sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter money express receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter money express amount: ");
		int amount = scan.nextInt();
		System.out.println("Enter money express status: ");
		String status = scan.nextLine();

		try {
			control.editMoneyExpress(trackingNo, senderID, receiverID, amount, status);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeReceiver() {
		System.out.println("Enter new receiver ID: ");
		int receiverID = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new receiver last name: ");
		String lastname = scan.nextLine();
		System.out.println("Enter new receiver first name: ");
		String firstname = scan.nextLine();
		System.out.println("Enter new receiver contact no: ");
		String contactNo = scan.nextLine();

		try {
			control.removeReceiver(receiverID, firstName, lastName, address, contactNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeSender() {
		System.out.println("Enter new sender ID: ");
		int senderID = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new sender last name: ");
		String lastname = scan.nextLine();
		System.out.println("Enter new sender first name: ");
		String firstname = scan.nextLine();
		System.out.println("Enter new sender contact no: ");
		String contactNo = scan.nextLine();

		try {
			control.removeSender(senderID, lastname, firstname, address, contactNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeTransaction() {
		System.out.println("Enter new transaction tracking no: ");
		int trackingNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new transaction sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter new transaction receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter new transaction date: ");
		String transactionDate = scan.nextLine();
		System.out.println("Enter new transaction courier fee: ");
		int courierFee = scan.nextInt();

		try {
			control.removeTransaction(trackingNo, senderID, receiverID, transactionDate, courierFee);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeMoneyExpress() {
		System.out.println("Enter money express tracking no: ");
		int trackingNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter money express sender ID: ");
		int senderID = scan.nextInt();
		System.out.println("Enter money express receiver ID: ");
		int receiverID = scan.nextInt();
		System.out.println("Enter money express amount: ");
		int amount = scan.nextInt();
		System.out.println("Enter money express status: ");
		String status = scan.nextLine();

		try {
			control.removeMoneyExpress(trackingNo, senderID, receiverID, amount, status);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
