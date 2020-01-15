package br.com.contmatic.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TextDividedByValidador implements ConstraintValidator<TextDividedBy, String> {

	private String separator;
	
	@Override
	public void initialize(TextDividedBy testDividedBy) {
		this.separator = testDividedBy.separator();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (separator.length() > value.length()) {
			return false;
		}
		if (value.substring(0, separator.length()).equals(separator) || value.substring(value.length() - separator.length()).equals(separator)) {
			return false;
		}
		int i = 1;
		while (i < value.length() - separator.length()) {
			if (value.substring(i, i + separator.length()).equals(separator)) {
				for (int j = 1; j <= separator.length(); j++) {
					if (value.substring(i + j, i + separator.length() + j).equals(separator)) {
						return false;
					}
				}
				i += separator.length();
			}
			i++;
		}
		return true;
	}

}
