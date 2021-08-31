// Assignment 6: ASU - CSE 205
// Name:	Dimitar Atanassov
// StudentID:	1217419086
//Lecture Date and Time:	Tuesday/Thursday 4:30-5:45
//  Description: GeneratePane creats a pane where a user can enter
//  department information and create a list of available departments.

/* --------------- */
/* Import Packages */
/* --------------- */

import java.util.ArrayList;


import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// JavaFX classes
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a department
 * information and create a list of available departments.
 */
public class GeneratePane extends HBox {
    /* ------------------ */
    /* Instance variables */
    /* ------------------ */
	Button AddDep;
	TextArea TextareaDep;
	Label DepTitle;	//Label for Department title	
	Label NumOfFac;	//Label for Number of Faculty
	Label UniName; //Label for University name
	Label ErrorLabel;
	TextField DepText;	//Input for Department title
	TextField FacText;	//Input for Number of Faculty
	TextField UniText;	//Input for Uni name
	TextArea DepTA;

    ArrayList<Department> departList;
    private SelectPane selectPane; // The relationship between GeneratePane and SelectPane is Aggregation
    //declare and init

    /**
     * CreatePane constructor
     *
     * @param list   the list of departments
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Department> list, SelectPane sePane) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */
    	this.departList = list;
    	this.selectPane = sePane;
    	AddDep = new Button("Add a Department");	//New button
    	DepTitle = new Label("Department Title");	//Label
    	NumOfFac = new Label ("Number of faculty");	//Label
    	UniName = new Label("University Name");	//Label
    	ErrorLabel = new Label();	//Creates a new label that will let the user know if there is an error
    	ErrorLabel.setTextFill(Color.color(1, 0, 0));	//Set label color to red 
    	DepText = new TextField();	
    	FacText = new TextField();
    	UniText = new TextField();
    	DepTA = new TextArea();
    	DepTA.setPrefHeight(400);	//Sets the size of the textarea
    	DepTA.setText("No Department");		//Sets a text in the Text area
    	DepTA.setEditable(false);	//User can not edit text area


        //initialize each instance variable (textfields, labels, textarea, button, etc.)
		//and set up the layout

		//create a GridPane to hold labels & text fields.
		//you can choose to use .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.
    	VBox pane1 = new VBox();
    	GridPane gridPane = new GridPane();
    	VBox pane2 = new VBox();
    	pane2.setPadding(new Insets(10,10,10,10));
    	HBox mainLay = new HBox();
    	mainLay.setSpacing(250);

		// Set both left and right columns to 50% width (half of window)
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
		//You might need to create a sub pane to hold the button

		//Set up the layout for the left half of the GeneratePane.
        //Adding things to the grid pane
    	gridPane.add(ErrorLabel,0, 0);
    	gridPane.add(DepTitle,1,1);
    	gridPane.add(NumOfFac, 1, 2);
    	gridPane.add(UniName,1,3);
    	gridPane.add(DepText, 2,1);
    	gridPane.add(FacText, 2, 2);
    	gridPane.add(UniText, 2, 3);
    	gridPane.add(AddDep,2,4);
    	gridPane.setVgap(5);
    	pane1.getChildren().addAll(gridPane);	//Stores grid pane in a vbox
    	pane2.getChildren().add(DepTA);		//Stores Textarea in a vbox
    	mainLay.getChildren().addAll(pane1,pane2);	//Stores both vboxs in an hbox so they are side by side
    	this.getChildren().addAll(mainLay);	//adds the mainlayout to the scene
		//the right half of the GeneratePane is simply a TextArea object
		//Note: a ScrollPane will be added to it automatically when there are no more space
		//Add the left half and right half to the GeneratePane


		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
        // Bind button click action to event handler
    	AddDep.setOnAction(new ButtonHandler());

    } // end of constructor

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a department" is pushed
     * or not, When the event occurs, it get a department's Title, number of faculties,
     * and its university information from the relevant text fields, then create a
     * new department and adds it to the departList. Meanwhile it will display the department's
     * information inside the text area. using the toString method of the Department
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of faculty
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        /**
         * handle Override the abstract method handle()
         */
        public void handle(ActionEvent event) {
            // Declare local variables
            Department newDepart;
            int numberOfFaculty = 0;
            Boolean isEmptyFields = false;

            // If any field is empty, set isEmptyFields flag to true
            if(DepText.getText().equals("")|| FacText.getText().equals("") || UniText.getText().equals("")){	//Check if there are emptyFields
            	ErrorLabel.setText("Please fill all fields.");
            	isEmptyFields = true;
            }

            // Display error message if there are empty fields
            else {	//Statement runs if there are no empty fields
            	isEmptyFields = false;
            	try {
            		numberOfFaculty = Integer.parseInt(FacText.getText());	//Change from string to int 
            		newDepart = new Department();	//Creates a new dep
            		newDepart.setDeptName(DepText.getText());	
            		newDepart.setNumberOfMembers(numberOfFaculty);
            		newDepart.setUniversity(UniText.getText());
            		for(int i = 0; i < departList.size(); i++) {	//Checks for duplicates in department name and uni name
            			if(departList.get(i).getUniversity().equals(newDepart.getUniversity()) && departList.get(i).getDeptName().equals(newDepart.getDeptName())) {
            				throw new Exception();
            			}
            		}
            		departList.add(newDepart);	//Adds new department to the list
            		ErrorLabel.setText("Department added");
            		DepTA.clear();	//Clears text area
            		for(Department elements: departList) {	//Adds the arraylist objects to the textArea
            			DepTA.appendText(elements.toString());
            		}
            		selectPane.updateDepartList(newDepart);
            	}
                catch (NumberFormatException e) {
                    // If the number of faculties entered was not an integer, display an error
                	ErrorLabel.setText("Please enter an integer for the number of faculty.");

                } 
                catch (Exception e) {
                    // Catches generic exception and displays message
                    // Used to display 'Department is not added - already exist' message if department already exist
                	ErrorLabel.setText("Department is not added - already exist");

                }
            }


            // If all fields are filled, try to add the department
            
                    /*
                     * Cast faculties Field to an integer, throws NumberFormatException if unsuccessful
                     */
            	


                    // Data is valid, so create new Department object and populate data

                    // Loop through existing departments to check for duplicates
                    // do not add it to the list if it exists and dispay a message




                    // department is not a duplicate, so display it and add it to list

                 //end of try
                
                    // If the number of faculties entered was not an integer, display an error

                
                
                    // Catches generic exception and displays message
                    // Used to display 'Department is not added - already exist' message if department already exist

                

           
        } // end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class


