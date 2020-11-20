package domain;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	
	private IntegerProperty id = new SimpleIntegerProperty(0);
	protected StringProperty nome = new SimpleStringProperty("");
	protected StringProperty sexo = new SimpleStringProperty("");
	protected StringProperty nascimento = new SimpleStringProperty("");
	protected StringProperty cpf = new SimpleStringProperty("");
	protected StringProperty endereco1 = new SimpleStringProperty("");
	protected StringProperty cidade = new SimpleStringProperty("");
	protected StringProperty bairro = new SimpleStringProperty("");
	protected StringProperty estado = new SimpleStringProperty("");
	protected StringProperty cep = new SimpleStringProperty("");
	protected BooleanProperty ativa = new SimpleBooleanProperty(false);
	protected StringProperty tipo = new SimpleStringProperty("");
	
	
	public final IntegerProperty idProperty() {
		return this.id;
	}
	
	public final int getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final StringProperty nascimentoProperty() {
		return this.nascimento;
	}
	
	public final String getNascimento() {
		return this.nascimentoProperty().get();
	}
	
	public final void setNascimento(final String nascimento) {
		this.nascimentoProperty().set(nascimento);
	}
	
	public final StringProperty cpfProperty() {
		return this.cpf;
	}
	
	public final String getCpf() {
		return this.cpfProperty().get();
	}
	
	public final void setCpf(final String cpf) {
		this.cpfProperty().set(cpf);
	}
	
	public final StringProperty endereco1Property() {
		return this.endereco1;
	}
	
	public final String getEndereco1() {
		return this.endereco1Property().get();
	}
	
	public final void setEndereco1(final String endereco1) {
		this.endereco1Property().set(endereco1);
	}
	
	public final StringProperty cidadeProperty() {
		return this.cidade;
	}
	
	public final String getCidade() {
		return this.cidadeProperty().get();
	}
	
	public final void setCidade(final String cidade) {
		this.cidadeProperty().set(cidade);
	}
	
	public final StringProperty bairroProperty() {
		return this.bairro;
	}
	
	public final String getBairro() {
		return this.bairroProperty().get();
	}
	
	public final void setBairro(final String bairro) {
		this.bairroProperty().set(bairro);
	}
	
	public final StringProperty estadoProperty() {
		return this.estado;
	}
	
	public final String getEstado() {
		return this.estadoProperty().get();
	}
	
	public final void setEstado(final String estado) {
		this.estadoProperty().set(estado);
	}
	
	public final StringProperty cepProperty() {
		return this.cep;
	}
	
	public final String getCep() {
		return this.cepProperty().get();
	}
	
	public final void setCep(final String cep) {
		this.cepProperty().set(cep);
	}
	
	public final BooleanProperty ativaProperty() {
		return this.ativa;
	}
	
	public final boolean isAtiva() {
		return this.ativaProperty().get();
	}
	
	public final void setAtiva(final boolean ativa) {
		this.ativaProperty().set(ativa);
	}

	public final StringProperty tipoProperty() {
		return this.tipo;
	}
	

	public final String getTipo() {
		return this.tipoProperty().get();
	}
	

	public final void setTipo(final String tipo) {
		this.tipoProperty().set(tipo);
	}

	public final StringProperty sexoProperty() {
		return this.sexo;
	}
	

	public final String getSexo() {
		return this.sexoProperty().get();
	}
	

	public final void setSexo(final String sexo) {
		this.sexoProperty().set(sexo);
	}
	
	
	
	
	

}
