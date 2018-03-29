package application;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class DecisionMaking {
	
	private String path;
	
	private double[][] table=new double[3][7];
	
	public DecisionMaking(String path){
		this.path=path;
	}
	
	public void readFile(){
	    try(FileReader reader = new FileReader(path))
        {
            String data= new String();
            int c;
            while((c=reader.read())!=-1){
                 data+=(char)c;
            } 
            String[] splitData=data.split("\n");
            String[] numbers;
           for (int i = 0; i < splitData.length; i++) {
        	   numbers = splitData[i].split(" ");
        	   for (int j = 0; j < 3; j++) {
        		   table[i][j]=Double.parseDouble(numbers[j]);
        	   }
           }
		}
        
	    catch(IOException ex){
            
            System.out.println(ex.getMessage());
        }  
	}
	
	public void calculateCriteria(){
		for (int i = 0; i < 3; i++) {
			table[i][3]=Math.min(table[i][0],Math.min(table[i][1], table[i][2]));
			table[i][4]=Math.min(table[i][0],Math.min(table[i][1], table[i][2]))*0.5+Math.max(table[i][0],Math.max(table[i][1], table[i][2]))*0.5;
			table[i][5]=(table[i][0]+table[i][1]+table[i][2])/3;
			table[i][6]=table[i][0]*0.5+table[i][1]*0.35+table[i][2]*0.15;
		}
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < 7; j++) {
				table[i][j] = Double.parseDouble(String.format(Locale.ENGLISH, "%(.2f", table[i][j]));
			}
		}
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double[][] getTable() {
		return table;
	}

	public void setTable(double[][] table) {
		this.table = table;
	}
	
}
