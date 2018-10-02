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
			return null;
		}
		return areaOptional.get();
	}

	public Iterator<Area> getAreas() {
		return repository.findAll().iterator();
	}

	public Area saveArea(AreaDto AreaDto) {
		Area Area = new Area();
		BeanUtils.copyProperties(AreaDto, Area);
		return repository.save(Area);
	}

}
