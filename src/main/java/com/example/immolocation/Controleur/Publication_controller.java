package com.example.immolocation.Controleur;

import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.IimageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Publication_controller {

    @Autowired
    IProprieteServices iProprieteServices;
    @Autowired
    IimageServices iimageServices;
    @Autowired
    IBailleurServices iBailleurServices;

    @RequestMapping("/")
    public String index() {

        return "/Accueil";
    }
/*
    @RequestMapping("/publication")
    public String publication(Model model) {

     *//*   ArrayList<?> arrayList=new ArrayList<>();
       List<Propriete> proprieteList= iProprieteServices.findAllFreePropriete();
       List<Image> imageList=new ArrayList<>();

       for(int i=0;i<proprieteList.size();i++){
           imageList=iimageServices.RechercherParPropriete(proprieteList.get(i));

       }
*//*  *//*List<Bailleur> bailleurList=new ArrayList<>();
        List<Propriete> proprieteList = iProprieteServices.findAllFreePropriete();
        List<Image> imageList=new ArrayList<>();
        for(int i=0;i<proprieteList.size();i++){
            imageList=iimageServices.RechercherParPropriete(proprieteList.get(i));

        }
        //List<Propriete> proprieteList1=proprieteRepository.findAll();
        for(int j=0;j<iProprieteServices.findAllFreePropriete().size();j++){
            Propriete  propriete =iProprieteServices.findAllFreePropriete().get(j);
            proprieteList.add(propriete);
            propriete.
            bailleurList.add(propriete.getBailleur());
        }


       model.addAttribute("imageList",imageList);
       model.addAttribute("bailleurList",bailleurList);
       model.addAttribute("proprieteList",proprieteList);
       return "publication";
    }*//*
    }*/




}