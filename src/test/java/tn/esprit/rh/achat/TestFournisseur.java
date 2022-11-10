package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.Rollback;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class TestFournisseur {
	
	 @Mock
	    private FournisseurRepository fournisseurRepository;

	    @InjectMocks
	    private FournisseurServiceImpl FournisseurService;
     //test add
	@Test
	 @Rollback(value = false)
	public void testAddFournisseur() {
		
		Fournisseur f = new Fournisseur();
        f.setLibelle("Test Code");
        when(fournisseurRepository.save(ArgumentMatchers.any(Fournisseur.class))).thenReturn(f);
        Fournisseur created = FournisseurService.addFournisseur(f);
        assertThat(created.getLibelle()).isSameAs(f.getLibelle());
        verify(fournisseurRepository).save(f);
		//fail("Not yet implemented");
	}
    //test get all
	@Test
    @Rollback(value = false)
    public void testretrieveAllFournisseurs(){
        List<Fournisseur> fList = new ArrayList<>();
        fList.add( new Fournisseur());
       // given(fournisseurRepository.findAll()).willReturn(fList);
        List<Fournisseur> expected = FournisseurService.retrieveAllFournisseurs();
        assertEquals(expected, fList);
        verify(fournisseurRepository).findAll();
    }
	//test get by id
	 @Test
	    public void testretreiveFournisseurByid() {
	        Fournisseur f = new Fournisseur();
	        f.setIdFournisseur(100L);
	        f.setLibelle("Test Libelle");
	        f.setCode("Test Code");

	        when(fournisseurRepository.findById(f.getIdFournisseur())).thenReturn(Optional.of(f));

	      //  Fournisseur expected = f.retrieveFournisseur(f.getIdFournisseur());

	       // assertThat(expected).isSameAs(f);
	        verify(fournisseurRepository).findById(f.getIdFournisseur());
	    }
	
	 
	//test delete
	@Test
    @Rollback(value = false)
    public void TestDeleteFournisseur(){
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(1L);
        f.setLibelle("Test Libelle");
        f.setCode("Test Code");

        when(fournisseurRepository.findById(f.getIdFournisseur())).thenReturn(Optional.of(f));

        FournisseurService.deleteFournisseur(f.getIdFournisseur());
        verify(fournisseurRepository).deleteById(f.getIdFournisseur());
    }
	//test update
	
	@Test
    public void TestUpdateFournisseur() {
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(89L);
        f.setLibelle("Test Libelle");
        f.setCode("Test Code");

        Fournisseur  Fournisseur = new Fournisseur();
        f.setLibelle("New Test Libelle");

        FournisseurService.updateFournisseur(Fournisseur);
        verify(fournisseurRepository).save(Fournisseur);
    }
	
	// test exception
	@Test(expected = RuntimeException.class)
    public void ExceptionwhenFournisseurNotExsit(){
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(89L);
        f.setLibelle("Test Libelle");
        f.setCode("Test Code");

        //given(fournisseurRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        FournisseurService.deleteFournisseur(f.getIdFournisseur());
    }

}
