package domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prontuario {
	private IntegerProperty id = new SimpleIntegerProperty(0);
	 private Pessoa paciente = new Pacientes();
	 private StringProperty data = new SimpleStringProperty("");
	 private StringProperty descricao = new SimpleStringProperty("");
	 private StringProperty sintomas = new SimpleStringProperty("");
	 private StringProperty medicamentos = new SimpleStringProperty("");
	 
	 
	public Pessoa getPaciente() {
		return paciente;
	}

	public void setPaciente(Pessoa paciente) {
		this.paciente = paciente;
	}

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
	
	public final StringProperty descricaoProperty() {
		return this.descricao;
	}
	
	public final String getDescricao() {
		return this.descricaoProperty().get();
	}
	
	public final void setDescricao(final String descricao) {
		this.descricaoProperty().set(descricao);
	}
	
	public final StringProperty sintomasProperty() {
		return this.sintomas;
	}
	
	public final String getSintomas() {
		return this.sintomasProperty().get();
	}
	
	public final void setSintomas(final String sintomas) {
		this.sintomasProperty().set(sintomas);
	}
	
	public final StringProperty medicamentosProperty() {
		return this.medicamentos;
	}
	
	public final String getMedicamentos() {
		return this.medicamentosProperty().get();
	}
	
	public final void setMedicamentos(final String medicamentos) {
		this.medicamentosProperty().set(medicamentos);
	}
	

}
