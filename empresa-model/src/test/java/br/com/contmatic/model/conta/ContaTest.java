package br.com.contmatic.model.conta;

import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;
import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;

import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.conta.Agencia;
import br.com.contmatic.model.conta.Conta;
import br.com.contmatic.model.conta.TipoConta;
import br.com.contmatic.templates.conta.AgenciaTemplateFixtureFactory;
import br.com.contmatic.templates.conta.ContaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class ContaTest.
 */
public class ContaTest {

    /** The conta. */
    private Conta conta;
    
    /** The outro conta. */
    private Conta outroConta;
    
    /** The agencia. */
    private Agencia agencia;
    
    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new ContaTemplateFixtureFactory().load();
        new AgenciaTemplateFixtureFactory().load();
    }

    /**
     * Tear down after class.
     *
     * @throws Exception the exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        conta = Fixture.from(Conta.class).gimme("valido");
        outroConta = Fixture.from(Conta.class).gimme("outroValido");
        agencia = Fixture.from(Agencia.class).gimme("valido");
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Nao deve aceitar valor nulo no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        conta.setNumero(null);
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Nao deve aceitar valor vazio no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        conta.setNumero("");
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        conta = Fixture.from(Conta.class).gimme("maiorTamanhoNumero");
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        conta = Fixture.from(Conta.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Deve aceitar numero valido.
     */
    @Test
    public void deve_aceitar_numero_valido() {
        conta = Fixture.from(Conta.class).gimme("validoNumero");
        assertFalse(procuraAlgumErro(conta));
    }

    /**
     * Nao deve aceitar valor nulo no agencia.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_agencia() {
        conta.setAgencia(null);
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Nao deve aceitar agencia invalido.
     */
    @Test
    public void nao_deve_aceitar_agencia_invalido() {
        conta.setAgencia(Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoNumero"));
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Deve aceitar agencia nao nulo valido.
     */
    @Test
    public void deve_aceitar_agencia_nao_nulo_valido() {
        conta.setAgencia(agencia);
        assertFalse(procuraAlgumErro(conta));
    }
    
    /**
     * Nao deve aceitar valor nulo no tipo conta.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoConta() {
        conta.setTipoConta(null);
        assertTrue(procuraAlgumErro(conta));
    }
    
    /**
     * Deve aceitar valor nao nulo no tipo conta.
     */
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoConta() {
        conta.setTipoConta(TipoConta.CONTA_CORRENTE);
        assertFalse(procuraAlgumErro(conta));
    }
    
    /**
     * Gets the numero deve trazer o valor armazenado em numero.
     *
     * @return the numero deve trazer o valor armazenado em numero
     */
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        conta.setNumero("1234567");
        assertThat(conta.getNumero(), is(equalTo("1234567")));
    }
    
    /**
     * Gets the agencia deve trazer o valor armazenado em agencia.
     *
     * @return the agencia deve trazer o valor armazenado em agencia
     */
    @Test
    public void getAgencia_deve_trazer_o_valor_armazenado_em_agencia() {
        conta.setAgencia(agencia);
        assertThat(conta.getAgencia(), is(equalTo(agencia)));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Conta.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Conta.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"123454321", agencia, TipoConta.CONTA_CORRENTE};
        assertTrue(verificaConstrutor(Conta.class, valores, String.class, Agencia.class, TipoConta.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com numero agencia igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_numero_agencia_igual() {
        outroConta.setNumero(conta.getNumero());
        outroConta.setAgencia(conta.getAgencia());
        assertThat(conta.hashCode(), is(equalTo(outroConta.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero igual agencia diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_agencia_diferente() {
        outroConta.setNumero(conta.getNumero());
        assertThat(conta.hashCode(), is(not(equalTo(outroConta.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero diferente agencia igual.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_diferente_agencia_igual() {
        outroConta.setAgencia(conta.getAgencia());
        assertThat(conta.hashCode(), is(not(equalTo(outroConta.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero agencia diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_agencia_diferente() {
        assertThat(conta.hashCode(), is(not(equalTo(outroConta.hashCode()))));
    }
    
    /**
     * Equals deve retornar true com numero agencia igual.
     */
    @Test
    public void equals_deve_retornar_true_com_numero_agencia_igual() {
        outroConta.setNumero(conta.getNumero());
        outroConta.setAgencia(conta.getAgencia());
        assertTrue(conta.equals(outroConta));
    }
    
    /**
     * Equals deve retornar false com numero igual agencia diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_igual_agencia_diferente() {
        outroConta.setNumero(conta.getNumero());
        assertFalse(conta.equals(outroConta));
    }
    
    /**
     * Equals deve retornar false com numero diferente agencia igual.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_diferente_agencia_igual() {
        outroConta.setAgencia(conta.getAgencia());
        assertFalse(conta.equals(outroConta));
    }
    
    /**
     * Equals deve retornar false com numero agencia diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_agencia_diferente() {
        assertFalse(conta.equals(outroConta));
    }
        
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Conta.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo numero no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        conta.setNumero("1234567");
        assertTrue(conta.toString().contains("1234567"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo agencia no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_agencia_no_texto_gerado_pelo_metodo_toString() {
        conta.setAgencia(agencia);
        assertTrue(conta.toString().contains(agencia.toString()));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(conta));
    }
    
}
