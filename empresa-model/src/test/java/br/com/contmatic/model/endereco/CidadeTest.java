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

import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.TipoUf;
import br.com.contmatic.templates.endereco.CidadeTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class CidadeTest.
 */
public class CidadeTest {
    
    /** The cidade. */
    private Cidade cidade;
    
    /** The outro cidade. */
    private Cidade outroCidade;

    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
        cidade = Fixture.from(Cidade.class).gimme("valido");
        outroCidade = Fixture.from(Cidade.class).gimme("outroValido");
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
        cidade.setNome(null);
        assertTrue(procuraAlgumErro(cidade));
    }
    
    /**
     * Nao deve aceitar valor vazio no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
    	cidade.setNome("");
        assertTrue(procuraAlgumErro(cidade));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("maiorTamanhoNome");
        assertTrue(procuraAlgumErro(cidade));
    }

    /**
     * Nao deve aceitar valor com apenas um caractere no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_um_caractere_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("umCaractereNome");
        assertTrue(procuraAlgumErro(cidade));
    }

    /**
     * Nao deve aceitar valor com apenas espaco no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("apenasEspacoNome");
        assertTrue(procuraAlgumErro(cidade));
    }
    
    /**
     * Nao deve aceitar valor com primeiro caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_invalido_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comPrimeiroCaractereInvalido");
        assertTrue(procuraAlgumErro(cidade));
    }

    /**
     * Nao deve aceitar valor com ultimo caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_ultimo_caractere_invalido_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comUltimoCaractereInvalido");
        assertTrue(procuraAlgumErro(cidade));
    }

    /**
     * Nao deve aceitar valor com um caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(procuraAlgumErro(cidade));
    }
    
    /**
     * Nao deve aceitar valor com dois espacos juntos no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_dois_espacos_juntos_no_nome() {
        cidade = Fixture.from(Cidade.class).gimme("comEspacoDuploNome");
        assertTrue(procuraAlgumErro(cidade));
    }
    
    /**
     * Deve aceitar nome valido.
     */
    @Test
    public void deve_aceitar_nome_valido() {
        cidade = Fixture.from(Cidade.class).gimme("validoNome");
        assertFalse(procuraAlgumErro(cidade));
    }
    
    /**
     * Nao deve aceitar valor nulo no tipo uf.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoUf() {
        cidade.setTipoUf(null);
        assertTrue(procuraAlgumErro(cidade));
    }
    
    /**
     * Deve aceitar valor nao nulo no tipo uf.
     */
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoUf() {
        cidade.setTipoUf(TipoUf.AC);
        assertFalse(procuraAlgumErro(cidade));
    }
    
    /**
     * Gets the nome deve trazer o valor armazenado em nome.
     *
     * @return the nome deve trazer o valor armazenado em nome
     */
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        cidade.setNome("São João");
        assertThat(cidade.getNome(), is(equalTo("São João")));
    }
    
    /**
     * Gets the tipo uf deve trazer o valor armazenado em tipo uf.
     *
     * @return the tipo uf deve trazer o valor armazenado em tipo uf
     */
    @Test
    public void getTipoUf_deve_trazer_o_valor_armazenado_em_tipoUf() {
        cidade.setTipoUf(TipoUf.AC);
        assertThat(cidade.getTipoUf(), is(equalTo(TipoUf.AC)));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Cidade.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Cidade.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"Goiania", TipoUf.AC};
        assertTrue(verificaConstrutor(Cidade.class, valores, String.class, TipoUf.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com nome tipo uf igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_nome_tipoUf_igual() {
        outroCidade.setNome(cidade.getNome());
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertThat(cidade.hashCode(), is(equalTo(outroCidade.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com nome igual tipo uf diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_igual_tipoUf_diferente() {
        outroCidade.setNome(cidade.getNome());
        assertThat(cidade.hashCode(), is(not(equalTo(outroCidade.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com nome diferente tipo uf igual.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_tipoUf_igual() {
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertThat(cidade.hashCode(), is(not(equalTo(outroCidade.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com nome diferente tipo uf diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_nome_diferente_tipoUf_diferente() {
        assertThat(cidade.hashCode(), is(not(equalTo(outroCidade.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com nome tipo uf igual.
     */
    @Test
    public void equals_deve_retornar_true_com_nome_tipoUf_igual() {
        outroCidade.setNome(cidade.getNome());
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertTrue(cidade.equals(outroCidade));
    }
    
    /**
     * Equals deve retornar false com nome igual tipo uf diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_nome_igual_tipoUf_diferente() {
        outroCidade.setNome(cidade.getNome());
        assertFalse(cidade.equals(outroCidade));
    }
    
    /**
     * Equals deve retornar false com nome diferente tipo uf igual.
     */
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_tipoUf_igual() {
        outroCidade.setTipoUf(cidade.getTipoUf());
        assertFalse(cidade.equals(outroCidade));
    }
    
    /**
     * Equals deve retornar false com nome diferente tipo uf diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_nome_diferente_tipoUf_diferente() {
        assertFalse(cidade.equals(outroCidade));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Cidade.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo nome no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        cidade.setNome("Rio Claro");
        assertTrue(cidade.toString().contains("Rio Claro"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo tipo uf no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoUf_no_texto_gerado_pelo_metodo_toString() {
        cidade.setTipoUf(TipoUf.AC);
        assertTrue(cidade.toString().contains("AC"));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(cidade));
    }
    
}
