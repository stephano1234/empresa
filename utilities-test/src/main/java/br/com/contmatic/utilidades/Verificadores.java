package br.com.contmatic.utilidades;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.google.common.base.Preconditions;

/**
 * The Class Verificadores.
 */
public class Verificadores {

	private static final String MENSAGEM_ERRO_NAO_INFORMADA = "A mensagem do erro procurado deve ser informada.";

	/** The Constant PARAM_NULO. */
	private static final String PARAM_NULO = "O objeto testado não pode ser nulo.";

	/** The validator. */
	private static Validator validator;

	/** The factory. */
	private static ValidatorFactory factory;

	/** The logger. */
	private static Logger logger = Logger.getGlobal();

	/**
	 * Instantiates a new verificadores.
	 */
	private Verificadores() {
	}

	/**
	 * Verifica erro.
	 *
	 * @param objetoTestado the objeto testado
	 * @param mensagem      the mensagem
	 * @return true, if successful
	 */
	public static boolean verificaErro(Object objetoTestado, String mensagem) {
		Preconditions.checkNotNull(objetoTestado, PARAM_NULO);
		Preconditions.checkNotNull(mensagem, MENSAGEM_ERRO_NAO_INFORMADA);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		boolean possuiErro = false;
		Set<ConstraintViolation<Object>> violacoes = validator.validate(objetoTestado);
		for (ConstraintViolation<Object> violacao : violacoes) {
			if (violacao.getMessageTemplate().equals(mensagem)) {
				possuiErro = true;
			}
		}
		return possuiErro;
	}

	/**
	 * Procura algum erro.
	 *
	 * @param objetoTestado the objeto testado
	 * @return true, if successful
	 */
	public static boolean procuraAlgumErro(Object objetoTestado) {
		Preconditions.checkNotNull(objetoTestado, PARAM_NULO);
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Set<ConstraintViolation<Object>> violacoes = validator.validate(objetoTestado);
		return !violacoes.isEmpty();
	}

	/**
	 * Verifica to string JSONSTYLE.
	 *
	 * @param objetoTestado the objeto testado
	 * @return true, if successful
	 */
	public static boolean verificaToStringJSONSTYLE(Object objetoTestado) {
		Preconditions.checkNotNull(objetoTestado, PARAM_NULO);
		StringBuilder formatoEsperado = new StringBuilder("{");
		Field[] campos = objetoTestado.getClass().getDeclaredFields();
		for (Field campo : campos) {
			campo.setAccessible(true);
			formatoEsperado.append("\"").append(campo.getName()).append("\":");
			try {
				if (campo.get(objetoTestado).getClass().isEnum()) {
					formatoEsperado
							.append("\"").append(transformaCaractereEmUnicode(campo.get(objetoTestado).getClass()
									.getSuperclass().getMethod("name").invoke(campo.get(objetoTestado)).toString()))
							.append("\",");
				} else {
					if (campo.get(objetoTestado).toString().charAt(0) == '{'
							|| campo.get(objetoTestado).toString().charAt(0) == '[') {
						formatoEsperado.append(transformaCaractereEmUnicode(campo.get(objetoTestado).toString())).append(",");
					} else {
					formatoEsperado.append("\"")
							.append(transformaCaractereEmUnicode(campo.get(objetoTestado).toString())).append("\",");
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				logger.log(Level.SEVERE, "Erro ao acessar os atributos do objeto testado.", e);
				return false;
			}
		}
		formatoEsperado.deleteCharAt(formatoEsperado.length() - 1);
		formatoEsperado.append("}");
		return objetoTestado.toString().equals(formatoEsperado.toString());
	}

	/**
	 * Transforma caractere em unicode.
	 *
	 * @param string the string
	 * @return the string
	 */
	public static String transformaCaractereEmUnicode(String string) {
		String letrasAcentuadas = "ÁáÉéÍíÓóÚúÀàÂâÊêÔôÃãÕõªºçÇ";
		Map<String, String> tabelaAcentos = new LinkedHashMap<>();
		tabelaAcentos.put("Á", "\\u00C1");
		tabelaAcentos.put("á", "\\u00E1");
		tabelaAcentos.put("É", "\\u00C9");
		tabelaAcentos.put("é", "\\u00E9");
		tabelaAcentos.put("Í", "\\u00CD");
		tabelaAcentos.put("í", "\\u00ED");
		tabelaAcentos.put("Ó", "\\u00D3");
		tabelaAcentos.put("ó", "\\u00F3");
		tabelaAcentos.put("Ú", "\\u00DA");
		tabelaAcentos.put("ú", "\\u00FA");
		tabelaAcentos.put("Â", "\\u00C2");
		tabelaAcentos.put("â", "\\u00E2");
		tabelaAcentos.put("Ê", "\\u00CA");
		tabelaAcentos.put("ê", "\\u00EA");
		tabelaAcentos.put("Ô", "\\u00D4");
		tabelaAcentos.put("ô", "\\u00F4");
		tabelaAcentos.put("Ã", "\\u00C3");
		tabelaAcentos.put("ã", "\\u00E3");
		tabelaAcentos.put("Õ", "\\u00D5");
		tabelaAcentos.put("õ", "\\u00F5");
		tabelaAcentos.put("ª", "\\u00AA");
		tabelaAcentos.put("º", "\\u00BA");
		tabelaAcentos.put("ç", "\\u00E7");
		tabelaAcentos.put("Ç", "\\u00C7");
		StringBuilder stringTransformada = new StringBuilder(string);
		String letraAcentuada;
		for (int i = 0; i < stringTransformada.length(); i++) {
			if (letrasAcentuadas.contains(stringTransformada.substring(i, i + 1))) {
				letraAcentuada = tabelaAcentos.get(stringTransformada.substring(i, i + 1));
				stringTransformada.deleteCharAt(i);
				stringTransformada.insert(i, letraAcentuada);
			}
		}
		return stringTransformada.toString();
	}

	/**
	 * Verifica construtor.
	 *
	 * @param classe          the classe
	 * @param valores         the valores
	 * @param tiposArgumentos the tipos argumentos
	 * @return true, if successful
	 */
	@Deprecated
	public static boolean verificaConstrutor(Class<?> classe, Object[] valores, Class<?>... tiposArgumentos) {
		Preconditions.checkNotNull(classe, "A classe deve ser informada.");
		Preconditions.checkNotNull(valores, "Os valores de inicialização do construtor devem ser informados.");
		Preconditions.checkNotNull(tiposArgumentos, "Os tipos de cada argumento do construtor devem ser informados.");
		Preconditions.checkArgument(valores.length == tiposArgumentos.length,
				"Deve haver um valor para cada tipo de argumento do construtor e vice-versa.");
		Object objetoCriadoPeloConstrutor;
		try {
			objetoCriadoPeloConstrutor = classe.getDeclaredConstructor(tiposArgumentos).newInstance(valores);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			logger.log(Level.SEVERE,
					"Erro ao instanciar um novo objeto com os valores e seus respectivos tipos declarados no teste.",
					e);
			return false;
		}
		Set<Method> getters = trazMetodosGetters(classe);
		List<Object> retornosGetter = new ArrayList<>();
		for (Method getter : getters) {
			try {
				retornosGetter.add(getter.invoke(objetoCriadoPeloConstrutor));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				logger.log(Level.SEVERE,
						"Erro ao extrair os atributos do objeto pelos seus respectivos métodos getters.", e);
				return false;
			}
		}
		for (Object valor : valores) {
			if (!retornosGetter.contains(valor)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Traz metodos getters.
	 *
	 * @param classe the classe
	 * @return the sets the
	 */
	@Deprecated
	public static Set<Method> trazMetodosGetters(Class<?> classe) {
		Set<Method> metodosGet = new HashSet<>();
		for (int i = 0; i < classe.getDeclaredMethods().length; i++) {
			if (classe.getDeclaredMethods()[i].getName().substring(0, 3).equals("get")) {
				metodosGet.add(classe.getDeclaredMethods()[i]);
			}
		}
		return metodosGet;
	}

	public static boolean verificaEncapsulamentos(Class<?> classe) {
		Object objeto = classeNewer(classe);
		List<Field> campos = Arrays.asList(classe.getDeclaredFields());
		List<Method> metodosSet = metodosSetters(classe, campos);
		List<Method> metodosGet = metodosGetters(classe, campos);
		Object[] valores = geraValoresCampos(campos);
		if (metodosGet.size() == metodosSet.size()) {
			if (metodosGet.size() == campos.size()) {
				for (int i = 0; i < valores.length; i++) {
					try {
						metodosSet.get(i).invoke(objeto, campos.get(i).getType().cast(valores[i]));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
					try {
						if (valores[i] != metodosGet.get(i).invoke(objeto)) {
							return false;
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	private static Object classeNewer(Class<?> classe) {
		if (classe.isInterface()) {
			return classe.cast(Proxy.newProxyInstance(null, new Class[] {classe}, new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					return null;
				}
			}));
		}
		try {
			return classe.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static List<Method> metodosSetters(Class<?> classe, List<Field> campos) {
		List<Method> metodosSet = new ArrayList<>();
		StringBuilder nomeMetodoSetter = new StringBuilder();
		for (Field campo : campos) {
			for (Method metodo : classe.getDeclaredMethods()) {
				nomeMetodoSetter.append("set").append(campo.getName());
				if (metodo.getName().equalsIgnoreCase(nomeMetodoSetter.toString())) {
					metodosSet.add(metodo);
				}
				nomeMetodoSetter.setLength(0);
			}
		}
		return metodosSet;
	}

	private static List<Method> metodosGetters(Class<?> classe, List<Field> campos) {
		List<Method> metodosGet = new ArrayList<>();
		StringBuilder nomeMetodoGetter = new StringBuilder();
		for (Field campo : campos) {
			for (Method metodo : classe.getDeclaredMethods()) {
				nomeMetodoGetter.append("get").append(campo.getName());
				if (metodo.getName().equalsIgnoreCase(nomeMetodoGetter.toString())) {
					metodosGet.add(metodo);
				}
				nomeMetodoGetter.setLength(0);
			}
		}
		return metodosGet;
	}

	private static Object[] geraValoresCampos(List<Field> campos) {
		Object[] valores = new Object[campos.size()];
		int i = 0;
		for (Field campo : campos) {
			if (campo.getType().isPrimitive()) {
				geraValoresCamposPrimitivos(valores, i, campo.getType());
				i++;
				continue;
			}
			if (campo.getType().isEnum()) {
				geraValoresCamposEnum(valores, i, campo.getType());
				i++;
				continue;
			}
			valores[i] = classeNewer(campo.getType());
			i++;
		}
		return valores;
	}

	private static void geraValoresCamposPrimitivos(Object[] valores, int i, Class<?> classeCampo) {
		// TODO Auto-generated method stub
		
	}

	private static void geraValoresCamposEnum(Object[] valores, int i, Class<?> classeCampo) {
		try {
			valores[i] = classeCampo.getEnumConstants()[0];
		} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
