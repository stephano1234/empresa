package br.com.contmatic.model.contato;

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

import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.contmatic.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class TelefoneFixoTest.
 */
public class TelefoneFixoTest {
    
    /** The telefone fixo. */
    private TelefoneFixo telefoneFixo;
    
    /** The outro telefone fixo. */
    private TelefoneFixo outroTelefoneFixo;

    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new TelefoneFixoTemplateFixtureFactory().load();
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
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("valido");
        outroTelefoneFixo = Fixture.from(TelefoneFixo.class).gimme("outroValido");
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
     * Nao deve aceitar valor nulo no ddd.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_ddd() {
        telefoneFixo.setDdd(null);
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no ddd.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("maiorTamanhoDdd");
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Nao deve aceitar valor menor que tamanho no ddd.
     */
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("menorTamanhoDdd");
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no ddd.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_ddd() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoDdd");
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Deve aceitar ddd valido.
     */
    @Test
    public void deve_aceitar_ddd_valido() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("validoDdd");
        assertFalse(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Nao deve aceitar valor nulo no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_numero() {
        telefoneFixo.setNumero(null);
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("maiorTamanhoNumero");
        assertTrue(procuraAlgumErro(telefoneFixo));
    }

    /**
     * Nao deve aceitar valor menor que tamanho no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("menorTamanhoNumero");
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Deve aceitar numero valido.
     */
    @Test
    public void deve_aceitar_numero_valido() {
        telefoneFixo = Fixture.from(TelefoneFixo.class).gimme("validoNumero");
        assertFalse(procuraAlgumErro(telefoneFixo));
    }
    
    /**
     * Gets the ddd deve trazer o valor armazenado em ddd.
     *
     * @return the ddd deve trazer o valor armazenado em ddd
     */
    @Test
    public void getDdd_deve_trazer_o_valor_armazenado_em_ddd() {
        telefoneFixo.setDdd("45");
        assertThat(telefoneFixo.getDdd(), is(equalTo("45")));
    }
    
    /**
     * Gets the numero deve trazer o valor armazenado em numero.
     *
     * @return the numero deve trazer o valor armazenado em numero
     */
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        telefoneFixo.setNumero("08004444");
        assertThat(telefoneFixo.getNumero(), is(equalTo("08004444")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TelefoneFixo.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(TelefoneFixo.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"00", "00000000"};
        assertTrue(verificaConstrutor(TelefoneFixo.class, valores, String.class, String.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com ddd numero igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_ddd_numero_igual() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertThat(telefoneFixo.hashCode(), is(equalTo(outroTelefoneFixo.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com ddd igual numero diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_igual_numero_diferente() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        assertThat(telefoneFixo.hashCode(), is(not(equalTo(outroTelefoneFixo.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com ddd diferente numero igual.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_diferente_numero_igual() {
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertThat(telefoneFixo.hashCode(), is(not(equalTo(outroTelefoneFixo.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com ddd diferente numero diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_ddd_diferente_numero_diferente() {
        assertThat(telefoneFixo.hashCode(), is(not(equalTo(outroTelefoneFixo.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com ddd numero igual.
     */
    @Test
    public void equals_deve_retornar_true_com_ddd_numero_igual() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertTrue(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    /**
     * Equals deve retornar false com ddd igual numero diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_ddd_igual_numero_diferente() {
        outroTelefoneFixo.setDdd(telefoneFixo.getDdd());
        assertFalse(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    /**
     * Equals deve retornar false com ddd diferente numero igual.
     */
    @Test
    public void equals_deve_retornar_false_com_ddd_diferente_numero_igual() {
        outroTelefoneFixo.setNumero(telefoneFixo.getNumero());
        assertFalse(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    /**
     * Equals deve retornar false com ddd diferente numero diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_ddd_diferente_numero_diferente() {
        assertFalse(telefoneFixo.equals(outroTelefoneFixo));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(TelefoneFixo.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo ddd no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_ddd_no_texto_gerado_pelo_metodo_toString() {
        telefoneFixo.setDdd("45");
        assertTrue(telefoneFixo.toString().contains("45"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo numero no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        telefoneFixo.setNumero("08004444");
        assertTrue(telefoneFixo.toString().contains("08004444"));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(telefoneFixo));
    }
    
}
