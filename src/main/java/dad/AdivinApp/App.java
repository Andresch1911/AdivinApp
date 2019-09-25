package dad.AdivinApp;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	private Label etiqueta;
	private Button button;
	private TextField entrada;
	private int contador = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		etiqueta = new Label("Introduce un numero entre 0 y 100");
		etiqueta.setWrapText(true);		
		
		entrada = new TextField();
		entrada.setPromptText("Introduce la palabra: ");
		entrada.setMaxWidth(150);
		
		button = new Button("Comprobar");
		button.setDefaultButton(true);
		button.setOnAction(e -> onSaludarButtonAction(e));
		
		
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(etiqueta, entrada, button);
		
		Scene scene = new Scene(root,320,200);
		primaryStage.setTitle("AdivinApp");		
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	private void onSaludarButtonAction(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Random rnd = new Random();
		int num = rnd.nextInt(100);
		try {
		String palabra = entrada.getText();
		int numero = Integer.parseInt(palabra);
		boolean comprobar = num == numero;
		contador++;
		if(numero > 100) {
			contador = contador +1;
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Aprende a leer");
			alert.setHeaderText("Es de 0 a 100");
			alert.setContentText("Sumas dos intentos: "+contador);

			alert.showAndWait();
		}
		if(comprobar) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Has Ganado");
			alert.setHeaderText("Has Adivinado el numero");
			alert.setContentText("Lo has intentado: "+contador);

			alert.showAndWait();
			
			
		}else{
			if(numero > num) {
				Alert mayor = new Alert(AlertType.WARNING);
				mayor.setTitle("Has Fallado");
				mayor.setHeaderText(numero + " es mayor que el numero a adivinar");
				mayor.setContentText("Vuelve a intentarlo!");
				mayor.showAndWait();
				
				//System.out.println(numero + " es mayor que el numero a adivinar");
			}else {
				Alert menor = new Alert(AlertType.WARNING);
				menor.setTitle("Has Fallado");
				menor.setHeaderText(numero + " es menor que el numero a adivinar");
				menor.setContentText("Vuelve a intentarlo!");
				menor.showAndWait();
				
				//System.out.println(numero + " es menor que el numero a adivinar");
			}
		}
		}catch(Exception a) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Numero no valido");
			alert.setHeaderText("Has introducido un numero no valido o letras");
			alert.setContentText("Vuelve a intentarlo");
			alert.showAndWait();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
