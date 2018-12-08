package com.signet.handler;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.DistributorDto;
import com.signet.exception.NotFoundException;
import com.signet.model.Area;
import com.signet.model.Distributor;
import com.signet.repository.AreaRepository;
import com.signet.repository.DistributorRepository;

@Service
public class DistributorHandler {

	@Autowired
	private DistributorRepository repository;
	
	@Autowired
	private AreaRepository areaRepository;

	public Distributor getDistributorOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("distributorId", String.valueOf(id)));
	}

	public Iterator<Distributor> getDistributors() {
		return repository.findAll().iterator();
	}

	public Distributor saveDistributor(DistributorDto distributorDto) {
		Distributor distributorEntity = new Distributor();
		Area areaEntity = areaRepository.findById(distributorDto.getAreaId()).
				orElseThrow(() -> new NotFoundException("areaId", String.valueOf(distributorDto.getAreaId())));
		distributorEntity.setArea(areaEntity);
		BeanUtils.copyProperties(distributorDto, distributorEntity);
		return repository.save(distributorEntity);
	}
	
	public Distributor updateDistributor(long id, DistributorDto distributorDto) {
		Distributor DistributorEntity = getDistributorOne(id);
		Area areaEntiry = areaRepository.findById(distributorDto.getAreaId()).
				orElseThrow(() -> new NotFoundException("areaId", String.valueOf(distributorDto.getAreaId())));
		DistributorEntity.setAddress(distributorDto.getAddress());
		DistributorEntity.setArea(areaEntiry);
		DistributorEntity.setContactNo(distributorDto.getContactNo());
		DistributorEntity.setEmail(distributorDto.getEmail());
		DistributorEntity.setName(distributorDto.getName());
		
	    return repository.save(DistributorEntity);
	}

	public boolean deleteDistributor(Long id) {
		Distributor DistributorEntity = getDistributorOne(id);
		repository.delete(DistributorEntity);
		return true;
	}

}
