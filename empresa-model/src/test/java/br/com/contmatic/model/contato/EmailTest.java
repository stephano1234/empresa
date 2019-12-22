package br.com.contmatic.model.contato;

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

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.templates.contato.EmailTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class EmailTest.
 */
public class EmailTest {
    
    /** The email. */
    private Email email;
    
    /** The outro email. */
    private Email outroEmail;

    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new EmailTemplateFixtureFactory().load();
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
        email = Fixture.from(Email.class).gimme("valido");
        outroEmail = Fixture.from(Email.class).gimme("outroValido");
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
     * Nao deve aceitar valor nulo no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_endereco() {
        email.setEndereco(null);
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor vazio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_endereco() {
        email.setEndereco("");
        assertTrue(procuraAlgumErro(email));
    }
        
    /**
     * Nao deve aceitar valor sem arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_sem_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("semArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor com arroba precedido por caractere invalido no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_arroba_precedido_por_caractere_invalido_no_endereco() {
        email = Fixture.from(Email.class).gimme("comArrobaPrecedidoPorCaractereInvalidoEndereco");
        assertTrue(procuraAlgumErro(email));
    }

    /**
     * Nao deve aceitar valor com mais de um arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_mais_de_um_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("comMaisDeUmArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor sem ponto no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_sem_ponto_no_endereco() {
        email = Fixture.from(Email.class).gimme("semPontoEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Deve aceitar valor valido no endereco.
     */
    @Test
    public void deve_aceitar_valor_valido_no_endereco() {
        email = Fixture.from(Email.class).gimme("validoEndereco");
        assertFalse(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor vazio antes do arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_antes_do_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("vazioAntesArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }

    /**
     * Nao deve aceitar valor maior que tamanho antes do arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_antes_do_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("maiorTamanhoAntesArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }

    /**
     * Nao deve aceitar primeiro valor invalido antes do arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_primeiro_valor_invalido_antes_do_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("primeiroCaractereInvalidoAntesArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido antes do arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_antes_do_arroba_no_endereco() {
    	email = Fixture.from(Email.class).gimme("comUmCaractereInvalidoAntesArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Deve aceitar valor valido antes do arroba no endereco.
     */
    @Test
    public void deve_aceitar_valor_valido_antes_do_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("randomValidoAntesArrobaEndereco");
        assertFalse(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor vazio depois do arroba antes do ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_depois_do_arroba_antes_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("vazioDepoisArrobaAtePontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }

    /**
     * Nao deve aceitar valor maior que tamanho depois do arroba antes do ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_depois_do_arroba_antes_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("maiorTamanhoDepoisArrobaAtePontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }

    /**
     * Nao deve aceitar primeiro valor invalido depois do arroba antes do ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_primeiro_valor_invalido_depois_do_arroba_antes_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("primeiroCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido depois do arroba antes do ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_depois_do_arroba_antes_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("comUmCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor sem ponto obrigatorio depois do arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_sem_ponto_obrigatorio_depois_do_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("semPontoObrigatorioDepoisArrobaEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor com ponto precedido por caractere invalido depois do arroba no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_ponto_precedido_por_caractere_invalido_depois_do_arroba_no_endereco() {
        email = Fixture.from(Email.class).gimme("comPontoObrigatorioPrecedidoPorCaractereInvalidoEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Deve aceitar valor valido depois do arroba antes do ponto obrigatorio no endereco.
     */
    @Test
    public void deve_aceitar_valor_valido_depois_do_arroba_antes_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("randomValidoDepoisArrobaAtePontoObrigatorioEndereco");
        assertFalse(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor menor que tamanho depois do ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_depois_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("menorTamanhoDepoisPontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho depois do ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_depois_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("maiorTamanhoDepoisPontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }
        
    /**
     * Nao deve aceitar valor com um caractere invalido depois ponto obrigatorio no endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_depois_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("comUmCaractereInvalidoDepoisPontoObrigatorioEndereco");
        assertTrue(procuraAlgumErro(email));
    }
    
    /**
     * Deve aceitar valor valido depois do ponto obrigatorio no endereco.
     */
    @Test
    public void deve_aceitar_valor_valido_depois_do_ponto_obrigatorio_no_endereco() {
        email = Fixture.from(Email.class).gimme("randomValidoDepoisPontoObrigatorioEndereco");
        assertFalse(procuraAlgumErro(email));
    }
    
    /**
     * Gets the endereco deve trazer o valor armazenado em endereco.
     *
     * @return the endereco deve trazer o valor armazenado em endereco
     */
    @Test
    public void getEndereco_deve_trazer_o_valor_armazenado_em_endereco() {
        email.setEndereco("teste@teste.teste");
        assertThat(email.getEndereco(), is(equalTo("teste@teste.teste")));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Email.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Email.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"teste@teste.teste"};
        assertTrue(verificaConstrutor(Email.class, valores, String.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com endereco igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_endereco_igual() {
        outroEmail.setEndereco(email.getEndereco());
        assertThat(email.hashCode(), is(equalTo(outroEmail.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com endereco diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_endereco_diferente() {
        assertThat(email.hashCode(), is(not(equalTo(outroEmail.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com endereco igual.
     */
    @Test
    public void equals_deve_retornar_true_com_endereco_igual() {
        outroEmail.setEndereco(email.getEndereco());
        assertTrue(email.equals(outroEmail));
    }
    
    /**
     * Equals deve retornar false com endereco diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_endereco_diferente() {
        assertFalse(email.equals(outroEmail));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Email.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo endereco no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_endereco_no_texto_gerado_pelo_metodo_toString() {
        email.setEndereco("teste@teste.teste");
        assertTrue(email.toString().contains("teste@teste.teste"));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(email));
    }
    
}
