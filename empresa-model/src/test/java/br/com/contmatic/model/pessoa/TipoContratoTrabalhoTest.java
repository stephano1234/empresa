package br.com.contmatic.model.pessoa;

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

import br.com.contmatic.model.pessoa.TipoContratoTrabalho;

/**
 * The Class TipoContratoTrabalhoTest.
 */
public class TipoContratoTrabalhoTest {

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
     * Verifica valor do atributo descricao da constante TEMP O DETERMINADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TEMPO_DETERMINADO() {
        assertThat(TipoContratoTrabalho.TEMPO_DETERMINADO.getDescricao(), is(equalTo("Contrato de trabalho por tempo determinado")));
    }

    /**
     * Verifica valor do atributo descricao da constante TEMP O INDETERMINADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TEMPO_INDETERMINADO() {
        assertThat(TipoContratoTrabalho.TEMPO_INDETERMINADO.getDescricao(), is(equalTo("Contrato de trabalho por tempo indeterminado")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante TEMPORAREO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TEMPORAREO() {
        assertThat(TipoContratoTrabalho.TEMPORAREO.getDescricao(), is(equalTo("Contrato de trabalho temporáreo")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante EVENTUAL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_EVENTUAL() {
        assertThat(TipoContratoTrabalho.EVENTUAL.getDescricao(), is(equalTo("Contrato de trabalho eventual")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante AUTONOMO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AUTONOMO() {
        assertThat(TipoContratoTrabalho.AUTONOMO.getDescricao(), is(equalTo("Contrato de trabalho autônomo")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante ESTAGIO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ESTAGIO() {
        assertThat(TipoContratoTrabalho.ESTAGIO.getDescricao(), is(equalTo("Contrato de estágio")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoContratoTrabalho.class).testing(GETTER).areWellImplemented();
    }
    
}
