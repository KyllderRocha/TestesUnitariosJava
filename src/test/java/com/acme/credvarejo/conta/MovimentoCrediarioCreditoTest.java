package com.acme.credvarejo.conta;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;

public class MovimentoCrediarioCreditoTest {
	MovimentoCrediarioCredito movimento;
	ContaCrediario conta;
	Cliente cliente;
	Date dt;
	private final PrintStream standarOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		dt = new Date();
		System.setOut(new PrintStream(outputStream));
		Cpf cpf = new Cpf(96203719099l);
		cliente = new Cliente(cpf, "Kyllder Rocha", 21, dt, 2000.00 , 0);
		IdentificadorContaCrediario idenCrediario = new IdentificadorContaCrediario(1l);
		conta = new ContaCrediario(idenCrediario, cliente, 0, 5000, 50, true);
		movimento = new MovimentoCrediarioCredito(conta, 200.0, dt, 500.0);
	}

	@Test
	public void getNomeExtratoMrTest() {
		assertEquals(movimento.getNomeExtrato(0), "ROCHA, KYLLDER MR.");
	}

	@Test
	public void getNomeExtratoMrsTest() {
		assertEquals(movimento.getNomeExtrato(1), "ROCHA, KYLLDER MRS.");
	}

	@Test
	public void getNomeExtratoTest() {
		assertEquals(movimento.getNomeExtrato(3), "Invalido!");
	}
	
	@Test
	public void getContaCrediarioTest() {
		assertEquals(movimento.getContaCrediario(), conta);
	}

	@Test
	public void setContaCrediarioTest() {
		ContaCrediario aux = new ContaCrediario(new IdentificadorContaCrediario(5l), cliente, 0, 5000, 50, true);
		movimento.setContaCrediario(aux);
		assertEquals(movimento.getContaCrediario(), aux);
	}
	
	@Test
	public void getValorTransacaoTest() {
		assertEquals(movimento.getValorTransacao(), 200.0, 0);
	}

	@Test
	public void setValorTransacaoTest() {
		movimento.setValorTransacao(500.0);
		assertEquals(movimento.getValorTransacao(), 500.0, 0);
	}

	@Test
	public void getDataHoraDaOperacaoTest() {
		assertEquals(movimento.getDataHoraDaOperacao(), dt);
	}

	@Test
	public void setDataHoraDaOperacaoTest() {
		Date aux = new Date();
		movimento.setDataHoraDaOperacao(aux);
		assertEquals(movimento.getDataHoraDaOperacao(), aux);
	}

	@Test
	public void getChaveTest() {
		assertEquals(movimento.getChave(), "ID: 1\nHora da Operacao: "+String.valueOf(dt));
	}

	@Test
	public void validarTest() {
		movimento.validar();
		assertEquals("Movimento Validado", outputStream.toString().trim());
	}
}
