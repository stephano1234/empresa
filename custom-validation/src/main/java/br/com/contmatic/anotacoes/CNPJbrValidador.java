package br.com.contmatic.anotacoes;

import static br.com.contmatic.utilidades.ConstantesNumericas.CNPJ;
import static br.com.contmatic.utilidades.ConstantesString.NUMERAL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class CNPJbrValidador.
 */
public class CNPJbrValidador implements ConstraintValidator<CNPJbr, String> {
	
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
		if (!value.matches(NUMERAL + "{" + CNPJ + "}")) {
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
		int dig1 = Integer.parseInt(value.substring(CNPJ - 2, CNPJ - 1));
		int dig2 = Integer.parseInt(value.substring(CNPJ - 1, CNPJ));
		int[] multiplicadores = {6, 5, 4, 3, 2, 9, 8, 7};
		int soma = 0;
		for (int i = 0; i < CNPJ - 2; i++) {
			soma += Integer.parseInt(value.substring(i, i + 1)) * multiplicadores[(i + 1) % 8];
		}
		if ((((11 - (soma % 11)) % 11) % 10) != dig1) {
			return false;
		}
		soma = 0;
		for (int i = 0; i < CNPJ - 1; i++) {
			soma += Integer.parseInt(value.substring(i, i + 1)) * multiplicadores[i % 8];
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
			for (int i = 0; i < CNPJ && !possuiNumeroDiferente; i++) {
				if (!value.substring(i, i + 1).equals(numeroRepetido.toString())) {
					possuiNumeroDiferente = true;
				}
				else {
					if (i == CNPJ - 1) {
						return false;
					}					
				}
			}
		}
		return true;
	}

}
