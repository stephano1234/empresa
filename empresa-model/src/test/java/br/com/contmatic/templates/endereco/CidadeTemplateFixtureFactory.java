package br.com.contmatic.templates.endereco;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.TAMANHO_REGULAR;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_ESPACO;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.TipoUf;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating CidadeTemplateFixture objects.
 */
public class CidadeTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(Cidade.class).addTemplate("valido", new Rule() {{     
            add("nome", random("São Paulo", "Campinas", "Sorocaba", "Guarulhos"));
            add("tipoUf", TipoUf.values()[nextInt(0, 13)]);
        }});        
        Fixture.of(Cidade.class).addTemplate("outroValido", new Rule() {{
            add("nome", random("Vitória", "Florianópolis", "Osasco", "São Caetano"));
            add("tipoUf", TipoUf.values()[nextInt(13, TipoUf.values().length)]);
        }});        
        Fixture.of(Cidade.class).addTemplate("apenasEspacoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, TAMANHO_REGULAR), APENAS_ESPACO));
        }});        
        Fixture.of(Cidade.class).addTemplate("maiorTamanhoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(TAMANHO_REGULAR + 1, "[a-z]"));
        }});
        Fixture.of(Cidade.class).addTemplate("umCaractereNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]"));
        }});
        Fixture.of(Cidade.class).addTemplate("comPrimeiroCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[a-z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Cidade.class).addTemplate("comUltimoCaractereInvalido").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + somenteCaractere(1, "[0-9]"));
        }});
        Fixture.of(Cidade.class).addTemplate("comUmCaractereInvalidoNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + apenasUmCaractere(nextInt(1, 10), "\\d", "[a-z]") + " " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Cidade.class).addTemplate("comEspacoDuploNome").inherits("valido", new Rule() {{
            add("nome", somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]") + "  " + somenteCaractere(1, "[A-Z]") + somenteCaractere(nextInt(1, 10), "[a-z]"));
        }});
        Fixture.of(Cidade.class).addTemplate("validoNome").inherits("valido", new Rule() {{
            add("nome", name());
        }});         
    }
    
}
