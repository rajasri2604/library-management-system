import javafx.application.Application; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.Alert; 
import javafx.stage.Stage; 
import java.io.IOException; 
import java.sql.*; 
public class App extends Application{ 
f
 inal static String url = "jdbc:mysql://localhost:3306/books"; 
f
 inal static String user = "root"; 
f
 inal static String pass = "0000"; 
public static void main(String[] args){ 
launch(args); 
} 
public void start(Stage stage){ 
Parent root; 
try { 
root = FXMLLoader.load(getClass().getResource("MainMenu.fxml")); 
Scene scene = new Scene(root); 
stage.setScene(scene); 
stage.setTitle("Team 2's RetailShop"); 
stage.setResizable(false); 
stage.show(); 
} catch (IOException e) { 
e.printStackTrace(); 
} 
} 
public static String getBookID(){ 
String res ="Book ID\n\n"; 
try{ 
Connection con = DriverManager.getConnection(url, user, pass); 
Statement stmt = con.createStatement(); 
String sql = "SELECT bookID FROM books;"; 
ResultSet rs = stmt.executeQuery(sql); 
while(rs.next()){ 
res+=(String.valueOf(rs.getInt("bookID"))+"\n\n"); 
} 
//System.out.println(res); 
con.close(); 
} 
catch(SQLException e){ 
e.printStackTrace(); 
} 
return res; 
} 
public static String getBookNames(){ 
String res ="Book Name\n\n"; 
try{ 
Connection con = DriverManager.getConnection(url, user, pass); 
Statement stmt = con.createStatement(); 
String sql = "SELECT bookname FROM books;"; 
ResultSet rs = stmt.executeQuery(sql); 
while(rs.next()){ 
res+=(rs.getString("Bookname"))+"\n\n"; 
} 
//System.out.println(res); 
con.close(); 
} 
catch(SQLException e){ 
e.printStackTrace(); 
} 
return res; 
} 
public static String getAuthorNames(){ 
String res ="Author Name\n\n"; 
try{ 
Connection con = DriverManager.getConnection(url, user, pass); 
Statement stmt = con.createStatement(); 
String sql = "SELECT bookAuthor FROM books;"; 
ResultSet rs = stmt.executeQuery(sql); 
while(rs.next()){ 
res+=rs.getString("BookAuthor")+"\n\n"; 
} 
//System.out.println(res); 
con.close(); 
} 
catch(SQLException e){ 
e.printStackTrace(); 
} 
return res; 
} 
public static void enterBook(String bookName, String bookAuthor){ 
try{ 
Connection con = DriverManager.getConnection(url, user, pass); 
Statement stmt = con.createStatement(); 
String findID ="SELECT bookID FROM books ORDER BY bookID DESC"; 
ResultSet id = stmt.executeQuery(findID); 
id.next(); 
int newID = id.getInt("bookID")+1; 
String sql ="INSERT INTO books VALUES ("+newID+", '"+bookName+"', 
'"+bookAuthor+"');"; 
stmt.execute(sql); 
//System.out.println("\t\tInserted Successfully"); 
} 
catch(SQLException e){ 
e.printStackTrace(); 
} 
} 
public static void showAlert(String Header, String message){ 
Alert alert = new Alert(Alert.AlertType.INFORMATION); 
alert.setTitle("Successful"); 
alert.setHeaderText(Header); 
alert.setContentText(message); 
alert.showAndWait(); 
} 
public static void deleteBook(int bookid){ 
String sql = "DELETE FROM books WHERE bookid = "+bookid+";"; 
try{ 
Connection con = DriverManager.getConnection(url, user, pass); 
Statement stmt = con.createStatement(); 
stmt.execute(sql); 
} 
catch(SQLException e){ 
e.printStackTrace(); 
} 
} 
}