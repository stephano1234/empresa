package br.com.contmatic.templates.contato;

import static br.com.contmatic.utilidades.ConstantesTesteString.INVALIDOS_EMAIL;
import static br.com.contmatic.utilidades.ConstantesTesteString.LETRA_MINUSCULA_NUMERAL;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.emailAleatorio;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.model.contato.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating EmailTemplateFixture objects.
 */
public class EmailTemplateFixtureFactory implements TemplateLoader {

	/**
	 * Load.
	 */
	@Override
    public void load() {
        Fixture.of(Email.class).addTemplate("valido", new Rule() {{
            add("endereco", random("oioioi@gmail.com", "stephano.regina@contmatic.com.br", "fausto@uol.com.br"));            
        }});        
        Fixture.of(Email.class).addTemplate("outroValido", new Rule() {{
            add("endereco", random("paulo4321@hotmail.com", "soares13@hotmail.com", "tetete@gmail.com"));
        }});
        Fixture.of(Email.class).addTemplate("semArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@", ""));
        }});
        Fixture.of(Email.class).addTemplate("comArrobaPrecedidoPorCaractereInvalidoEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@", somenteCaractere(1, "[._-]") + "@"));
        }});        
        Fixture.of(Email.class).addTemplate("comMaisDeUmArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio() + "@");
        }});        
        Fixture.of(Email.class).addTemplate("semPontoEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.", ""));
        }});        
        Fixture.of(Email.class).addTemplate("validoEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio());
        }});            
        Fixture.of(Email.class).addTemplate("vazioAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll(".*@", "@"));
        }});
        Fixture.of(Email.class).addTemplate("maiorTamanhoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll(".*@", somenteCaractere(30 + 1, LETRA_MINUSCULA_NUMERAL) + "@"));
        }});
        Fixture.of(Email.class).addTemplate("primeiroCaractereInvalidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", somenteCaractere(1, "[._-]|" + INVALIDOS_EMAIL) + emailAleatorio());
        }});        
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll(".*@", somenteCaractere(1, LETRA_MINUSCULA_NUMERAL) + apenasUmCaractere(nextInt(1, 29 + 1), INVALIDOS_EMAIL, LETRA_MINUSCULA_NUMERAL) + "@"));
        }});               
        Fixture.of(Email.class).addTemplate("randomValidoAntesArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.+", "") + "@hotmail.com");
        }});             
        Fixture.of(Email.class).addTemplate("vazioDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.*\\.(?!\\.)", "@" + "."));
        }});
        Fixture.of(Email.class).addTemplate("maiorTamanhoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.*\\.(?!\\.)", "@" + somenteCaractere(20 + 1, "[a-z]") + "."));
        }});
        Fixture.of(Email.class).addTemplate("primeiroCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("(?<=@).", somenteCaractere(1, "[._-]|" + INVALIDOS_EMAIL)));
        }});               
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.*\\.(?!\\.)", "@" + somenteCaractere(1, LETRA_MINUSCULA_NUMERAL) + apenasUmCaractere(nextInt(1, 19 + 1), "[_]|" + INVALIDOS_EMAIL, LETRA_MINUSCULA_NUMERAL) + "."));
        }});        
        Fixture.of(Email.class).addTemplate("semPontoObrigatorioDepoisArrobaEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.*\\.(?!\\.)", "@" + somenteCaractere(1, LETRA_MINUSCULA_NUMERAL) + somenteCaractere(nextInt(1, 19 + 1), LETRA_MINUSCULA_NUMERAL)));
        }});                
        Fixture.of(Email.class).addTemplate("comPontoObrigatorioPrecedidoPorCaractereInvalidoEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("@.*\\.(?!\\.)", "@" + somenteCaractere(1, LETRA_MINUSCULA_NUMERAL) + somenteCaractere(nextInt(1, 19 - 1 + 1), LETRA_MINUSCULA_NUMERAL) + somenteCaractere(1, "[._-]|" + INVALIDOS_EMAIL) + "."));
        }});           
        Fixture.of(Email.class).addTemplate("randomValidoDepoisArrobaAtePontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", "lalala@" + emailAleatorio().replaceAll(".*@", "").replaceAll("\\.(?!.*\\.).*", "") + ".com");
        }});        
        Fixture.of(Email.class).addTemplate("maiorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.(?!.*\\.).*", "." + somenteCaractere(6 + 1, "[a-z]")));
        }});        
        Fixture.of(Email.class).addTemplate("menorTamanhoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.(?!.*\\.).*", "." + somenteCaractere(2 - 1, "[a-z]")));
        }});        
        Fixture.of(Email.class).addTemplate("comUmCaractereInvalidoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", emailAleatorio().replaceAll("\\.(?!.*\\.).*", "." + apenasUmCaractere(nextInt(2, 6 + 1), "[_-]|[0-9]|" + INVALIDOS_EMAIL, "[a-z]")));
        }});        
        Fixture.of(Email.class).addTemplate("randomValidoDepoisPontoObrigatorioEndereco").inherits("valido", new Rule() {{
            add("endereco", "lalala@contmatic." + emailAleatorio().replaceAll(".*\\.(?!\\.)", ""));
        }});        
    }

}
