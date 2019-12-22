package br.com.contmatic.templates.pessoa;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.CPF;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.TAMANHO_REGULAR;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_ESPACO;
import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.cpfInvalido;
import static br.com.contmatic.utilidades.FuncoesRandomicas.cpfValido;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

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
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating PessoaTemplateFixture objects.
 */
public class PessoaTemplateFixtureFactory implements TemplateLoader {


	/**
	 * Load.
	 */
	@Override
    public void load() {
        new EnderecoTemplateFixtureFactory().load();        
        new CelularTemplateFixtureFactory().load();
        new TelefoneFixoTemplateFixtureFactory().load();        
        new EmailTemplateFixtureFactory().load();        
        new ContaTemplateFixtureFactory().load();        
        Set<Endereco> enderecos = new HashSet<Endereco>();        
        Set<Endereco> outroEnderecos = new HashSet<Endereco>();        
        Set<Celular> celulares = new HashSet<Celular>();        
        Set<Celular> outroCelulares = new HashSet<Celular>();        
        Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();        
        Set<TelefoneFixo> outroTelefonesFixo = new HashSet<TelefoneFixo>();        
        Set<Email> emails = new HashSet<Email>();        
        Set<Email> outroEmails = new HashSet<Email>();        
        Set<Conta> contas = new HashSet<Conta>();        
        Set<Conta> outroContas = new HashSet<Conta>();        
        for (int i = 0; i < nextInt(1, ELEMENTOS_ARRAY_GERADA); i++) {        	
        	enderecos.add(Fixture.from(Endereco.class).gimme("valido"));        	
        	outroEnderecos.add(Fixture.from(Endereco.class).gimme("outroValido"));        	
        	celulares.add(Fixture.from(Celular.class).gimme("valido"));        	
        	outroCelulares.add(Fixture.from(Celular.class).gimme("outroValido"));        	
        	telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));        	
        	outroTelefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("outroValido"));        	
        	emails.add(Fixture.from(Email.class).gimme("valido"));        	
        	outroEmails.add(Fixture.from(Email.class).gimme("outroValido"));        	
        	contas.add(Fixture.from(Conta.class).gimme("valido"));        	
        	outroContas.add(Fixture.from(Conta.class).gimme("outroValido"));        	        	
        }    	
        Fixture.of(Pessoa.class).addTemplate("valido", new Rule() {{
            add("cpf", random("39270773809", "90563441887", "38325120398", "04759868496"));
            add("nome", random("Carlos Alberto", "José César", "Maria Paula", "Ana Duarte"));            
            add("enderecos", enderecos);
            add("dataNascimento", LocalDate.now().minusYears(nextInt(1, 30)));
            add("celulares", celulares);
            add("telefonesFixo", telefonesFixo);
            add("emails", emails);
            add("tipoGrauInstrucao", TipoGrauInstrucao.values()[nextInt(0, TipoGrauInstrucao.values().length)]);
            add("tipoEstadoCivil", TipoEstadoCivil.values()[nextInt(0, TipoEstadoCivil.values().length)]);
            add("tipoSexo", TipoSexo.values()[nextInt(0, TipoSexo.values().length)]);
            add("contas", contas);
        }});
        Fixture.of(Pessoa.class).addTemplate("outroValido", new Rule() {{
            add("cpf", random("60421184124", "65490465727", "01351417029", "87841587511"));
            add("nome", random("Carlos Alberto", "José César", "Maria Paula", "Ana Duarte"));            
            add("enderecos", enderecos);
            add("dataNascimento", LocalDate.now().minusYears(nextInt(1, 30)));
            add("celulares", celulares);
            add("telefonesFixo", outroTelefonesFixo);
            add("emails", emails);
            add("tipoGrauInstrucao", TipoGrauInstrucao.values()[nextInt(0, TipoGrauInstrucao.values().length)]);
            add("tipoEstadoCivil", TipoEstadoCivil.values()[nextInt(0, TipoEstadoCivil.values().length)]);
            add("tipoSexo", TipoSexo.values()[nextInt(0, TipoSexo.values().length)]);
            add("contas", outroContas);
        }});
        Fixture.of(Pessoa.class).addTemplate("maiorTamanhoCpf").inherits("valido", new Rule() {{
            add("cpf", somenteCaractere(CPF + 1, APENAS_NUMERAL));
        }});                
        Fixture.of(Pessoa.class).addTemplate("menorTamanhoCpf").inherits("valido", new Rule() {{
            add("cpf", somenteCaractere(CPF - 1, APENAS_NUMERAL));
        }});      
        Fixture.of(Pessoa.class).addTemplate("comUmCaractereInvalidoCpf").inherits("valido", new Rule() {{
            add("cpf", apenasUmCaractere(CPF, "[\\D]", APENAS_NUMERAL));
        }});        
        Fixture.of(Pessoa.class).addTemplate("numerosRepetidosCpf").inherits("valido", new Rule() {{
            add("cpf", somenteCaractere(CPF, Integer.toString(nextInt(0, 10))));
        }});
        Fixture.of(Pessoa.class).addTemplate("comPrimeiroDigitoVerificadorInvalidoCpf").inherits("valido", new Rule() {{
            add("cpf", cpfInvalido(9));
        }});
        Fixture.of(Pessoa.class).addTemplate("comSegundoDigitoVerificadorInvalidoCpf").inherits("valido", new Rule() {{
            add("cpf", cpfInvalido(10));
        }});        
        Fixture.of(Pessoa.class).addTemplate("cpfValido").inherits("valido", new Rule() {{
            add("cpf", cpfValido());
        }});                
        Fixture.of(Pessoa.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, TAMANHO_REGULAR), APENAS_ESPACO));
        }});        
        Fixture.of(Pessoa.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(TAMANHO_REGULAR + 1, "[a-z]"));
        }});
        Fixture.of(Pessoa.class).addTemplate("umCaractereNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]"));
        }});
        Fixture.of(Pessoa.class).addTemplate("comPrimeiroCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[a-z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Pessoa.class).addTemplate("comUltimoCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + somenteCaractere(1, "[0-9]"));
        }});
        Fixture.of(Pessoa.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + apenasUmCaractere(nextInt(1, 10), "\\d", "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Pessoa.class).addTemplate("comEspacoDuploNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + "  " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Pessoa.class).addTemplate("validoNome").inherits("valido", new Rule() {{
            add("nome", name());
        }});
        Fixture.of(Pessoa.class).addTemplate("dataNascimentoFutura").inherits("valido", new Rule() {{
            add("dataNascimento", LocalDate.now().plusYears(nextInt(1, 5)));
        }});
        Fixture.of(Pessoa.class).addTemplate("dataNascimentoPassada").inherits("valido", new Rule() {{
            add("dataNascimento", LocalDate.now().minusYears(nextInt(1, 30)));
        }});
    }

}
