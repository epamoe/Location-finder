package com.example.immolocation.Service;

import com.example.immolocation.Dao.FactureRepository;
import com.example.immolocation.Dao.LocatireRepository;
import com.example.immolocation.Model.Facture;
import com.example.immolocation.Model.Locataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.abs;

@Service
public class ServiceFacture {

    @Autowired
    Facture facture;

    @Autowired
    LocatireRepository locataireRepository;

    @Autowired
    private FactureRepository factureRepository;


    //retoure la liste des facture selon les id

    public List<Facture> Liste_de_facture(long id) {

       return factureRepository.liste_facture(id);
    }


    public int derniere_dette_loc(long id) {

        List<Facture> test= factureRepository.dernier_facture_loc(id);

       return  test.get(0).getDette();
    }


    public int dernier_avance_loc(long id) {

        List<Facture> test= factureRepository.dernier_facture_loc(id);

        return  test.get(0).getAvance();
    }


    public int dernier_surplus_loc(long id) {

        List<Facture> test= factureRepository.dernier_facture_loc(id);

        return  test.get(0).getSurplus();
    }
    //methode permetant de facture elle attriebut une facture facture a un locatiare

    public void attribuer_fact(long id, int montant)
    {
        long montant_mensuel=locataireRepository.montant_mentuel(id);

       if( derniere_dette_loc(id)>0 && dernier_avance_loc(id)==0)
       {
           int soustraction_dette_montant=derniere_dette_loc(id)-montant;
           int soustraction_montant_dette=montant-derniere_dette_loc(id);


           if (soustraction_dette_montant==0) {
               facture.setMontant(0);
               facture.setDette((int) montant_mensuel);
           }
     /*
         if( locataireRepository.montant_mentuel(id)==soustraction_dette_montant)
          {
           facture.setDette(soustraction_dette_montant);

        }*/

           if( locataireRepository.montant_mentuel(id)==soustraction_montant_dette)
           {
               facture.setMontant(soustraction_montant_dette);
            }


           if ( montant_mensuel>soustraction_montant_dette){
               facture.setAvance( abs(soustraction_montant_dette + dernier_avance_loc(id)));
               facture.setDette((int) (montant_mensuel-soustraction_montant_dette));
           }

           if( montant_mensuel<soustraction_montant_dette){
               facture.setMontant((int) locataireRepository.montant_mentuel(id));
               facture.setSurplus((int) (soustraction_dette_montant-montant_mensuel));
           }

       }

        if(derniere_dette_loc(id)==0 && dernier_surplus_loc(id)==0){
            if (montant_mensuel>montant){
                //facture.setAvance(montant);
                facture.setDette((int) abs(montant_mensuel-montant));
            }
            else if (montant_mensuel<montant){
                facture.setSurplus((int) abs(montant-montant_mensuel));
                facture.setMontant((int) montant_mensuel);
            }
        }


        ////////////////////////////valide
        if(derniere_dette_loc(id)==0 && dernier_surplus_loc(id)>0){
           long avance =dernier_surplus_loc(id)-montant_mensuel;
            int  somme_montant_avance = (int) (avance+montant);
            if(avance<0){
                        if( somme_montant_avance<montant_mensuel ){
                            facture.setAvance( somme_montant_avance );
                            facture.setDette((int) (montant_mensuel-somme_montant_avance));
                        }
                        else if(  somme_montant_avance ==montant_mensuel){
                            facture.setMontant(somme_montant_avance);
                        }
                        else if(somme_montant_avance>montant_mensuel){
                            facture.setMontant((int) montant_mensuel);
                            facture.setSurplus((int) (somme_montant_avance-montant_mensuel));
                        }
            }
            else if(avance==0){
                facture.setMontant((int) montant_mensuel);
                facture.setSurplus(montant);
            }
            else if(avance>0){
                facture.setMontant((int) montant_mensuel);
                facture.setSurplus((int) (avance+montant));
            }

        }
        if(dernier_avance_loc(id)>0 && derniere_dette_loc(id)==0) {

          int somme_avance_montant = dernier_avance_loc(id) + montant;
          if (somme_avance_montant==montant_mensuel){
              facture.setMontant(somme_avance_montant);
          }
          else if(montant_mensuel>somme_avance_montant) {
              facture.setMontant(0);
              facture.setDette((int) (montant_mensuel-somme_avance_montant));
          }
          else if(montant_mensuel<somme_avance_montant) {
              facture.setMontant((int) montant_mensuel);
              facture.setSurplus((int) (somme_avance_montant - montant_mensuel));
          }



        }
                  facture.setLocataire(locataireRepository.findById(id));
                  factureRepository.save(facture);
    }
}

/*        Locataire locataire =locataireRepository.findById(id);
            facture.setLocataire(locataire);
          if (montant == (int) locataireRepository.montant_mentuel(id)){
              factureRepository.save(facture);
          }
          else if (montant < (int) locataireRepository.montant_mentuel(id))
          {
              facture.setDette((int) locataireRepository.montant_mentuel(id)-montant);
              facture.setAvance(montant);
              facture.setMontant(0);
              factureRepository.save(facture);
          }else
          {
            facture.setSurplus(montant-(int)locataireRepository.montant_mentuel(id));
              factureRepository.save(facture);
          }
            facture.setMontant(montant);
           factureRepository.save(facture);
*/


   /* public void avertissement_dette() {
        chrono.schedule(new TimerTask() {

            @Override
            public void run() {

            }
        }, 700000000, 70000000);
    }
*/