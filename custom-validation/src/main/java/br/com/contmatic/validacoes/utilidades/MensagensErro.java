package br.com.contmatic.validacoes.utilidades;

/**
 * The Class MensagensErro.
 */
public class MensagensErro {
    
    /** The Constant VALOR_NULO. */
    public static final String VALOR_NULO = "O campo não pode ser nulo.";
    
    /** The Constant VAZIO_OU_COM_ELEMENTO_NULO. */
    public static final String NULO_OU_COM_ELEMENTO_NULO = "O campo não pode ser nulo e não pode conter qualquer elemento nulo.";
    
    public static final String NULO_VAZIO_OU_COM_ELEMENTO_NULO = "O campo não pode ser nulo e deve conter ao menos um elemento não nulo e não pode conter qualquer elemento nulo.";
    
    /** The Constant EMAIL_INVALIDO. */
    public static final String EMAIL_INVALIDO = "O campo deve ser um endereço de e-mail.";
    
    /** The Constant CPF_INVALIDO. */
    public static final String CPF_INVALIDO = "O campo deve conter um CPF válido.";
    
    /** The Constant CEP_INVALIDO. */
    public static final String CEP_INVALIDO = "O campo deve conter um CEP válido.";
    
    /** The Constant NUMERO_ENDERECO_INVALIDO. */
    public static final String NUMERO_ENDERECO_INVALIDO = "O campo deve conter um número de endereço válido.";
    
    /** The Constant CNPJ_INVALIDO. */
    public static final String CNPJ_INVALIDO = "O campo deve conter um CNPJ válido.";
    
    /** The Constant NOME_INVALIDO. */
    public static final String NOME_INVALIDO = "O campo deve conter um nome válido.";
    
    /** The Constant NOT_BLANK_INVALIDO. */
    public static final String NOT_BLANK_INVALIDO = "O campo deve conter ao menos um caractere que não seja um espaço em branco.";
    
    /** The Constant TAMANHO_INVALIDO. */
    public static final String TAMANHO_INVALIDO = "O campo não pode ter menos de {min} ou mais de {max} caracteres.";
    
    /** The Constant CELULAR_INVALIDO. */
    public static final String CELULAR_INVALIDO = "O campo deve conter um celular válido.";
    
    /** The Constant TELEFONE_INVALIDO. */
    public static final String TELEFONE_INVALIDO = "O campo deve conter um telefone válido.";
    
    /** The Constant DDD_INVALIDO. */
    public static final String DDD_INVALIDO = "O campo deve conter um DDD válido.";
    
    /** The Constant CODIGO_BANCO_INVALIDO. */
    public static final String CODIGO_BANCO_INVALIDO = "O campo deve conter um código de banco válido.";
    
    /** The Constant RAZAO_SOCIAL_INVALIDO. */
    public static final String RAZAO_SOCIAL_INVALIDO = "O campo deve conter uma Razão Social válida.";
    
    /** The Constant NUMERO_AGENCIA_INVALIDO. */
    public static final String NUMERO_AGENCIA_INVALIDO = "O campo deve conter um número de agência válido.";
    
    /** The Constant NUMERO_CONTA_INVALIDO. */
    public static final String NUMERO_CONTA_INVALIDO = "O campo deve conter um número de conta bancária válido.";
    
    /** The Constant DECIMAL_MAX. */
    public static final String DECIMAL_MAX = "O campo não pode ser maior que {value}.";
    
    /** The Constant DECIMAL_MIN. */
    public static final String DECIMAL_MIN = "O campo não pode ser menor que {value}.";
    
    /** The Constant DATA_PASSADO. */
    public static final String DATA_PASSADO = "A data deve ser anterior à data atual.";
    
    /**
     * Instantiates a new mensagens erro.
     */
    private MensagensErro() {
    }

}
