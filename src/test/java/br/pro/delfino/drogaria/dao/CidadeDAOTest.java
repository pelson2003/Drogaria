package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoCidade = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoCidade);

		Cidade cidade = new Cidade();
		cidade.setNome("Belo Horizonte");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);

	}

	@Test
	@Ignore
	public void listar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		for (Cidade cidade : resultado) {
			System.out.println("Codigo Cidade " + cidade.getCodigo());
			System.out.println("Nome Cidade " + cidade.getNome());
			System.out.println("Codigo Estado " + cidade.getEstado().getCodigo());
			System.out.println("Nome Estado " + cidade.getEstado().getNome());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Long codigoCidade = 4L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		System.out.println("Codigo Cidade " + cidade.getCodigo());
		System.out.println("Nome Cidade " + cidade.getNome());
		System.out.println("Codigo Estado " + cidade.getEstado().getCodigo());
		System.out.println("Nome Estado " + cidade.getEstado().getNome());
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		cidadeDAO.excluir(cidade);
		System.out.println("Codigo Cidade " + cidade.getCodigo());
		System.out.println("Nome Cidade " + cidade.getNome());
		System.out.println("Codigo Estado " + cidade.getEstado().getCodigo());
		System.out.println("Nome Estado " + cidade.getEstado().getNome());
	}
	
	
	@Test
	public void buscarPorEstado() {

		Long estadoCodigo = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);
		for (Cidade cidade : resultado) {
			System.out.println("Codigo Cidade " + cidade.getCodigo());
			System.out.println("Nome Cidade " + cidade.getNome());
			System.out.println("Codigo Estado " + cidade.getEstado().getCodigo());
			System.out.println("Nome Estado " + cidade.getEstado().getNome());
			System.out.println();
		}
	}
	
	@Ignore
	@Test
	public void editar() {

		Long codigoCidade = 1L;
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		estado.setNome("Parana");
		estado.setSigla("PR");
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		cidade.setNome("Campinas");
		cidade.setEstado(estado);
		
		cidadeDAO.editar(cidade);
		
		System.out.println("Codigo Cidade " + cidade.getCodigo());
		System.out.println("Nome Cidade " + cidade.getNome());
		System.out.println("Codigo Estado " + cidade.getEstado().getCodigo());
		System.out.println("Nome Estado " + cidade.getEstado().getNome());
	}

	}

	

