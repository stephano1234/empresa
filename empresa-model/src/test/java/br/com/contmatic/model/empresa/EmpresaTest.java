package br.com.contmatic.model.empresa;

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
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.TipoEmpresa;
import br.com.contmatic.model.empresa.TipoPorteEmpresa;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.pessoa.ContratoTrabalho;
import br.com.contmatic.model.pessoa.Pessoa;
import br.com.contmatic.templates.conta.ContaTemplateFixtureFactory;
import br.com.contmatic.templates.contato.CelularTemplateFixtureFactory;
import br.com.contmatic.templates.contato.EmailTemplateFixtureFactory;
import br.com.contmatic.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.contmatic.templates.empresa.EmpresaTemplateFixtureFactory;
import br.com.contmatic.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.templates.pessoa.ContratoTrabalhoTemplateFixtureFactory;
import br.com.contmatic.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {
    
    /** The empresa. */
    private Empresa empresa;
    
    /** The outro empresa. */
    private Empresa outroEmpresa;
    
    /** The responsaveis. */
    private Set<Pessoa> responsaveis = new HashSet<Pessoa>();
    
    /** The contratos trabalho. */
    private Set<ContratoTrabalho> contratosTrabalho = new HashSet<ContratoTrabalho>();
    
    /** The enderecos. */
    private Set<Endereco> enderecos = new HashSet<Endereco>();
        
    /** The telefones fixo. */
    private Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();

    /** The emails. */
    private Set<Email> emails = new HashSet<Email>();
    
    /** The celulares. */
    private Set<Celular> celulares = new HashSet<Celular>();

    /** The contas. */
    private Set<Conta> contas = new HashSet<Conta>();

    /**
     * Sets the up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        new EmpresaTemplateFixtureFactory().load();
        new PessoaTemplateFixtureFactory().load();
        new ContratoTrabalhoTemplateFixtureFactory().load();
        new EnderecoTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();
        new EmailTemplateFixtureFactory().load();
        new CelularTemplateFixtureFactory().load();
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
        empresa = Fixture.from(Empresa.class).gimme("valido");
        outroEmpresa = Fixture.from(Empresa.class).gimme("outroValido");
        for (int i = 0; i < nextInt(1, ELEMENTOS_ARRAY_GERADA); i++) {
        	responsaveis.add(Fixture.from(Pessoa.class).gimme("valido"));
        	contratosTrabalho.add(Fixture.from(ContratoTrabalho.class).gimme("valido"));
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));        	
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));
        	emails.add(Fixture.from(Email.class).gimme("valido"));
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));
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
     * Nao deve aceitar valor nulo no cnpj.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_cnpj() {
        empresa.setCnpj(null);
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no cnpj.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("maiorTamanhoCnpj");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor menor que tamanho no cnpj.
     */
    @Test
    public void nao_deve_aceitar_valor_menor_que_tamanho_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("menorTamanhoCnpj");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no cnpj.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("comUmCaractereInvalidoCnpj");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor com apenas numeros repetidos no cnpj.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_numeros_repetidos_no_cnpj() {
        empresa = Fixture.from(Empresa.class).gimme("numerosRepetidosCnpj");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar cnpj com primeiro digito verificador invalido.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_primeiro_digito_verificador_invalido() {
        empresa = Fixture.from(Empresa.class).gimme("comPrimeiroDigitoVerificadorInvalidoCnpj");
        assertTrue(procuraAlgumErro(empresa));
    }    

    /**
     * Nao deve aceitar cnpj com segundo digito verificador invalido.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_segundo_digito_verificador_invalido() {
        empresa = Fixture.from(Empresa.class).gimme("comSegundoDigitoVerificadorInvalidoCnpj");
        assertTrue(procuraAlgumErro(empresa));
    }    

    /**
     * Deve aceitar cnpj valido.
     */
    @Test
    public void deve_aceitar_cnpj_valido() {
        empresa = Fixture.from(Empresa.class).gimme("cnpjValido");
        assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor nulo no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_nulo_no_razaoSocial() {
        empresa.setRazaoSocial(null);
        assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Nao deve aceitar valor vazio no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_vazio_no_razaoSocial() {
    	empresa.setRazaoSocial("");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor maior que tamanho no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_maior_que_tamanho_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("maiorTamanhoRazaoSocial");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor com apenas um caractere razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_apenas_um_caractere_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("umCaractereRazaoSocial");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor com primeiro caractere invalido no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_primeiro_caractere_invalido_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comPrimeiroCaractereInvalido");
        assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Nao deve aceitar valor com ultimo caractere invalido no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_ultimo_caractere_invalido_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comUltimoCaractereInvalido");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor com um caractere invalido no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_um_caractere_invalido_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comUmCaractereInvalidoRazaoSocial");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar valor com dois espacos juntos no razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_dois_espacos_juntos_no_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comEspacoDuploRazaoSocial");
        assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Nao deve aceitar valor com dois pontos juntos no meio do razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_dois_pontos_juntos_no_meio_do_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comPontoDuploRazaoSocial");
        assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Nao deve aceitar valor com dois pontos juntos no final do razao social.
     */
    @Test
    public void nao_deve_aceitar_valor_com_dois_pontos_juntos_no_final_do_razaoSocial() {
        empresa = Fixture.from(Empresa.class).gimme("comPontoDuploNoFinalRazaoSocial");
        assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Deve aceitar razao social valido.
     */
    @Test
    public void deve_aceitar_razaoSocial_valido() {
        empresa = Fixture.from(Empresa.class).gimme("razaoSocialValido");
        assertFalse(procuraAlgumErro(empresa));
    }

    /**
     * Nao deve aceitar data abertura nulo.
     */
    @Test
    public void nao_deve_aceitar_dataAbertura_nulo() {
    	empresa.setDataAbertura(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar data abertura futura.
     */
    @Test
    public void nao_deve_aceitar_dataAbertura_futura() {
    	empresa = Fixture.from(Empresa.class).gimme("dataAberturaFutura");
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar data abertura passada.
     */
    @Test
    public void deve_aceitar_dataAbertura_passada() {
    	empresa = Fixture.from(Empresa.class).gimme("dataAberturaPassada");
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar responsaveis nulo.
     */
    @Test
    public void nao_deve_aceitar_responsaveis_nulo() {
    	empresa.setResponsaveis(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar responsaveis vazio.
     */
    @Test
    public void nao_deve_aceitar_responsaveis_vazio() {
    	empresa.setResponsaveis(new HashSet<Pessoa>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar responsaveis com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_responsaveis_com_pelo_menos_um_elemento_nulo() {
    	empresa.getResponsaveis().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar responsaveis com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_responsaveis_com_elemento_invalido() {
    	empresa.getResponsaveis().add(Fixture.from(Pessoa.class).gimme("comSegundoDigitoVerificadorInvalidoCpf"));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar responsaveis nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_responsaveis_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setResponsaveis(responsaveis);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Deve aceitar contratos trabalho nulo.
     */
    @Test
    public void deve_aceitar_contratosTrabalho_nulo() {
    	empresa.setContratosTrabalho(null);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar contratos trabalho vazio.
     */
    @Test
    public void nao_deve_aceitar_contratosTrabalho_vazio() {
    	empresa.setContratosTrabalho(new HashSet<ContratoTrabalho>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar contratos trabalho com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_contratosTrabalho_com_pelo_menos_um_elemento_nulo() {
    	empresa.getContratosTrabalho().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
       
    /**
     * Nao deve aceitar contratos trabalho com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_contratosTrabalho_com_elemento_invalido() {
    	empresa.getContratosTrabalho().add(new ContratoTrabalho(Fixture.from(Pessoa.class)
    	.gimme("comSegundoDigitoVerificadorInvalidoCpf"), null, null));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar contratos trabalho nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_contratosTrabalho_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setContratosTrabalho(contratosTrabalho);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar enderecos nulo.
     */
    @Test
    public void nao_deve_aceitar_enderecos_nulo() {
    	empresa.setEnderecos(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar enderecos vazio.
     */
    @Test
    public void nao_deve_aceitar_enderecos_vazio() {
    	empresa.setEnderecos(new HashSet<Endereco>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar enderecos com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_enderecos_com_pelo_menos_um_elemento_nulo() {
    	empresa.getEnderecos().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar enderecos com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_enderecos_com_elemento_invalido() {
    	empresa.getEnderecos().add(Fixture.from(Endereco.class).gimme("comUmCaractereInvalidoCep"));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar enderecos nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_enderecos_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setEnderecos(enderecos);
    	assertFalse(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar telefones fixo nulo.
     */
    @Test
    public void deve_aceitar_telefonesFixo_nulo() {
    	empresa.setTelefonesFixo(null);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar telefones fixo vazio.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_vazio() {
    	empresa.setTelefonesFixo(new HashSet<TelefoneFixo>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar telefones fixo com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_com_pelo_menos_um_elemento_nulo() {
    	empresa.getTelefonesFixo().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar telefones fixo com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_telefonesFixo_com_elemento_invalido() {
    	empresa.getTelefonesFixo().add(Fixture.from(TelefoneFixo.class).gimme("comUmCaractereInvalidoNumero"));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar telefones fixo nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_telefonesFixo_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setTelefonesFixo(telefonesFixo);
    	assertFalse(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar emails nulo.
     */
    @Test
    public void deve_aceitar_emails_nulo() {
    	empresa.setEmails(null);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar emails vazio.
     */
    @Test
    public void nao_deve_aceitar_emails_vazio() {
    	empresa.setEmails(new HashSet<Email>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar emails com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_emails_com_pelo_menos_um_elemento_nulo() {
    	empresa.getEmails().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar emails com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_emails_com_elemento_invalido() {
    	empresa.getEmails().add(Fixture.from(Email.class).gimme("comUmCaractereInvalidoAntesArrobaEndereco"));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar emails nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_emails_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setEmails(emails);
    	assertFalse(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar celulares nulo.
     */
    @Test
    public void deve_aceitar_celulares_nulo() {
    	empresa.setCelulares(null);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar celulares vazio.
     */
    @Test
    public void nao_deve_aceitar_celulares_vazio() {
    	empresa.setCelulares(new HashSet<Celular>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar celulares com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_celulares_com_pelo_menos_um_elemento_nulo() {
    	empresa.getCelulares().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar celulares com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_celulares_com_elemento_invalido() {
    	empresa.getCelulares().add(Fixture.from(Celular.class).gimme("comUmCaractereInvalidoNumero"));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar celulares nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_celulares_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setCelulares(celulares);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Deve aceitar contas nulo.
     */
    @Test
    public void deve_aceitar_contas_nulo() {
    	empresa.setContas(null);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar contas vazio.
     */
    @Test
    public void nao_deve_aceitar_contas_vazio() {
    	empresa.setContas(new HashSet<Conta>());
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar contas com pelo menos um elemento nulo.
     */
    @Test
    public void nao_deve_aceitar_contas_com_pelo_menos_um_elemento_nulo() {
    	empresa.getContas().add(null);
    	assertTrue(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar contas com elemento invalido.
     */
    @Test
    public void nao_deve_aceitar_contas_com_elemento_invalido() {
    	empresa.getContas().add(Fixture.from(Conta.class).gimme("comUmCaractereInvalidoNumero"));
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar contas nao vazio sem elemento nulo apenas elemento valido.
     */
    @Test
    public void deve_aceitar_contas_nao_vazio_sem_elemento_nulo_apenas_elemento_valido() {
    	empresa.setContas(contas);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Nao deve aceitar tipo empresa nulo.
     */
    @Test
    public void nao_deve_aceitar_tipoEmpresa_nulo() {
    	empresa.setTipoEmpresa(null);
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar tipo empresa nao nulo.
     */
    @Test
    public void deve_aceitar_tipoEmpresa_nao_nulo() {
    	empresa.setTipoEmpresa(TipoEmpresa.SOCIEDADE);
    	assertFalse(procuraAlgumErro(empresa));
    }

    /**
     * Nao deve aceitar tipo porte empresa nulo.
     */
    @Test
    public void nao_deve_aceitar_tipoPorteEmpresa_nulo() {
    	empresa.setTipoPorteEmpresa(null);
    	assertTrue(procuraAlgumErro(empresa));
    }

    /**
     * Deve aceitar tipo porte empresa nao nulo.
     */
    @Test
    public void deve_aceitar_tipoPorteEmpresa_nao_nulo() {
    	empresa.setTipoPorteEmpresa(TipoPorteEmpresa.EPP);
    	assertFalse(procuraAlgumErro(empresa));
    }
    
    /**
     * Gets the cnpj deve trazer o valor armazenado em cnpj.
     *
     * @return the cnpj deve trazer o valor armazenado em cnpj
     */
    @Test
    public void getCnpj_deve_trazer_o_valor_armazenado_em_cnpj() {
        empresa.setCnpj("13282774000102");
        assertThat(empresa.getCnpj(), is(equalTo("13282774000102")));
    }
    
    /**
     * Gets the razao social deve trazer o valor armazenado em razao social.
     *
     * @return the razao social deve trazer o valor armazenado em razao social
     */
    @Test
    public void getRazaoSocial_deve_trazer_o_valor_armazenado_em_razaoSocial() {
        empresa.setRazaoSocial("Empresa SA");
        assertThat(empresa.getRazaoSocial(), is(equalTo("Empresa SA")));
    }

    /**
     * Gets the data abertura deve trazer o valor armazenado em data abertura.
     *
     * @return the data abertura deve trazer o valor armazenado em data abertura
     */
    @Test
    public void getDataAbertura_deve_trazer_o_valor_armazenado_em_dataAbertura() {
        empresa.setDataAbertura(LocalDate.parse("1990-02-12"));
        assertThat(empresa.getDataAbertura(), is(equalTo(LocalDate.parse("1990-02-12"))));
    }    
    
    /**
     * Gets the responsaveis deve trazer o valor armazenado em responsaveis.
     *
     * @return the responsaveis deve trazer o valor armazenado em responsaveis
     */
    @Test
    public void getResponsaveis_deve_trazer_o_valor_armazenado_em_responsaveis() {
        empresa.setResponsaveis(responsaveis);
        assertThat(empresa.getResponsaveis(), is(equalTo(responsaveis)));
    }
    
    /**
     * Gets the contratos trabalho deve trazer o valor armazenado em contratos trabalho.
     *
     * @return the contratos trabalho deve trazer o valor armazenado em contratos trabalho
     */
    @Test
    public void getContratosTrabalho_deve_trazer_o_valor_armazenado_em_contratosTrabalho() {
        empresa.setContratosTrabalho(contratosTrabalho);
        assertThat(empresa.getContratosTrabalho(), is(equalTo(contratosTrabalho)));
    }
    
    /**
     * Gets the enderecos deve trazer o valor armazenado em enderecos.
     *
     * @return the enderecos deve trazer o valor armazenado em enderecos
     */
    @Test
    public void getEnderecos_deve_trazer_o_valor_armazenado_em_enderecos() {
        empresa.setEnderecos(enderecos);
        assertThat(empresa.getEnderecos(), is(equalTo(enderecos)));
    }
    
    /**
     * Gets the telefones fixo deve trazer o valor armazenado em telefones fixo.
     *
     * @return the telefones fixo deve trazer o valor armazenado em telefones fixo
     */
    @Test
    public void getTelefonesFixo_deve_trazer_o_valor_armazenado_em_telefonesFixo() {
        empresa.setTelefonesFixo(telefonesFixo);
        assertThat(empresa.getTelefonesFixo(), is(equalTo(telefonesFixo)));
    }
    
    /**
     * Gets the emails deve trazer o valor armazenado em emails.
     *
     * @return the emails deve trazer o valor armazenado em emails
     */
    @Test
    public void getEmails_deve_trazer_o_valor_armazenado_em_emails() {
        empresa.setEmails(emails);
        assertThat(empresa.getEmails(), is(equalTo(emails)));
    }

    /**
     * Gets the celulares deve trazer o valor armazenado em celulares.
     *
     * @return the celulares deve trazer o valor armazenado em celulares
     */
    @Test
    public void getCelulares_deve_trazer_o_valor_armazenado_em_celulares() {
        empresa.setCelulares(celulares);
        assertThat(empresa.getCelulares(), is(equalTo(celulares)));
    }
    
    /**
     * Gets the contas deve trazer o valor armazenado em contas.
     *
     * @return the contas deve trazer o valor armazenado em contas
     */
    @Test
    public void getContas_deve_trazer_o_valor_armazenado_em_contas() {
        empresa.setContas(contas);
        assertThat(empresa.getContas(), is(equalTo(contas)));
    }
    
    /**
     * Gets the tipo empresa deve trazer o valor armazenado em tipo empresa.
     *
     * @return the tipo empresa deve trazer o valor armazenado em tipo empresa
     */
    @Test
    public void getTipoEmpresa_deve_trazer_o_valor_armazenado_em_tipoEmpresa() {
        empresa.setTipoEmpresa(TipoEmpresa.SOCIEDADE);
        assertThat(empresa.getTipoEmpresa(), is(equalTo(TipoEmpresa.SOCIEDADE)));
    }
    
    /**
     * Gets the tipo porte empresa deve trazer o valor armazenado em tipo porte empresa.
     *
     * @return the tipo porte empresa deve trazer o valor armazenado em tipo porte empresa
     */
    @Test
    public void getTipoPorteEmpresa_deve_trazer_o_valor_armazenado_em_tipoPorteEmpresa() {
        empresa.setTipoPorteEmpresa(TipoPorteEmpresa.EPP);
        assertThat(empresa.getTipoPorteEmpresa(), is(equalTo(TipoPorteEmpresa.EPP)));
    }
    
    /**
     * Deve haver metodo get publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_get_publico_para_cada_atributo() {
        assertPojoMethodsFor(Empresa.class).testing(GETTER).areWellImplemented();
    }
    
    /**
     * Deve haver metodo set publico para cada atributo.
     */
    @Test
    public void deve_haver_metodo_set_publico_para_cada_atributo() {
        assertPojoMethodsFor(Empresa.class).testing(SETTER).areWellImplemented();
    }
    
    /**
     * Verifica construtor publico com argumentos especificados e implementacao correta.
     */
    @Test
    public void verifica_construtor_publico_com_argumentos_especificados_e_implementacao_correta() {
        Object[] valores = {"13282774000102", "Empresa SA", LocalDate.parse("1990-02-12"), responsaveis, enderecos, TipoEmpresa.SOCIEDADE, TipoPorteEmpresa.EPP};
        assertTrue(verificaConstrutor(Empresa.class, valores, String.class, String.class, LocalDate.class, Set.class, Set.class, TipoEmpresa.class, TipoPorteEmpresa.class));
    }
    
    /**
     * Hashcode deve retornar mesmos codigos com cnpj igual.
     */
    @Test
    public void hashcode_deve_retornar_mesmos_codigos_com_cnpj_igual() {
        outroEmpresa.setCnpj(empresa.getCnpj());
        assertThat(empresa.hashCode(), is(equalTo(outroEmpresa.hashCode())));
    }
        
    /**
     * Hashcode deve retornar diferentes codigos com cnpj diferente.
     */
    @Test
    public void hashcode_deve_retornar_diferentes_codigos_com_cnpj_diferente() {
        assertThat(empresa.hashCode(), is(not(equalTo(outroEmpresa.hashCode()))));
    }
        
    /**
     * Equals deve retornar true com cnpj igual.
     */
    @Test
    public void equals_deve_retornar_true_com_cnpj_igual() {
        outroEmpresa.setCnpj(empresa.getCnpj());
        assertTrue(empresa.equals(outroEmpresa));
    }
        
    /**
     * Equals deve retornar false com cnpj diferente.
     */
    @Test
    public void equals_deve_retornar_false_com_cnpj_diferente() {
        assertFalse(empresa.equals(outroEmpresa));
    }
    
    /**
     * Verifica consistencia da implementacao do metodo equals de acordo com a regra estabelecida de comparacao.
     */
    @Test
    public void verifica_consistencia_da_implementacao_do_metodo_equals_de_acordo_com_a_regra_estabelecida_de_comparacao() {
        EqualsVerifier.forClass(Empresa.class).suppress(NONFINAL_FIELDS, ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    
    /**
     * Verifica existencia do texto que representa o atributo cnpj no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_cnpj_no_texto_gerado_pelo_metodo_toString() {
        empresa.setCnpj("13282774000102");
        assertTrue(empresa.toString().contains("13282774000102"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo razao social no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_razaoSocial_no_texto_gerado_pelo_metodo_toString() {
        empresa.setRazaoSocial("Empresa SA");
        assertTrue(empresa.toString().contains("Empresa SA"));
    }

    /**
     * Verifica existencia do texto que representa o atributo data abertura no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_dataAbertura_no_texto_gerado_pelo_metodo_toString() {
        empresa.setDataAbertura(LocalDate.parse("1990-02-12"));
        assertTrue(empresa.toString().contains("1990-02-12"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo responsaveis no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_responsaveis_no_texto_gerado_pelo_metodo_toString() {
        empresa.setResponsaveis(responsaveis);
        assertTrue(empresa.toString().contains(responsaveis.toString()));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo contratos trabalho no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_contratosTrabalho_no_texto_gerado_pelo_metodo_toString() {
        empresa.setContratosTrabalho(contratosTrabalho);
        assertTrue(empresa.toString().contains(contratosTrabalho.toString()));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo enderecos no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_enderecos_no_texto_gerado_pelo_metodo_toString() {
        empresa.setEnderecos(enderecos);
        assertTrue(empresa.toString().contains(enderecos.toString()));
    }

    /**
     * Verifica existencia do texto que representa o atributo telefones fixo no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_telefonesFixo_no_texto_gerado_pelo_metodo_toString() {
        empresa.setTelefonesFixo(telefonesFixo);
        assertTrue(empresa.toString().contains(telefonesFixo.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo telefones fixo nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_telefonesFixo_nulo() {
        empresa.setTelefonesFixo(null);
        assertTrue(empresa.toString().contains("Sem telefone fixo"));
    }

    /**
     * Verifica existencia do texto que representa o atributo emails no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_emails_no_texto_gerado_pelo_metodo_toString() {
        empresa.setEmails(emails);
        assertTrue(empresa.toString().contains(emails.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo emails nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_emails_nulo() {
        empresa.setEmails(null);
        assertTrue(empresa.toString().contains("Sem e-mail"));
    }

    /**
     * Verifica existencia do texto que representa o atributo celulares no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_celulares_no_texto_gerado_pelo_metodo_toString() {
        empresa.setCelulares(celulares);
        assertTrue(empresa.toString().contains(celulares.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo celulares nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_celulares_nulo() {
        empresa.setCelulares(null);
        assertTrue(empresa.toString().contains("Sem celular"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo contas no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_contas_no_texto_gerado_pelo_metodo_toString() {
        empresa.setContas(contas);
        assertTrue(empresa.toString().contains(contas.toString()));
    }

    /**
     * Verifica texto gerado pelo metodo to string quando atributo contas nulo.
     */
    @Test
    public void verifica_texto_gerado_pelo_metodo_toString_quando_atributo_contas_nulo() {
        empresa.setContas(null);
        assertTrue(empresa.toString().contains("Sem conta banc\\u00E1ria"));
    }
    
    /**
     * Verifica existencia do texto que representa o atributo tipo empresa no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoEmpresa_no_texto_gerado_pelo_metodo_toString() {
        empresa.setTipoEmpresa(TipoEmpresa.SOCIEDADE);
        assertTrue(empresa.toString().contains(TipoEmpresa.SOCIEDADE.name()));
    }

    /**
     * Verifica existencia do texto que representa o atributo tipo porte empresa no texto gerado pelo metodo to string.
     */
    @Test
    public void verifica_existencia_do_texto_que_representa_o_atributo_tipoPorteEmpresa_no_texto_gerado_pelo_metodo_toString() {
        empresa.setTipoPorteEmpresa(TipoPorteEmpresa.EPP);
        assertTrue(empresa.toString().contains(TipoPorteEmpresa.EPP.name()));
    }
    
    /**
     * Metodo to string deve gerar representacao do objeto em json com todos os atributos da classe.
     */
    @Test
    public void metodo_toString_deve_gerar_representacao_do_objeto_em_json_com_todos_os_atributos_da_classe() {
        assertTrue(verificaToStringJSONSTYLE(empresa));
    }
    
}
