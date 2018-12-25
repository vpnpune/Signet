package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.PackagesDto;
import com.signet.model.Package;
import com.signet.repository.PackagesRepository;

@Service
public class PackagesHandler {

	@Autowired
	private PackagesRepository repository;

	public Package getPackagesOne(Long id) {
		Optional<Package> packagesOptional = repository.findById(id);

		if (packagesOptional.isPresent()) {
			return packagesOptional.get();
		}
		return null;
	}

	public Iterator<Package> getPackages() {
		return repository.findAll().iterator();
	}

	public Package savePackages(PackagesDto packagesDto) {
		Package packages= new Package();
		BeanUtils.copyProperties(packagesDto, packages);
		return repository.save(packages);
	}

	public Package updatePackages(Long id, PackagesDto packagesDto) {
		Package packageEntity = getPackagesOne(id);
		packageEntity.setIsHD(packagesDto.getIsHD());
		packageEntity.setPackageName(packagesDto.getPackageName());
		packageEntity.setPopular(packagesDto.isPopular());

	    return repository.save(packageEntity);
	}

	public boolean deletePackages(Long id) {
		Package packageEntity = getPackagesOne(id);
		repository.delete(packageEntity);
		return true;
	}

}
