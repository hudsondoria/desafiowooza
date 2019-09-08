package br.com.wooza.desafiowooza.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.wooza.desafiowooza.facade.PlanosFacade;
import br.com.wooza.desafiowooza.vo.PlanoVO;
import br.com.wooza.desafiowooza.vo.TipoDDD;

@Controller
@RequestMapping("/planos")
public class PlanosController {

	@Autowired
	PlanosFacade planosFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody PlanoVO consultarPlano(@PathVariable("id") String id) {
		return planosFacade.consultarPlano(id);
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<PlanoVO> cadastrarPlano(@Valid @RequestBody PlanoVO novoPlano) {
		PlanoVO planoCadastrado = planosFacade.salvarPlano(novoPlano);
		if(planoCadastrado == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
		
			return ResponseEntity.ok(planoCadastrado);
		}
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void removerPlano(@PathVariable("id") String id) {
		
		planosFacade.removerPlano(planosFacade.consultarPlano(id));
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseEntity<?> consultarPorTipoDDD(@RequestBody TipoDDD tipoDDD) {
		
		List<PlanoVO> resultado = planosFacade.consultarPlanoTipo(tipoDDD.tipo, tipoDDD.ddd);
		if(resultado == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
		
			return ResponseEntity.ok(resultado);
		}
	}
	
}
