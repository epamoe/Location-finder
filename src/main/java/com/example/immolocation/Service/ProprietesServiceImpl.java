package com.example.immolocation.Service;


import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Dao.ProprietesRepository;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Model.Proprietes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProprietesServiceImpl {

	@Autowired
	private ProprietesRepository proprietesRepository;
	
	public void savePropriete(Proprietes propriete) {
		proprietesRepository.save(propriete);
	}

	public List<Proprietes> getAllActivePropriete() {
		return proprietesRepository.findAll();
	}

	public Optional<Proprietes> getProprieteById(Long id) {
		return proprietesRepository.findById(id);
	}
}

