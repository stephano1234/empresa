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

import br.com.contmatic.model.endereco.TipoUf;

/**
 * The Class TipoUfTest.
 */
public class TipoUfTest {

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
     * Verifica valor do atributo descricao da constante AC.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AC() {
        assertThat(TipoUf.AC.getSigla(), is(equalTo("AC")));
    }

    /**
     * Verifica valor do atributo descricao da constante AL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AL() {
        assertThat(TipoUf.AL.getSigla(), is(equalTo("AL")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante AM.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AM() {
        assertThat(TipoUf.AM.getSigla(), is(equalTo("AM")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante AP.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_AP() {
        assertThat(TipoUf.AP.getSigla(), is(equalTo("AP")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante BA.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_BA() {
        assertThat(TipoUf.BA.getSigla(), is(equalTo("BA")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante CE.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_CE() {
        assertThat(TipoUf.CE.getSigla(), is(equalTo("CE")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante DF.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DF() {
        assertThat(TipoUf.DF.getSigla(), is(equalTo("DF")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante ES.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ES() {
        assertThat(TipoUf.ES.getSigla(), is(equalTo("ES")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante GO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_GO() {
        assertThat(TipoUf.GO.getSigla(), is(equalTo("GO")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MA.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MA() {
        assertThat(TipoUf.MA.getSigla(), is(equalTo("MA")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MG.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MG() {
        assertThat(TipoUf.MG.getSigla(), is(equalTo("MG")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MS.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MS() {
        assertThat(TipoUf.MS.getSigla(), is(equalTo("MS")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MT.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MT() {
        assertThat(TipoUf.MT.getSigla(), is(equalTo("MT")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PA.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PA() {
        assertThat(TipoUf.PA.getSigla(), is(equalTo("PA")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PB.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PB() {
        assertThat(TipoUf.PB.getSigla(), is(equalTo("PB")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PE.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PE() {
        assertThat(TipoUf.PE.getSigla(), is(equalTo("PE")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PI.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PI() {
        assertThat(TipoUf.PI.getSigla(), is(equalTo("PI")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PR.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_PR() {
        assertThat(TipoUf.PR.getSigla(), is(equalTo("PR")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante RJ.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RJ() {
        assertThat(TipoUf.RJ.getSigla(), is(equalTo("RJ")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante RN.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RN() {
        assertThat(TipoUf.RN.getSigla(), is(equalTo("RN")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante RO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RO() {
        assertThat(TipoUf.RO.getSigla(), is(equalTo("RO")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante RR.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RR() {
        assertThat(TipoUf.RR.getSigla(), is(equalTo("RR")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante RS.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_RS() {
        assertThat(TipoUf.RS.getSigla(), is(equalTo("RS")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SC.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SC() {
        assertThat(TipoUf.SC.getSigla(), is(equalTo("SC")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SE.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SE() {
        assertThat(TipoUf.SE.getSigla(), is(equalTo("SE")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SP.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SP() {
        assertThat(TipoUf.SP.getSigla(), is(equalTo("SP")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante TO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_TO() {
        assertThat(TipoUf.TO.getSigla(), is(equalTo("TO")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoUf.class).testing(GETTER).areWellImplemented();
    }
    
}
