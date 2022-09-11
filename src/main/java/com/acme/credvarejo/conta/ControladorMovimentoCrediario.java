package com.acme.credvarejo.conta;

import com.acme.credvarejo.ado.conta.InterfaceRepositorioMovimentoCrediario;

public class ControladorMovimentoCrediario {
	private InterfaceRepositorioMovimentoCrediario repositorio;
	
	public ControladorMovimentoCrediario(InterfaceRepositorioMovimentoCrediario repositorio) {
		this.repositorio = repositorio;
	}
	
	
	public void inserirCredito(MovimentoCrediarioCredito movimentoCredito) {
		if(movimentoCredito == null) {
			System.out.println("Invalido!");
		}else {
			movimentoCredito.validar();
			repositorio.incluirCredito(movimentoCredito);
		}
	}
	
	public void inserirDebito(MovimentoCrediarioDebito movimentoDebito) {
		if(movimentoDebito == null) {
			System.out.println("Invalido!");
		}else {
			movimentoDebito.validar();
			repositorio.incluirDebito(movimentoDebito);
		}
	}
}
