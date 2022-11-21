
package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vitg.dto.SubTopicDTO;
import com.vitg.entity.SubTopic;
import org.modelmapper.ModelMapper;

@Component
public class SubTopicMappers {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SubTopicDTO subTopicToSubTopicDTO(SubTopic subTopic) {
		return  modelMapper.map(subTopic , SubTopicDTO.class);
	}

	public SubTopic subTopicDTOToSubTopic(SubTopicDTO subTopicDTO) {

		return modelMapper.map(subTopicDTO, SubTopic.class);
	}


}
