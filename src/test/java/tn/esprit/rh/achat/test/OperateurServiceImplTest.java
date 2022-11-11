package tn.esprit.rh.achat.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {

	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(OperateurServiceImplTest.class);
	
	@Autowired
	OperateurRepository operateurRepository ;
	
	@Autowired
	IOperateurService iOperateurService;

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testaddOperateur() {
		Operateur operateur = new Operateur("OperateurTest", "OperateurTest");
		iOperateurService.addOperateur(operateur);
	assertNotNull(operateur.getIdOperateur());
	l.info("Mission added successfuly ");
	operateurRepository.deleteById(operateur.getIdOperateur());
	
	
	
}
	@Test
	public void testList() {
	List<Operateur> o = (List<Operateur>) operateurRepository.findAll();
	assertThat(o).size().isPositive();
	l.info( "> 0");
	}
	

}
