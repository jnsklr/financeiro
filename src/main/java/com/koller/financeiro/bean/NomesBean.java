package com.koller.financeiro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean(name = "nomesBean")
@ViewScoped
public class NomesBean {

	private String nome;
	private List<String> nomes = new ArrayList<>();
	
	
	
	private HtmlInputText inputName;
	private HtmlCommandButton botaoAdicionar;

	public HtmlInputText getInputName() {
		return inputName;
	}

	public void setInputName(HtmlInputText inputName) {
		this.inputName = inputName;
	}

	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}

	public void adicionar() {
		this.nomes.add(nome);

		if (this.nomes.size() > 3) {
			this.inputName.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Muitos nomes add..");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

}
