package principal;

import dao.PessoaDao;
import domain.Pacientes;
import domain.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CadPacienteController {
	@FXML TextField txtNome;
	@FXML TextField txtNasc;
	@FXML RadioButton rdMasc;
	@FXML RadioButton rdFem;
	@FXML TextField txtEndereco;
	@FXML TextField txtBairro;
	@FXML TextField txtCidade;
	@FXML TextField txtCpf;
	@FXML TextField txtEstado;
	@FXML TextField txtCep;
	@FXML CheckBox ckAtivo;
	
	private Pessoa pacienteS = null;
	
	public void gravar() {
		if(pacienteS == null) {
			Pessoa p = new Pacientes();
			p.setNome(txtNome.getText());
			p.setSexo(rdMasc.isSelected()?"M":"F");
			p.setNascimento(txtNasc.getText());
			p.setBairro(txtBairro.getText());
			p.setCidade(txtCidade.getText());
			p.setCpf(txtCpf.getText());
			p.setEstado(txtEstado.getText());
			p.setEndereco1(txtEndereco.getText());
			p.setCep(txtCep.getText());
			p.setAtiva(ckAtivo.isSelected());
			
			PessoaDao.novaPessoa(p);
		}else {
			pacienteS.setNome(txtNome.getText());
			pacienteS.setSexo(rdMasc.isSelected()?"M":"F");
			pacienteS.setNascimento(txtNasc.getText());
			pacienteS.setBairro(txtBairro.getText());
			pacienteS.setCidade(txtCidade.getText());
			pacienteS.setCpf(txtCpf.getText());
			pacienteS.setEstado(txtEstado.getText());
			pacienteS.setEndereco1(txtEndereco.getText());
			pacienteS.setCep(txtCep.getText());
			pacienteS.setAtiva(ckAtivo.isSelected());
			PessoaDao.alteraPessoa(pacienteS);
			pacienteS = null;
		}
		

	}
	

}
