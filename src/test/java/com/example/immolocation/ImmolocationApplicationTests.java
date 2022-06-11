package com.example.immolocation;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.ProprieteServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ImmolocationApplicationTests {

    @Autowired
    BailleurRepository bailleurRepository;

  /*  @Autowired
    IProprieteServices iProprieteServices;

    @Autowired
    ProprieteRepository proprieteRepository;

    @Test
    public void save(){

        Bailleur bailleur=new Bailleur("alex","deparie",21,"marvel","ankara");
        bailleurRepository.save(bailleur);
        Propriete propriete1 = new Propriete("tres enorme","ankara","loundesk",true,1600);
        e.ajouterProprieter(propriete1,bailleur);
        System.out.println(propriete1.getBailleur().toString());

}
    /*
    @Test
    public void findprop(){
        List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(bailleurRepository.findById(1L).get());
        System.out.println(proprieteList.get(0).toString());

    }

    @Test
    public void findpropriete(){
        List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(bailleurRepository.findById(1L).get());
        for(int i=0;i< proprieteList.size();i++) {
            System.out.println(proprieteList.get(i).toString());

        }
        Propriete propriete=proprieteList.get(5);
        iProprieteServices.supprimerPropriete(propriete.getId_propriete());
        System.out.println("vous avez supprimez la propriete suivante:"+propriete.toString());
    }

    @Test
    public void Save(){
       Propriete propriete=new Propriete("hoolé","makarie","eozuj",false,50,bailleurRepository.findById(2L).get());
        iProprieteServices.ajouterProprieter(propriete,bailleurRepository.findById(2L).get());

    }

    @Test
    public void consulterPropriete() {

        Propriete propriete= proprieteRepository.findById(9L);
        System.out.println(propriete.toString());


    }
*/

 /*   @Test
    public void bailleur(){
        Bailleur bailleur=bailleurRepository.findById(1L).get();
        System.out.println(bailleur.toString());
    }


*/



}

