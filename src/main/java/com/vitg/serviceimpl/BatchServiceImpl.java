

package com.vitg.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitg.dto.BatchDTO;
import com.vitg.dto.SubCourseDTO;
import com.vitg.dto.TopicDTO;
import com.vitg.entity.Batch;
import com.vitg.entity.SubCourse;
import com.vitg.entity.Topic;
import com.vitg.mappers.BatchMapper;

import com.vitg.repository.BatchRepository;
import com.vitg.repository.SubCourseRepository;
import com.vitg.service.BatchService;
import com.vitg.service.CourseService;





@Service
public class BatchServiceImpl implements BatchService{


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BatchRepository batchRepository;
	@Autowired
	private  SubCourseRepository  subCourseRepository;


	@Autowired
	private BatchMapper batchMapper;


	//@Transactional
	//public BatchDTO createBatch(BatchDTO batchDTO) {
	//
	//	Batch batch=(Batch) modelMapper.map(batchDTO, Batch.class);
	//
	//	Batch savedBatch= batchRepository.save(batch);
	//	BatchDTO batchDTOResponse=modelMapper.map(savedBatch, BatchDTO.class);
	//	return batchDTOResponse;
	//}
	@Transactional
	public  BatchDTO createBatch( BatchDTO  batchDTO) {

		SubCourse subCourse=subCourseRepository.findById(batchDTO.getSubCourse().getId());

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

		batchDTO.setSubCourse(subCourseDTO);

		Batch batch= modelMapper.map(batchDTO,  Batch.class);
		Batch savedBatch=  batchRepository.save( batch);

		//Course course=courseRepository.findById(savedSubCourse.getCourse().getId());

		savedBatch.setSubCourse(subCourse);
		//CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
		BatchDTO  batchDTOResponse=modelMapper.map(savedBatch,  BatchDTO.class);


		batchDTOResponse.setSubCourse(subCourseDTO);
		return  batchDTOResponse;
	}

	public BatchDTO getBatchById(int id) {

		Batch batch=batchRepository.findById(id);

		BatchDTO batchDTO = batchMapper.batchToBatchDTO(batch);

		return batchDTO;

	}


	public List<BatchDTO> getAllBatches() {
		List<Batch>  batchList=batchRepository.findAll();

		List<BatchDTO> batchDTOList=new ArrayList<>();

		for(Batch batch:batchList) {
			BatchDTO batchDTO=modelMapper.map(batch, BatchDTO.class);
			batchDTOList.add(batchDTO);
		}

		return batchDTOList;
	}

	public BatchDTO updateBatch(BatchDTO batchDTO) {
		//batchDTO.setStatus(true);
		SubCourse subCourse=subCourseRepository.findById(batchDTO.getSubCourse().getId());

		SubCourseDTO subCourseDTO= new SubCourseDTO();
		subCourseDTO.setId(subCourse.getId());
		subCourseDTO.setName(subCourse.getName());

		Batch batch=modelMapper.map(batchDTO, Batch.class);
		Batch batchResponse=batchRepository.save(batch);
		BatchDTO batchDTOResponse=modelMapper.map(batchResponse, BatchDTO.class);
		return batchDTOResponse;

	}
	@Override
	public BatchDTO saveBatch(BatchDTO batchDTO) {
		Batch batch=modelMapper.map(batchDTO, Batch.class);
		Batch BatchResponse=batchRepository.save(batch);
		BatchDTO batchDTOResponse=modelMapper.map(BatchResponse, BatchDTO.class);
		return batchDTOResponse;
	}


	@Override
	public void deleteById(int id) {

		batchRepository.deleteById(id);
	}	



	@Override
	public List<BatchDTO> getBatchListBySubCourseId(int subCourseId) {
		List<Batch> batchList = batchRepository.findAll();
		//System.out.println(topicList);
		List<BatchDTO> batchDTOList = new ArrayList<>();

		for(Batch batch: batchList) {
			if(batch.getSubCourse().getId() == subCourseId) {
				BatchDTO batchDTO = modelMapper.map(batch, BatchDTO.class);
				batchDTOList.add(batchDTO);
			}
		}
		System.out.println(batchDTOList);
		return batchDTOList;
	}	

}
