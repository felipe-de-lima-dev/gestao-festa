package br.gov.etec.gestaofesta2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_convidado")
public class Convidado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvidado;
	private String nome;
	private int acompanhante;
	public Long getIdConvidado() {
		return idConvidado;
	}
	public void setIdConvidado(Long idConvidado) {
		this.idConvidado = idConvidado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAcompanhante() {
		return acompanhante;
	}
	public void setAcompanhante(int acompanhante) {
		this.acompanhante = acompanhante;
	}
	
	
}
