package br.com.contmatic.anotacoes;

import static br.com.contmatic.utilidades.ConstantesNumericas.CPF;
import static br.com.contmatic.utilidades.ConstantesString.NUMERAL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class CPFbrValidador.
 */
public class CPFbrValidador implements ConstraintValidator<CPFbr, String> {
	
	/**
	 * Checks if is valid.
	 *
	 * @param value the value
	 * @param constraintValidatorContext the constraint validator context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (value == null) {
			return true;
		}
		if (!value.matches(NUMERAL + "{" + CPF + "}")) {
			return false;
		}		
		return verificaNumerosTodosIguais(value) && verificaDigitosValidadores(value);
	}

	/**
	 * Verifica digitos validadores.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	private boolean verificaDigitosValidadores(String value) {
		int dig1 = Integer.parseInt(value.substring(CPF - 2, CPF - 1));
		int dig2 = Integer.parseInt(value.substring(CPF - 1, CPF));
		int soma = 0;
		for (int i = 0; i < CPF - 2; i++) {
			soma += Integer.parseInt(value.substring(i, i + 1)) * (10 - i);
		}
		if ((((11 - (soma % 11)) % 11) % 10) != dig1) {
			return false;
		}
		soma = 0;
		for (int i = 0; i < CPF - 1; i++) {
			soma += Integer.parseInt(value.substring(i, i + 1)) * (11 - i);
		}
		return (((11 - (soma % 11)) % 11) % 10) == dig2;
	}

	/**
	 * Verifica numeros todos iguais.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	private boolean verificaNumerosTodosIguais(String value) {
		boolean possuiNumeroDiferente;
		for (Integer numeroRepetido = 0; numeroRepetido < 10; numeroRepetido++) {
			possuiNumeroDiferente = false;
			for (int i = 0; i < CPF && !possuiNumeroDiferente; i++) {
				if (!value.substring(i, i + 1).equals(numeroRepetido.toString())) {
					possuiNumeroDiferente = true;
				}
				else {
					if (i == CPF - 1) {
						return false;
					}					
				}
			}
		}
		return true;
	}

}
