package br.com.contmatic.templates.endereco;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.TAMANHO_REGULAR;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_ESPACO;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.model.endereco.Bairro;
import br.com.contmatic.model.endereco.Cidade;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating BairroTemplateFixture objects.
 */
public class BairroTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {        
        new CidadeTemplateFixtureFactory().load();        
        Cidade cidade = Fixture.from(Cidade.class).gimme("valido");        
        Cidade outroCidade = Fixture.from(Cidade.class).gimme("outroValido");        
        Fixture.of(Bairro.class).addTemplate("valido", new Rule() {{     
            add("nome", random("Tatuapé", "Capão Redondo", "Paraisópolis", "Vila Olímpia"));
            add("cidade", cidade);
        }});        
        Fixture.of(Bairro.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Vila Madalena", "Barra Funda", "Piqueri", "Mandaqui"));
            add("cidade", outroCidade);
        }});
        Fixture.of(Bairro.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, TAMANHO_REGULAR), APENAS_ESPACO));
        }});        
        Fixture.of(Bairro.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(TAMANHO_REGULAR + 1, "[a-z]"));
        }});
        Fixture.of(Bairro.class).addTemplate("umCaractereNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]"));
        }});
        Fixture.of(Bairro.class).addTemplate("comPrimeiroCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[a-z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Bairro.class).addTemplate("comUltimoCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + somenteCaractere(1, "[0-9]"));
        }});
        Fixture.of(Bairro.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + apenasUmCaractere(nextInt(1, 10), "\\d", "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Bairro.class).addTemplate("comEspacoDuploNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + "  " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Bairro.class).addTemplate("validoNome").inherits("valido", new Rule() {{
            add("nome", name());
        }});       
    }
    
}
