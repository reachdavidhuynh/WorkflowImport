package application;
import java.awt.Desktop;
import  java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public final class FileChooserClass extends Application{

    private Desktop desktop = Desktop.getDesktop();
 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");
 
        final FileChooser fileChooser = new FileChooser();
 
        final Label label1 = new Label("File:");
        final TextField textField = new TextField();
        textField.setPrefWidth(800);
        final Button openButton = new Button("Select a File...");
        final Button anotherbutton = new Button("Open a File...");
        final Button savebutton = new Button("Save File to use ...");
        final ObservableList<String> lines = FXCollections.observableArrayList("ERRORS:", "--------------");
        final ListView<String> myList = new ListView<String>(lines);
        
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        //openFile(file);
                        textField.setText(file.getPath());
                        String myString[] = DomMaker.childrenParse(file.getPath());
                        lines.add(myString[0]);
                        lines.add(myString[1]);
                        lines.add(myString[2]);
                        lines.add(myString[3]);
                    }
                }
            });
        
        anotherbutton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                    	File anfile = new File(textField.getText());
                    	if (anfile != null) {
                           openFile(anfile);
                        }
                    }
                });
     
        savebutton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e)  {
                    	File anfile = null;
                    	if(textField.getText()!= "" || textField.getText() != null){
                    		 anfile = new File(textField.getText());
                    	}
                    		else{
                    			System.out.println("No file chosen");
                    			return; 
                    		}
                    	if (anfile != null) {
                    		  boolean bool = false; 
                    		  String workingDir = System.getProperty("user.dir");
                    		  File dir = new File("XML Uploads");
                    		  dir.mkdir();
                    		  String path = workingDir + File.separator + "XML Uploads" + File.separator;
                    		  File dest = null;
                    		  dest = new File(path + "savedFile.xml");
                    		  try{
                    		     bool = dest.createNewFile();
								copyFiles(anfile, dest);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
                        }
                    }
                });

 

        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(label1, 0, 0);
        GridPane.setConstraints(textField, 0, 1);
        GridPane.setConstraints(openButton, 0, 2);
        GridPane.setConstraints(anotherbutton,  0,3); 
        GridPane.setConstraints(savebutton, 0, 4); 
        GridPane.setConstraints(myList,  0,  5);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(label1, textField, openButton, savebutton, myList);
 
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
    }
 
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                FileChooserClass.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }



	private static void copyFiles(File source, File dest) throws IOException{
		Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
		
}