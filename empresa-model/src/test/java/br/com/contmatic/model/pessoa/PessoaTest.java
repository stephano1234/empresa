package br.com.contmatic.model.pessoa;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;

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

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.conta.Conta;
import br.com.contmatic.model.contato.Celular;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.pessoa.Pessoa;
import br.com.contmatic.model.pessoa.TipoEstadoCivil;
import br.com.contmatic.model.pessoa.TipoGrauInstrucao;
import br.com.contmatic.model.pessoa.TipoSexo;
import br.com.contmatic.templates.conta.ContaTemplateFixtureFactory;
import br.com.contmatic.templates.contato.CelularTemplateFixtureFactory;
import br.com.contmatic.templates.contato.EmailTemplateFixtureFactory;
import br.com.contmatic.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.contmatic.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class PessoaTest.
 */
public class PessoaTest {
    
    /** The pessoa. */
    private Pessoa pessoa;
    
    /** The outro pessoa. */
    private Pessoa outroPessoa;
    
    /** The enderecos. */
    private Set<Endereco> enderecos = new HashSet<Endereco>();
    
    /** The celulares. */
    private Set<Celular> celulares = new HashSet<Celular>();

    /** The telefones fixo. */
    private Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();
    
    /** The emails. */
    private Set<Email> emails = new HashSet<Email>();

    /** The contas. */
    private Set<Conta> contas = new HashSet<Conta>();
    
    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new PessoaTemplateFixtureFactory().load();
        new EnderecoTemplateFixtureFactory().load();
        new CelularTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();
        new EmailTemplateFixtureFactory().load();
        new ContaTemplateFixtureFactory().load();
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
        pessoa = Fixture.from(Pessoa.class).gimme("valido");
        outroPessoa = Fixture.from(Pessoa.class).gimme("outroValido");
        for (int i = 0; i < ELEMENTOS_ARRAY_GERADA; i++) {
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        	emails.add(Fixture.from(Email.class).gimme("valido"));
        	contas.add(Fixture.from(Conta.class).gimme("valido"));
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
     * Nao deve aceitar valor nulo no cpf.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cpf() {
        pessoa.setCpf(null);
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no cpf.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("maiorTamanhoCpf");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor menor que tamanho no cpf.
     */
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("menorTamanhoCpf");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no cpf.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("comUmCaractereInvalidoCpf");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor com apenas numeros repetidos no cpf.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_numeros_repetidos_no_cpf() {
        pessoa = Fixture.from(Pessoa.class).gimme("numerosRepetidosCpf");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar cpf com primeiro digito verificador invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_primeiro_digito_verificador_invalido() {
        pessoa = Fixture.from(Pessoa.class).gimme("comPrimeiroDigitoVerificadorInvalidoCpf");
        assertTrue(procuraAlgumErro(pessoa));
    }    

    /**
     * Nao deve aceitar cpf com segundo digito verificador invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_segundo_digito_verificador_invalido() {
        pessoa = Fixture.from(Pessoa.class).gimme("comSegundoDigitoVerificadorInvalidoCpf");
        assertTrue(procuraAlgumErro(pessoa));
    }    
    
    /**
     * Deve aceitar cpf valido.
     */
    @Test
    public void deve_aceitar_cpf_valido() {
        pessoa = Fixture.from(Pessoa.class).gimme("cpfValido");
        assertFalse(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor nulo no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_nome() {
        pessoa.setNome(null);
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor vazio no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_nome() {
    	pessoa.setNome("");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("maiorTamanhoNome");
        assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar valor com apenas um caractere no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_um_caractere_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("umCaractereNome");
        assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar valor com apenas espaco no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_espaco_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("apenasEspacoNome");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor com primeiro caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_invalido_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comPrimeiroCaractereInvalido");
        assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar valor com ultimo caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_ultimo_caractere_invalido_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comUltimoCaractereInvalido");
        assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar valor com um caractere invalido no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comUmCaractereInvalidoNome");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar valor com dois espacos juntos no nome.
     */
    @Test
    public void nao_deve_aceitar_valor_com_dois_espacos_juntos_no_nome() {
        pessoa = Fixture.from(Pessoa.class).gimme("comEspacoDuploNome");
        assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Deve aceitar nome valido.
     */
    @Test
    public void deve_aceitar_nome_valido() {
        pessoa = Fixture.from(Pessoa.class).gimme("validoNome");
        assertFalse(procuraAlgumErro(pessoa));
    }
        
    /**
     * Nao deve aceitar enderecos nulo.
     */
    @Test
    public void nao_deve_aceitar_enderecos_nulo() {
    	pessoa.setEnderecos(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar enderecos vazio.
     */
    @Test
    public void nao_deve_aceitar_enderecos_vazio() {
    	pessoa.setEnderecos(new HashSet<Endereco>());
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar enderecos com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_enderecos_com_pelo_menos_um_elemento_nulo() {
    	pessoa.getEnderecos().add(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar enderecos com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_enderecos_com_elemento_invalido() {
    	pessoa.getEnderecos().add(Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoCep"));
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar enderecos nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_enderecos_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	pessoa.setEnderecos(enderecos);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar data nascimento nulo.
     */
    @Test
    public void nao_deve_aceitar_dataNascimento_nulo() {
    	pessoa.setDataNascimento(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar data nascimento futura.
     */
    @Test
    public void nao_deve_aceitar_dataNascimento_futura() {
    	pessoa = Fixture.from(Pessoa.class).gimme("dataNascimentoFutura");
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar data nascimento passada.
     */
    @Test
    public void deve_aceitar_dataNascimento_passada() {
    	pessoa = Fixture.from(Pessoa.class).gimme("dataNascimentoPassada");
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar celulares nulo.
     */
    @Test
    public void deve_aceitar_celulares_nulo() {
    	pessoa.setCelulares(null);
    	assertFalse(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar celulares vazio.
     */
    @Test
    public void nao_deve_aceitar_celulares_vazio() {
    	pessoa.setCelulares(new HashSet<Celular>());
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar celulares com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_celulares_com_pelo_menos_um_elemento_nulo() {
    	pessoa.getCelulares().add(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar celulares com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_celulares_com_elemento_invalido() {
    	pessoa.getCelulares().add(Fixture.from(Celular.class).gimme("comUmCaractereInvalidoNumero"));
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar celulares nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_celulares_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	pessoa.setCelulares(celulares);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar telefones fixo nulo.
     */
    @Test
    public void deve_aceitar_telefonesFixo_nulo() {
    	pessoa.setTelefonesFixo(null);
    	assertFalse(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar telefones fixo vazio.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_vazio() {
    	pessoa.setTelefonesFixo(new HashSet<TelefoneFixo>());
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar telefones fixo com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_com_pelo_menos_um_elemento_nulo() {
    	pessoa.getTelefonesFixo().add(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar telefones fixo com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_com_elemento_invalido() {
    	pessoa.getTelefonesFixo().add(Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero"));
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar telefones fixo nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_telefonesFixo_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	pessoa.setTelefonesFixo(telefonesFixo);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar emails nulo.
     */
    @Test
    public void deve_aceitar_emails_nulo() {
    	pessoa.setEmails(null);
    	assertFalse(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar emails vazio.
     */
    @Test
    public void nao_deve_aceitar_emails_vazio() {
    	pessoa.setEmails(new HashSet<Email>());
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar emails com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_emails_com_pelo_menos_um_elemento_nulo() {
    	pessoa.getEmails().add(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar emails com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_emails_com_elemento_invalido() {
    	pessoa.getEmails().add(Fixture.from(Email.class).gimme("comUmCaractereInvalidoAntesArrobaEndereco"));
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar emails nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_emails_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	pessoa.setEmails(emails);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar tipo grau instrucao nulo.
     */
    @Test
    public void nao_deve_aceitar_tipoGrauInstrucao_nulo() {
    	pessoa.setTipoGrauInstrucao(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar tipo grau instrucao nao nulo.
     */
    @Test
    public void deve_aceitar_tipoGrauInstrucao_nao_nulo() {
    	pessoa.setTipoGrauInstrucao(TipoGrauInstrucao.ANALFABETO);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar tipo estado civil nulo.
     */
    @Test
    public void nao_deve_aceitar_tipoEstadoCivil_nulo() {
    	pessoa.setTipoEstadoCivil(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar tipo estado civil nao nulo.
     */
    @Test
    public void deve_aceitar_tipoEstadoCivil_nao_nulo() {
    	pessoa.setTipoEstadoCivil(TipoEstadoCivil.CASADO);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Nao deve aceitar tipo sexo nulo.
     */
    @Test
    public void nao_deve_aceitar_tipoSexo_nulo() {
    	pessoa.setTipoSexo(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar tipo sexo nao nulo.
     */
    @Test
    public void deve_aceitar_tipoSexo_nao_nulo() {
    	pessoa.setTipoSexo(TipoSexo.FEMININO);
    	assertFalse(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar contas nulo.
     */
    @Test
    public void deve_aceitar_contas_nulo() {
    	pessoa.setContas(null);
    	assertFalse(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar contas vazio.
     */
    @Test
    public void nao_deve_aceitar_contas_vazio() {
    	pessoa.setContas(new HashSet<Conta>());
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar contas com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_contas_com_pelo_menos_um_elemento_nulo() {
    	pessoa.getContas().add(null);
    	assertTrue(procuraAlgumErro(pessoa));
    }
    
    /**
     * Nao deve aceitar contas com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_contas_com_elemento_invalido() {
    	pessoa.getContas().add(Fixture.from(Conta.class).gimme("comUmCaractereInvalidoNumero"));
    	assertTrue(procuraAlgumErro(pessoa));
    }

    /**
     * Deve aceitar contas nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_contas_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	pessoa.setContas(contas);
    	assertFalse(procuraAlgumErro(pessoa));
    }
    
    /**
     * Gets the cpf deve trazer o valor armazenado em cpf.
     *
     * @return the cpf deve trazer o valor armazenado em cpf
     */
    @Test
    public void getCpf_deve_trazer_o_valor_armazenado_em_cpf() {
        pessoa.setCpf("28361440844");
        assertThat(pessoa.getCpf(), is(equalTo("28361440844")));
    }
    
    /**
     * Gets the nome deve trazer o valor armazenado em nome.
     *
     * @return the nome deve trazer o valor armazenado em nome
     */
    @Test
    public void getNome_deve_trazer_o_valor_armazenado_em_nome() {
        pessoa.setNome("Gabriel Marques");
        assertThat(pessoa.getNome(), is(equalTo("Gabriel Marques")));
    }
    
    /**
     * Gets the enderecos deve trazer o valor armazenado em enderecos.
     *
     * @return the enderecos deve trazer o valor armazenado em enderecos
     */
    @Test
    public void getEnderecos_deve_trazer_o_valor_armazenado_em_enderecos() {
        pessoa.setEnderecos(enderecos);
        assertThat(pessoa.getEnderecos(), is(equalTo(enderecos)));
    }
    
    /**
     * Gets the data nascimento deve trazer o valor armazenado em data nascimento.
     *
     * @return the data nascimento deve trazer o valor armazenado em data nascimento
     */
    @Test
    public void getDataNascimento_deve_trazer_o_valor_armazenado_em_dataNascimento() {
        pessoa.setDataNascimento(LocalDate.parse("1990-02-12"));
        assertThat(pessoa.getDataNascimento(), is(equalTo(LocalDate.parse("1990-02-12"))));
    }

    /**
     * Gets the celulares deve trazer o valor armazenado em celulares.
     *
     * @return the celulares deve trazer o valor armazenado em celulares
     */
    @Test
    public void getCelulares_deve_trazer_o_valor_armazenado_em_celulares() {
        pessoa.setCelulares(celulares);
        assertThat(pessoa.getCelulares(), is(equalTo(celulares)));
    }
    
    /**
     * Gets the telefones fixo deve trazer o valor armazenado em telefones fixo.
     *
     * @return the telefones fixo deve trazer o valor armazenado em telefones fixo
     */
    @Test
    public void getTelefonesFixo_deve_trazer_o_valor_armazenado_em_telefonesFixo() {
        pessoa.setTelefonesFixo(telefonesFixo);
        assertThat(pessoa.getTelefonesFixo(), is(equalTo(telefonesFixo)));
    }
    
    /**
     * Gets the emails deve trazer o valor armazenado em emails.
     *
     * @return the emails deve trazer o valor armazenado em emails
     */
    @Test
    public void getEmails_deve_trazer_o_valor_armazenado_em_emails() {
        pessoa.setEmails(emails);
        assertThat(pessoa.getEmails(), is(equalTo(emails)));
    }

    /**
     * Gets the tipo grau instrucao deve trazer o valor armazenado em tipo grau instrucao.
     *
     * @return the tipo grau instrucao deve trazer o valor armazenado em tipo grau instrucao
     */
    @Test
    public void getTipoGrauInstrucao_deve_trazer_o_valor_armazenado_em_tipoGrauInstrucao() {
        pessoa.setTipoGrauInstrucao(TipoGrauInstrucao.ANALFABETO);
        assertThat(pessoa.getTipoGrauInstrucao(), is(equalTo(TipoGrauInstrucao.ANALFABETO)));
    }
    
    /**
     * Gets the tipo estado civil deve trazer o valor armazenado em tipo estado civil.
     *
     * @return the tipo estado civil deve trazer o valor armazenado em tipo estado civil
     */
    @Test
    public void getTipoEstadoCivil_deve_trazer_o_valor_armazenado_em_tipoEstadoCivil() {
        pessoa.setTipoEstadoCivil(TipoEstadoCivil.CASADO);
        assertThat(pessoa.getTipoEstadoCivil(), is(equalTo(TipoEstadoCivil.CASADO)));
    }
    
    /**
     * Gets the tipo sexo deve trazer o valor armazenado em tipo sexo.
     *
     * @return the tipo sexo deve trazer o valor armazenado em tipo sexo
     */
    @Test
    public void getTipoSexo_deve_trazer_o_valor_armazenado_em_tipoSexo() {
        pessoa.setTipoSexo(TipoSexo.FEMININO);
        assertThat(pessoa.getTipoSexo(), is(equalTo(TipoSexo.FEMININO)));
    }
    
    /**
     * Gets the contas deve trazer o valor armazenado em contas.
     *
     * @return the contas deve trazer o valor armazenado em contas
     */
    @Test
    public void getContas_deve_trazer_o_valor_armazenado_em_contas() {
        pessoa.setContas(contas);
        assertThat(pessoa.getContas(), is(equalTo(contas)));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Pessoa.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Pessoa.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"28361440844", "Gabriel Marques", enderecos, LocalDate.parse("1990-02-12"), TipoGrauInstrucao.ANALFABETO, TipoEstadoCivil.CASADO, TipoSexo.FEMININO};
        assertTrue(verificaConstrutor(Pessoa.class, valores, String.class, String.class, Set.class, LocalDate.class, TipoGrauInstrucao.class, TipoEstadoCivil.class, TipoSexo.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com cpf igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_cpf_igual() {
        outroPessoa.setCpf(pessoa.getCpf());
        assertThat(pessoa.hashCode(), is(equalTo(outroPessoa.hashCode())));
    }
        
    /**
     * Hashcode deve retornar diferentes codigos com cpf diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cpf_diferente() {
        assertThat(pessoa.hashCode(), is(not(equalTo(outroPessoa.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com cpf igual.
     */
    @Test
    public void equals_deve_retornar_true_com_cpf_igual() {
        outroPessoa.setCpf(pessoa.getCpf());
        assertTrue(pessoa.equals(outroPessoa));
    }
        
    /**
     * Equals deve retornar false com cpf diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_cpf_diferente() {
        assertFalse(pessoa.equals(outroPessoa));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Pessoa.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo cpf no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cpf_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setCpf("28361440844");
        assertTrue(pessoa.toString().contains("28361440844"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo nome no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_nome_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setNome("Gabriel Marques");
        assertTrue(pessoa.toString().contains("Gabriel Marques"));
    }

    /**
     * Verifica existencia do texto que representa o atributo enderecos no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_enderecos_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setEnderecos(enderecos);
        assertTrue(pessoa.toString().contains(enderecos.toString()));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo data nascimento no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_dataNascimento_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setDataNascimento(LocalDate.parse("1990-02-12"));
        assertTrue(pessoa.toString().contains("1990-02-12"));
    }

    /**
     * Verifica existencia do texto que representa o atributo celulares no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_celulares_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setCelulares(celulares);
        assertTrue(pessoa.toString().contains(celulares.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo celulares nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_celulares_nulo() {
        pessoa.setCelulares(null);
        assertTrue(pessoa.toString().contains("Sem celular"));
    }

    /**
     * Verifica existencia do texto que representa o atributo telefones fixo no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_telefonesFixo_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTelefonesFixo(telefonesFixo);
        assertTrue(pessoa.toString().contains(telefonesFixo.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo telefones fixo nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_telefonesFixo_nulo() {
        pessoa.setTelefonesFixo(null);
        assertTrue(pessoa.toString().contains("Sem telefone fixo"));
    }

    /**
     * Verifica existencia do texto que representa o atributo emails no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_emails_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setEmails(emails);
        assertTrue(pessoa.toString().contains(emails.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo emails nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_emails_nulo() {
        pessoa.setEmails(null);
        assertTrue(pessoa.toString().contains("Sem e-mail"));
    }

    /**
     * Verifica existencia do texto que representa o atributo tipo grau instrucao no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoGrauInstrucao_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTipoGrauInstrucao(TipoGrauInstrucao.ANALFABETO);
        assertTrue(pessoa.toString().contains(TipoGrauInstrucao.ANALFABETO.name()));
    }

    /**
     * Verifica existencia do texto que representa o atributo tipo estado civil no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoEstadoCivil_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTipoEstadoCivil(TipoEstadoCivil.CASADO);
        assertTrue(pessoa.toString().contains(TipoEstadoCivil.CASADO.name()));
    }

    /**
     * Verifica existencia do texto que representa o atributo tipo sexo no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoSexo_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setTipoSexo(TipoSexo.FEMININO);
        assertTrue(pessoa.toString().contains(TipoSexo.FEMININO.name()));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo contas no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_contas_no_texto_gerado_pelo_metodo_toString() {
        pessoa.setContas(contas);
        assertTrue(pessoa.toString().contains(contas.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo contas nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_contas_nulo() {
        pessoa.setContas(null);
        assertTrue(pessoa.toString().contains("Sem conta banc\\u00E1ria"));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(pessoa));
    }
    
}
