package principal;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.AgendamentoDao;

import domain.Agendamento;

import domain.Pessoa;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AgendamentoController {
	    @FXML
	    private TextField nomePaciente;

	    @FXML
	    private DatePicker data;

	    @FXML
	    private TextField horario;
		@FXML TableView<Pessoa> tbl;
		@FXML TableColumn<Pessoa, String> colNome;
		@FXML TableColumn<Pessoa, String> colDt_Nascimento;

	    
		private Agendamento agendamento = null;
		private Pessoa pacienteSel = null;
		
		@FXML
		public void initialize() {
			colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
			colDt_Nascimento.setCellValueFactory(cellData -> cellData.getValue().nascimentoProperty());
			
			exibirPacientes();
		}
		@FXML
		public void filtrar() {
			String filtro = nomePaciente.getText();
			if(filtro.equals(""))
				exibirPacientes();
			else {
			ArrayList<Pessoa> filtradas = AgendamentoDao.filtra(filtro, "Paciente");
			tbl.setItems(FXCollections.observableArrayList(filtradas));
		}
			}
	    
		@FXML
		public void gravar() {
			Pessoa paciente = tbl.getSelectionModel().getSelectedItem();
			if(agendamento == null) {
				Agendamento a = new Agendamento();
				a.setData(data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				a.setHorario(horario.getText());	
     			a.setNomePaciente(nomePaciente.getText());
     			a.setPaciente(paciente);
				AgendamentoDao.novoAgendamento(a);
			}else {
				agendamento.setNomePaciente(nomePaciente.getText());
				agendamento.setHorario(horario.getText());
				agendamento.setData(data.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				AgendamentoDao.novoAgendamento(agendamento);
				agendamento = null;
			}

		}
		private void exibirPacientes() {
			ArrayList<Pessoa> lista = AgendamentoDao.listaTodas("Paciente");
			tbl.setItems(FXCollections.observableArrayList(lista));
		}
		 @FXML
		   public void clicaTabela() {
			 pacienteSel = tbl.getSelectionModel().getSelectedItem();
			   if(pacienteSel != null) {
				   nomePaciente.setText(pacienteSel.getNome());


			   }
		   }



}