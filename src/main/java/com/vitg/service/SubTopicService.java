
package com.vitg.service;

import java.util.List;

import com.vitg.dto.SubTopicDTO;
import com.vitg.dto.TopicDTO;


public interface SubTopicService {
public SubTopicDTO getSubTopicById(int id);
public void deleteById(int id);
	
	public SubTopicDTO createSubTopic(SubTopicDTO subTopicDTO);
    public SubTopicDTO updateSubTopic (SubTopicDTO subTopicDTO);
    public SubTopicDTO saveSubTopic (SubTopicDTO subTopicDTO);
    public List<SubTopicDTO> getAllSubTopics();
    public List<SubTopicDTO> getSubTopicListByTopicId(int topicId);

}