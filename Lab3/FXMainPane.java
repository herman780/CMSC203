

import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	//student Task #2:
		//  declare five buttons, a label, and a textfield
		Button hello, howdy, chinese, clear, exit;
		Label wordFeedback;
		TextField wordStatement;
		
		//Declaring of a sixth button saying "Hello" in another language (Optional) from task #4 
		Button punjabi;
		
		//  declare two HBoxes
		HBox componentStorage, componentStorage2;
		
		//student Task #4:
		//  declare an instance of DataManager
		DataManager dataManager;
		/**
		 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
		 * wait to add a component to its containing component until the container has
		 * been created.  This is the only constraint on the order in which the following 
		 * statements appear.
		 */
		FXMainPane() {
			//student Task #2:
			//  instantiate the buttons, label, and textfield
			hello = new Button("Hello");
			howdy = new Button("Howdy");
			chinese = new Button("Chinese");
		    clear = new Button("Clear");
			exit = new Button("Exit");
			wordFeedback = new Label("Feedback:");
			wordStatement = new TextField();
			//  instantiate the HBoxes
			componentStorage = new HBox();
			componentStorage2 = new HBox();
			
			//student Task #4:
			//  instantiate the DataManager instance
			dataManager = new DataManager();
			
			// Instantiating the sixth button of "Hello" in another language from student task #4:
			punjabi = new Button("Punjabi");
			
			//  set margins and set alignment of the components
			componentStorage.setAlignment(Pos.CENTER);
			componentStorage2.setAlignment(Pos.CENTER);
			
			Insets insetEach = new Insets(15);
			HBox.setMargin(hello, insetEach);
			HBox.setMargin(howdy, insetEach);
			HBox.setMargin(chinese, insetEach);
			HBox.setMargin(punjabi, insetEach);
			HBox.setMargin(clear, insetEach);
			HBox.setMargin(exit, insetEach);
			HBox.setMargin(wordFeedback, insetEach);
			HBox.setMargin(wordStatement, insetEach);
			
			//student Task #3:
			//  add the label and textfield to one of the HBoxes
			componentStorage.getChildren().addAll(hello, howdy, chinese, punjabi, clear, exit);
			componentStorage2.getChildren().addAll(wordFeedback, wordStatement);
			//  add the buttons to the other HBox
			//  add the HBoxes to this FXMainPanel (a VBox)
			getChildren().addAll(componentStorage,componentStorage2);
			
			hello.setOnAction(new ButtonHandler());
			howdy.setOnAction(new ButtonHandler());
			chinese.setOnAction(new ButtonHandler());
			punjabi.setOnAction(new ButtonHandler());
			clear.setOnAction(new ButtonHandler());
			exit.setOnAction(new ButtonHandler());
			
		}
		
		//Task #4:
		//  create a private inner class to handle the button clicks
		private class ButtonHandler implements EventHandler<ActionEvent>
		{
			
			public void handle(ActionEvent event)
			{
				if(event.getTarget() == hello)
				{
					wordStatement.setText(dataManager.getHello());
				}
				else if(event.getTarget() == howdy)
				{
					wordStatement.setText(dataManager.getHowdy());
				}
				else if(event.getTarget() == chinese)
				{
					wordStatement.setText(dataManager.getChinese());
				}
				else if(event.getTarget() == punjabi)
				{
					wordStatement.setText(dataManager.getPunjabi());
				}
				else if(event.getTarget() == clear)
				{
					wordStatement.setText("");
				}
				else if(event.getTarget() == exit)
				{
					Platform.exit();
					System.exit(0);
				}
				
			}
			
			
		}
	

}
