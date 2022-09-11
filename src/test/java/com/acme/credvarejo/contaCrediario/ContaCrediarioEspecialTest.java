package com.acme.credvarejo.contaCrediario;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class ContaCrediarioEspecialTest {
	ContaCrediarioEspecial contaCrediarioEspecial;
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
		contaCrediarioEspecial = new ContaCrediarioEspecial(idenCrediario,cliente,200,5000,20,true,0.2,20);
	}

	@Test
	public void getPercentualDeDescontoTest() {
		assertEquals(contaCrediarioEspecial.getPercentualDeDesconto(), 0.2, 0);
	}

	@Test
	public void setPercentualDeDescontoTest() {
		contaCrediarioEspecial.setPercentualDeDesconto(0.1);
		assertEquals(contaCrediarioEspecial.getPercentualDeDesconto(), 0.1, 0);
	}

	@Test
	public void getPontosAcumuladosTest() {
		assertEquals(contaCrediarioEspecial.getPontosAcumulados(), 20);
	}

	@Test
	public void setPontosAcumuladosTest() {
		contaCrediarioEspecial.setPontosAcumulados(10);
		assertEquals(contaCrediarioEspecial.getPontosAcumulados(),10);
	}
}
