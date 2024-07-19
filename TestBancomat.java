package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TestBancomat extends Application {

	

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		ContoCorrente conto1 = new ContoCorrente("1234", 10000);
		ContoCorrente conto2 = new ContoCorrente("2345", 10000);
		
		Bancomat banca1 = new Bancomat ();
		
		banca1.addConto(conto1);
		banca1.addConto(conto2);
		
		System.out.println(banca1.getSaldo("1234"));
		
		
	

	
	//creating label email 
    Text text1 = new Text("Inserisci pin");
    
    //Creating Text Filed for email        
    TextField textField1 = new TextField(); 
    
  //creating label email 
    Text text2 = new Text("Inserisci importo");
    
    //Creating Text Filed for email        
    TextField textField2 = new TextField();
    
    Button btn1=new Button("Submit");
    
    Button btnP=new Button("Preleva");
    
    Button btnD=new Button("Deposita");
    
  //Creating a Grid Pane 
    GridPane gridPane = new GridPane();    
    
    //Setting size for the pane 
    gridPane.setMinSize(400, 400); 
	
    //Setting the padding  
    gridPane.setPadding(new Insets(30, 30, 30, 30));
    
    gridPane.setVgap(5); 
    gridPane.setHgap(10);
    
    
    btnP.setVisible(false);
    btnD.setVisible(false);
    text2.setVisible(false);
    textField2.setVisible(false);
	
    gridPane.add(text1, 0, 0);
    gridPane.add(textField1, 1, 0);
    gridPane.add(btn1, 0, 3);
    gridPane.add(btnP, 0, 4);
    gridPane.add(text2, 0, 1);
    gridPane.add(textField2, 1, 1);
    gridPane.add(btnD, 0, 5);
	
	
    //Creating a scene object 
    Scene scene = new Scene(gridPane); 
    
    //Setting title to the Stage 
    stage.setTitle("TestBancomat");
    
 // Registrare un gestore di eventi sul pulsante
    btn1.setOnAction(e -> {
        // Leggere l'input dai campi di testo
    	 String campo  = textField1.getText();
    	 
    	 if (banca1.check(campo)== true) {
    		 
    		 btnP.setVisible(true);
    		 btnD.setVisible(true);
    		 text2.setVisible(true);
    		 textField2.setVisible(true);
    		 
    		// Creare e mostrare un popup con l'input
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("TestBAncomat");
	            alert.setHeaderText("Pin Corretto");
	           
	            alert.showAndWait();
    	 }
    	 
    	 else {
    		 
    		// Creare e mostrare un popup con l'input
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("TestBancomat");
	            alert.setHeaderText("Pin Errato");
	           
	            alert.showAndWait();
    		 
    		 
    	 }
    		
    
    
    
    
	});
    
    
    btnP.setOnAction(e -> {
    	// Leggere l'input dai campi di testo
   	 String campo  = textField1.getText();
   	 String importo1 = textField2.getText();
   	int Saldo = banca1.getSaldo(campo);
   	 //trasfroma stringa in intero
   	 int importo = Integer.parseInt(importo1);
   	 
   	 
   	if  (banca1.check(campo)== true ) {
		
		
   		banca1.Preleva(campo, importo);
		
		if (Saldo >= importo ) {
			
			
    		
    		Saldo = banca1.getSaldo(campo);
   	 
    		
    		// Creare e mostrare un popup con l'input
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("TestBancomat");
            alert.setHeaderText("Prelievo eseguito con successo");
            alert.setContentText("saldo: "+ Saldo);
            alert.showAndWait();}
		
		else if (Saldo == 0) {
   		 // Creare e mostrare un popup con l'input
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("TestBancomat");
           alert.setHeaderText("Impossibile prelevare, Saldo pari a zero ");
            
           alert.showAndWait();}
		
		else   {
   		 // Creare e mostrare un popup con l'input
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("TestBancomat");
           alert.setHeaderText("Saldo insufficiente");
          
           alert.showAndWait();}
		
   	}
		
	
   	
    });
		
		btnD.setOnAction(e -> {
	    	// Leggere l'input dai campi di testo
	   	 String campo  = textField1.getText();
	   	 String importo1 = textField2.getText();
	   	 
	   	 //trasfroma stringa in intero
	   	 int importo = Integer.parseInt(importo1);
	   	if  (banca1.check(campo)== true ) {
			
			
			int Saldo = banca1.getSaldo(campo);
			
			if (Saldo > 0 ) {
				
				
	    		banca1.Versa(campo, importo);
	    		Saldo = banca1.getSaldo(campo);
	   	 
	    		
	    		// Creare e mostrare un popup con l'input
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("TestBancomat");
	            alert.setHeaderText("Prelievo eseguito con successo");
	            alert.setContentText("saldo: "+ Saldo);
	            alert.showAndWait();}
			
			else if (Saldo == 0) {
	   		 // Creare e mostrare un popup con l'input
	           Alert alert = new Alert(AlertType.INFORMATION);
	           alert.setTitle("TestBancomat");
	           alert.setHeaderText("Impossibile prelevare, Saldo pari a zero ");
	            
	           alert.showAndWait();}
			
			else   {
	   		 // Creare e mostrare un popup con l'input
	           Alert alert = new Alert(AlertType.INFORMATION);
	           alert.setTitle("TestBancomat");
	           alert.setHeaderText("Saldo insufficiente");
	          
	           alert.showAndWait();}
		
	   	
		
		
		
		
		
		
		
		
		
		
	
		
    };
    
    
	});
    
  //Adding scene to the stage 
    stage.setScene(scene);
    
    //Displaying the conten
	
    stage.show(); }
    
	
    
    
    
    
    
    
    
    public static void main(String[] args) {
		launch(args);
    
    
    
}
}
	