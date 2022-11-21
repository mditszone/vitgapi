
package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vitg.dto.TopicDTO;
import com.vitg.entity.Topic;
import org.modelmapper.ModelMapper;

@Component
public class TopicMappers {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TopicDTO topicToTopicDTO(Topic Topic) {
		return  modelMapper.map(Topic , TopicDTO.class);
	}

	public Topic topicDTOToTopic(TopicDTO TopicDTO) {

		return modelMapper.map(TopicDTO, Topic.class);
	}


}