package com.example.carros.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private Integer ano_fabricacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(Integer ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	
	
	
}