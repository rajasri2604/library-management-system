import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.scene.layout.VBox; 
import java.io.IOException; 
import java.net.URL; 
import java.util.ResourceBundle; 
import javafx.fxml.FXMLLoader; 
import javafx.fxml.Initializable; 
import javafx.scene.Node; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 
public class BookDetailsController implements Initializable { 
@FXML 
private VBox BookAuthorVBox; 
@FXML 
private VBox BookIDVBox; 
@FXML 
private VBox BookNameVBox; 
private Stage stage; 
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
public void initialize(URL url, ResourceBundle resourceBundle){ 
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
}