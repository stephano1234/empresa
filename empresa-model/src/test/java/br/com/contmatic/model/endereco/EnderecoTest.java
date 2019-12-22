package br.com.contmatic.model.endereco;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;

import static br.com.contmatic.utilidades.Verificadores.procuraAlgumErro;
import static br.com.contmatic.utilidades.Verificadores.verificaConstrutor;
import static br.com.contmatic.utilidades.Verificadores.verificaToStringJSONSTYLE;

import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.NONFINAL_FIELDS;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.endereco.Logradouro;
import br.com.contmatic.model.endereco.TipoEndereco;
import br.com.contmatic.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.contmatic.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.templates.endereco.LogradouroTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

    /** The endereco. */
    private Endereco endereco;
    
    /** The outro endereco. */
    private Endereco outroEndereco;
    
    /** The logradouro. */
    private Logradouro logradouro;
    
    /** The telefones fixo. */
    private Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();
    
    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new EnderecoTemplateFixtureFactory().load();
        new LogradouroTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();
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
        endereco = Fixture.from(Endereco.class).gimme("valido");
        outroEndereco = Fixture.from(Endereco.class).gimme("outroValido");
        logradouro = Fixture.from(Logradouro.class).gimme("valido");
        for (int i = 0; i < nextInt(1, ELEMENTOS_ARRAY_GERADA); i++) {
            telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        }
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
     * Nao deve aceitar valor nulo no cep.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cep() {
        endereco.setCep(null);
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no cep.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("maiorTamanhoCep");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor menor que tamanho no cep.
     */
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("menorTamanhoCep");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no cep.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_cep() {
        endereco = Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoCep");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar cep valido.
     */
    @Test
    public void deve_aceitar_cep_valido() {
        endereco = Fixture.from(Endereco.class).gimme("validoCep");
        assertFalse(procuraAlgumErro(endereco));
    }

    /**
     * Deve aceitar valor nulo no numero.
     */
    @Test
    public void deve_aceitar_valor_nulo_no_numero() {
    	endereco.setNumero(null);
    	assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor vazio no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_numero() {
        endereco.setNumero("");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("maiorTamanhoNumero");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no numero.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_numero() {
        endereco = Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoNumero");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar numero valido.
     */
    @Test
    public void deve_aceitar_numero_valido() {
        endereco = Fixture.from(Endereco.class).gimme("validoNumero");
        assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar valor nulo no complemento.
     */
    @Test
    public void deve_aceitar_valor_nulo_no_complemento() {
    	endereco.setComplemento(null);
    	assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor vazio no complemento.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_complemento() {
        endereco.setComplemento("");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no complemento.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("maiorTamanhoComplemento");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor com apenas espaco no complemento.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_complemento() {
        endereco = Fixture.from(Endereco.class).gimme("apenasEspacoComplemento");
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar complemento valido.
     */
    @Test
    public void deve_aceitar_complemento_valido() {
        endereco = Fixture.from(Endereco.class).gimme("validoComplemento");
        assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor nulo no logradouro.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_logradouro() {
        endereco.setLogradouro(null);
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar logradouro invalido.
     */
    @Test
    public void nao_deve_aceitar_logradouro_invalido() {
        endereco.setLogradouro(Fixture.from(Logradouro.class).gimme("comUmCaractereInvalidoNome"));
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar logradouro nao nulo valido.
     */
    @Test
    public void deve_aceitar_logradouro_nao_nulo_valido() {
        endereco.setLogradouro(logradouro);
        assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar valor nulo no telefones fixo.
     */
    @Test
    public void deve_aceitar_valor_nulo_no_telefonesFixo() {
    	endereco.setTelefonesFixo(null);
    	assertFalse(procuraAlgumErro(endereco));
    }

    /**
     * Nao deve aceitar telefones fixo vazio.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_vazio() {
        endereco.setTelefonesFixo(new HashSet<TelefoneFixo>());
        assertTrue(procuraAlgumErro(endereco));
    }

    /**
     * Nao deve aceitar telefones fixo com elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_com_elemento_nulo() {
        endereco.getTelefonesFixo().add(null);
    	assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar telefones fixo com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_com_elemento_invalido() {
    	endereco.getTelefonesFixo().add(Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero"));
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar telefones fixo nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_telefonesFixo_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
        endereco.setTelefonesFixo(telefonesFixo);
        assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Nao deve aceitar valor nulo no tipo endereco.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_tipoEndereco() {
        endereco.setTipoEndereco(null);
        assertTrue(procuraAlgumErro(endereco));
    }
    
    /**
     * Deve aceitar valor nao nulo no tipo endereco.
     */
    @Test
    public void deve_aceitar_valor_nao_nulo_no_tipoEndereco() {
        endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
        assertFalse(procuraAlgumErro(endereco));
    }
    
    /**
     * Gets the cep deve trazer o valor armazenado em cep.
     *
     * @return the cep deve trazer o valor armazenado em cep
     */
    @Test
    public void getCep_deve_trazer_o_valor_armazenado_em_cep() {
        endereco.setCep("22223333");
        assertThat(endereco.getCep(), is(equalTo("22223333")));
    }
    
    /**
     * Gets the numero deve trazer o valor armazenado em numero.
     *
     * @return the numero deve trazer o valor armazenado em numero
     */
    @Test
    public void getNumero_deve_trazer_o_valor_armazenado_em_numero() {
        endereco.setNumero("701");
        assertThat(endereco.getNumero(), is(equalTo("701")));
    }
    
    /**
     * Gets the complemento deve trazer o valor armazenado em complemento.
     *
     * @return the complemento deve trazer o valor armazenado em complemento
     */
    @Test
    public void getComplemento_deve_trazer_o_valor_armazenado_em_complemento() {
        endereco.setComplemento("LADO B");
        assertThat(endereco.getComplemento(), is(equalTo("LADO B")));
    }
    
    /**
     * Gets the logradouro deve trazer o valor armazenado em logradouro.
     *
     * @return the logradouro deve trazer o valor armazenado em logradouro
     */
    @Test
    public void getLogradouro_deve_trazer_o_valor_armazenado_em_logradouro() {
        endereco.setLogradouro(logradouro);
        assertThat(endereco.getLogradouro(), is(equalTo(logradouro)));
    }
    
    /**
     * Gets the telefone fixo deve trazer o valor armazenado em telefones fixo.
     *
     * @return the telefone fixo deve trazer o valor armazenado em telefones fixo
     */
    @Test
    public void getTelefoneFixo_deve_trazer_o_valor_armazenado_em_telefonesFixo() {
        endereco.setTelefonesFixo(telefonesFixo);
        assertThat(endereco.getTelefonesFixo(), is(equalTo(telefonesFixo)));
    }
    
    /**
     * Gets the tipo endereco deve trazer o valor armazenado em tipo endereco.
     *
     * @return the tipo endereco deve trazer o valor armazenado em tipo endereco
     */
    @Test
    public void getTipoEndereco_deve_trazer_o_valor_armazenado_em_tipoEndereco() {
        endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
        assertThat(endereco.getTipoEndereco(), is(equalTo(TipoEndereco.COMERCIAL)));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Endereco.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Endereco.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"21210090", "340", logradouro, TipoEndereco.COMERCIAL};
        assertTrue(verificaConstrutor(Endereco.class, valores, String.class, String.class, Logradouro.class, TipoEndereco.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com cep numero logradouro igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_cep_numero_logradouro_igual() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(equalTo(outroEndereco.hashCode())));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com cep numero igual logradouro diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_numero_igual_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com cep logradouro igual numero diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_logradouro_igual_numero_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com cep igual numero logradouro diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_igual_numero_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero igual cep logradouro diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_igual_cep_logradouro_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com numero logradouro igual cep diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_numero_logradouro_igual_cep_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com logradouro igual cep numero diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_logradouro_igual_cep_numero_diferente() {
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
    
    /**
     * Hashcode deve retornar diferentes codigos com cep numero logradouro diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cep_numero_logradouro_diferente() {
        assertThat(endereco.hashCode(), is(not(equalTo(outroEndereco.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com cep numero logradouro igual.
     */
    @Test
    public void equals_deve_retornar_true_com_cep_numero_logradouro_igual() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertTrue(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com cep numero igual logradouro diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_cep_numero_igual_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setNumero(endereco.getNumero());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com cep logradouro igual numero diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_cep_logradouro_igual_numero_diferente() {
        outroEndereco.setCep(endereco.getCep());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com cep igual numero logradouro diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_cep_igual_numero_logradouro_diferente() {
        outroEndereco.setCep(endereco.getCep());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com numero igual cep logradouro diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_igual_cep_logradouro_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com numero logradouro igual cep diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_numero_logradouro_igual_cep_diferente() {
        outroEndereco.setNumero(endereco.getNumero());
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com logradouro igual cep numero diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_logradouro_igual_cep_numero_diferente() {
        outroEndereco.setLogradouro(endereco.getLogradouro());
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Equals deve retornar false com cep numero logradouro diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_cep_numero_logradouro_diferente() {
        assertFalse(endereco.equals(outroEndereco));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Endereco.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo cep no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cep_no_texto_gerado_pelo_metodo_toString() {
        endereco.setCep("22223333");
        assertTrue(endereco.toString().contains("22223333"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo numero no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_numero_no_texto_gerado_pelo_metodo_toString() {
        endereco.setNumero("701");
        assertTrue(endereco.toString().contains("701"));
    }
    
    /**
     * Verifica texto gerado pelo metodo to string quando atributo numero nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_numero_nulo() {
        endereco.setNumero(null);
        assertTrue(endereco.toString().contains("Sem n\\u00FAmero"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo complemento no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_complemento_no_texto_gerado_pelo_metodo_toString() {
        endereco.setComplemento("CASA");
        assertTrue(endereco.toString().contains("CASA"));
    }
    
    /**
     * Verifica texto gerado pelo metodo to string quando atributo complemento nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_complemento_nulo() {
        endereco.setComplemento(null);
        assertTrue(endereco.toString().contains("Sem informa\\u00E7\\u00F5es adicionais do endere\\u00E7o"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo logradouro no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_logradouro_no_texto_gerado_pelo_metodo_toString() {
        endereco.setLogradouro(logradouro);
        assertTrue(endereco.toString().contains(logradouro.toString()));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo telefones fixo no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_telefonesFixo_no_texto_gerado_pelo_metodo_toString() {
        endereco.setTelefonesFixo(telefonesFixo);
        assertTrue(endereco.toString().contains(telefonesFixo.toString()));
    }
    
    /**
     * Verifica texto gerado pelo metodo to string quando atributo telefone fixo nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_telefoneFixo_nulo() {
        endereco.setTelefonesFixo(null);
        assertTrue(endereco.toString().contains("Sem telefone fixo atrelado a este endere\\u00E7o"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo tipo endereco no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoEndereco_no_texto_gerado_pelo_metodo_toString() {
        endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
        assertTrue(endereco.toString().contains(TipoEndereco.COMERCIAL.name()));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(endereco));
    }
    
}
