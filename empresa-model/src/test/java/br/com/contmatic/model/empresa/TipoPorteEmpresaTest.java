package br.com.contmatic.model.empresa;

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

import br.com.contmatic.model.empresa.TipoPorteEmpresa;

/**
 * The Class TipoPorteEmpresaTest.
 */
public class TipoPorteEmpresaTest {

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
     * Verifica valor do atributo descricao da constante ME.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ME() {
        assertThat(TipoPorteEmpresa.ME.getDescricao(), is(equalTo("Microempresa")));
    }

    /**
     * Verifica valor do atributo descricao da constante EPP.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_EPP() {
        assertThat(TipoPorteEmpresa.EPP.getDescricao(), is(equalTo("Empresa de pequeno porte")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MEDIO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MEDIO() {
        assertThat(TipoPorteEmpresa.MEDIO.getDescricao(), is(equalTo("Empresa de médio porte")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante GRANDE.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_GRANDE() {
        assertThat(TipoPorteEmpresa.GRANDE.getDescricao(), is(equalTo("Empresa de grande porte")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoPorteEmpresa.class).testing(GETTER).areWellImplemented();
    }
    
}
