package com.example.immolocation.Controleur;

import com.example.immolocation.Model.Proprietes;
import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.IProprietesServices;
import com.example.immolocation.Service.IimageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Publication_controller {

    @Autowired
    IProprietesServices iProprietesServices;
    @Autowired
    IimageServices iimageServices;
    @Autowired
    IBailleurServices iBailleurServices;


    @GetMapping("/publication")
    public String publication(Model model){
        List<Proprietes> proprietesList=iProprietesServices.findAllFreePropriete();
        model.addAttribute("proprietes",proprietesList);
        return "publication";
    }



}