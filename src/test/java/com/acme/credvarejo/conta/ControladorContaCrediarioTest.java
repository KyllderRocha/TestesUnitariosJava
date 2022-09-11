package com.acme.credvarejo.conta;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.conta.RepositorioContaCrediario;
import com.acme.credvarejo.ado.conta.RepositorioMovimentoCrediario;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;

public class ControladorContaCrediarioTest {
	ControladorContaCrediario controlador;
	ControladorMovimentoCrediario conMovimentoCrediario;
	RepositorioMovimentoCrediario crediario;
	Cliente cliente;
	Cpf cpf;
	Date dt;

	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outputStream));
		cpf = new Cpf(96203719099l);
		dt = new Date();
		cliente = new Cliente(cpf, "Kyllder Rocha", 21, dt, 2000.00 , 0);
		controlador = new ControladorContaCrediario(new RepositorioContaCrediario());
		crediario = new RepositorioMovimentoCrediario();
		conMovimentoCrediario = new ControladorMovimentoCrediario(crediario);
	}

	@Test
	public void inserirTest() {
		controlador.inserir(cliente, 5000.0, 10);
		outputStream.reset();
		IdentificadorContaCrediario id = new IdentificadorContaCrediario(cliente.getCpf().getNumero());
		controlador.buscar(id);
		assertNotEquals("Invalido!", outputStream.toString().trim());
	}
	

	@Test
	public void creditarTest() {
		controlador.inserir(cliente, 5000.0, 10);
		outputStream.reset();
		IdentificadorContaCrediario id = new IdentificadorContaCrediario(cliente.getCpf().getNumero());
		controlador.creditar(id, 2000, conMovimentoCrediario);
		crediario.buscarTodos();
		assertNotEquals("Credito: \r\n"
				+ "\r\n"
				+ "Debito:", outputStream.toString().trim());
	}
	
	@Test
	public void debitarTest() {
		controlador.inserir(cliente, 5000.0, 10);
		outputStream.reset();
		IdentificadorContaCrediario id = new IdentificadorContaCrediario(cliente.getCpf().getNumero());
		controlador.debitar(id, 2000, conMovimentoCrediario);
		crediario.buscarTodos();
		assertNotEquals("Credito: \r\n"
				+ "\r\n"
				+ "Debito:", outputStream.toString().trim());
	}
}
