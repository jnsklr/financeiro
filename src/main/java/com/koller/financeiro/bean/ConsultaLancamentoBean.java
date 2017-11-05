package com.koller.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.koller.financeiro.model.Lancamento;
import com.koller.financeiro.repository.Lancamentos;
import com.koller.financeiro.util.JpaUtil;

@ManagedBean(name = "consultaLancamentosBean")
@ViewScoped
public class ConsultaLancamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Lancamento> lancamentos;
	
	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		Lancamentos lancamentos = new Lancamentos(manager);
		
		this.lancamentos = lancamentos.todos();
		
		manager.close();
	}

	/*
	 * public void consultar() { EntityManager manager = JpaUtil.getEntityManager();
	 * TypedQuery<Lancamento> query = manager.createQuery("from Lancamento",
	 * Lancamento.class); this.setLancamentos(query.getResultList());
	 * manager.close(); }
	 */

	public List<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
