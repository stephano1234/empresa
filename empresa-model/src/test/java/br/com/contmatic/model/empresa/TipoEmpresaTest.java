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

import br.com.contmatic.model.empresa.TipoEmpresa;

/**
 * The Class TipoEmpresaTest.
 */
public class TipoEmpresaTest {

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
     * Verifica valor do atributo descricao da constante INDIVIDUAL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_INDIVIDUAL() {
        assertThat(TipoEmpresa.INDIVIDUAL.getDescricao(), is(equalTo("Empresário Individual")));
    }

    /**
     * Verifica valor do atributo descricao da constante MEI.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MEI() {
        assertThat(TipoEmpresa.MEI.getDescricao(), is(equalTo("Microempreendedor Individual")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante EIRELI.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_EIRELI() {
        assertThat(TipoEmpresa.EIRELI.getDescricao(), is(equalTo("Empresa Individual de Responsabilidade Limitada")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SOCIEDADE.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SOCIEDADE() {
        assertThat(TipoEmpresa.SOCIEDADE.getDescricao(), is(equalTo("Sociedade Emppresária")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SOCIEDAD E SIMPLES.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SOCIEDADE_SIMPLES() {
        assertThat(TipoEmpresa.SOCIEDADE_SIMPLES.getDescricao(), is(equalTo("Sociedade Simples")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoEmpresa.class).testing(GETTER).areWellImplemented();
    }
    
}
