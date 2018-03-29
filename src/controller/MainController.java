package controller;

import java.io.File;

import javax.swing.JFileChooser;

import application.DecisionMaking;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
    private TextArea cell11;
	@FXML
    private TextArea cell12;
	@FXML
    private TextArea cell13;
	@FXML
    private TextArea cell21;
	@FXML
    private TextArea cell22;
	@FXML
    private TextArea cell23;
	@FXML
    private TextArea cell31;
	@FXML
    private TextArea cell32;
	@FXML
    private TextArea cell33;
	@FXML
    private TextArea cell41;
	@FXML
    private TextArea cell42;
	@FXML
    private TextArea cell43;
	@FXML
    private TextArea cell51;
	@FXML
    private TextArea cell52;
	@FXML
    private TextArea cell53;
	@FXML
    private TextArea cell61;
	@FXML
    private TextArea cell62;
	@FXML
    private TextArea cell63;
	@FXML
    private TextArea cell71;
	@FXML
    private TextArea cell72;
	@FXML
    private TextArea cell73;
	@FXML
	private TextField path;
	
	 @FXML
	 public void onClickMethod(){
		 DecisionMaking decisionMaking = new DecisionMaking(path.getText());
		 decisionMaking.readFile();
		 decisionMaking.calculateCriteria();
		 double[][] table = decisionMaking.getTable();
		 TextArea[][] cells= new TextArea[3][7];
		 cells[0][0]=cell11;
		 cells[1][0]=cell12;
		 cells[2][0]=cell13;
		 cells[0][1]=cell21;
		 cells[1][1]=cell22;
		 cells[2][1]=cell23;
		 cells[0][2]=cell31;
		 cells[1][2]=cell32;
		 cells[2][2]=cell33;
		 cells[0][3]=cell41;
		 cells[1][3]=cell42;
		 cells[2][3]=cell43;
		 cells[0][4]=cell51;
		 cells[1][4]=cell52;
		 cells[2][4]=cell53;
		 cells[0][5]=cell61;
		 cells[1][5]=cell62;
		 cells[2][5]=cell63;
		 cells[0][6]=cell71;
		 cells[1][6]=cell72;
		 cells[2][6]=cell73;
		 for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < 7; j++) {
				cells[i][j].setText(String.valueOf(table[i][j]));
			}
		}
	
		for (int j = 3; j < 7; j++) {
			double max=Math.max(table[0][j], Math.max(table[1][j], table[2][j]));
			for (int i = 0; i < 3; i++) {
				if(table[i][j]==max){
					cells[i][j].setStyle("-fx-border-color: green; -fx-border-width:3");
				}
			}
		}
	}
	 @FXML
	 public void onClickMethodChooseFile(){
		 JFileChooser fileopen = new JFileChooser();
		 int ret = fileopen.showDialog(null, "Відкрити файл");                
		 if (ret == JFileChooser.APPROVE_OPTION) {
		     File file = fileopen.getSelectedFile();
		     path.setText(file.getPath());
		 }
	 }
		
}
	 

