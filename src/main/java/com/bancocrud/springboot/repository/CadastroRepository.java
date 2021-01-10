package com.bancocrud.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancocrud.springboot.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

}
