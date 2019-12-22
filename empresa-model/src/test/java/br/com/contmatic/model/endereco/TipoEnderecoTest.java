package br.com.contmatic.model.endereco;

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

import br.com.contmatic.model.endereco.TipoEndereco;

/**
 * The Class TipoEnderecoTest.
 */
public class TipoEnderecoTest {

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
     * Verifica valor do atributo descricao da constante RESIDENCIAL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RESIDENCIAL() {
        assertThat(TipoEndereco.RESIDENCIAL.getDescricao(), is(equalTo("Endereço residencial")));
    }

    /**
     * Verifica valor do atributo descricao da constante COMERCIAL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_COMERCIAL() {
        assertThat(TipoEndereco.COMERCIAL.getDescricao(), is(equalTo("Endereço comercial")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoEndereco.class).testing(GETTER).areWellImplemented();
    }
    
}
