package domain;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicos extends Pessoa{
	
	public Medicos(){
		setTipo("Medico");
	}

	protected StringProperty crm = new SimpleStringProperty("");
	protected StringProperty especialidade = new SimpleStringProperty("");
	public final StringProperty crmProperty() {
		return this.crm;
	}
	
	public final String getCrm() {
		return this.crmProperty().get();
	}
	
	public final void setCrm(final String crm) {
		this.crmProperty().set(crm);
	}
	
	public final StringProperty especialidadeProperty() {
		return this.especialidade;
	}
	
	public final String getEspecialidade() {
		return this.especialidadeProperty().get();
	}
	
	public final void setEspecialidade(final String especialidade) {
		this.especialidadeProperty().set(especialidade);
	}
	
	
	

	
	
	
	
	
	

}
