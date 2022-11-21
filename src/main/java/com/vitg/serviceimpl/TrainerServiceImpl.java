package com.vitg.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.TrainerDTO;
import com.vitg.entity.Role;
import com.vitg.entity.Trainer;
import com.vitg.entity.User;
import com.vitg.mappers.TrainerMapper;
import com.vitg.repository.TrainerRepository;
import com.vitg.repository.UserRepository;
import com.vitg.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrainerMapper trainerMapper;

	@Autowired
	private TrainerRepository trainerRepository;

	@Autowired
	private UserRepository userRepository;



	public TrainerDTO getTrainerById(int id) {

		Trainer trainer=trainerRepository.findById(id);
		TrainerDTO trainerDTO = trainerMapper.trainerToTrainerDTO(trainer);

		//Optional<User> user=userRepository.findById(id);

		return trainerDTO;

	}

	public void deleteById(int id) {
		trainerRepository.deleteById(id);
	}

	@Override
	public TrainerDTO saveTrainer(TrainerDTO trainerDTO) {

		Trainer trainer=modelMapper.map(trainerDTO, Trainer.class);
		Trainer TrainerResponse=trainerRepository.save(trainer);
		TrainerDTO trainerDTOResponse=modelMapper.map(TrainerResponse, TrainerDTO.class);
		return trainerDTOResponse;
	}

	public List<TrainerDTO> getAllTrainers(){
		List<Trainer>  trainerList=trainerRepository.findAll();

		List<TrainerDTO> trainerDTOList=new ArrayList<>();

		for(Trainer trainer:trainerList) {
			TrainerDTO trainerDTO=modelMapper.map(trainer, TrainerDTO.class);
			trainerDTOList.add(trainerDTO);
		}

		return trainerDTOList;
	}

	public TrainerDTO updateTrainer(TrainerDTO trainerDTO) {
		Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
		Trainer trainerResponse = trainerRepository.save(trainer);
		Role role = trainerResponse.getRole();
		User user = userRepository.findByPhoneNumber(trainer.getPhoneNumber());
		user.setRole(role);
		userRepository.save(user);
		TrainerDTO trainerDTOResponse = modelMapper.map(trainerResponse, TrainerDTO.class);
		return trainerDTOResponse;

	}
}
