package br.com.wooza.desafiowooza.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.wooza.desafiowooza.vo.PlanoVO;

public interface PlanosRepository extends CrudRepository<PlanoVO, Long>{
	
	public PlanoVO findByCodPlano(String codPlano);
	public List<PlanoVO> findByTipoIgnoreCaseAndDddsDisponiveisIn(String tipo, String ddd);
	public List<PlanoVO> findByOperadoraIgnoreCaseAndDddsDisponiveisIn(String operadora, String ddd);

}
