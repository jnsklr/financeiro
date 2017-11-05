package com.koller.financeiro.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.koller.financeiro.model.Lancamento;
import com.koller.financeiro.model.Pessoa;
import com.koller.financeiro.model.TipoLancamento;

public class CriaLancamentos {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Calendar dataVencimento1 = Calendar.getInstance();
		dataVencimento1.set(2017, 5, 8);

		Calendar dataVencimento2 = Calendar.getInstance();
		dataVencimento2.set(2017, 6, 6);
	

		Pessoa cliente = new Pessoa();
		cliente.setNome("WWW Indústria de Alimentos");

		Pessoa fornecedor = new Pessoa();
		fornecedor.setNome("SoftBRAX Treinamentos");

		Lancamento lancamento1 = new Lancamento();
		lancamento1.setDescricao("Venda de licença de software");
		lancamento1.setPessoa(fornecedor);
		lancamento1.setDataVencimento(dataVencimento2.getTime()); //dataVencimento1.getTime());
		lancamento1.setDataPagamento(dataVencimento2.getTime());
		lancamento1.setValor(new BigDecimal(103_000));
		lancamento1.setTipo(TipoLancamento.DESPESA);

		Lancamento lancamento2 = new Lancamento();
		lancamento2.setDescricao("Venda de suporte anual");
		lancamento2.setPessoa(cliente);
		lancamento2.setDataVencimento(dataVencimento1.getTime());
		lancamento2.setDataPagamento(dataVencimento1.getTime());
		lancamento2.setValor(new BigDecimal(15_000));
		lancamento2.setTipo(TipoLancamento.RECEITA);
	/*
		Lancamento lancamento3 = new Lancamento();
		lancamento3.setDescricao("Treinamento da equipe");
		lancamento3.setPessoa(fornecedor);
		lancamento3.setDataVencimento(dataVencimento2.getTime());
		lancamento2.setDataPagamento(dataVencimento2.getTime());
		lancamento3.setValor(new BigDecimal(68_000));
		lancamento3.setTipo(TipoLancamento.DESPESA);
		*/
		manager.persist(cliente);
		manager.persist(fornecedor);
		manager.persist(lancamento1);
		manager.persist(lancamento2);
		//manager.persist(lancamento3);

		trx.commit();
		manager.close();

	}

}
