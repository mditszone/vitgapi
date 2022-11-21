package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitg.entity.SubTopicConcept;

public interface SubTopicConceptRepository extends JpaRepository<SubTopicConcept, Integer>{
	SubTopicConcept findById(int id);
	
}





