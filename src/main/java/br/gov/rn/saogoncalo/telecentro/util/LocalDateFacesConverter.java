package br.gov.rn.saogoncalo.telecentro.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateFacesConverter")
public class LocalDateFacesConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (null == arg2 || arg2.isEmpty()) {
			return null;
		}

		LocalDate localDate;

		try {
			localDate = LocalDate.parse(arg2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		} catch (DateTimeParseException e) {

			throw new ConverterException("O ano deve conter 4 dígitos. Exemplo: 13/11/2015.");
		}

		return localDate;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (null == arg2) {
			return "";
		}
		return ((LocalDate) arg2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}