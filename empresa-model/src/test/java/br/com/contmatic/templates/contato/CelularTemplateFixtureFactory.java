package br.com.contmatic.templates.contato;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.DDD;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.NUMERO_CELULAR;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.model.contato.Celular;
import br.com.contmatic.model.contato.TipoContatoCelular;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating CelularTemplateFixture objects.
 */
public class CelularTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(Celular.class).addTemplate("valido", new Rule() {{
            add("ddd", random("12", "11", "68", "82"));
            add("numero", random("933445566", "950385476", "920381188", "940991818"));            
            add("tipoContatoCelular", TipoContatoCelular.values()[nextInt(0, 3)]);            
        }});        
        Fixture.of(Celular.class).addTemplate("outroValido", new Rule() {{
            add("ddd", random("13", "21", "69", "79"));
            add("numero", random("966554433", "988888888", "931240079", "908003232"));
            add("tipoContatoCelular", TipoContatoCelular.values()[nextInt(3, TipoContatoCelular.values().length)]);
        }});
        Fixture.of(Celular.class).addTemplate("maiorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD + 1, APENAS_NUMERAL));
        }});                
        Fixture.of(Celular.class).addTemplate("menorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD - 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Celular.class).addTemplate("comUmCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", apenasUmCaractere(DDD, "[^0-9]", APENAS_NUMERAL));
        }});        
        Fixture.of(Celular.class).addTemplate("validoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD, APENAS_NUMERAL));
        }});
        Fixture.of(Celular.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_CELULAR + 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Celular.class).addTemplate("menorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_CELULAR - 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Celular.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", apenasUmCaractere(NUMERO_CELULAR, "[^0-9]", APENAS_NUMERAL));
        }});        
        Fixture.of(Celular.class).addTemplate("validoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_CELULAR, APENAS_NUMERAL));
        }});        
    }

}
