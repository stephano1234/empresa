package br.com.contmatic.model.endereco;

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

import br.com.contmatic.model.endereco.Bairro;
import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.templates.endereco.BairroTemplateFixtureFactory;
import br.com.contmatic.templates.endereco.CidadeTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class BairroTest.
 */
public class BairroTest {
    
    /** The bairro. */
    private Bairro bairro;
    
    /** The outro bairro. */
    private Bairro outroBairro;
    
    /** The cidade. */
    private Cidade cidade;

    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new BairroTemplateFixtureFactory().load();
        new CidadeTemplateFixtureFactory().load();
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
        bairro = Fixture.from(Bairro.class).gimme("valido");
        outroBairro = Fixture.from(Bairro.class).gimme("outroValido");
        cidade = Fixture.from(Cidade.class).gimme("valido");
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
     * Nao deve aceitar valor nulo no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        bairro.setNome(null);
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Nao deve aceitar valor vazio no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
    	bairro.setNome("");
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("maiorTamanhoNome");
        assertTrue(procuraAlgumErro(bairro));
    }

    /**
     * Nao deve aceitar valor com apenas um caractere no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_um_caractere_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("umCaractereNome");
        assertTrue(procuraAlgumErro(bairro));
    }

    /**
     * Nao deve aceitar valor com apenas espaco no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("apenasEspacoNome");
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Nao deve aceitar valor com primeiro caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_invalido_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comPrimeiroCaractereInvalido");
        assertTrue(procuraAlgumErro(bairro));
    }

    /**
     * Nao deve aceitar valor com ultimo caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_ultimo_caractere_invalido_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comUltimoCaractereInvalido");
        assertTrue(procuraAlgumErro(bairro));
    }

    /**
     * Nao deve aceitar valor com um caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Nao deve aceitar valor com dois espacos juntos no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_dois_espacos_juntos_no_nome() {
        bairro = Fixture.from(Bairro.class).gimme("comEspacoDuploNome");
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Deve aceitar nome valido.
     */
    @Test
    public void deve_aceitar_nome_valido() {
        bairro = Fixture.from(Bairro.class).gimme("validoNome");
        assertFalse(procuraAlgumErro(bairro));
    }
        
    /**
     * Nao deve aceitar valor nulo no cidade.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cidade() {
        bairro.setCidade(null);
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Nao deve aceitar cidade invalido.
     */
    @Test
    public void nao_deve_aceitar_cidade_invalido() {
        bairro.setCidade(Fixture.from(Cidade.class).gimme("comUmCaractereInvalidoNome"));
        assertTrue(procuraAlgumErro(bairro));
    }
    
    /**
     * Deve aceitar cidade nao nulo valido.
     */
    @Test
    public void deve_aceitar_cidade_nao_nulo_valido() {
        bairro.setCidade(cidade);
        assertFalse(procuraAlgumErro(bairro));
    }
    
    /**
     * Gets the nome deve trazer o valor armazenado em nome.
     *
     * @return the nome deve trazer o valor armazenado em nome
     */
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        bairro.setNome("Pompéia");
        assertThat(bairro.getNome(), is(equalTo("Pompéia")));
    }
    
    /**
     * Gets the cidade deve trazer o valor armazenado em cidade.
     *
     * @return the cidade deve trazer o valor armazenado em cidade
     */
    @Test
    public void getCidade_deve_trazer_o_valor_armazenado_em_cidade() {
        bairro.setCidade(cidade);
        assertThat(bairro.getCidade(), is(equalTo(cidade)));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Bairro.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Bairro.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"Itaim Bibi", cidade};
        assertTrue(verificaConstrutor(Bairro.class, valores, String.class, Cidade.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com nome cidade igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_nome_cidade_igual() {
        outroBairro.setNome(bairro.getNome());
        outroBairro.setCidade(bairro.getCidade());
        assertThat(bairro.hashCode(), is(equalTo(outroBairro.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com nome igual cidade diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_igual_cidade_diferente() {
        outroBairro.setNome(bairro.getNome());
        assertThat(bairro.hashCode(), is(not(equalTo(outroBairro.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com nome diferente cidade igual.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_cidade_igual() {
        outroBairro.setCidade(bairro.getCidade());
        assertThat(bairro.hashCode(), is(not(equalTo(outroBairro.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com nome diferente cidade diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_cidade_diferente() {
        assertThat(bairro.hashCode(), is(not(equalTo(outroBairro.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com nome cidade igual.
     */
    @Test
    public void equals_deve_retornar_true_com_nome_cidade_igual() {
        outroBairro.setNome(bairro.getNome());
        outroBairro.setCidade(bairro.getCidade());
        assertTrue(bairro.equals(outroBairro));
    }
    
    /**
     * Equals deve retornar false com nome igual cidade diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_nome_igual_cidade_diferente() {
        outroBairro.setNome(bairro.getNome());
        assertFalse(bairro.equals(outroBairro));
    }
    
    /**
     * Equals deve retornar false com nome diferente cidade igual.
     */
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_cidade_igual() {
        outroBairro.setCidade(bairro.getCidade());
        assertFalse(bairro.equals(outroBairro));
    }
    
    /**
     * Equals deve retornar false com nome diferente cidade diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_cidade_diferente() {
        assertFalse(bairro.equals(outroBairro));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Bairro.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo nome no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        bairro.setNome("Lapa");
        assertTrue(bairro.toString().contains("Lapa"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo cidade no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cidade_no_texto_gerado_pelo_metodo_toString() {
        bairro.setCidade(cidade);
        assertTrue(bairro.toString().contains(cidade.toString()));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(bairro));
    }
    
}
