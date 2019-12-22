package br.com.contmatic.templates.conta;

import static br.com.contmatic.utilidades.ConstantesString.APENAS_LETRA_NUMERAL;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.MAX_NUMERO_CONTA;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import br.com.contmatic.model.conta.Agencia;
import br.com.contmatic.model.conta.Conta;
import br.com.contmatic.model.conta.TipoConta;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating ContaTemplateFixture objects.
 */
public class ContaTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {        
        new AgenciaTemplateFixtureFactory().load();        
        Agencia agencia = Fixture.from(Agencia.class).gimme("valido");        
        Agencia outroAgencia = Fixture.from(Agencia.class).gimme("outroValido");
        Fixture.of(Conta.class).addTemplate("valido", new Rule() {{
            add("numero", random("11111D", "32325678901A", "7654321p", "555557"));
            add("agencia", agencia);
            add("tipoConta", TipoConta.values()[nextInt(0, TipoConta.values().length)]);
        }});        
        Fixture.of(Conta.class).addTemplate("outroValido", new Rule() {{
            add("numero", random("55555D", "99999D", "9999999999D", "1234567"));
            add("agencia", outroAgencia);
            add("tipoConta", TipoConta.values()[nextInt(0, TipoConta.values().length)]);
        }});
        Fixture.of(Conta.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(MAX_NUMERO_CONTA + 1, APENAS_LETRA_NUMERAL));
        }});        
        Fixture.of(Conta.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", apenasUmCaractere(MAX_NUMERO_CONTA, "[^A-Za-z0-9]", APENAS_LETRA_NUMERAL));
        }});        
        Fixture.of(Conta.class).addTemplate("validoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(MAX_NUMERO_CONTA, APENAS_LETRA_NUMERAL));
        }});        
    }

}
