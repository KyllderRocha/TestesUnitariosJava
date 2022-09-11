package com.acme.credvarejo.conta;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.cliente.RepositorioCliente;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.ControladorCliente;
import com.acme.credvarejo.cliente.Cpf;

public class ContaCrediarioTest {
	ContaCrediario conta ;
	Cliente cliente;
	IdentificadorContaCrediario idenCrediario;
	Cpf cpf;
	
	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outputStream));
		cpf = new Cpf(96203719099l);
		cliente = new Cliente(cpf, "Kyllder Rocha", 21, new Date(), 2000.00 , 0);
		idenCrediario = new IdentificadorContaCrediario(1l);
		conta = new ContaCrediario(idenCrediario, cliente, 0, 5000, 50, true);
	}

	@Test
	public void isAtivaTest() {
		assertTrue(conta.isAtiva());
	}
	
	@Test
	public void desativarTest() {
		conta.desativar();
		assertFalse(conta.isAtiva());
	}

	@Test
	public void reativarTest() {
		conta.desativar();
		conta.reativar();
		assertTrue(conta.isAtiva());
	}
	
	@Test
	public void setAtivaTest() {
		conta.setAtiva(false);
		assertFalse(conta.isAtiva());
	}

	@Test
	public void getSaldoDevidoTest() {
		conta.efetuarCompra(100);
		assertEquals(conta.getSaldoDevido(),100,0);
	}

	@Test
	public void setSaldoDevidoTest() {
		conta.setSaldoDevido(100);
		assertEquals(conta.getSaldoDevido(),100,0);
	}

	@Test
	public void efetuarCompraTest() {
		conta.efetuarCompra(10);
		assertEquals(conta.getSaldoDevido(),10,0);
	}
	
	@Test
	public void efetuarPagamentoTest() {
		conta.efetuarCompra(100);
		conta.efetuarPagamento(50);
		assertEquals(conta.getSaldoDevido(),50,0);
	}

	@Test
	public void getIdentificadorContaTest() {
		assertEquals(conta.getIdentificadorConta(), idenCrediario);
	}

	@Test
	public void setIdentificadorContaTest() {
		IdentificadorContaCrediario aux = new IdentificadorContaCrediario(5l);
		conta.setIdentificadorConta(aux);
		assertEquals(conta.getIdentificadorConta(), aux);
	}

	@Test
	public void getClienteTest() {
		assertEquals(conta.getCliente(), cliente);
	}

	@Test
	public void setClienteTest() {
		Cliente aux = new Cliente(cpf, "Keylla", 30, new Date(), 5000.00 , 0);
		conta.setCliente(aux);
		assertEquals(conta.getCliente(), aux);
	}

	@Test
	public void getLimiteDeCreditoTest() {
		assertEquals(conta.getLimiteDeCredito(),5000,0);
	}

	@Test
	public void setLimiteDeCreditoTest() {
		conta.setLimiteDeCredito(10000);
		assertEquals(conta.getLimiteDeCredito(),10000,0);
	}

	@Test
	public void getVencimentoTest() {
		assertEquals(conta.getVencimento(),50);
	}

	@Test
	public void setVencimentoTest() {
		conta.setVencimento(100);
		assertEquals(conta.getVencimento(),100);
	}
	
	@Test
	public void getChaveTest() {
		assertEquals(conta.getChave(), Long.toString(idenCrediario.getNumero()));
	}
	
	@Test
	public void validarTest() {
		conta.efetuarCompra(100);
		conta.validar();
		assertEquals("Conta Validada", outputStream.toString().trim());
	}
}
