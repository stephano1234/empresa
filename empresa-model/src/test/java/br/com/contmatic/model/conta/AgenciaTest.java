package br.com.contmatic.model.conta;

import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;
import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;

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
import br.com.contmatic.templates.conta.AgenciaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class AgenciaTest.
 */
public class AgenciaTest {
    
    /** The agencia. */
    private Agencia agencia;
    
    /** The outro agencia. */
    private Agencia outroAgencia;
    
    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
        agencia = Fixture.from(Agencia.class).gimme("valido");
        outroAgencia = Fixture.from(Agencia.class).gimme("outroValido");
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
        agencia.setNumero(null);
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Nao deve aceitar valor vazio no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        agencia.setNumero("");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("maiorTamanhoNumero");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        agencia = Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Deve aceitar numero valido.
     */
    @Test
    public void deve_aceitar_numero_valido() {
        agencia = Fixture.from(Agencia.class).gimme("validoNumero");
        assertFalse(procuraAlgumErro(agencia));
    }

    /**
     * Nao deve aceitar valor nulo no codigo banco.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_codigoBanco() {
        agencia.setCodigoBanco(null);
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Nao deve aceitar valor vazio no codigo banco.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_codigoBanco() {
        agencia.setCodigoBanco("");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no codigo banco.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_codigoBanco() {
        agencia = Fixture.from(Agencia.class).gimme("maiorTamanhoCodigoBanco");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no codigo banco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_codigoBanco() {
        agencia = Fixture.from(Agencia.class).gimme("comUmCaractereInvalidoCodigoBanco");
        assertTrue(procuraAlgumErro(agencia));
    }
    
    /**
     * Deve aceitar codigo banco valido.
     */
    @Test
    public void deve_aceitar_codigoBanco_valido() {
        agencia = Fixture.from(Agencia.class).gimme("validoCodigoBanco");
        assertFalse(procuraAlgumErro(agencia));
    }
    
    /**
     * Gets the numero deve trazer o valor armazenado em numero.
     *
     * @return the numero deve trazer o valor armazenado em numero
     */
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        agencia.setNumero("2244");
        assertThat(agencia.getNumero(), is(equalTo("2244")));
    }
    
    /**
     * Gets the codigo banco deve trazer o valor armazenado em codigo banco.
     *
     * @return the codigo banco deve trazer o valor armazenado em codigo banco
     */
    @Test
    public void getCodigoBanco_deve_trazer_o_valor_armazenado_em_codigoBanco() {
        agencia.setCodigoBanco("77B");
        assertThat(agencia.getCodigoBanco(), is(equalTo("77B")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Agencia.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Agencia.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"1223", "77B"};
        assertTrue(verificaConstrutor(Agencia.class, valores, String.class, String.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com numero codigo banco igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_numero_codigoBanco_igual() {
        outroAgencia.setNumero(agencia.getNumero());
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertThat(agencia.hashCode(), is(equalTo(outroAgencia.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero igual codigo banco diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_codigoBanco_diferente() {
        outroAgencia.setNumero(agencia.getNumero());
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero diferente codigo banco igual.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_diferente_codigoBanco_igual() {
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero codigo banco diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_codigoBanco_diferente() {
        assertThat(agencia.hashCode(), is(not(equalTo(outroAgencia.hashCode()))));
    }
    
    /**
     * Equals deve retornar true com numero codigo banco igual.
     */
    @Test
    public void equals_deve_retornar_true_com_numero_codigoBanco_igual() {
        outroAgencia.setNumero(agencia.getNumero());
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertTrue(agencia.equals(outroAgencia));
    }
    
    /**
     * Equals deve retornar false com numero igual codigo banco diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_igual_codigoBanco_diferente() {
        outroAgencia.setNumero(agencia.getNumero());
        assertFalse(agencia.equals(outroAgencia));
    }
    
    /**
     * Equals deve retornar false com numero diferente codigo banco igual.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_diferente_codigoBanco_igual() {
        outroAgencia.setCodigoBanco(agencia.getCodigoBanco());
        assertFalse(agencia.equals(outroAgencia));
    }
    
    /**
     * Equals deve retornar false com numero codigo banco diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_codigoBanco_diferente() {
        assertFalse(agencia.equals(outroAgencia));
    }
        
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Agencia.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo numero no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        agencia.setNumero("2244");
        assertTrue(agencia.toString().contains("2244"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo codigo banco no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_codigoBanco_no_texto_gerado_pelo_metodo_toString() {
        agencia.setCodigoBanco("77B");
        assertTrue(agencia.toString().contains("77B"));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(agencia));
    }
    
}
