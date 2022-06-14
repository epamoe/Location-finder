package com.example.immolocation;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.IimageServices;
import com.example.immolocation.Service.ProprieteServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ImmolocationApplicationTests {

    @Autowired
    BailleurRepository bailleurRepository;

    @Autowired
    IProprieteServices iProprieteServices;

    @Autowired
    ProprieteRepository proprieteRepository;

    @Autowired
    IimageServices iimageServices;

    @Autowired
    IBailleurServices iBailleurServices;

    @Test
    public void save(){

        /*Bailleur bailleur=new Bailleur("alex","deparie",21,"marvel","ankara");
        bailleurRepository.save(bailleur);*/
       /* Propriete propriete1 = new Propriete("tres enorme","ankara","loundesk",true,1600);
        e.ajouterProprieter(propriete1,bailleur);
        System.out.println(propriete1.getBailleur().toString());*/

    }
   /* @Test
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
       //Propriete propriete=new Propriete("hoolé","makarie","eozuj",false,50,bailleurRepository.findById(2L).get());
        //iProprieteServices.ajouterProprieter(propriete,bailleurRepository.findById(2L).get());

    }

    @Test
    public void consulterPropriete() {

        Propriete propriete= proprieteRepository.findById(9L);
        System.out.println(propriete.toString());


    }

    @Test
    public void bailleur(){
        Bailleur bailleur=bailleurRepository.findById(1L).get();
        System.out.println(bailleur.toString());
    }


    @Test
    public void publier(){
        List<Propriete> proprieteList = iProprieteServices.findAllFreePropriete();
       List<Image> imageList=new ArrayList<>();
        for(int i=0;i<proprieteList.size();i++){
            imageList=iimageServices.RechercherParPropriete(proprieteList.get(i));

        }
        //List<Propriete> proprieteList1=proprieteRepository.findAll();
        for(int j=0;j<iProprieteServices.findAllFreePropriete().size();j++){
          Propriete  propriete =iProprieteServices.findAllFreePropriete().get(j);
            proprieteList.add(propriete);
            System.out.println("numero du bailleur: "+proprieteList.get(j).getBailleur().getTelephone());

            System.out.println("description : "+proprieteList.get(j).getDescription());

            System.out.println("locaalisation: "+proprieteList.get(j).getLocalisation());

            System.out.println("prix de la propriete: "+proprieteList.get(j).getPrix());
        }*/
    }
  /*  @Test
    public void publier2(){
        List<Propriete> proprieteList = iProprieteServices.findAllFreePropriete();
        List<Image> imageList=new ArrayList<>();

        for(int i=0;i<proprieteList.size();i++){
            imageList=iimageServices.RechercherParPropriete(proprieteList.get(i));

        }
        //List<Propriete> proprieteList1=proprieteRepository.findAll();
        for(int j=0;j<iProprieteServices.findAllFreePropriete().size();j++){
            imageList=iimageServices.RechercherParPropriete(proprieteList.get(j));

            System.out.println("numero du bailleur: "+proprieteList.get(j).getBailleur().getTelephone());

            System.out.println("description : "+proprieteList.get(j).getDescription());

            System.out.println("locaalisation: "+proprieteList.get(j).getLocalisation());

            System.out.println("prix de la propriete: "+proprieteList.get(j).getPrix());
        }

    }*/



