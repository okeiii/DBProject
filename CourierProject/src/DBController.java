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
    
    public void showReceiver() {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM receiverdetails;";
    	return stmt.executeQuery(sql);
    }
    
    public void showSender() {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM senderdetails;";
    	return stmt.executeQuery(sql);
    }
    
    public void showTransaction() {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM transactions;";
    	return stmt.executeQuery(sql);
    }
    
    public void showMoneyExpress() {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM moneyexpress;";
    	return stmt.executeQuery(sql);
    }
    
    
   /** public void newReceiver(int rID, String fName, String lName, String address, int contact) throws Exception {
    	sql = "INSERT INTO receiverdetails(receiverID,firstName,lastName,address,contactNo) VALUES (?, ?, ?, ?, ?);";
    	ps = connection.prepareStatement(sql);
    	ps.setString(1, rID);
    	ps.setString(2, fName);
    	ps.setString(3, lName);
    	ps.setInt(4, address);
    	ps.setInt(5, contact);
    	ps.executeUpdate();
    	System.out.println("Successfully added to database");
    }

    public ResultSet verifyID(Integer rID) throws Exception {
    	sql = "SELECT receiverID FROM courier WHERE firstName = ?;";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, rID);
    	return ps.executeQuery();
    }
    
    public ResultSet checkContactNo(Integer contact) throws Exception{
    	sql = "SELECT contactNo FROM courier WHERE receiverID = ?";
    	ps=connection.prepareStatement(sql);
    	ps.setInt(1, rID);
    	return ps.executeQuery();
    }

    public ResultSet getAllReceivers() throws Exception {
    	stmt = connection.createStatement();
    	sql = "SELECT * FROM receiverdetails;";
    	return stmt.executeQuery(sql);
    }
    
    public ResultSet getAllSenders() throws Exception {
    	stmt = connection.createStatement();
    	sql = "Select * from senderdetails;";
    	return stmt.executeQuery(sql);
    }
    
    public ResultSet getAllMoneyExp() throws Exception {
    	stmt = connection.createStatement();
    	sql = "Select * from moneyexpress;";
    	return stmt.executeQuery(sql);
    }
    
    public ResultSet getAllTransactions() throws Exception {
    	stmt = connection.createStatement();
    	sql = "Select * from transactions;";
    	return stmt.executeQuery(sql);
    }
    
    public void deleteTransaction(Integer rID) throws Exception{
    	sql = "delete FROM transactions where receiverID = ?;";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, rID);
    	ps.executeUpdate();
    	System.out.println("Transaction deleted.");
    }
    
    public void newTransaction(Integer sID,String fName,String lName,String address,Integer contact)throws Exception{
    	sql = "Insert into orders(senderID,firstName,lastName,address,contactNo) values(? , ?, ?, ?, ?, ?)";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, sID);
    	ps.setString(2, firstName);
    	ps.setString(3, lastName);
    	ps.setInt(4, address);
    	ps.setInt(5, contactNo);
    	ps.executeUpdate();
    	System.out.println("New sender has been added");
    }
    
    public void updateProductQty(Integer ID,Integer quantity) throws Exception {
    	sql = "Update store.products SET productQty = ? where productID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, quantity);
    	ps.setInt(2, ID);
    	ps.executeUpdate();
    	System.out.println("Product quantity has been updated.");
    }
    
    public void updateOrderStatus(String status,Integer id) throws Exception{
    	sql = "Update store.orders SET orderStatus = ? where orderID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setString(1, status);
    	ps.setInt(2, id);
    	ps.executeUpdate();
    	System.out.println("Order status has been updated.");
    }
    
    public void deleteOrder(Integer id) throws Exception{
    	sql = "Delete from orders where orderID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    	ps.executeUpdate();
    	System.out.println("Order has been deleted.");
    }
    
    public void newCustomer(String name,String address,Integer contact) throws Exception{
    	sql = "Insert into customers(customerName,address,contactNo) values(?,?,?)";
    	ps = connection.prepareStatement(sql);
    	ps.setString(1, name);
    	ps.setString(2, address);
    	ps.setInt(3, contact);
    	ps.executeUpdate();
    	System.out.println("New customer has been added.");
    }
    
    public ResultSet getCustomerContact(Integer id) throws Exception{
    	sql = "Select contactNo from customers where customerID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    	return ps.executeQuery();
    }
    
    public void updateCustomerAddress(Integer ID, String address) throws Exception {
    	sql = "Update customers SET address = ? where customerID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setString(1, address);
    	ps.setInt(2, ID);
    	ps.executeUpdate();
    	System.out.println("Customer address has been updated.");
    }
    
    public void deleteCustomer(Integer id) throws Exception{
    	sql = "Delete from customers where customerID = ? ";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    	ps.executeUpdate();
    	System.out.println("Customer has been deleted");
    }
    
    public void newCashier(String name,Integer salary) throws Exception{
    	sql = "Insert into cashier(cashierName,salary) values(?,?)";
    	ps = connection.prepareStatement(sql);
    	ps.setString(1, name);
    	ps.setInt(2, salary);
    	ps.executeUpdate();
    	System.out.println("New cashier has been added.");
    }
    
    public ResultSet getCashierInfo(Integer id) throws Exception{
    	sql = "select * from cashier where cashierid = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    	return ps.executeQuery();
    }
    
    public void deleteCashier(Integer id) throws Exception{
    	sql = "Delete from cashier where cashierID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    	ps.executeUpdate();
    	System.out.println("Cashier removed.");
    }
    
    public ResultSet getProductInfo(Integer id)throws Exception {
    	sql = "Select * from products where productID = ?";
    	ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    	return ps.executeQuery();
    }

}**/




