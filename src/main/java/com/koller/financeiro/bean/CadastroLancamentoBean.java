package com.koller.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.koller.financeiro.model.Lancamento;
import com.koller.financeiro.model.Pessoa;
import com.koller.financeiro.model.TipoLancamento;
import com.koller.financeiro.repository.Lancamentos;
import com.koller.financeiro.repository.Pessoas;
import com.koller.financeiro.util.JpaUtil;
import com.koller.service.CadastroLancamentos;
import com.koller.service.NegocioException;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> todasPessoas;

	public void prepararCadastro() {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Pessoas pessoas = new Pessoas(manager);
			this.setTodasPessoas(pessoas.todas());
		} finally {
			manager.close();
		}
	}

	public void salvar() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			trx.begin();
			CadastroLancamentos cadastro = new CadastroLancamentos(new Lancamentos(manager));
			cadastro.salvar(this.lancamento);

			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
			trx.commit();
		} catch (NegocioException e) {
			trx.rollback();
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
			// TODO: handle exception
		} finally {
			manager.close();
		}
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public List<Pessoa> getTodasPessoas() {
		return this.todasPessoas;
	}

	public void setTodasPessoas(List<Pessoa> todasPessoas) {
		this.todasPessoas = todasPessoas;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
}
