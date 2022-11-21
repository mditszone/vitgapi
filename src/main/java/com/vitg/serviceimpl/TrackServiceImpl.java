
package com.vitg.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitg.dto.BatchDTO;
import com.vitg.dto.SubCourseDTO;
import com.vitg.dto.TrackDTO;
import com.vitg.entity.Batch;
import com.vitg.entity.SubCourse;
import com.vitg.entity.Track;

import com.vitg.mappers.TrackMapper;
import com.vitg.repository.SubCourseRepository;
import com.vitg.repository.TrackRepository;

import com.vitg.service.TrackService;

@Service
public class TrackServiceImpl implements TrackService{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private TrackMapper trackMapper;

	@Autowired
	private  SubCourseRepository  subCourseRepository;


	@Transactional
	public TrackDTO createTrack(TrackDTO trackDTO) {

		Track track=(Track) modelMapper.map(trackDTO, Track.class);

		Track savedTrack= trackRepository.save(track);
		TrackDTO trackDTOResponse=modelMapper.map(savedTrack, TrackDTO.class);
		return trackDTOResponse;
	}

	public TrackDTO getTrackById(int id) {

		Track track=trackRepository.findById(id);

		TrackDTO trackDTO = trackMapper.trackToTrackDTO(track);

		return trackDTO;

	}
	public List<TrackDTO> getAllTracks() {
		List<Track>  trackList=trackRepository.findAll();

		List<TrackDTO> trackDTOList=new ArrayList<>();

		for(Track track:trackList) {
			TrackDTO trackDTO=modelMapper.map(track, TrackDTO.class);
			trackDTOList.add(trackDTO);
		}

		return trackDTOList;
	}

	public TrackDTO updateTrack(TrackDTO trackDTO) {
		//trackDTO.setStatus(true);
		Track track=modelMapper.map(trackDTO, Track.class);
		Track trackResponse=trackRepository.save(track);
		TrackDTO trackDTOResponse=modelMapper.map(trackResponse, TrackDTO.class);
		return trackDTOResponse;

	}
	@Override
	public TrackDTO saveTrack(TrackDTO trackDTO) {
		Track track=modelMapper.map(trackDTO, Track.class);
		Track TrackResponse=trackRepository.save(track);
		TrackDTO trackDTOResponse=modelMapper.map(TrackResponse, TrackDTO.class);
		return trackDTOResponse;
	}


	@Override
	public void deleteById(int id) {

		trackRepository.deleteById(id);
	}	


}
