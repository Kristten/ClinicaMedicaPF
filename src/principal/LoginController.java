package principal;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {
	@FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;
    
    
    public void entrar(ActionEvent event) throws IOException {
    	if(txtUsuario.getText().equalsIgnoreCase("admin") && txtSenha.getText().equalsIgnoreCase("admin")) {
    	BorderPane voltar = (BorderPane)FXMLLoader.load(getClass().getResource("InicialMedico.fxml"));
		Scene scene = new Scene(voltar);
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.setMaximized(true);
		window.show();
		
    	}
    	
    	else if(txtUsuario.getText().equalsIgnoreCase("secretaria") && txtSenha.getText().equalsIgnoreCase("secretaria")) {
        	BorderPane voltar = (BorderPane)FXMLLoader.load(getClass().getResource("InicialSecretaria.fxml"));
    		Scene scene = new Scene(voltar);
    		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    		window.setScene(scene);
    		window.setMaximized(true);
    		window.show();
    		
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "Senha ou usuário ínvalidos!");
        	}
    }


	public TextField getTxtUsuario() {
		return txtUsuario;
	}


	public void setTxtUsuario(TextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}


	public PasswordField getTxtSenha() {
		return txtSenha;
	}


	public void setTxtSenha(PasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}
    

}
