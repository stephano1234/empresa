package br.com.contmatic.templates.contato;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.DDD;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.NUMERO_TELEFONE;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating TelefoneFixoTemplateFixture objects.
 */
public class TelefoneFixoTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(TelefoneFixo.class).addTemplate("valido", new Rule() {{
            add("ddd", random("12", "11", "68", "82"));
            add("numero", random("33445566", "50385476", "20381188", "40991818"));            
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("outroValido", new Rule() {{
            add("ddd", random("13", "21", "69", "79"));
            add("numero", random("66554433", "88888888", "31240079", "08003232"));            
        }});
        Fixture.of(TelefoneFixo.class).addTemplate("maiorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD + 1, APENAS_NUMERAL));
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("menorTamanhoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD - 1, APENAS_NUMERAL));
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("comUmCaractereInvalidoDdd").inherits("valido", new Rule() {{
            add("ddd", apenasUmCaractere(DDD, "[^0-9]", APENAS_NUMERAL));
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("validoDdd").inherits("valido", new Rule() {{
            add("ddd", somenteCaractere(DDD, APENAS_NUMERAL));
        }});
        Fixture.of(TelefoneFixo.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_TELEFONE + 1, APENAS_NUMERAL));
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("menorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_TELEFONE - 1, APENAS_NUMERAL));
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", apenasUmCaractere(NUMERO_TELEFONE, "[^0-9]", APENAS_NUMERAL));
        }});        
        Fixture.of(TelefoneFixo.class).addTemplate("validoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(NUMERO_TELEFONE, APENAS_NUMERAL));
        }});        
    }

}
