package br.com.contmatic.model.empresa;

import static br.com.contmatic.utilidades.ConstantesString.RAZAO_SOCIAL;

import static br.com.contmatic.utilidades.MensagensErro.DATA_PASSADO;
import static br.com.contmatic.utilidades.MensagensErro.RAZAO_SOCIAL_INVALIDO;
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

import br.com.contmatic.anotacoes.CNPJbr;
import br.com.contmatic.anotacoes.CollectionComElementoNaoNulo;
import br.com.contmatic.model.conta.Conta;
import br.com.contmatic.model.contato.Celular;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.TelefoneFixo;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.pessoa.ContratoTrabalho;
import br.com.contmatic.model.pessoa.Pessoa;

/**
 * The Class Empresa.
 */
public class Empresa {

	/** The cnpj. */
	@NotNull(message = VALOR_NULO)
	@CNPJbr
	private String cnpj;

	/** The razao social. */
	@NotNull(message = VALOR_NULO)
	@Pattern(regexp = RAZAO_SOCIAL, message = RAZAO_SOCIAL_INVALIDO)
	private String razaoSocial;

	/** The data abertura. */
	@NotNull(message = VALOR_NULO)
	@Past(message = DATA_PASSADO)
	private LocalDate dataAbertura;

	/** The responsaveis. */
	@NotNull(message = VALOR_NULO)
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Pessoa> responsaveis;

	/** The contratos trabalho. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<ContratoTrabalho> contratosTrabalho;

	/** The enderecos. */
	@NotNull(message = VALOR_NULO)
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Endereco> enderecos;

	/** The telefones fixo. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<TelefoneFixo> telefonesFixo;

	/** The emails. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Email> emails;

	/** The celulares. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Celular> celulares;

	/** The contas. */
	@CollectionComElementoNaoNulo
	@Valid
	private Set<Conta> contas;

	/** The tipo empresa. */
	@NotNull(message = VALOR_NULO)
	private TipoEmpresa tipoEmpresa;

	/** The tipo porte empresa. */
	@NotNull(message = VALOR_NULO)
	private TipoPorteEmpresa tipoPorteEmpresa;

	/**
	 * Instantiates a new empresa.
	 *
	 * @param cnpj the cnpj
	 * @param razaoSocial the razao social
	 * @param dataAbertura the data abertura
	 * @param responsaveis the responsaveis
	 * @param enderecos the enderecos
	 * @param tipoEmpresa the tipo empresa
	 * @param tipoPorteEmpresa the tipo porte empresa
	 */
	public Empresa(String cnpj, String razaoSocial, LocalDate dataAbertura, Set<Pessoa> responsaveis,
			Set<Endereco> enderecos, TipoEmpresa tipoEmpresa, TipoPorteEmpresa tipoPorteEmpresa) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.dataAbertura = dataAbertura;
		this.responsaveis = responsaveis;
		this.enderecos = enderecos;
		this.tipoEmpresa = tipoEmpresa;
		this.tipoPorteEmpresa = tipoPorteEmpresa;
	}

	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Gets the razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Sets the razao social.
	 *
	 * @param razaoSocial the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Gets the data abertura.
	 *
	 * @return the data abertura
	 */
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	/**
	 * Sets the data abertura.
	 *
	 * @param dataAbertura the new data abertura
	 */
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	/**
	 * Gets the responsaveis.
	 *
	 * @return the responsaveis
	 */
	public Set<Pessoa> getResponsaveis() {
		return responsaveis;
	}

	/**
	 * Sets the responsaveis.
	 *
	 * @param responsaveis the new responsaveis
	 */
	public void setResponsaveis(Set<Pessoa> responsaveis) {
		this.responsaveis = responsaveis;
	}

	/**
	 * Gets the contratos trabalho.
	 *
	 * @return the contratos trabalho
	 */
	public Set<ContratoTrabalho> getContratosTrabalho() {
		return contratosTrabalho;
	}

	/**
	 * Sets the contratos trabalho.
	 *
	 * @param contratosTrabalho the new contratos trabalho
	 */
	public void setContratosTrabalho(Set<ContratoTrabalho> contratosTrabalho) {
		this.contratosTrabalho = contratosTrabalho;
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
	 * Gets the tipo empresa.
	 *
	 * @return the tipo empresa
	 */
	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * Sets the tipo empresa.
	 *
	 * @param tipoEmpresa the new tipo empresa
	 */
	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	/**
	 * Gets the tipo porte empresa.
	 *
	 * @return the tipo porte empresa
	 */
	public TipoPorteEmpresa getTipoPorteEmpresa() {
		return tipoPorteEmpresa;
	}

	/**
	 * Sets the tipo porte empresa.
	 *
	 * @param tipoPorteEmpresa the new tipo porte empresa
	 */
	public void setTipoPorteEmpresa(TipoPorteEmpresa tipoPorteEmpresa) {
		this.tipoPorteEmpresa = tipoPorteEmpresa;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder()
				.append(cnpj)
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
		if (!(objeto instanceof Empresa)) {
			return false;
		}
		if (this == objeto) {
			return true;
		}
		final Empresa outroEmpresa = (Empresa) objeto;
		return new EqualsBuilder()
				.append(cnpj, outroEmpresa.cnpj)
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
				.append("cnpj", cnpj)
				.append("razaoSocial", razaoSocial)
				.append("dataAbertura", dataAbertura)
				.append("responsaveis", responsaveis)
				.append("contratosTrabalho", contratosTrabalho)	
				.append("enderecos", enderecos)		
				.append("telefonesFixo", (telefonesFixo != null) ? telefonesFixo : "Sem telefone fixo")
				.append("emails", (emails != null) ? emails : "Sem e-mail")
				.append("celulares", (celulares != null) ? celulares : "Sem celular")
				.append("contas", (contas != null) ? contas : "Sem conta bancária")
				.append("tipoEmpresa", tipoEmpresa)
				.append("tipoPorteEmpresa", tipoPorteEmpresa)
				.toString();
	}
	
}
