package br.pro.delfino.drogaria.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.domain.Estado;
@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;
	
	
	
	public void novo(){
		estado = new Estado();
	}
	
	@PostConstruct
	public void listar(){
		//Messages.addGlobalInfo("Programacao WEB com Java");
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			System.out.println("Listagem");;			
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Listagem com problema: " + erro);
			System.out.println(erro + " de listagem");
			erro.printStackTrace();
		}
	}	
	
	public void excluir(ActionEvent evento){
		
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			Messages.addGlobalInfo(estado.getNome() + " removido com sucesso");
			estados = estadoDAO.listar();
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Deletar com Problemas " + erro);
			System.out.println(erro + " de deleção");
			erro.printStackTrace();
		}		
	}	
	
	public void editar(ActionEvent evento){
		
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
//			EstadoDAO estadoDAO = new EstadoDAO();
//			estadoDAO.merge(estado);
//			Messages.addGlobalInfo(estado.getNome() + " Alterado com sucesso");
//			estados = estadoDAO.listar();
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Deletar com Problemas " + erro);
			System.out.println(erro + " de deleção");
			erro.printStackTrace();
		}		
	}	
	
	public void salvar(){
		//Messages.addGlobalInfo("Programacao WEB com Java");
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			novo();
			Messages.addGlobalInfo("Estado Salvo com Sucesso");
			estados = estadoDAO.listar();
		} catch (RuntimeException erro ){
			Messages.addGlobalInfo("Estado com Problemas " + erro);
			System.out.println(erro + " de gravação");
			erro.printStackTrace();
		}
		
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
}
