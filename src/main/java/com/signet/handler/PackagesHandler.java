package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.PackagesDto;
import com.signet.model.Packages;
import com.signet.repository.PackagesRepository;

@Service
public class PackagesHandler {

	@Autowired
	private PackagesRepository repository;

	public Packages getPackagesOne(Long id) {
		Optional<Packages> packagesOptional = repository.findById(id);

		if (packagesOptional.isPresent()) {
			return packagesOptional.get();
		}
		return null;
	}

	public Iterator<Packages> getPackages() {
		return repository.findAll().iterator();
	}

	public Packages savePackages(PackagesDto packagesDto) {
		Packages packages= new Packages();
		BeanUtils.copyProperties(packagesDto, packages);
		return repository.save(packages);
	}

}
