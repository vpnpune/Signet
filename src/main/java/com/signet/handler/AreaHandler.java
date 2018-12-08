package com.signet.handler;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.AreaDto;
import com.signet.exception.NotFoundException;
import com.signet.model.Area;
import com.signet.repository.AreaRepository;

@Service
public class AreaHandler {

	@Autowired
	private AreaRepository repository;

	public Area getAreaOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("areaId", String.valueOf(id)));
	}

	public Iterator<Area> getAreas() {
		return repository.findAll().iterator();
	}

	public Area saveArea(AreaDto AreaDto) {
		Area area = new Area();
		BeanUtils.copyProperties(AreaDto, area);
		return repository.save(area);
	}

	public Area updateArea(long id, AreaDto areaDto) {
		Area area = getAreaOne(id);
		area.setAreaName(areaDto.getAreaName());
		area.setCityName(areaDto.getCityName());

		return repository.save(area);
	}

	public boolean deleteArea(Long id) {
		Area area = getAreaOne(id);
		repository.delete(area);
		return true;
	}

}
