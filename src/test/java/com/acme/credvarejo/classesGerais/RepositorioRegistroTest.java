package com.acme.credvarejo.classesGerais;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class RepositorioRegistroTest {
	RepositorioRegistro registro;
	
	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outputStream));
		registro = new RepositorioRegistro(0);
	}
	
	@Test
	public void incluirTest() {
		registro.incluir("1");
		registro.buscarChave("1");
		assertEquals("Chave: 1", outputStream.toString().trim());
	}

	@Test
	public void alterarTest() {
		registro.incluir("1");
		registro.alterar("1","2");
		registro.buscarChave("2");
		assertEquals("Chave: 2", outputStream.toString().trim());
	}

	@Test
	public void alterarInvalidoTest() {
		registro.incluir("1");
		registro.alterar("3","2");
		assertEquals("Chave Invalida!", outputStream.toString().trim());
	}
	
	@Test
	public void excluirTest() {
		registro.incluir("1");
		registro.excluir("1");
		registro.buscarChave("1");
		assertEquals("Vazio!", outputStream.toString().trim());
	}

	@Test
	public void buscarTudoTest() {
		registro.incluir("1");
		registro.buscarTodos();
		assertNotEquals("Vazio!", outputStream.toString().trim());
	}
	
	@Test
	public void alterarVazioTest() {
		registro.alterar("1", "2");
		assertEquals("Vazio!", outputStream.toString().trim());
	}

	@Test
	public void excluirVazioTest() {
		registro.excluir("1");
		assertEquals("Vazio!", outputStream.toString().trim());
	}

	@Test
	public void buscarChaveVazioTest() {
		registro.buscarChave("1");
		assertEquals("Vazio!", outputStream.toString().trim());
	}
	
	@Test
	public void buscarTodosVazioTest() {
		registro.buscarTodos();
		assertEquals("Vazio!", outputStream.toString().trim());
	}
}
