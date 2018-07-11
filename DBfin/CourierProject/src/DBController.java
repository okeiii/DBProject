import java.sql.*;

public class DBController {
	private PreparedStatement ps = null;
	private String sql = null;
	private Connection connection;
	private Statement stmt;

    public void dbConnect(String url, String user, String pass) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, pass);
    }

    public void showReceiver() throws Exception {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM receiverdetails;";
    	return stmt.executeQuery(sql);
    }

    public void showSender() throws Exception {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM senderdetails;";
    	return stmt.executeQuery(sql);
    }

    public void showTransaction() throws Exception {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM transactions;";
    	return stmt.executeQuery(sql);
    }

    public void showMoneyExpress() throws Exception {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM moneyexpress;";
    	return stmt.executeQuery(sql);
    }

    public void addReceiver(int rID, String fName, String lName, String address, String contact) throws Exception {
    	sql = "INSERT INTO receiverdetails(receiverID, firstName, lastName, address, contactNo) VALUES(?, ?, ?, ?, ?);";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, rID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setString(4, address);
    	ps.setInt(5, contact);
    	ps.executeUpdate();
    	System.out.println("Successfully added Receiver");
    	height = 10;
    }

    public void addSender(int sID, String fName, String lName, String address, int contact) throws Exception {
    	sql = "INSERT INTO senderdetails(senderID, firstName, lastName, address, contactNo) VALUES(?, ?, ?, ?, ?);";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, sID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setString(4, address);
    	ps.setInt(5, contact);
    	ps.executeUpdate();
    	System.out.println("Successfully added Sender");
    	height = 10;
    }

    public void addTransaction(int tNo, int sID, int rID, String tDate, int cFee) throws Exception {
    	sql = "INSERT INTO transactions(trackingNo, senderID, receiverID, transactionDate, courierFee) VALUES(?, ?, ?, ?, ?);";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, tNo);
    	ps.setString(2, sID);
    	ps.setString(3, rID);
    	ps.setString(4, tDate);
    	ps.setInt(5, cFee);
    	ps.executeUpdate();
    	System.out.println("Successfully added Transaction");
    	height = 10;
    }

    public void addMoneyExpress(int tNo, int sID, int rID, int amt, String sts) throws Exception {
    	sql = "INSERT INTO transactions(trackingNo, senderID, receiverID, amount, status) VALUES(?, ?, ?, ?, ?);";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, tNo);
    	ps.setString(2, sID);
    	ps.setString(3, rID);
    	ps.setString(4, amt);
    	ps.setInt(5, sts);
    	ps.executeUpdate();
    	System.out.println("Successfully added Money Express info");
    	height = 10;
    }

    public void editReceiver(int rID, String fName, String lName, String address, int contact) throws Exception {
    	sql = "UPDATE receiverdetails SET receiverID = ? WHERE lastname = ?";
    	ps.setInt(1, rID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setString(4, address);
    	ps.setInt(5, contact);
    	ps.executeUpdate();
    	System.out.println("Receiver has been edited");
    }

    public void editSender(int sID, String fName, String lName, String address, int contact) throws Exception {
    	sql = "UPDATE senderdetails SET senderID = ? WHERE lastname = ?";
    	ps.setInt(1, sID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setString(4, address);
    	ps.setInt(5, contact);
    	ps.executeUpdate();
    	System.out.println("Sender has been edited");
    }

    public void editTransaction(int tNo, String sID, String rID, String tDate, int cFee) throws Exception {
    	sql = "UPDATE transactions SET trackingNo = ? WHERE senderID = ?";
    	ps.setInt(1, tNo);
    	ps.setString(2, sID);
    	ps.setString(3, rID);
    	ps.setString(4, tDate);
    	ps.setInt(5, cFee);
    	ps.executeUpdate();
    	System.out.println("Transaction has been edited");
    }

    public void editMoneyExpress(int tNo, String sID, String rID, int amt, String sts) throws Exception {
    	sql = "UPDATE moneyexpress SET status = ? WHERE senderID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, tNo);
    	ps.setString(2, sID);
    	ps.setString(3, rID);
    	ps.setString(4, amt);
    	ps.setInt(5, sts);
    	ps.executeUpdate();
    	System.out.println("Money express has been edited");
    }

    public void removeReceiver() {
    	sql = "DELETE FROM receiverdetails WHERE receiverID = ?;";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, rID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setString(4, address);
    	ps.setInt(5, contact);
    	System.out.println("Receiver info deleted.");
    }

    public void removeSender() {
    	sql = "DELETE FROM senderdetails WHERE senderID = ?;";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, sID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setString(4, address);
    	ps.setInt(5, contact);
    	System.out.println("Sender info deleted.");
    }

    public void removeTransaction() {
    	sql = "DELETE FROM transactions WHERE receiverID = ?;";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, tNo);
    	ps.setString(2, sID);
    	ps.setString(3, rID);
    	ps.setString(4, tDate);
    	ps.setInt(5, cFee);
    	System.out.println("Transaction info deleted.");
    }

    public void removeMoneyExpress() {
    	sql = "DELETE FROM moneyexpress WHERE receiverID = ?;";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, tNo);
    	ps.setString(2, sID);
    	ps.setString(3, rID);
    	ps.setString(4, amt);
    	ps.setInt(5, sts);
    	ps.executeUpdate();
    	System.out.println("Money Express info deleted.");
    }

}




