package domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agendamento {
	 private IntegerProperty id = new SimpleIntegerProperty(0);
	 private Pessoa paciente = new Pacientes();
	 private StringProperty data = new SimpleStringProperty("");
	 private StringProperty horario = new SimpleStringProperty("");
	 private StringProperty nomePaciente = new SimpleStringProperty("");
	
	 
	 
	 public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	
	public final StringProperty dataProperty() {
		return this.data;
	}
	
	public final String getData() {
		return this.dataProperty().get();
	}
	
	public final void setData(final String data) {
		this.dataProperty().set(data);
	}
	
	public final StringProperty horarioProperty() {
		return this.horario;
	}
	
	public final String getHorario() {
		return this.horarioProperty().get();
	}
	
	public final void setHorario(final String horario) {
		this.horarioProperty().set(horario);
	}

	public Pessoa getPaciente() {
		return paciente;
	}

	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}

	public final StringProperty nomePacienteProperty() {
		return this.nomePaciente;
	}
	

	public final String getNomePaciente() {
		return this.nomePacienteProperty().get();
	}
	

	public final void setNomePaciente(final String nomePaciente) {
		this.nomePacienteProperty().set(nomePaciente);
	}
	
	
	 
	 


}
