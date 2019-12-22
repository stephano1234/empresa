package br.com.contmatic.model.contato;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.contato.TipoContatoCelular;

/**
 * The Class TipoContatoCelularTest.
 */
public class TipoContatoCelularTest {

    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
     * Verifica valor do atributo descricao da constante APENA S LIGACAO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_APENAS_LIGACAO() {
        assertThat(TipoContatoCelular.APENAS_LIGACAO.getDescricao(), is(equalTo("Recebe apenas ligações")));
    }

    /**
     * Verifica valor do atributo descricao da constante APENA S MENSAGE M TEXTO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_APENAS_MENSAGEM_TEXTO() {
        assertThat(TipoContatoCelular.APENAS_MENSAGEM_TEXTO.getDescricao(), is(equalTo("Recebe apenas mensagens de texto")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante APENA S MENSAGE M INTERNET.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_APENAS_MENSAGEM_INTERNET() {
        assertThat(TipoContatoCelular.APENAS_MENSAGEM_INTERNET.getDescricao(), is(equalTo("Recebe apenas mensagens de internet")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante LIGACA O MENSAGE M TEXTO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_LIGACAO_MENSAGEM_TEXTO() {
        assertThat(TipoContatoCelular.LIGACAO_MENSAGEM_TEXTO.getDescricao(), is(equalTo("Recebe apenas ligações e mensagens de texto")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante LIGACA O MENSAGE M INTERNET.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_LIGACAO_MENSAGEM_INTERNET() {
        assertThat(TipoContatoCelular.LIGACAO_MENSAGEM_INTERNET.getDescricao(), is(equalTo("Recebe apenas ligações e mensagens de internet")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MENSAGE M TEXT O INTERNET.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MENSAGEM_TEXTO_INTERNET() {
        assertThat(TipoContatoCelular.MENSAGEM_TEXTO_INTERNET.getDescricao(), is(equalTo("Recebe apenas mensagens de texto e de internet")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante LIGACA O MENSAGE M TEXT O INTERNET.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_LIGACAO_MENSAGEM_TEXTO_INTERNET() {
        assertThat(TipoContatoCelular.LIGACAO_MENSAGEM_TEXTO_INTERNET.getDescricao(), is(equalTo("Recebe ligações, mensagens de texto e de internet")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoContatoCelular.class).testing(GETTER).areWellImplemented();
    }
    
}
