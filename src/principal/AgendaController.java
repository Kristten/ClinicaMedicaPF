package principal;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.AgendaDao;


import domain.Agendamento;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AgendaController {
	@FXML TableView<Agendamento> tbl;
	@FXML TableColumn<Agendamento, String> colNome;
	@FXML TableColumn<Agendamento, String> colHorario;
//	private Agendamento agendamento = null;

	// data/hora atual
	LocalDateTime agora = LocalDateTime.now();

	// formatar a data
	DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String dataFormatada = formatterData.format(agora);

	// formatar a hora
	DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	String horaFormatada = formatterHora.format(agora);
	
	
	@FXML
	public void initialize() {
		
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomePacienteProperty());
		colHorario.setCellValueFactory(cellData -> cellData.getValue().horarioProperty());
		
		exibirAgendamentos();
	  
	
	}
		
	private void exibirAgendamentos() {
		ArrayList<Agendamento> lista = AgendaDao.buscaAgendamento(dataFormatada);
		tbl.setItems(FXCollections.observableArrayList(lista));
	}
	
	


}
