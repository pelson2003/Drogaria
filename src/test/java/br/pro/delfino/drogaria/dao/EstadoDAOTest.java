package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getNome() + "-" + estado.getSigla());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Registro nao encontrado");
		} else {
			System.out.println(estado.getNome() + "_" + estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {

		Long codigo = 5L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Registro nao encontrado");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Removido: " + estado.getNome() + "_" + estado.getSigla());
		}
		
	}
	
	@Test
	public void editar() {

		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Registro nao encontrado");
		} else {
			System.out.println("Original: " + estado.getNome() + "_" + estado.getSigla());
			estado.setNome("Minas Gerais");
			estado.setSigla("MG");
			estadoDAO.editar(estado);
			System.out.println("Mudado: " + estado.getNome() + "_" + estado.getSigla());
		}
		
	}

}
