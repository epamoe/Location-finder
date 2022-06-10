package com.example.immolocation.Service;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationServiceImpl implements IPublicationServices {

    @Autowired
    IProprieteServices iProprieteServices;
    @Autowired
    IBailleurServices iBailleurServices;
    @Autowired
    IimageServices iimageServices;

    @Override
    public List publier() {

        List<Propriete> proprieteList=iProprieteServices.findAllFreePropriete();
    return proprieteList;
    }

}
