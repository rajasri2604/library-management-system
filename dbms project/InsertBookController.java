import java.io.IOException; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Node; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 
public class InsertBookController { 
@FXML 
private TextField NewAuthorField; 
@FXML 
private TextField NewBookField; 
private Stage stage; 
@FXML 
void DoneButtonOnClicked(ActionEvent event) { 
String bookname = NewBookField.getText(); 
String Authorname = NewAuthorField.getText(); 
App.enterBook(bookname, Authorname); 
App.showAlert("Book Added!","The Book "+bookname+" is Added to the 
Database"); 
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