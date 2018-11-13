package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.AreaDto;
import com.signet.model.Area;
import com.signet.repository.AreaRepository;

@Service
public class AreaHandler {

	@Autowired
	private AreaRepository repository;

	public Area getAreaOne(Long id) {
		Optional<Area> areaOptional = repository.findById(id);

		if (areaOptional.isPresent()) {
			return areaOptional.get();
		}
		return null;
	}

	public Iterator<Area> getAreas() {
		return repository.findAll().iterator();
	}

	public Area saveArea(AreaDto AreaDto) {
		Area area = new Area();
		BeanUtils.copyProperties(AreaDto, area);
		return repository.save(area);
	}

}
