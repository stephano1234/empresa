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

import br.com.contmatic.model.pessoa.TipoEstadoCivil;

/**
 * The Class TipoEstadoCivilTest.
 */
public class TipoEstadoCivilTest {

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
     * Verifica valor do atributo descricao da constante SOLTEIRO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SOLTEIRO() {
        assertThat(TipoEstadoCivil.SOLTEIRO.getDescricao(), is(equalTo("Solteiro(a)")));
    }

    /**
     * Verifica valor do atributo descricao da constante CASADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_CASADO() {
        assertThat(TipoEstadoCivil.CASADO.getDescricao(), is(equalTo("Casado(a)")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante DIVORCIADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DIVORCIADO() {
        assertThat(TipoEstadoCivil.DIVORCIADO.getDescricao(), is(equalTo("Divorciado(a)")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante VIUVO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_VIUVO() {
        assertThat(TipoEstadoCivil.VIUVO.getDescricao(), is(equalTo("Viuvo(a)")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante OUTROS.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_OUTROS() {
        assertThat(TipoEstadoCivil.OUTROS.getDescricao(), is(equalTo("Outros")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoEstadoCivil.class).testing(GETTER).areWellImplemented();
    }
    
}
