

package com.vitg.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitg.dto.CourseDTO;
import com.vitg.dto.SubCourseDTO;
import com.vitg.dto.SubTopicConceptDTO;
import com.vitg.dto.SubTopicDTO;
import com.vitg.dto.TopicDTO;
import com.vitg.entity.Course;
import com.vitg.entity.SubCourse;
import com.vitg.entity.SubTopic;
import com.vitg.entity.SubTopicConcept;
import com.vitg.entity.Topic;
import com.vitg.mappers.SubTopicMappers;
import com.vitg.repository.CourseRepository;
import com.vitg.repository.SubTopicRepository;
import com.vitg.repository.TopicRepository;
import com.vitg.service.CourseService;
import com.vitg.service.SubTopicService;


@Service
public  class SubTopicServiceImpl implements SubTopicService{


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SubTopicRepository subTopicRepository;
	
	@Autowired
	private TopicRepository topicRepository;


	@Autowired
	private SubTopicMappers subTopicMapper;
	
	

@Transactional
	public  SubTopicDTO createSubTopic( SubTopicDTO  subTopicDTO) {
		
	Topic topic=topicRepository.findById(subTopicDTO.getTopic().getId());
		
		SubTopic  subTopic= modelMapper.map(subTopicDTO,  SubTopic.class);
		SubTopic savedSubTopic=  subTopicRepository.save( subTopic);
		
		savedSubTopic.setTopic(topic);
		//CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
		
		SubTopicDTO  subTopicDTOResponse=modelMapper.map(savedSubTopic,  SubTopicDTO.class);
		TopicDTO topicDTO = new TopicDTO();
		topicDTO.setId(topic.getId());
	topicDTO.setName(topic.getName());
	
		subTopicDTOResponse.setTopic(topicDTO);
		return  subTopicDTOResponse;
	}

	public SubTopicDTO getSubTopicById(int id) {

		SubTopic subTopic=subTopicRepository.findById(id);

		SubTopicDTO subTopicDTO = subTopicMapper.subTopicToSubTopicDTO(subTopic);
		return subTopicDTO;

	}
	
	public List<SubTopicDTO> getAllSubTopics(){
		List<SubTopic>  subTopicList=subTopicRepository.findAll();
		List<SubTopicDTO> subTopicDTOList=new ArrayList<>();
		for(SubTopic subTopic:subTopicList) {
			SubTopicDTO subTopicDTO=modelMapper.map(subTopic, SubTopicDTO.class);
			subTopicDTOList.add(subTopicDTO);
		}

		return subTopicDTOList;
	}
	public SubTopicDTO updateSubTopic(SubTopicDTO subTopicDTO) {
		SubTopic subTopic=(SubTopic) modelMapper.map(subTopicDTO, SubTopic.class);
		SubTopic subTopicResponse=subTopicRepository.save(subTopic);
		SubTopicDTO subTopicDTOResponse=(SubTopicDTO) modelMapper.map(subTopicResponse, SubTopicDTO.class);
		return subTopicDTOResponse;

	}
	@Override
	public SubTopicDTO saveSubTopic(SubTopicDTO subTopicDTO) {
		SubTopic subTopic=modelMapper.map(subTopicDTO, SubTopic.class);
		SubTopic SubTopicResponse=subTopicRepository.save(subTopic);
		SubTopicDTO subTopicDTOResponse=modelMapper.map(SubTopicResponse, SubTopicDTO.class);
		return subTopicDTOResponse;
	}

	@Override
	public void deleteById(int id) {

		subTopicRepository.deleteById(id);
	}

	@Override
	public List<SubTopicDTO> getSubTopicListByTopicId(int topicId) {
		List<SubTopic> subTopicList = subTopicRepository.findAll();
		System.out.println(subTopicList);
		List<SubTopicDTO> subTopicDTOList = new ArrayList<>();
		
		for(SubTopic subTopic: subTopicList) {
			if(subTopic.getTopic().getId() == topicId) {
				SubTopicDTO subTopicDTO = modelMapper.map(subTopic, SubTopicDTO.class);
				subTopicDTOList.add(subTopicDTO);
			}
		}
		System.out.println(subTopicDTOList);
		return subTopicDTOList;
	}	
	
}