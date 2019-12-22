package br.com.contmatic.utilidades;

import org.apache.commons.lang3.RandomUtils;

import com.google.common.base.Preconditions;

/**
 * The Class FuncoesRandomicas.
 */
public class FuncoesRandomicas {

	/**
	 * Instantiates a new funcoes randomicas.
	 */
	private FuncoesRandomicas() {
	}
	
	/**
	 * Todos caracteres validos.
	 *
	 * @param expressaoRegular the expressao regular
	 * @return the string
	 */
	public static String todosCaracteresValidos(String expressaoRegular) {
		Preconditions.checkNotNull(expressaoRegular, "A expressão regular deve ser informada.");
		StringBuilder caracteresValidos = new StringBuilder();
		for (int i = 0; i < ConstantesTesteString.UNVIVERSO_CARACTERES.length(); i++) {
			if (ConstantesTesteString.UNVIVERSO_CARACTERES.substring(i, i + 1).matches(expressaoRegular)) {
				caracteresValidos.append(ConstantesTesteString.UNVIVERSO_CARACTERES.substring(i, i + 1));
			}
		}
		return caracteresValidos.toString();
	}

	/**
	 * Somente caractere.
	 *
	 * @param tamanho the tamanho
	 * @param expressaoRegular the expressao regular
	 * @return the string
	 */
	public static String somenteCaractere(int tamanho, String expressaoRegular) {
		Preconditions.checkArgument(tamanho >= 0,
				"O tamanho da string gerada não pode ser um número inteiro negativo.");
		Preconditions.checkNotNull(expressaoRegular, "A expressão regular deve ser informada.");
		StringBuilder stringSemCaractereInvalido = new StringBuilder();
		String caracteresValidos = todosCaracteresValidos(expressaoRegular);
		for (int i = 0; i < tamanho && !caracteresValidos.isEmpty(); i++) {
			stringSemCaractereInvalido
					.append(caracteresValidos.charAt(RandomUtils.nextInt(0, caracteresValidos.length())));
		}
		return stringSemCaractereInvalido.toString();
	}

	/**
	 * Apenas um caractere.
	 *
	 * @param tamanho the tamanho
	 * @param regexCaractere the regex caractere
	 * @param regexCaracteres the regex caracteres
	 * @return the string
	 */
	public static String apenasUmCaractere(int tamanho, String regexCaractere, String regexCaracteres) {
		Preconditions.checkArgument(tamanho >= 1,
				"O tamanho da string gerada por apenasUmCaractere deve ser maior ou igual a um.");
		Preconditions.checkNotNull(regexCaractere, "A expressão regular do caractere único deve ser informada.");
		Preconditions.checkNotNull(regexCaracteres, "A expressão regular dos outros caracteres deve ser informada.");
		int posicaoCaractere = RandomUtils.nextInt(0, tamanho);
		return somenteCaractere(posicaoCaractere, regexCaracteres) + somenteCaractere(1, regexCaractere)
				+ somenteCaractere((tamanho - 1) - posicaoCaractere, regexCaracteres);
	}

	/**
	 * String aleatoria.
	 *
	 * @param tamanho the tamanho
	 * @return the string
	 */
	public static String stringAleatoria(int tamanho) {
		Preconditions.checkArgument(tamanho >= 0,
				"O tamanho da string gerada não pode ser um número inteiro negativo.");
		StringBuilder randomString = new StringBuilder("");
		for (int i = 0; i < tamanho; i++) {
			randomString.append(ConstantesTesteString.UNVIVERSO_CARACTERES
					.charAt(RandomUtils.nextInt(0, ConstantesTesteString.UNVIVERSO_CARACTERES.length())));
		}
		return randomString.toString();
	}

	/**
	 * Email aleatorio.
	 *
	 * @return the string
	 */
	public static String emailAleatorio() {
		StringBuilder emailRandom = new StringBuilder();
		emailRandom.append(somenteCaractere(1, ConstantesTesteString.LETRA_MINUSCULA_NUMERAL));
		emailRandom.append(somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, 29 + 1),
				"([a-z]|[0-9]|[\\.]|[_]|[-])"));
		if (emailRandom.substring(emailRandom.length() - 1, emailRandom.length()).matches("[-_\\.]")) {
			emailRandom.deleteCharAt(emailRandom.length() - 1);
			emailRandom.append(somenteCaractere(1, ConstantesTesteString.LETRA_MINUSCULA_NUMERAL));
		}
		emailRandom.append("@");
		emailRandom.append(somenteCaractere(1, ConstantesTesteString.LETRA_MINUSCULA_NUMERAL));
		emailRandom.append(somenteCaractere(RandomUtils.nextInt(ConstantesTesteNumericas.INCLUI_STRING_VAZIO, 19 + 1),
				"([a-z]|[0-9]|[\\.]|[-])"));
		if (emailRandom.substring(emailRandom.length() - 1, emailRandom.length()).matches("[-_\\.]")) {
			emailRandom.deleteCharAt(emailRandom.length() - 1);
			emailRandom.append(somenteCaractere(1, ConstantesTesteString.LETRA_MINUSCULA_NUMERAL));
		}
		emailRandom.append(".");
		emailRandom.append(somenteCaractere(RandomUtils.nextInt(2, 6 + 1), "[a-z]"));
		return emailRandom.toString();
	}

	/**
	 * Cpf valido.
	 *
	 * @return the string
	 */
	public static String cpfValido() {
		StringBuilder cpfRandom = new StringBuilder();
		cpfRandom.append(somenteCaractere(9, ConstantesTesteString.APENAS_NUMERAL));
		while (cpfRandom.charAt(7) == cpfRandom.charAt(8)) {
			cpfRandom.deleteCharAt(8);
			cpfRandom.append(somenteCaractere(1, ConstantesTesteString.APENAS_NUMERAL));
		}
		int soma = 0;
		for (int i = 0; i < ConstantesTesteNumericas.CPF - 2; i++) {
			soma += Integer.parseInt(cpfRandom.substring(i, i + 1)) * (10 - i);
		}
		cpfRandom.append((((11 - (soma % 11)) % 11) % 10));
		soma = 0;
		for (int i = 0; i < ConstantesTesteNumericas.CPF - 1; i++) {
			soma += Integer.parseInt(cpfRandom.substring(i, i + 1)) * (11 - i);
		}
		cpfRandom.append((((11 - (soma % 11)) % 11) % 10));
		return cpfRandom.toString();
	}

	/**
	 * Cnpj valido.
	 *
	 * @return the string
	 */
	public static String cnpjValido() {
		StringBuilder cnpjRandom = new StringBuilder();
		cnpjRandom.append(somenteCaractere(8, ConstantesTesteString.APENAS_NUMERAL));
		cnpjRandom.append("0001");
		int[] multiplicadores = { 6, 5, 4, 3, 2, 9, 8, 7 };
		int soma = 0;
		for (int i = 0; i < ConstantesTesteNumericas.CNPJ - 2; i++) {
			soma += Integer.parseInt(cnpjRandom.substring(i, i + 1)) * multiplicadores[(i + 1) % 8];
		}
		cnpjRandom.append((((11 - (soma % 11)) % 11) % 10));
		soma = 0;
		for (int i = 0; i < ConstantesTesteNumericas.CNPJ - 1; i++) {
			soma += Integer.parseInt(cnpjRandom.substring(i, i + 1)) * multiplicadores[i % 8];
		}
		cnpjRandom.append((((11 - (soma % 11)) % 11) % 10));
		return cnpjRandom.toString();
	}

	/**
	 * Cpf invalido.
	 *
	 * @param posicaoDigitoVerificador the posicao digito verificador
	 * @return the string
	 */
	public static String cpfInvalido(int posicaoDigitoVerificador) {
		StringBuilder cpfInvalidoRandom = new StringBuilder(cpfValido());
		Integer digitoVerificadorValido = Integer
				.parseInt(cpfInvalidoRandom.substring(posicaoDigitoVerificador, posicaoDigitoVerificador + 1));
		Integer digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
		while (digitoVerificadorValido.equals(digitoVerificadorInvalido)) {
			digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
		}
		cpfInvalidoRandom.deleteCharAt(posicaoDigitoVerificador);
		cpfInvalidoRandom.insert(posicaoDigitoVerificador, digitoVerificadorInvalido.toString());
		return cpfInvalidoRandom.toString();
	}

	/**
	 * Cnpj invalido.
	 *
	 * @param posicaoDigitoVerificador the posicao digito verificador
	 * @return the string
	 */
	public static String cnpjInvalido(int posicaoDigitoVerificador) {
		StringBuilder cnpjInvalidoRandom = new StringBuilder(cnpjValido());
		Integer digitoVerificadorValido = Integer
				.parseInt(cnpjInvalidoRandom.substring(posicaoDigitoVerificador, posicaoDigitoVerificador + 1));
		Integer digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
		while (digitoVerificadorValido.equals(digitoVerificadorInvalido)) {
			digitoVerificadorInvalido = RandomUtils.nextInt(0, 10);
		}
		cnpjInvalidoRandom.deleteCharAt(posicaoDigitoVerificador);
		cnpjInvalidoRandom.insert(posicaoDigitoVerificador, digitoVerificadorInvalido.toString());
		return cnpjInvalidoRandom.toString();
	}

}
