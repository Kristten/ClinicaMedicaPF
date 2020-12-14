package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import dao.PessoaDao;
import dao.ProntuarioDao;

import domain.Pessoa;
import domain.Prontuario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProntuarioController {
	@FXML
	private DatePicker data;
    @FXML
    private TextField txtPaciente;
    @FXML
    private TableView<Pessoa> tbl;
    @FXML
    private TableColumn<Pessoa, String> colNome;
    @FXML
    private TableColumn<Pessoa, String> colDataNascimento;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private TextArea txtSintomas;
    @FXML
    private TextArea txtMedicamentos;
    private Prontuario prontuario = null;


    
	@FXML
	public void initialize() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDataNascimento.setCellValueFactory(cellData -> cellData.getValue().nascimentoProperty());
		
		exibirPaciente();
	}
	private void exibirPaciente() {
		ArrayList<Pessoa> lista = PessoaDao.listaTodas("Paciente");
		tbl.setItems(FXCollections.observableArrayList(lista));
	}
	
	@FXML
	public void gravar() {
		Pessoa paciente = tbl.getSelectionModel().getSelectedItem();
		if(prontuario == null) {
			Prontuario a = new Prontuario();
			a.setData(data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			a.setDescricao(txtDescricao.getText());	
 			a.setMedicamentos(txtMedicamentos.getText());
 			a.setSintomas(txtSintomas.getText());
 			a.setPaciente(paciente);
			ProntuarioDao.novoProntuario(a);
		}else {
			prontuario.setPaciente(paciente);
			prontuario.setDescricao(txtDescricao.getText());
			prontuario.setData(data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			prontuario.setMedicamentos(txtMedicamentos.getText());
			prontuario.setSintomas(txtSintomas.getText());
			ProntuarioDao.novoProntuario(prontuario);
			prontuario = null;
		}

	}
	 @FXML
	    public void exportaHTML() {
	    Prontuario p = ProntuarioDao.listaUltimo();
	    		String html = "<html>"
	    				+ "<h1><b>Prontuario Médico</b></h1>"
	    				+ "<h2>Paciente: "+tbl.getSelectionModel().getSelectedItem().getNome()+"</h2>";
//         				+ "<table border='1' cellspacing='0' cellpadding='0'>"
//	    				+ "<tr bgcolor='#b3c155'><td>Nome</td><td>Data</td><td>Descrição</td><td>Sintomas</td></tr>";
	
	    		 
					html += "<tr>";
					html += "<td>"+p.getDescricao()+"<br/></td>";
					html += "<td>"+p.getSintomas()+"<br/></td>";
					html += "<td>"+p.getMedicamentos()+"<br/></td>";
					html += "<td>"+p.getData()+"<br/></td>";
					html += "</tr>";
	    			
	    		html += "</html>";
	    		try {
					FileWriter fw = new FileWriter(new File("relatorio01.html"));
					BufferedWriter bw = new BufferedWriter(fw);
					bw.append(html);
					bw.close();
					fw.close();
					
				
						File caminho = new File("relatorio01.html");
						URI url = caminho.toURI();
						Runtime.getRuntime().exec("cmd.exe /c start chrome.exe "+url);
						//Desktop d = Desktop.getDesktop();
						//d.browse(caminho.toURI());
					
	    		} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
	    

}
