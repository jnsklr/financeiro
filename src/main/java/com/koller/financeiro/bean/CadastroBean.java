package com.koller.financeiro.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "cadastroBean")
public class CadastroBean {

	public String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void cadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage message = new FacesMessage(
				FacesMessage.SEVERITY_INFO, 
				"Cadastro Efetuado.",
				"Cliente adicionado.");
		context.addMessage(null, message);
	}
}
