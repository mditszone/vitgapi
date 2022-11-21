


package com.vitg.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitg.dto.CourseDTO;
import com.vitg.dto.SubCourseDTO;
import com.vitg.dto.SubTopicDTO;
import com.vitg.dto.TopicDTO;
import com.vitg.entity.Course;
import com.vitg.entity.SubCourse;
import com.vitg.entity.SubTopic;
import com.vitg.entity.Topic;
import com.vitg.mappers.SubTopicMappers;
import com.vitg.mappers.TopicMappers;
import com.vitg.repository.CourseRepository;
import com.vitg.repository.SubCourseRepository;
import com.vitg.repository.SubTopicRepository;
import com.vitg.repository.TopicRepository;
import com.vitg.service.CourseService;
import com.vitg.service.SubTopicService;
import com.vitg.service.TopicService;


@Service
public  class TopicServiceImpl implements TopicService{


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private  TopicRepository topicRepository;

	@Autowired
	private  SubCourseRepository  subCourseRepository;
	
	@Autowired
	private TopicMappers topicMapper;
	


//	@Transactional
//	public  TopicDTO createTopic( TopicDTO  topicDTO) {
//		
//		SubCourse subcourse=subCourseRepository.findById(topicDTO.getSubCourse().getId());
//		
//		
//
//		Topic  topic= modelMapper.map(topicDTO,  Topic.class);
//		Topic savedTopic=  topicRepository.save( topic);
//		
//		
//		savedTopic.setSubCourse(subcourse);
//		
//		
//		
//		TopicDTO  topicDTOResponse=modelMapper.map(savedTopic,  TopicDTO.class);
//		SubCourseDTO subCourseDTO = new SubCourseDTO();
//		subCourseDTO.setId(subcourse.getId());
//		subCourseDTO.setName(subcourse.getName());
//	
//		topicDTOResponse.setSubCourse(subCourseDTO);
//		return  topicDTOResponse;
//	}
	@Transactional
	public  TopicDTO createTopic( TopicDTO  topicDTO) {
		
		SubCourse subCourse=subCourseRepository.findById(topicDTO.getSubCourse().getId());
		
		SubCourseDTO subCourseDTO= new SubCourseDTO();
		subCourseDTO.setId(subCourse.getId());
		subCourseDTO.setName(subCourse.getName());
		subCourseDTO.setImage(subCourse.getImage());
		subCourseDTO.setFee(subCourse.getFee());
		subCourseDTO.setDurationDays(subCourse.getDurationDays());
		subCourseDTO.setDurationHours(subCourse.getDurationHours());
		subCourseDTO.setExamCertification(subCourse.getExamCertification());
		subCourseDTO.setOverview(subCourse.getOverview());
		subCourseDTO.setTrainingMode(subCourse.getTrainingMode());
		subCourseDTO.setYoutubeUrl(subCourse.getYoutubeUrl());
		
		topicDTO.setSubCourse(subCourseDTO);
		
		Topic  topic= modelMapper.map(topicDTO,  Topic.class);
		Topic savedTopic=  topicRepository.save( topic);
		
		//Course course=courseRepository.findById(savedSubCourse.getCourse().getId());
		
		savedTopic.setSubCourse(subCourse);
		//CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
		TopicDTO  topicDTOResponse=modelMapper.map(savedTopic,  TopicDTO.class);
		
		
		topicDTOResponse.setSubCourse(subCourseDTO);
		return  topicDTOResponse;
	}
	
	public TopicDTO getTopicById(int id) {

		Topic topic=topicRepository.findById(id);

		TopicDTO topicDTO = topicMapper.topicToTopicDTO(topic);

		//Optional<User> user=userRepository.findById(id);

		return topicDTO;
	}
	
	

	public List<TopicDTO> getAllTopics(){
		List<Topic>  topicList=topicRepository.findAll();
		List<TopicDTO> topicDTOList=new ArrayList<>();
		for(Topic topic:topicList) {
			TopicDTO topicDTO=modelMapper.map(topic, TopicDTO.class);
			topicDTOList.add(topicDTO);
		}

		return topicDTOList;
	}

	public TopicDTO updateTopic(TopicDTO topicDTO) {
		Topic topic=(Topic) modelMapper.map(topicDTO, Topic.class);
		Topic topicResponse=topicRepository.save(topic);
		TopicDTO topicDTOResponse=(TopicDTO) modelMapper.map(topicResponse, TopicDTO.class);
		return topicDTOResponse;

	}
	@Override
	public TopicDTO saveTopic(TopicDTO topicDTO) {
		Topic topic=modelMapper.map(topicDTO, Topic.class);
		Topic TopicResponse=topicRepository.save(topic);
		TopicDTO topicDTOResponse=modelMapper.map(TopicResponse, TopicDTO.class);
		return topicDTOResponse;
	}
	@Override
	public void deleteById(int id) {

		topicRepository.deleteById(id);
	}

	@Override
	public List<TopicDTO> getTopicListBySubCourseId(int subCourseId) {
		List<Topic> topicList = topicRepository.findAll();
		//System.out.println(topicList);
		List<TopicDTO> topicDTOList = new ArrayList<>();
		
		for(Topic topic: topicList) {
			if(topic.getSubCourse().getId() == subCourseId) {
				TopicDTO topicDTO = modelMapper.map(topic, TopicDTO.class);
				topicDTOList.add(topicDTO);
			}
		}
		System.out.println(topicDTOList);
		return topicDTOList;
	}	
	
}