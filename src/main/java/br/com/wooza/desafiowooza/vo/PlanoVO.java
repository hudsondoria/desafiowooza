package br.com.wooza.desafiowooza.vo;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planos")
public class PlanoVO {

	@Id
	private String codPlano;
	@NotNull
	private Integer minutos;
	@NotNull
	private Integer franquia;
	@NotNull
	private Double valor;
	@NotNull
	private String tipo;
	@NotNull
	private String operadora;
	private String[] dddsDisponiveis;
	@CreatedDate
	private Date dataInclusao;
	@LastModifiedDate
	private Date dataUltModificacao;
	
	public String getCodPlano() {
		return codPlano;
	}
	public void setCodPlano(String codPlano) {
		this.codPlano = codPlano;
	}
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	public Integer getFranquia() {
		return franquia;
	}
	public void setFranquia(Integer franquia) {
		this.franquia = franquia;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	public String[] getDddsDisponiveis() {
		return dddsDisponiveis;
	}
	public void setDddsDisponiveis(String[] dddsDisponiveis) {
		this.dddsDisponiveis = dddsDisponiveis;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataUltModificacao() {
		return dataUltModificacao;
	}
	public void setDataUltModificacao(Date dataUltModificacao) {
		this.dataUltModificacao = dataUltModificacao;
	}
	@Override
	public String toString() {
		return "PlanoVO [codPlano=" + codPlano + ", minutos=" + minutos + ", franquia=" + franquia + ", valor=" + valor
				+ ", tipo=" + tipo + ", operadora=" + operadora + ", dddsDisponiveis="
				+ Arrays.toString(dddsDisponiveis) + ", dataInclusao=" + dataInclusao + ", dataUltModificacao="
				+ dataUltModificacao + "]";
	}
	
}
