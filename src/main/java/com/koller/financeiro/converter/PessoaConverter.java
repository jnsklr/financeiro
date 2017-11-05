package com.koller.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.koller.financeiro.model.Pessoa;
import com.koller.financeiro.repository.Pessoas;
import com.koller.financeiro.util.JpaUtil;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext contex, UIComponent component, String value) {

		Pessoa retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			if (value != null && !"".equals(value)) {
				Pessoas pessoas = new Pessoas(manager);
				retorno = pessoas.porId(new Long(value));
			}
			return retorno;
		} finally {
			manager.close();
		}

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;
	}

}
