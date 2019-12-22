package br.com.contmatic.model.pessoa;

import static br.com.contmatic.utilidades.ConstantesString.NOME;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.NOME_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.joda.time.LocalDate;

import br.com.contmatic.anotacoes.CPFbr;
import br.com.contmatic.anotacoes.CollectionComElementoNaoNulo;
import br.com.contmatic.model.conta.Conta;
import br.com.contmatic.model.contato.Celular;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.contmatic.model.endereco.Endereco;

/**
 * The Class Pessoa.
 */
public class Pessoa {

	/** The cpf. */
	@NotNull(message = VALOR_NULO)
	@CPFbr
	private String cpf;

	/** The nome. */
	@NotNull(message = VALOR_NULO)
	@Pattern(regexp = NOME, message = NOME_INVALIDO)
	private String nome;

	/** The enderecos. */
	@NotNull(message = VALOR_NULO)
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Endereco> enderecos;

	/** The data nascimento. */
	@NotNull(message = VALOR_NULO)
	@Past(message = DATA_PASSADO)
	private LocalDate dataNascimento;

	/** The celulares. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Celular> celulares;
	
	/** The telefones fixo. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<TelefoneFixo> telefonesFixo;

	/** The emails. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Email> emails;

	/** The tipo grau instrucao. */
	@NotNull(message = VALOR_NULO)
	private TipoGrauInstrucao tipoGrauInstrucao;

	/** The tipo estado civil. */
	@NotNull(message = VALOR_NULO)
	private TipoEstadoCivil tipoEstadoCivil;

	/** The tipo sexo. */
	@NotNull(message = VALOR_NULO)
	private TipoSexo tipoSexo;
	
	/** The contas. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Conta> contas;

	/**
	 * Instantiates a new pessoa.
	 *
	 * @param cpf the cpf
	 * @param nome the nome
	 * @param enderecos the enderecos
	 * @param dataNascimento the data nascimento
	 * @param tipoGrauInstrucao the tipo grau instrucao
	 * @param tipoEstadoCivil the tipo estado civil
	 * @param tipoSexo the tipo sexo
	 */
	public Pessoa(String cpf, String nome, Set<Endereco> enderecos, LocalDate dataNascimento,
			TipoGrauInstrucao tipoGrauInstrucao, TipoEstadoCivil tipoEstadoCivil, TipoSexo tipoSexo) {
		this.cpf = cpf;
		this.nome = nome;
		this.enderecos = enderecos;
		this.dataNascimento = dataNascimento;
		this.tipoGrauInstrucao = tipoGrauInstrucao;
		this.tipoEstadoCivil = tipoEstadoCivil;
		this.tipoSexo = tipoSexo;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the enderecos.
	 *
	 * @return the enderecos
	 */
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * Sets the enderecos.
	 *
	 * @param enderecos the new enderecos
	 */
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * Gets the data nascimento.
	 *
	 * @return the data nascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Sets the data nascimento.
	 *
	 * @param dataNascimento the new data nascimento
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Gets the celulares.
	 *
	 * @return the celulares
	 */
	public Set<Celular> getCelulares() {
		return celulares;
	}

	/**
	 * Sets the celulares.
	 *
	 * @param celulares the new celulares
	 */
	public void setCelulares(Set<Celular> celulares) {
		this.celulares = celulares;
	}

	/**
	 * Gets the telefones fixo.
	 *
	 * @return the telefones fixo
	 */
	public Set<TelefoneFixo> getTelefonesFixo() {
		return telefonesFixo;
	}

	/**
	 * Sets the telefones fixo.
	 *
	 * @param telefonesFixo the new telefones fixo
	 */
	public void setTelefonesFixo(Set<TelefoneFixo> telefonesFixo) {
		this.telefonesFixo = telefonesFixo;
	}

	/**
	 * Gets the emails.
	 *
	 * @return the emails
	 */
	public Set<Email> getEmails() {
		return emails;
	}

	/**
	 * Sets the emails.
	 *
	 * @param emails the new emails
	 */
	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	/**
	 * Gets the tipo grau instrucao.
	 *
	 * @return the tipo grau instrucao
	 */
	public TipoGrauInstrucao getTipoGrauInstrucao() {
		return tipoGrauInstrucao;
	}

	/**
	 * Sets the tipo grau instrucao.
	 *
	 * @param tipoGrauInstrucao the new tipo grau instrucao
	 */
	public void setTipoGrauInstrucao(TipoGrauInstrucao tipoGrauInstrucao) {
		this.tipoGrauInstrucao = tipoGrauInstrucao;
	}

	/**
	 * Gets the tipo estado civil.
	 *
	 * @return the tipo estado civil
	 */
	public TipoEstadoCivil getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}

	/**
	 * Sets the tipo estado civil.
	 *
	 * @param tipoEstadoCivil the new tipo estado civil
	 */
	public void setTipoEstadoCivil(TipoEstadoCivil tipoEstadoCivil) {
		this.tipoEstadoCivil = tipoEstadoCivil;
	}

	/**
	 * Gets the tipo sexo.
	 *
	 * @return the tipo sexo
	 */
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}

	/**
	 * Sets the tipo sexo.
	 *
	 * @param tipoSexo the new tipo sexo
	 */
	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	/**
	 * Gets the contas.
	 *
	 * @return the contas
	 */
	public Set<Conta> getContas() {
		return contas;
	}

	/**
	 * Sets the contas.
	 *
	 * @param contas the new contas
	 */
	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder()
				.append(cpf)
				.toHashCode();
	}

	/**
	 * Equals.
	 *
	 * @param objeto the objeto
	 * @return true, if successful
	 */
	@Override
	public final boolean equals(Object objeto) {
		if (!(objeto instanceof Pessoa)) {
			return false;
		}
		if (this == objeto) {
			return true;
		}
		final Pessoa outroPessoa = (Pessoa) objeto;
		return new EqualsBuilder()
				.append(cpf, outroPessoa.cpf)
				.isEquals();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this, JSON_STYLE)
				.append("cpf", cpf)
				.append("nome", nome)
				.append("enderecos", enderecos)
				.append("dataNascimento", dataNascimento)
				.append("celulares", (celulares != null) ? celulares : "Sem celular")
				.append("telefonesFixo", (telefonesFixo != null) ? telefonesFixo : "Sem telefone fixo")
				.append("emails", (emails != null) ? emails : "Sem e-mail")
				.append("tipoGrauInstrucao", tipoGrauInstrucao)
				.append("tipoEstadoCivil", tipoEstadoCivil)
				.append("tipoSexo", tipoSexo)
				.append("contas", (contas != null) ? contas : "Sem conta bancária")
				.toString();
	}

}
