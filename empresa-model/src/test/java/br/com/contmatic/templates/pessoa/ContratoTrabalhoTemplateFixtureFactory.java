package br.com.contmatic.templates.pessoa;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import org.joda.time.LocalDate;

import br.com.contmatic.model.pessoa.ContratoTrabalho;
import br.com.contmatic.model.pessoa.Pessoa;
import br.com.contmatic.model.pessoa.TipoContratoTrabalho;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating ContratoTrabalhoTemplateFixture objects.
 */
public class ContratoTrabalhoTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
    	new PessoaTemplateFixtureFactory().load();
    	Pessoa pessoa = Fixture.from(Pessoa.class).gimme("valido");    	
    	Pessoa outroPessoa = Fixture.from(Pessoa.class).gimme("outroValido");    	
        Fixture.of(ContratoTrabalho.class).addTemplate("valido", new Rule() {{
            add("pessoa", pessoa);
            add("tipoContratoTrabalho", TipoContratoTrabalho.values()[nextInt(0, TipoContratoTrabalho.values().length)]);
            add("dataInicioContrato", LocalDate.now().minusYears(nextInt(1, 5)));
        }});        
        Fixture.of(ContratoTrabalho.class).addTemplate("outroValido", new Rule() {{
        	add("pessoa", outroPessoa);
            add("tipoContratoTrabalho", TipoContratoTrabalho.values()[nextInt(0, TipoContratoTrabalho.values().length)]);
            add("dataInicioContrato", LocalDate.now().minusYears(nextInt(1, 5)));
        }});
        Fixture.of(ContratoTrabalho.class).addTemplate("dataInicioContratoFutura").inherits("valido", new Rule() {{
            add("dataInicioContrato", LocalDate.now().plusYears(nextInt(1, 5)));
        }});
        Fixture.of(ContratoTrabalho.class).addTemplate("dataInicioContratoPassada").inherits("valido", new Rule() {{
            add("dataInicioContrato", LocalDate.now().minusYears(nextInt(1, 5)));
        }});        
    }

}
