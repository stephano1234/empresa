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

import br.com.contmatic.model.pessoa.TipoGrauInstrucao;

/**
 * The Class TipoGrauInstrucaoTest.
 */
public class TipoGrauInstrucaoTest {

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
     * Verifica valor do atributo descricao da constante ANALFABETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ANALFABETO() {
        assertThat(TipoGrauInstrucao.ANALFABETO.getDescricao(), is(equalTo("Analfabeto")));
    }

    /**
     * Verifica valor do atributo descricao da constante AT E 5 AN O INCOMPLET O ENSIN O FUNDAMENTAL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ATE_5_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL() {
        assertThat(TipoGrauInstrucao.ATE_5_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL.getDescricao(), is(equalTo("Até o 5º ano incompleto do Ensino Fundamental")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante O 5 AN O COMPLET O ENSIN O FUNDAMENTAL.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_O_5_ANO_COMPLETO_ENSINO_FUNDAMENTAL() {
        assertThat(TipoGrauInstrucao.O_5_ANO_COMPLETO_ENSINO_FUNDAMENTAL.getDescricao(), is(equalTo("5º ano completo do Ensino Fundamental")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante D O 6 A O 9 AN O ENSIN O FUNDAMENTA L INCOMPLETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DO_6_AO_9_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO() {
        assertThat(TipoGrauInstrucao.DO_6_AO_9_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO.getDescricao(), is(equalTo("Do 6º ao 9º ano do Ensino Fundamental incompleto")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante ENSIN O FUNDAMENTA L COMPLETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ENSINO_FUNDAMENTAL_COMPLETO() {
        assertThat(TipoGrauInstrucao.ENSINO_FUNDAMENTAL_COMPLETO.getDescricao(), is(equalTo("Ensino Fundamental completo")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante ENSIN O MEDI O INCOMPLETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ENSINO_MEDIO_INCOMPLETO() {
        assertThat(TipoGrauInstrucao.ENSINO_MEDIO_INCOMPLETO.getDescricao(), is(equalTo("Ensino Médio incompleto")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante ENSIN O MEDI O COMPLETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_ENSINO_MEDIO_COMPLETO() {
        assertThat(TipoGrauInstrucao.ENSINO_MEDIO_COMPLETO.getDescricao(), is(equalTo("Ensino Médio completo")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SUPERIO R INCOMPLETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SUPERIOR_INCOMPLETO() {
        assertThat(TipoGrauInstrucao.SUPERIOR_INCOMPLETO.getDescricao(), is(equalTo("Superior incompleto")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante SUPERIO R COMPLETO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_SUPERIOR_COMPLETO() {
        assertThat(TipoGrauInstrucao.SUPERIOR_COMPLETO.getDescricao(), is(equalTo("Superior completo")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PO S GRADUACA O ESPECIALIZACAO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_POS_GRADUACAO_ESPECIALIZACAO() {
        assertThat(TipoGrauInstrucao.POS_GRADUACAO_ESPECIALIZACAO.getDescricao(), is(equalTo("Pós-Graduação / Especialização")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante MESTRADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_MESTRADO() {
        assertThat(TipoGrauInstrucao.MESTRADO.getDescricao(), is(equalTo("Mestrado")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante DOUTORADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_DOUTORADO() {
        assertThat(TipoGrauInstrucao.DOUTORADO.getDescricao(), is(equalTo("Doutorado")));
    }
    
    /**
     * Verifica valor do atributo descricao da constante PO S DOUTORADO.
     */
    @Test
    public void verifica_valor_do_atributo_descricao_da_constante_POS_DOUTORADO() {
        assertThat(TipoGrauInstrucao.POS_DOUTORADO.getDescricao(), is(equalTo("Pós-Doutorado")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(TipoGrauInstrucao.class).testing(GETTER).areWellImplemented();
    }
    
}
