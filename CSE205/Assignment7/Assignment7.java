// Assignment #7: Arizona State University CSE205
//          Name:
//     StudentID:
//       Lecture: (MWF 8:00am)
//   Description: The Assignment7 class creates a CirclePane object
//                on which we can draw circles with different
//                colors.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Assignment7 extends Application
{
    public void start(Stage primaryStage)
    {
        //create a CirclePane object.
        CirclePane gui = new CirclePane();

        //put gui on top of the rootPane
        StackPane rootPane = new StackPane(); //A type of pane
        rootPane.getChildren().add(gui);	//Get the gui you created

        // Create a scene and place rootPane in the stage
        Scene scene = new Scene(rootPane, 630, 540);	
        primaryStage.setTitle("Color Circle Grids");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
