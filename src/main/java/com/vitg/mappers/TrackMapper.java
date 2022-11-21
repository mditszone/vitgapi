package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vitg.dto.TrackDTO;
import com.vitg.entity.Track;
import org.modelmapper.ModelMapper;

@Component
public class TrackMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public TrackDTO trackToTrackDTO(Track track) {
		return  modelMapper.map(track , TrackDTO.class);
	}

	public Track trackDTOToTrack(TrackDTO trackDTO) {

		return modelMapper.map(trackDTO, Track.class);
	}
}
