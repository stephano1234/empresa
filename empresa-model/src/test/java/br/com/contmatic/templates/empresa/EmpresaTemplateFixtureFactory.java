package br.com.contmatic.templates.empresa;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.CNPJ;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.TAMANHO_REGULAR;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.cnpjInvalido;
import static br.com.contmatic.utilidades.FuncoesRandomicas.cnpjValido;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

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
import br.com.contmatic.templates.endereco.EnderecoTemplateFixtureFactory;
import br.com.contmatic.templates.pessoa.ContratoTrabalhoTemplateFixtureFactory;
import br.com.contmatic.templates.pessoa.PessoaTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating EmpresaTemplateFixture objects.
 */
public class EmpresaTemplateFixtureFactory implements TemplateLoader {

	/**
	 * Load.
	 */
	@Override
    public void load() {
		new PessoaTemplateFixtureFactory().load();		
		new ContratoTrabalhoTemplateFixtureFactory().load();		
		new EnderecoTemplateFixtureFactory().load();        
        new TelefoneFixoTemplateFixtureFactory().load();        
        new EmailTemplateFixtureFactory().load();        
        new CelularTemplateFixtureFactory().load();        
        new ContaTemplateFixtureFactory().load();        
        Set<Pessoa> responsaveis = new HashSet<Pessoa>();        
        Set<Pessoa> outroResponsaveis = new HashSet<Pessoa>();
        Set<ContratoTrabalho> contratosTrabalho = new HashSet<ContratoTrabalho>();        
        Set<ContratoTrabalho> outroContratosTrabalho = new HashSet<ContratoTrabalho>();        
        Set<Endereco> enderecos = new HashSet<Endereco>();        
        Set<Endereco> outroEnderecos = new HashSet<Endereco>();                
        Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();        
        Set<TelefoneFixo> outroTelefonesFixo = new HashSet<TelefoneFixo>();        
        Set<Email> emails = new HashSet<Email>();        
        Set<Email> outroEmails = new HashSet<Email>();
        Set<Celular> celulares = new HashSet<Celular>();        
        Set<Celular> outroCelulares = new HashSet<Celular>();
        Set<Conta> contas = new HashSet<Conta>();        
        Set<Conta> outroContas = new HashSet<Conta>();        
        for (int i = 0; i < nextInt(1, ELEMENTOS_ARRAY_GERADA); i++) {        	        	
        	responsaveis.add(Fixture.from(Pessoa.class).gimme("valido"));        	
        	outroResponsaveis.add(Fixture.from(Pessoa.class).gimme("outroValido"));        	
        	contratosTrabalho.add(Fixture.from(ContratoTrabalho.class).gimme("valido"));        	
        	outroContratosTrabalho.add(Fixture.from(ContratoTrabalho.class).gimme("outroValido"));        	
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));        	
        	outroEnderecos.add(Fixture.from(Endereco.class).gimme("outroValido"));        	
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));        	
        	outroTelefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("outroValido"));        	
        	emails.add(Fixture.from(Email.class).gimme("valido"));        	
        	outroEmails.add(Fixture.from(Email.class).gimme("outroValido"));
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));        	
        	outroCelulares.add(Fixture.from(Celular.class).gimme("outroValido"));        	
        	contas.add(Fixture.from(Conta.class).gimme("valido"));        	
        	outroContas.add(Fixture.from(Conta.class).gimme("outroValido"));        	        	
        }
        Fixture.of(Empresa.class).addTemplate("valido", new Rule() {{
            add("cnpj", random("92385152000178", "68564301000181", "13125387000154", "94359762000122"));
            add("razaoSocial", random("Contmatic Phoenix", "José César Ltda.", "Manufaturas EPP", "Fomentos Latino-Americanos S.A."));            
            add("responsaveis", responsaveis);
            add("contratosTrabalho", contratosTrabalho);
            add("dataAbertura", LocalDate.now().minusYears(nextInt(1, 30)));
            add("enderecos", enderecos);
            add("telefonesFixo", telefonesFixo);
            add("emails", emails);
            add("celulares", celulares);
            add("contas", contas);
            add("tipoEmpresa", TipoEmpresa.values()[nextInt(0, TipoEmpresa.values().length)]);
            add("tipoPorteEmpresa", TipoPorteEmpresa.values()[nextInt(0, TipoPorteEmpresa.values().length)]);
        }});
        Fixture.of(Empresa.class).addTemplate("outroValido", new Rule() {{
            add("cnpj", random("93944007000142", "28808705000159", "01053510000190", "98323917000121"));
            add("razaoSocial", random("Maria dos Santos", "Carlos Augusto ME", "Super Esporte Artigos Esportivos Ltda.", "Itaú SA"));            
            add("responsaveis", outroResponsaveis);
            add("contratosTrabalho", outroContratosTrabalho);
            add("dataAbertura", LocalDate.now().minusYears(nextInt(1, 30)));
            add("enderecos", outroEnderecos);
            add("telefonesFixo", outroTelefonesFixo);
            add("emails", outroEmails);
            add("celulares", outroCelulares);
            add("contas", outroContas);
            add("tipoEmpresa", TipoEmpresa.values()[nextInt(0, TipoEmpresa.values().length)]);
            add("tipoPorteEmpresa", TipoPorteEmpresa.values()[nextInt(0, TipoPorteEmpresa.values().length)]);
        }});
        Fixture.of(Empresa.class).addTemplate("maiorTamanhoCnpj").inherits("valido", new Rule() {{
            add("cnpj", somenteCaractere(CNPJ + 1, APENAS_NUMERAL));
        }});                
        Fixture.of(Empresa.class).addTemplate("menorTamanhoCnpj").inherits("valido", new Rule() {{
            add("cnpj", somenteCaractere(CNPJ - 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Empresa.class).addTemplate("comUmCaractereInvalidoCnpj").inherits("valido", new Rule() {{
            add("cnpj", apenasUmCaractere(CNPJ, "\\D", APENAS_NUMERAL));
        }});        
        Fixture.of(Empresa.class).addTemplate("numerosRepetidosCnpj").inherits("valido", new Rule() {{
            add("cnpj", somenteCaractere(CNPJ, Integer.toString(nextInt(0, 10))));
        }});
        Fixture.of(Empresa.class).addTemplate("comPrimeiroDigitoVerificadorInvalidoCnpj").inherits("valido", new Rule() {{
            add("cnpj", cnpjInvalido(12));
        }});
        Fixture.of(Empresa.class).addTemplate("comSegundoDigitoVerificadorInvalidoCnpj").inherits("valido", new Rule() {{
            add("cnpj", cnpjInvalido(13));
        }});
        Fixture.of(Empresa.class).addTemplate("cnpjValido").inherits("valido", new Rule() {{
            add("cnpj", cnpjValido());
        }});
        Fixture.of(Empresa.class).addTemplate("maiorTamanhoRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(TAMANHO_REGULAR + 1, "[a-z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("umCaractereRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("comPrimeiroCaractereInvalido").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[a-z]") + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("comUltimoCaractereInvalido").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + somenteCaractere(1, "\\d"));
        }});
        Fixture.of(Empresa.class).addTemplate("comUmCaractereInvalidoRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + apenasUmCaractere(nextInt(1, 10), "\\d", "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("comEspacoDuploRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + "  " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("comPontoDuploRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + ".." + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("comPontoDuploNoFinalRazaoSocial").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(10, "[A-Z]") + "..");
        }});
        Fixture.of(Empresa.class).addTemplate("razaoSocialValido").inherits("valido", new Rule() {{
            add("razaoSocial", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(10, 20), "[A-Z&Ç'-]") + somenteCaractere(1, "[A-Z]"));
        }});
        Fixture.of(Empresa.class).addTemplate("dataAberturaFutura").inherits("valido", new Rule() {{
            add("dataAbertura", LocalDate.now().plusYears(nextInt(1, 5)));
        }});
        Fixture.of(Empresa.class).addTemplate("dataAberturaPassada").inherits("valido", new Rule() {{
            add("dataAbertura", LocalDate.now().minusYears(nextInt(1, 30)));
        }});
    }

}
