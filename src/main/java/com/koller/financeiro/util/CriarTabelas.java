package com.koller.financeiro.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.koller.financeiro.model.Lancamento;

public class CriarTabelas {

	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("FinanceiroPU");

		/*
		 * EntityManager manager = JpaUtil.getEntityManager(); TypedQuery<Lancamento>
		 * query = manager.createQuery("from Lancamento", Lancamento.class);
		 * List<Lancamento> lancamentos = query.getResultList();
		 */
	}

}
