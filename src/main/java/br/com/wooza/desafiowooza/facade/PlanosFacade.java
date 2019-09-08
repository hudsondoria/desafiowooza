package br.com.wooza.desafiowooza.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wooza.desafiowooza.repositories.PlanosRepository;
import br.com.wooza.desafiowooza.vo.PlanoVO;

@Service
public class PlanosFacade {

	@Autowired
	PlanosRepository planosRepo;
	
	/**
	 * Registra ou altera um plano na base
	 * @param plano
	 * @return Plano salvo
	 */
	public PlanoVO salvarPlano(PlanoVO plano) {
		return planosRepo.save(plano);
	}
	
	/**
	 * Remove o plano da base
	 * @param plano
	 */
	public void removerPlano(PlanoVO plano) {
		planosRepo.delete(plano);
	}
	
	/**
	 * Realiza a consulta do plano pelo código do plano
	 * @param codPlano
	 * @return Único plano
	 */
	public PlanoVO consultarPlano(String codPlano) {
		return planosRepo.findByCodPlano(codPlano);
	}
	
	/**
	 * Realiza a consulta do plano pelo tipo do plano e o DDD
	 * @param tipo
	 * @param ddd
	 * @return Lista de Planos
	 */
	public List<PlanoVO> consultarPlanoTipo(String tipo, String ddd) {
		return planosRepo.findByTipoIgnoreCaseAndDddsDisponiveisIn(tipo, ddd);
	}
	
	/**
	 * Realiza a consulta do plano pelo nome da operadora e o DDD
	 * @param operadora
	 * @param ddd
	 * @return Lista de Planos
	 */
	public List<PlanoVO> consultarPlanoOperadora(String operadora, String ddd) {
		return planosRepo.findByOperadoraIgnoreCaseAndDddsDisponiveisIn(operadora, ddd);
	}
	
}
