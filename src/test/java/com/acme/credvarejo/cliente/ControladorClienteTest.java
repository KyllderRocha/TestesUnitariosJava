package com.acme.credvarejo.cliente;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.cliente.RepositorioCliente;

public class ControladorClienteTest {
	
	ControladorCliente controlador ;
	Cliente cliente;
	Cpf cpf;
	
	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outputStream));
		controlador = new ControladorCliente(new RepositorioCliente(0));
		cpf = new Cpf(96203719099l);
		cliente = new Cliente(cpf, "Kyllder Rocha", 21, new Date(), 2000.00 , 0);
	}

	@Test
	public void incluirValido() {
		controlador.incluir(cliente);
		assertEquals("Cliente Validado", outputStream.toString().trim());
	}
	
	@Test
	public void incluirInvalido() {
		controlador.incluir(null);
		assertEquals("Invalido!", outputStream.toString().trim());
	}
	
	@Test
	public void alterarVazio() {
		controlador.alterar(96203719099l,"Kyllder");
		assertEquals("Vazio!", outputStream.toString().trim());
	}
	
	@Test
	public void alterarValido() {
		controlador.incluir(cliente);
		controlador.alterar(96203719099l,"Kyllder");
		outputStream.reset();
		controlador.buscar(96203719099l);
		assertEquals("Cliente: Kyllder", outputStream.toString().trim());
	}
	
	@Test
	public void buscarTest() {
		controlador.incluir(cliente);
		outputStream.reset();
		controlador.buscar(96203719099l);
		assertEquals("Cliente: Kyllder Rocha", outputStream.toString().trim());
	}

	@Test
	public void excluirTest() {
		controlador.incluir(cliente);
		controlador.excluir(96203719099l);
		outputStream.reset();
		controlador.buscar(96203719099l);
		assertEquals("Invalido", outputStream.toString().trim());
	}
	
	@Test
	public void buscarTodosTest() {
		controlador.incluir(cliente);
		outputStream.reset();
		controlador.buscar(96203719099l);
		assertEquals("Cliente: Kyllder Rocha", outputStream.toString().trim());
	}
}
