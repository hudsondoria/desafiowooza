package br.com.wooza.desafiowooza;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.wooza.desafiowooza.facade.PlanosFacade;
import br.com.wooza.desafiowooza.vo.PlanoVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesafiowoozaApplicationTests {
	
	protected final Logger log = LoggerFactory.getLogger(DesafiowoozaApplicationTests.class);
	
	@Autowired
	PlanosFacade planosFacade;

	@Test
	public void criarPlano() {
		log.info("******** Criando Plano **********");
		PlanoVO novoPlano = new PlanoVO();
		novoPlano.setMinutos(1000);
		novoPlano.setFranquia(4);
		novoPlano.setValor(59.90);
		novoPlano.setTipo("Controle");
		novoPlano.setOperadora("Claro");
		
		String[]ddds = {"021","011","034","033"};
		novoPlano.setDddsDisponiveis(ddds);
		
		log.info(planosFacade.salvarPlano(novoPlano).toString());
	}

	@Test
	public void pesquisarPlanoPorTipoDDD() {
		log.info("******** Pesquisar Plano por Tipo e DDD **********");
		log.info(planosFacade.consultarPlanoTipo("controle", "074").toString());
	}
	
	@Test
	public void pesquisarPlanoPorOperadoraDDD() {
		log.info("******** Pesquisar Plano por Operadora e DDD **********");
		log.info(planosFacade.consultarPlanoOperadora("Claro", "021").toString());
	}
	
	@Test
	public void pesquisarPlanoPorCodigo() {
		log.info("******** Pesquisar Plano por Código do Plano **********");
		log.info(planosFacade.consultarPlano("5d7435c8f3bd192f9cf20975").toString());
	}
	
	@Test
	public void removerPlano() {
		log.info("******** Removendo Plano **********");
		PlanoVO plano = planosFacade.consultarPlanoTipo("controle", "033").get(0);
		log.info(plano.toString());
		planosFacade.removerPlano(plano);
		log.info("Plano removido!");
	}
	
}
