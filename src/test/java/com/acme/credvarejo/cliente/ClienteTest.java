package com.acme.credvarejo.cliente;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	Cliente cliente;
	Cpf cpf;
	
	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outputStream));
		cpf = new Cpf(96203719099l);
		cliente = new Cliente(cpf, "Kyllder Rocha", 21, new Date(), 2000.00 , 0);
	}

	@Test
	public void gravaNomeCompletoTest() {
		cliente.gravaNomeCompleto("Kyllder Almeida da Rocha");
		assertEquals(cliente.getNome(), "Kyllder Almeida da Rocha");
	}

	@Test
	public void getPrimeiroNomeTest() {
		assertEquals(cliente.getPrimeiroNome(), "Kyllder");
	}
	
	@Test
	public void getSegundoNomeNomeTest() {
		assertEquals(cliente.getSegundoNome(), "Rocha");
	}

	@Test
	public void getCpfTest() {
		assertEquals(cliente.getCpf(), cpf);
	}

	@Test
	public void getNomeTeste() {
		assertEquals(cliente.getNome(), "Kyllder Rocha");
	}

	@Test
	public void getIdadeTest() {
		assertEquals(cliente.getIdade(), 21);
	}

	@Test
	public void getClienteDesdeTest() {
		assertEquals(cliente.getClienteDesde(), new Date());
	}

	@Test
	public void getRendaTest() {
		assertEquals(cliente.getRenda(), 2000.00, 0);
	}

	@Test
	public void getSexoTest() {
		assertEquals(cliente.getSexo(), 0);
	}

	@Test
	public void getMascTest() {
		assertEquals(cliente.getMasc(), 0);
	}
	
	@Test
	public void getFemTest() {
		assertEquals(cliente.getFem(), 1);
	}

	@Test
	public void getChaveTest() {
		assertEquals(cliente.getChave(),Long.toString(cliente.getCpf().getNumero()));
	}

	@Test
	public void setSexoTest() {
		cliente.setSexo(1);
		assertEquals(cliente.getSexo(),1);
	}

	@Test
	public void setCpfTest() {
		Cpf cpfAux = new Cpf(81203219099l);
		cliente.setCpf(cpfAux);
		assertEquals(cliente.getCpf(), cpfAux);
	}

	@Test
	public void setNomeTest() {
		cliente.setNome("Nome Novo");
		assertEquals(cliente.getNome(),"Nome Novo");
	}
	
	@Test
	public void setIdadeTest() {
		cliente.setIdade(22);
		assertEquals(cliente.getIdade(), 22);
	}
	
	@Test
	public void setClienteDesdeTest() {
		cliente.setClienteDesde(new Date());
		assertEquals(cliente.getClienteDesde(), new Date());
	}
	
	@Test
	public void setRendaTest() {
		cliente.setRenda(2200.00);
		assertEquals(cliente.getRenda(), 2200.00, 0);
	}
	
	@Test
	public void validarValido() {
		cliente.validar();
		assertEquals("Cliente Validado", outputStream.toString().trim());
	}
	
	@Test
	public void validarInvalido() {
		cliente.setSexo(3);
		cliente.validar();
		assertEquals("Cliente invalido", outputStream.toString().trim());
	}
	
}
