package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SecretariaController {
	@FXML TabPane tabPane;
	@FXML 
	public void abreCadPaciente() {
		abreTab("Pacientes", "CadPaciente.fxml");
	}
	public void abreAgendamento() {
		abreTab("Agendamento", "AgendamentoConsulta.fxml");
	}
	public void abreAgenda() {
		abreTab("Agenda", "Agenda.fxml");
	}
	@FXML 
	private void voltar(ActionEvent event) throws IOException {
    	
		try {
		BorderPane voltar = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(voltar);
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.setMaximized(true);
		window.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	 private void abreTab(String titulo, String path) {
			try{
				Tab tab = tabAberta(titulo);
				if (tab==null) {
					tab = new Tab(titulo);
					tab.setClosable(true);
					tabPane.getTabs().add(tab);
					FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
					Parent root = loader.load();
					tab.setContent((Node) root);
				}
				selecionaTab(tab);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	    private Tab tabAberta(String titulo) {
			for (Tab tb : tabPane.getTabs()) {
				if(!(tb.getText()==null) && tb.getText().equals(titulo)) 
					return tb;
			}
			return null;
		}
	    
	    
	    private void selecionaTab(Tab tab) {
			tabPane.getSelectionModel().select(tab);
		}
	    
//	    private void agendarConsulta() {
//	    	
//	    }

}
