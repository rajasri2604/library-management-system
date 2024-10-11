import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Node; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.control.Button; 
import java.io.IOException; 
import javafx.event.ActionEvent; 
public class MainMenuController { 
@FXML 
private Button deleteBooks; 
@FXML 
private Button insertBooks; 
@FXML 
private Button showBooks; 
@FXML 
private Button updateBooks; 
private Stage stage; 
@FXML 
void OnClickDeleteBooks(ActionEvent event) { 
try{ 
Parent root = 
FXMLLoader.load(getClass().getResource("BookDetailsAndDeletion.fxml")); 
Scene scene = new Scene(root); 
stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
stage.setScene(scene); 
stage.show(); 
} 
catch(IOException e){ 
e.printStackTrace(); 
} 
} 
@FXML 
void OnClickInsertBooks(ActionEvent event) { 
try{ 
Parent root = FXMLLoader.load(getClass().getResource("InsertBook.fxml")); 
Scene scene = new Scene(root); 
stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
stage.setScene(scene); 
stage.show(); 
} 
catch(IOException e){ 
e.printStackTrace(); 
} 
} 
@FXML 
void OnClickShowBooks(ActionEvent event) { 
try{ 
Parent root = FXMLLoader.load(getClass().getResource("BookDetails.fxml")); 
Scene scene = new Scene(root); 
stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
stage.setScene(scene); 
stage.show(); 
} 
catch(IOException e){ 
e.printStackTrace(); 
} 
} 
@FXML 
void OnClickUpdateBooks(ActionEvent event) { 
} 
}