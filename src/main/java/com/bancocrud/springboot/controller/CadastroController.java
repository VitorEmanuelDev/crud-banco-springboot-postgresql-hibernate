package com.bancocrud.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bancocrud.springboot.exception.ResourceNotFoundException;
import com.bancocrud.springboot.model.Cadastro;
import com.bancocrud.springboot.repository.CadastroRepository;


@RestController
@RequestMapping("/api/v1")
public class CadastroController {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	//pegar todas as contas
	@GetMapping("/cadastros")
	@ResponseStatus(HttpStatus.OK)
	public List<Cadastro> getAllCadastros(){
		
		return this.cadastroRepository.findAll();
		
	}
	
	//pegar a conta pelo id
	@GetMapping("/cadastros/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cadastro> getCadastroById(@PathVariable(value = "id") Long cadastroId)
	    throws ResourceNotFoundException {
		
	    Cadastro cadastro = cadastroRepository.findById(cadastroId)
	      .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o ID :: " + cadastroId));
	    return ResponseEntity.ok().body(cadastro);
	    
	}
	
	//salvar conta
	@PostMapping("/cadastros")
	@ResponseStatus(HttpStatus.CREATED)
	public Cadastro createCadastro(@RequestBody Cadastro cadastro) {
		
		return this.cadastroRepository.save(cadastro);
		
	}
	
	//atualizar conta
	@PutMapping("/cadastros/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cadastro> updateCadastro(@PathVariable(value = "id") Long cadastroId,
    	@Validated @RequestBody Cadastro cadastroCaracteristicas) throws ResourceNotFoundException {
        Cadastro cadastro = cadastroRepository.findById(cadastroId)
        .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o ID :: " + cadastroId));
        
        cadastro.setCpf(cadastroCaracteristicas.getCpf());
        cadastro.setEmail(cadastroCaracteristicas.getEmail());
        cadastro.setNome(cadastroCaracteristicas.getNome());
        cadastro.setDataNascimento(cadastroCaracteristicas.getDataNascimento());
        
        return ResponseEntity.ok(this.cadastroRepository.save(cadastro));
        
    }
	
	//deletar conta
	@DeleteMapping("/cadastros/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> deleteCadastro(@PathVariable(value = "id") Long cadastroId) 
			throws ResourceNotFoundException {
	    Cadastro cadastro = cadastroRepository.findById(cadastroId)
	   .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada para o ID :: " + cadastroId));
	
	    this.cadastroRepository.delete(cadastro);
	    Map<String, Boolean> resposta = new HashMap<>();
	    resposta.put("cadastro deletado", Boolean.TRUE);
	    return resposta;
	}

}
