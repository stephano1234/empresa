package br.com.contmatic.templates.endereco;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.TAMANHO_REGULAR;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_ESPACO;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.model.endereco.Bairro;
import br.com.contmatic.model.endereco.Logradouro;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating LogradouroTemplateFixture objects.
 */
public class LogradouroTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {      
        new BairroTemplateFixtureFactory().load();        
        Bairro bairro = Fixture.from(Bairro.class).gimme("valido");        
        Bairro outroBairro = Fixture.from(Bairro.class).gimme("outroValido");        
        Fixture.of(Logradouro.class).addTemplate("valido", new Rule() {{     
            add("nome", random("Avenida Paulista", "Rua Padre Vieira", "Alameda Santos", "Rua Monte Alegre"));
            add("bairro", bairro);
        }});        
        Fixture.of(Logradouro.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Avenida Brasil", "Avenida 23 de Maio", "Estrada de Itapicirica da Serra", "Rua João Cachoeira"));
            add("bairro", outroBairro);
        }});
        Fixture.of(Logradouro.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, TAMANHO_REGULAR), APENAS_ESPACO));
        }});        
        Fixture.of(Logradouro.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(TAMANHO_REGULAR + 1, "[a-z]"));
        }});
        Fixture.of(Logradouro.class).addTemplate("umCaractereNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]"));
        }});
        Fixture.of(Logradouro.class).addTemplate("comPrimeiroCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[a-z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Logradouro.class).addTemplate("comUltimoCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + somenteCaractere(1, "[0-9]"));
        }});
        Fixture.of(Logradouro.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + apenasUmCaractere(nextInt(1, 10), "\\d", "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Logradouro.class).addTemplate("comEspacoDuploNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + "  " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Logradouro.class).addTemplate("validoNome").inherits("valido", new Rule() {{
            add("nome", name());
        }});         
    }
    
}
