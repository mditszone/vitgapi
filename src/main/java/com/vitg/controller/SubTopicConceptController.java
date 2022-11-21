
package com.vitg.controller;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vitg.dto.SubTopicConceptDTO;
import com.vitg.exception.BadRequestException;
import com.vitg.exception.RecordNotFoundException;
import com.vitg.repository.SubTopicConceptRepository;
import com.vitg.service.SubTopicConceptService;


@RestController
@CrossOrigin
@RequestMapping("/api/subTopicConcept")
public class SubTopicConceptController {
	@Autowired
	private SubTopicConceptService subTopicConceptService;


	@Autowired
	private SubTopicConceptRepository subTopicConceptRepository;

	
	@PostMapping()
	public ResponseEntity<SubTopicConceptDTO> createSubTopicConcept(@RequestBody SubTopicConceptDTO subTopicConceptDTO) {

		System.out.println("inside create subTopicConcept" +subTopicConceptDTO);
		SubTopicConceptDTO subTopicConceptDTOResponse = subTopicConceptService.createSubTopicConcept(subTopicConceptDTO);

		return new ResponseEntity<>(subTopicConceptDTOResponse, HttpStatus.CREATED);

	}
	@GetMapping("/{id}")
	public ResponseEntity<SubTopicConceptDTO> getSubTopicConceptById(@PathVariable(value = "id") int id)
	{

		SubTopicConceptDTO subTopicConceptDTO= subTopicConceptService.getSubTopicConceptById(id);
		return new ResponseEntity<>(subTopicConceptDTO, HttpStatus.OK);
	}
	@GetMapping("/AllSubTopicConcepts")
	public List<SubTopicConceptDTO> getAllSubTopicConcepts() {
		return subTopicConceptService.getAllSubTopicConcepts();
	}

	@PutMapping()
	public ResponseEntity<SubTopicConceptDTO> updateSubTopicConceptInfo( @RequestBody @Valid SubTopicConceptDTO subTopicConceptDTO)
			throws BadRequestException {
		if (!subTopicConceptRepository.existsById(subTopicConceptDTO.getId())) {
			throw new RecordNotFoundException("SubTopicConcept details does'nt exist ");
		}
		subTopicConceptDTO = subTopicConceptService.updateSubTopicConcept(subTopicConceptDTO);
		return new ResponseEntity<>(subTopicConceptDTO, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteSubTopicConceptById(@PathVariable(value = "id") int id) { 
		subTopicConceptService.deleteById(id);
		return ResponseEntity.ok().build();

		
		
		
	}

}
