package br.com.contmatic.validacoes.utilidades;

/**
 * The Class ConstantesString.
 */
public class ConstantesString {
        
    /** The Constant NUMERAL. */
    public static final String NUMERAL = "[0-9]";
    
    /** The Constant APENAS_LETRA_NUMERAL. */
    public static final String APENAS_LETRA_NUMERAL = "[A-Za-z0-9]";
    
    /** The Constant EMAIL. */
    public static final String EMAIL = "^[a-z0-9][a-z0-9._-]{0,29}(?<![._-])@[a-z0-9][a-z0-9.-]{0,19}(?<![.-])\\.[a-z]{2,6}$";    
    
    /** The Constant NOME. */
    public static final String NOME = "^[A-ZÁÉÍÓÚÃÕÀÂÊÔ]([A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[-'ç]|([ ](?![ ]))){0," + (ConstantesNumericas.TAMANHO_REGULAR - 2) + "}[A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]$";
    
    /** The Constant NOT_BLANK. */
    public static final String NOT_BLANK = ".*\\S.*";
    
    /** The Constant CELULAR. */
    public static final String CELULAR = NUMERAL + "{" + ConstantesNumericas.NUMERO_CELULAR + "}";
    
    /** The Constant TELEFONE. */
    public static final String TELEFONE = NUMERAL + "{" + ConstantesNumericas.NUMERO_TELEFONE + "}";
    
    /** The Constant DDD. */
    public static final String DDD = NUMERAL + "{" + ConstantesNumericas.DDD + "}";
    
    /** The Constant CEP. */
    public static final String CEP = NUMERAL + "{" + ConstantesNumericas.CEP + "}";
    
    /** The Constant NUMERO_ENDERECO. */
    public static final String NUMERO_ENDERECO = NUMERAL + "{1," + ConstantesNumericas.MAX_NUMERO_ENDERECO + "}";
    
    /** The Constant CODIGO_BANCO. */
    public static final String CODIGO_BANCO = APENAS_LETRA_NUMERAL + "{1," + ConstantesNumericas.MAX_CODIGO_BANCO + "}";
    
    /** The Constant NUMERO_AGENCIA. */
    public static final String NUMERO_AGENCIA = APENAS_LETRA_NUMERAL + "{1," + ConstantesNumericas.MAX_NUMERO_AGENCIA + "}";
    
    /** The Constant NUMERO_CONTA. */
    public static final String NUMERO_CONTA = APENAS_LETRA_NUMERAL + "{1," + ConstantesNumericas.MAX_NUMERO_CONTA + "}";
    
    /** The Constant RAZAO_SOCIAL. */
    public static final String RAZAO_SOCIAL = "^[A-ZÁÉÍÓÚÃÕÀÂÊÔ]([A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|[&'çÇ\\-]|(?<!\\.)\\.|([ ](?![ ]))){0," + (ConstantesNumericas.TAMANHO_REGULAR - 2) + "}([A-Za-zÁÉÍÓÚáéíóúÃÕãõÀàÂÊÔâêô]|(?<!\\.)\\.)$";
    
    /**
     * Instantiates a new constantes string.
     */
    private ConstantesString() {
    }

}
