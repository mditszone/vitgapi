
package com.vitg.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitg.dto.CourseDTO;
import com.vitg.dto.SubTopicConceptDTO;
import com.vitg.dto.SubTopicDTO;
import com.vitg.entity.Course;
import com.vitg.entity.SubTopic;
import com.vitg.entity.SubTopicConcept;
import com.vitg.mappers.SubTopicConceptMappers;
import com.vitg.repository.CourseRepository;
import com.vitg.repository.SubTopicConceptRepository;
import com.vitg.service.CourseService;
import com.vitg.service.SubTopicConceptService;


@Service
public  class SubTopicConceptServiceImpl implements SubTopicConceptService{


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SubTopicConceptRepository subTopicConceptRepository;


	@Autowired
	private SubTopicConceptMappers subTopicConceptMapper;

	@Transactional
	public SubTopicConceptDTO createSubTopicConcept(SubTopicConceptDTO subTopicConceptDTO) {

		SubTopicConcept subTopicConcept=(SubTopicConcept) modelMapper.map(subTopicConceptDTO, SubTopicConcept.class);

		SubTopicConcept savedSubTopicConcept= subTopicConceptRepository.save(subTopicConcept);
		SubTopicConceptDTO subTopicConceptDTOResponse=modelMapper.map(savedSubTopicConcept, SubTopicConceptDTO.class);

		return subTopicConceptDTOResponse;
	}
	public SubTopicConceptDTO getSubTopicConceptById(int id) {

		SubTopicConcept subTopicConcept=subTopicConceptRepository.findById(id);

		SubTopicConceptDTO subTopicConceptDTO = subTopicConceptMapper.subTopicConceptToSubTopicConceptDTO(subTopicConcept);

		//Optional<User> user=userRepository.findById(id);

		return subTopicConceptDTO;

	}
	
	public List<SubTopicConceptDTO> getAllSubTopicConcepts(){
		List<SubTopicConcept>  subTopicConceptList=subTopicConceptRepository.findAll();
		List<SubTopicConceptDTO> subTopicConceptDTOList=new ArrayList<>();
		for(SubTopicConcept subTopicConcept:subTopicConceptList) {
			SubTopicConceptDTO subTopicConceptDTO=modelMapper.map(subTopicConcept, SubTopicConceptDTO.class);
			subTopicConceptDTOList.add(subTopicConceptDTO);
		}

		return subTopicConceptDTOList;
	}
	public SubTopicConceptDTO updateSubTopicConcept(SubTopicConceptDTO subTopicConceptDTO) {
		SubTopicConcept subTopicConcept=(SubTopicConcept) modelMapper.map(subTopicConceptDTO, SubTopicConcept.class);
		SubTopicConcept subTopicConceptResponse=subTopicConceptRepository.save(subTopicConcept);
		SubTopicConceptDTO subTopicConceptDTOResponse=(SubTopicConceptDTO) modelMapper.map(subTopicConceptResponse, SubTopicConceptDTO.class);
		return subTopicConceptDTOResponse;

	}
	@Override
	public SubTopicConceptDTO saveSubTopicConcept(SubTopicConceptDTO subTopicConceptDTO) {
		SubTopicConcept subTopicConcept=modelMapper.map(subTopicConceptDTO, SubTopicConcept.class);
		SubTopicConcept SubTopicConceptResponse=subTopicConceptRepository.save(subTopicConcept);
		SubTopicConceptDTO subTopicConceptDTOResponse=modelMapper.map(SubTopicConceptResponse, SubTopicConceptDTO.class);
		return subTopicConceptDTOResponse;
	}

	@Override
	public void deleteById(int id) {
		subTopicConceptRepository.deleteById(id);

	}

	



}