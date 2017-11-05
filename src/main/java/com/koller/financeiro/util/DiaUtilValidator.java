package com.koller.financeiro.util;

import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarNameProvider;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("diaUtil")
public class DiaUtilValidator implements Validator {

	@Override
	public void validate(FacesContext contex, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub

		Date data = (Date) value;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);

		int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

		if (diaSemana < Calendar.MONDAY || diaSemana > Calendar.FRIDAY) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inválida",
					"A data informada não é um dia útil"));

		}

	}

}
