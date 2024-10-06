package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Trainer;
import com.repository.TrainerRepository;

@Service
public class TrainerService {
	
	@Autowired
	TrainerRepository trainerRepository;
	
	public List<Trainer> findAllTrainer(){
		return trainerRepository.findAll();
	}
	
	public String storeTrainer(Trainer trainer) {
		if(trainerRepository.existsById(trainer.getTid())) {
			return "Trainer id must be unique";
		}else {
			trainerRepository.save(trainer);
			return "Trainer details stored";	
		}
	}

	public String deleteTrainerDetails(int tid) {
		//if(trainerRepository.existsById(tid)) {
			trainerRepository.deleteById(tid);
			return "Trainer record deleted";
	//	}else {
	//		return "Trainer record not present";	
	//	}
	}
	
	public String updateTrainerTechnology(Trainer trainer) {		// id and tech 
		Optional<Trainer> result = trainerRepository.findById(trainer.getTid());
		if(result.isPresent()){
			Trainer t = result.get();		// t hold record from db 
			t.setTech(trainer.getTech());
			trainerRepository.saveAndFlush(t);
			return "Trainer technology updated successfully";
		}else {
			return "Trainer record not present";	
		}
	}
	
	public Trainer findTrainerById(int tid) {		// it pass 
		Optional<Trainer> result = trainerRepository.findById(tid);
		if(result.isPresent()){
			Trainer t = result.get();	
			return t;				// return trainer object. 
		}else {
			return null;	
		}
	}
}
