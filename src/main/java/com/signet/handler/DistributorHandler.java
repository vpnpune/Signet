package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.DistributorDto;
import com.signet.model.Distributor;
import com.signet.repository.DistributorRepository;

@Service
public class DistributorHandler {

	@Autowired
	private DistributorRepository repository;

	public Distributor getDistributorOne(Long id) {
		Optional<Distributor> distributorOptional = repository.findById(id);

		if (distributorOptional.isPresent()) {
			return null;
		}
		return distributorOptional.get();
	}

	public Iterator<Distributor> getDistributors() {
		return repository.findAll().iterator();
	}

	public Distributor saveDistributor(DistributorDto dto) {
		Distributor distributor = new Distributor();
		BeanUtils.copyProperties(dto, distributor);
		return repository.save(distributor);
	}

}
