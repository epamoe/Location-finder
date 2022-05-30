package com.example.immolocation;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.ProprieteServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImmolocationApplicationTests {

    @Autowired
    BailleurRepository bailleurRepository;
    ProprieteServiceImp e = new ProprieteServiceImp();

    @Test
    public void save(){

        /*Bailleur bailleur=new Bailleur("alex","deparie",21,"marvel","ankara");
        bailleurRepository.save(bailleur);
        Propriete propriete1 = new Propriete("tres enorme","ankara","loundesk",true,1600);
        e.ajouterProprieter(propriete1,bailleur);
        System.out.println(propriete1.getBailleur().toString());
*/
    }

}
