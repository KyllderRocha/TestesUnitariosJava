package com.acme.credvarejo.conta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IdentificadorContaCrediarioTest {
	IdentificadorContaCrediario identificador;
	@Before
	public void setUp() throws Exception {
		identificador = new IdentificadorContaCrediario(11l);
	}

	@Test
	public void getNumeroTest() {
		assertEquals(identificador.getNumero(), 11l);
	}

	@Test
	public void setNumeroTest() {
		identificador.setNumero(12l);
		assertEquals(identificador.getNumero(), 12l);
	}

	@Test
	public void calcularDigitoVerificadorUniTest() {
		identificador.setNumero(1l);
		assertEquals(identificador.calcularDigitoVerificador(), 1l);
	}

	@Test
	public void calcularDigitoVerificadorTest() {
		assertEquals(identificador.calcularDigitoVerificador(), 2);
	}
	@Test
	public void verificarValidadeDigitoTest() {
		assertTrue(identificador.verificarValidadeDigito(2));
	}
}
