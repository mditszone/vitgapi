
package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vitg.dto.SubTopicConceptDTO;
import com.vitg.entity.SubTopicConcept;
import org.modelmapper.ModelMapper;

@Component
public class SubTopicConceptMappers {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SubTopicConceptDTO subTopicConceptToSubTopicConceptDTO(SubTopicConcept subTopicConcept) {
		return  modelMapper.map(subTopicConcept , SubTopicConceptDTO.class);
	}

	public SubTopicConcept subTopicConceptDTOToSubTopicConcept(SubTopicConceptDTO subTopicConceptDTO) {

		return modelMapper.map(subTopicConceptDTO, SubTopicConcept.class);
	}


}

