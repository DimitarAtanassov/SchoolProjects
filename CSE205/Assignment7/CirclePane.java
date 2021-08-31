// Assignment #7: Arizona State University CSE205
//          Name: Dimitar Atanassov
//     StudentID: 1217419085
//       Lecture: (T Th 4:30 - 5:45)
//   Description: CirclePane class creates a pane where we can use
//                mouse key to drag on canvass and there will be some color following
//                the mouse. We can also use combo boxes to change its colors and stroke widths
//                //--- is where you need to add your own code

//import any necessary classes here
//----
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CirclePane extends BorderPane
{
    //instance variables - check assignment's description
    //----

    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> bgColorCombo;
    private ComboBox<String> widthCombo;
    private Circle[][] circleArray;
    Label PrimaryColorLabel;
    Label BackgroundColorLabel;
    Label StrokeWidthLabel;
    Color primaryColor;
    Color secondaryColor;
    Color bgColor;
    int selectWidth;
    
    private final int NUM_COL =6, NUM_ROW = 6, RADIUS = 40;
    private GridPane canvas;	//this is where circles are drawn

    //constructor
    public CirclePane()
    {
    	
        //Step #1: Initialize instance varibles and set up the layout
		//----
    	PrimaryColorLabel = new Label("PrimaryColor");	//Label for primary color combobox
    	BackgroundColorLabel = new Label("BackgroundColor");	//Label for bg color combobox
    	StrokeWidthLabel = new Label("StrokeWidth");	//Label for stroke width
    	primaryColorCombo = new ComboBox<String>();	//Combo box that stores primary colors
    	primaryColor = Color.BLACK;
    	bgColor = Color.WHITE;
    	secondaryColor = Color.GREY;
    	selectWidth = 1;
    	
    	String primColor [] = {"Black", "Red", "Green", "Blue"};
    	for(int i = 0; i < primColor.length; i++) {
    		primaryColorCombo.getItems().add(primColor[i]);	//Adds colors to combo box
    	}
    	primaryColorCombo.setPromptText(primColor[0]);	//Sets the inital text of Combobox
    	
    	bgColorCombo = new ComboBox <String>();
    	String bgColor [] = {"White", "Beige", "AliceBlue", "Gold"};
    	for(int i = 0; i < bgColor.length; i++) {
    		bgColorCombo.getItems().add(bgColor[i]);	//Adds colors to combo box
    	}
    	bgColorCombo.setPromptText(bgColor[0]);		//Sets inital text
    	
    	widthCombo = new ComboBox<String>();
    	String widthArr [] = {"1", "3", "5", "7"};		
    	for(int i = 0; i < widthArr.length; i++) {
    		widthCombo.getItems().add(widthArr[i]);		//Adds numbers to combobox as a string
    	}
    	widthCombo.setPromptText(widthArr[0]);	//sets inital text
    	
    	


        //Instantiate the two dimensional circleArray that contains
    	circleArray = new Circle[NUM_ROW][NUM_COL];
        //6 columns and 6 rows of circles (36 in total)
        //----
    	

        //instantiate canvas and set its width and height
        canvas = new GridPane();
        canvas.setPrefWidth(2*RADIUS * NUM_COL);
        canvas.setPrefHeight(2*RADIUS * NUM_ROW);

        //Use nested loop to instantiate the 6 columns by 6 rows of
        //Circle objects, add them inside the circleArrary
        for(int i = 0; i < NUM_ROW; i++) {
    		for(int j = 0; j < NUM_COL; j++ ) {
    			 Circle circle = new Circle(i,j,RADIUS);	//Creates a new circle at row i column j and radius of 40
    			 circle.setFill(Color.WHITE);	//Fill color of circle
    			 circle.setStroke(Color.BLACK);	//Outline of circle
    			 circle.setStrokeWidth(selectWidth);	//Stroke width of circle
    			 canvas.add(circle,i, j);	//adds each cirle to gridpane
       			 circleArray[i][j] = circle;	//adds circle object to array
    		}
    	}
        
        //----
        //----
        //leftPane is a VBox, it should contain labels and the 3 comboBox
        VBox leftPane = new VBox();
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setStyle("-fx-border-color: black");
        leftPane.getChildren().addAll(PrimaryColorLabel,primaryColorCombo,BackgroundColorLabel,bgColorCombo,  
        		StrokeWidthLabel, widthCombo);
        //----

        //add leftPane and canvas to CirclePane
        //----
        this.setLeft(leftPane);
        this.setCenter(canvas);

        //Step 3: register the source nodes with its handler objects
        //----
        canvas.setOnMouseDragged(new MouseHandler());	//Checks if mouse is dragged
        primaryColorCombo.setOnAction(new PrimaryColorHandler());
        bgColorCombo.setOnAction(new BackgroundColorHandler());
        widthCombo.setOnAction(new WidthHandler());
    }

    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
			//Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
			//to check whether the mouse key is dragged or released, etc
			//write your own codes here
            //----
        	try {
            	if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            		int diameter = RADIUS * 2 + selectWidth * 2;
            		int x =(int) event.getX()/diameter;	//Get the x value of mouse
            		int y =(int)event.getY()/diameter;	//Gets y value of mouse
            		for(int i = 0; i < circleArray.length;i++) {
            			for(int j = 0; j < circleArray[i].length; j++) {
            				circleArray[i][j].setFill(bgColor);
            			}
            		}
            		for(int  i = 0; i < circleArray.length; i++) {	//row
            			for(int j = 0; j < circleArray[i].length; j++) {	//column
            				if(i == x && j == y) {	//Checks if row and column match x and y
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x - 1][y].setFill(secondaryColor);
            					circleArray[x + 1][y].setFill(secondaryColor);
            					circleArray[x][y + 1].setFill(secondaryColor);
            					circleArray[x][y - 1].setFill(secondaryColor);
            				}
            				
            			}
            		}
            	}
        	}catch(ArrayIndexOutOfBoundsException e) {
        		if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        			int diameter = RADIUS * 2 + selectWidth * 2;
            		int x =(int) event.getX()/diameter;	//Get the x value of mouse
            		int y =(int)event.getY()/diameter;	//Gets y value of mouse
            		for(int  i = 0; i < circleArray.length; i++) {	
            			for(int j = 0; j < circleArray[i].length; j++ ) {
            				if(i == x && j == y && x==0 && y==0) {	//All if statements below just fix up the program so everything works properly
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x +1][y].setFill(secondaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 5 && y == 0 ) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x-1][y].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 5 && y == 5 ) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            					circleArray[x-1][y].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 0 && y == 5 ) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            					circleArray[x+1][y].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 0 && y == 1 ) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            					circleArray[x+1][y].setFill(secondaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 0 && y == 2 ) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x+1][y].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 0 && y == 3 ) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x+1][y].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 0 && y == 4) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x+1][y].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 1 && y == 5) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 2 && y == 5) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if (i == x && j == y && x == 3 && y == 5){
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 4 && y == 5) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 5 && y == 4) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 5 && y == 3) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 5 && y == 2) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            				if(i == x && j == y && x == 5 && y == 1) {
            					circleArray[x][y].setFill(primaryColor);
            					circleArray[x][y+1].setFill(secondaryColor);
            					circleArray[x][y-1].setFill(secondaryColor);
            				}
            			}
            		}
        		}
        	}
        }
    }//end MouseHandler

	//Step #2(B) - Primary and secondary color handler
    private class PrimaryColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
			//Write your own code here
			//----
        	switch(primaryColorCombo.getSelectionModel().getSelectedItem()) {	//Gets selected item in combobaox
        	case "Black":	//Every case is for a different selecetion of color
        		primaryColor = Color.BLACK;
        		secondaryColor = Color.GRAY;
        		break;
        		
        	case "Red":
        		primaryColor = Color.RED;
        		secondaryColor = Color.PINK;
        		break;
        		
        	case "Green":
        		primaryColor = Color.GREEN;
        		secondaryColor = Color.LIGHTGREEN;
        		break;
        		
        	case "Blue" :
        		primaryColor = Color.BLUE;
        		secondaryColor = Color.POWDERBLUE;
        		break;
        	}

		}
    }//end PrimaryColorHandler

    //Step #2(C): background color handler
 	//Write a private class called BackgroundColorHandler that handles the background
    private class BackgroundColorHandler implements EventHandler<ActionEvent>{
        //color changes
        //----
        //----
    	public void handle(ActionEvent event) {
    		switch(bgColorCombo.getSelectionModel().getSelectedItem()) {
    		case "White":
    			bgColor = Color.WHITE;
    			break;
    		
    		case "Beige":
    			bgColor = Color.BEIGE;
    			break;
    			
    		case "AliceBlue":
    			bgColor = Color.ALICEBLUE;
    			break;
    		
    		case "Gold":
    			bgColor = Color.GOLD;
    			break;
    		}
    		for(int i = 0; i < circleArray.length; i++) {
    			for (int j = 0; j < circleArray[i].length; j++) {
    				circleArray[i][j].setFill(bgColor);
    			}
    		}
    	}
    }
    




    //Step #2(D): handle the stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent event) {
    		selectWidth = Integer.parseInt(widthCombo.getValue());	//Need to change to an int from a string so you can store in selectWidth
    		for(int i = 0; i < circleArray.length; i++) {
    			for (int j = 0; j < circleArray[i].length; j++) {
    				circleArray[i][j].setStrokeWidth(selectWidth);
    			}
    		}
    	}

    }//end of WidthHandler

} //end of CirclePane