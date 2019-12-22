package br.com.contmatic.templates.conta;

import static br.com.contmatic.utilidades.ConstantesString.APENAS_LETRA_NUMERAL;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.MAX_NUMERO_AGENCIA;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.MAX_CODIGO_BANCO;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import br.com.contmatic.model.conta.Agencia;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating AgenciaTemplateFixture objects.
 */
public class AgenciaTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(Agencia.class).addTemplate("valido", new Rule() {{
            add("numero", random("11111", "3232", "4457o", "1234"));
            add("codigoBanco", random("341", "23z", "14", "123"));
        }});        
        Fixture.of(Agencia.class).addTemplate("outroValido", new Rule() {{
            add("numero", random("4321", "3422G", "7667", "47590"));
            add("codigoBanco", random("056", "31A", "22", "431"));
        }});
        Fixture.of(Agencia.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(MAX_NUMERO_AGENCIA + 1, APENAS_LETRA_NUMERAL));
        }});        
        Fixture.of(Agencia.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", apenasUmCaractere(MAX_NUMERO_AGENCIA, "[^A-Za-z0-9]", APENAS_LETRA_NUMERAL));
        }});        
        Fixture.of(Agencia.class).addTemplate("validoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(MAX_NUMERO_AGENCIA, APENAS_LETRA_NUMERAL));
        }});
        Fixture.of(Agencia.class).addTemplate("maiorTamanhoCodigoBanco").inherits("valido", new Rule() {{
            add("codigoBanco", somenteCaractere(MAX_CODIGO_BANCO + 1, APENAS_LETRA_NUMERAL));
        }});        
        Fixture.of(Agencia.class).addTemplate("comUmCaractereInvalidoCodigoBanco").inherits("valido", new Rule() {{
            add("codigoBanco", apenasUmCaractere(MAX_CODIGO_BANCO, "[^A-Za-z0-9]", APENAS_LETRA_NUMERAL));
        }});        
        Fixture.of(Agencia.class).addTemplate("validoCodigoBanco").inherits("valido", new Rule() {{
            add("codigoBanco", somenteCaractere(MAX_CODIGO_BANCO, APENAS_LETRA_NUMERAL));
        }});        
    }

}
