package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.CidadeDAO;
import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {


	private List<Cidade> cidades;
	private Cidade cidade;
	private List<Estado> estados;
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@PostConstruct
	public void listar(){
		
		try{
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Listagem com problema: " + erro);
			System.out.println(erro + " de listagem");
			erro.printStackTrace();
		}
		
	}
	
	public void novo(){
		
		try{
			cidade = new Cidade();
			EstadoDAO estadoDAO = new EstadoDAO();	
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Gerar nova Listagem: " + erro);
			System.out.println(erro + " gerar listagem cidade");
			erro.printStackTrace();
		}
		
	}
	
	public void salvar(){
		
		try{
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			cidade = new Cidade();
			EstadoDAO estadoDAO = new EstadoDAO();	
			estados = estadoDAO.listar("nome");
			cidades = cidadeDAO.listar();
			Messages.addGlobalInfo("Cidade Salva com sucesso");
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Erro ao Salvar: " + erro);
			System.out.println(erro + " ao Salvar");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			Messages.addGlobalInfo(cidade.getNome() + " removido com sucesso");
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Deletar com Problemas " + erro);
			System.out.println(erro + " de deleção");
			erro.printStackTrace();
		}		
	}	
	
	public void editar(ActionEvent evento){
			
		try{
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			EstadoDAO estadoDAO = new EstadoDAO();	
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Erro ao selectionar cidade: " + erro);
			System.out.println(erro + " selecionar cidade com problema");
			erro.printStackTrace();
		}
	
	}	
	
}
