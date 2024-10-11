import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader; 
import javafx.fxml.Initializable; 
import javafx.scene.Node; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.VBox; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 
import java.io.IOException; 
import java.net.URL; 
import java.util.ResourceBundle; 
public class DeletionController implements Initializable { 
@FXML 
private VBox BookIDVBox; 
@FXML 
private VBox BookNameVBox; 
@FXML 
private VBox BookAuthorVBox; 
@FXML 
private Button backButton; 
@FXML 
private TextField cusIDDeletion; 
@FXML 
private Button deleteButton; 
private Stage stage; 
public void initialize(URL url, ResourceBundle res){ 
String BookID= App.getBookID(); 
System.out.println(BookID); 
Text bookID = new Text(BookID); 
BookIDVBox.getChildren().add(bookID); 
String bookName = App.getBookNames(); 
Text Booknames = new Text(bookName); 
BookNameVBox.getChildren().add(Booknames); 
String Author = App.getAuthorNames(); 
Text Authornames = new Text(Author); 
BookAuthorVBox.getChildren().add(Authornames); 
} 
@FXML 
void DeleteButtonOnClicked(ActionEvent event) { 
int cusID = Integer.parseInt(cusIDDeletion.getText()); 
App.deleteBook(cusID); 
App.showAlert( "Entry Removed", "The Book with Book ID: "+cusID+" has been 
deletd from the Database."); 
} 
@FXML 
void backButtonOnClicked(ActionEvent event) { 
try{ 
Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml")); 
Scene scene = new Scene(root); 
stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
stage.setScene(scene); 
stage.show(); 
} 
catch(IOException e){ 
e.printStackTrace(); 
} 
} 
}