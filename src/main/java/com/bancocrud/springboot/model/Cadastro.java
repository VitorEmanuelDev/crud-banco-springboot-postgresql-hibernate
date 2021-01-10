package com.bancocrud.springboot.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CadastrosDB", uniqueConstraints={@UniqueConstraint(columnNames={"CPF", "EMAIL"})})
public class Cadastro {

    private long id;
    @NotNull
    @Pattern(regexp="\\d{11}", message = "Apenas informe 11 digitos.")
    private String cpf;
    @NotNull
    @Size(min=2, max=100)
    private String nome;
    @NotNull
    @Email
    @Pattern(regexp=".+@.+\\..+", message = "Informe um e-mail válido")
    private String email;
    @NotNull
    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
 
    public Cadastro() {
  
    }
 
    public Cadastro(String cpf, String nome, String email, LocalDate dataNascimento) {
         this.cpf = cpf;
         this.nome = nome;
         this.email = email;
         this.dataNascimento = dataNascimento;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "NOME",nullable = false)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "CPF", nullable = false, unique = true)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    @Column(name = "EMAIL", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "NASCIMENTO", nullable = false)
    public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

    @Override
    public String toString() {
        return "Cadastro [id=" + id + ", Nome=" + nome + ", CPF=" + cpf + ", e-mail=" + email + ", data de nascimento=" + dataNascimento + "]";
    }

}