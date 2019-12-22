package br.com.contmatic.templates.endereco;

import static br.com.contmatic.utilidades.ConstantesTesteNumericas.TAMANHO_REGULAR;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.CEP;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.ELEMENTOS_ARRAY_GERADA;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.EXCLUI_STRING_VAZIO;
import static br.com.contmatic.utilidades.ConstantesTesteNumericas.MAX_NUMERO_ENDERECO;

import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_ESPACO;
import static br.com.contmatic.utilidades.ConstantesTesteString.APENAS_NUMERAL;

import static br.com.contmatic.utilidades.FuncoesRandomicas.apenasUmCaractere;
import static br.com.contmatic.utilidades.FuncoesRandomicas.somenteCaractere;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import java.util.HashSet;
import java.util.Set;

import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.endereco.Logradouro;
import br.com.contmatic.model.endereco.TipoEndereco;
import br.com.contmatic.templates.contato.TelefoneFixoTemplateFixtureFactory;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating EnderecoTemplateFixture objects.
 */
public class EnderecoTemplateFixtureFactory implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {        
        new LogradouroTemplateFixtureFactory().load();        
        new TelefoneFixoTemplateFixtureFactory().load();        
        Logradouro logradouro = Fixture.from(Logradouro.class).gimme("valido");        
        Logradouro outroLogradouro = Fixture.from(Logradouro.class).gimme("outroValido");        
        Set<TelefoneFixo> telefonesFixo = new HashSet<TelefoneFixo>();        
        Set<TelefoneFixo> outroTelefonesFixo = new HashSet<TelefoneFixo>();        
        for (int i = 0; i < nextInt(1, ELEMENTOS_ARRAY_GERADA); i++) {        
            telefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("valido"));        
            outroTelefonesFixo.add(Fixture.from(TelefoneFixo.class).gimme("outroValido"));        
        }
        Fixture.of(Endereco.class).addTemplate("valido", new Rule() {{
            add("cep", random("04546080", "12320010", "12345678"));
            add("numero", random("12", "467", "1920"));
            add("complemento", random("2ª casa da rua", "Bl B", "1º andar"));
            add("logradouro", logradouro);
            add("telefonesFixo", telefonesFixo);
            add("tipoEndereco", TipoEndereco.values()[nextInt(0, TipoEndereco.values().length)]);
        }});                
        Fixture.of(Endereco.class).addTemplate("outroValido", new Rule() {{
            add("cep", random("87654321", "11111111", "90023078"));
            add("numero", random("11", "2300", "2"));
            add("complemento", random("b", "apto 82", "4"));
            add("logradouro", outroLogradouro);
            add("telefonesFixo", outroTelefonesFixo);
            add("tipoEndereco", TipoEndereco.values()[nextInt(0, TipoEndereco.values().length)]);
        }});
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoCep").inherits("valido", new Rule() {{
            add("cep", somenteCaractere(CEP + 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Endereco.class).addTemplate("menorTamanhoCep").inherits("valido", new Rule() {{
            add("cep", somenteCaractere(CEP - 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoCep").inherits("valido", new Rule() {{
            add("cep", apenasUmCaractere(CEP, "[^0-9]", APENAS_NUMERAL));
        }});        
        Fixture.of(Endereco.class).addTemplate("validoCep").inherits("valido", new Rule() {{
            add("cep", somenteCaractere(CEP, APENAS_NUMERAL));
        }});
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(MAX_NUMERO_ENDERECO + 1, APENAS_NUMERAL));
        }});        
        Fixture.of(Endereco.class).addTemplate("comUmCaractereInvalidoNumero").inherits("valido", new Rule() {{
            add("numero", apenasUmCaractere(nextInt(EXCLUI_STRING_VAZIO, MAX_NUMERO_ENDERECO + 1), "[^0-9]", APENAS_NUMERAL));
        }});        
        Fixture.of(Endereco.class).addTemplate("validoNumero").inherits("valido", new Rule() {{
            add("numero", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, MAX_NUMERO_ENDERECO + 1), APENAS_NUMERAL));
        }});
        Fixture.of(Endereco.class).addTemplate("maiorTamanhoComplemento").inherits("valido", new Rule() {{
            add("complemento", somenteCaractere(TAMANHO_REGULAR + 1, "[A-Za-z0-9]"));
        }});        
        Fixture.of(Endereco.class).addTemplate("apenasEspacoComplemento").inherits("valido", new Rule() {{
            add("complemento", somenteCaractere(nextInt(EXCLUI_STRING_VAZIO, TAMANHO_REGULAR + 1), APENAS_ESPACO));
        }});        
        Fixture.of(Endereco.class).addTemplate("validoComplemento").inherits("valido", new Rule() {{
            add("complemento", apenasUmCaractere(nextInt(EXCLUI_STRING_VAZIO, TAMANHO_REGULAR + 1), "\\w", APENAS_ESPACO));
        }});        
    }

}
