package com.acme.credvarejo.cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CpfTest {
	Cpf cpf ;
	@Before
	public void before() {
		cpf = new Cpf(96203719099l);
	}
	
	@Test
	public void isCPFValido() {
		assertTrue(cpf.isCPF("50858735059"));
	}
	
	@Test
	public void isCPFInvalido() {
		assertFalse(cpf.isCPF("11111111111"));
	}
	
	@Test
	public void imprimeCPFValido() {
		assertEquals(cpf.imprimeCPF("96203719099"), "962.037.190-99");
	}
	
	@Test
	public void imprimeCPFInvalido() {
		assertNotEquals(cpf.imprimeCPF("96203719099"),"96203719099");
	}

	@Test
	public void calculaDigitoMod11Valido() {
		assertEquals(cpf.calculaDigitoMod11("96203719099",2,12,true), "00");
	}
	
	@Test
	public void calculaDigitoMod11Invalido() {
		assertNotEquals(cpf.calculaDigitoMod11("96203719099",2,12,true), "01");
	}

	@Test
	public void getNumeroValido() {
		assertEquals(cpf.getNumero(),96203719099l);
	}
	
	@Test
	public void getNumeroInvalido() {
		assertNotEquals(cpf.getNumero(),91203219099l);
	}

	@Test
	public void setNumeroValido() {
		cpf.setNumero(81203219099l);
		assertEquals(cpf.getNumero(),81203219099l);
	}
	
	@Test
	public void setNumeroInvalido() {
		cpf.setNumero(81203219099l);
		assertNotEquals(cpf.getNumero(),96203719099l);
	}
}
