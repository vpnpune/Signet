package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.ChannelCategoryDto;
import com.signet.model.ChannelCategory;
import com.signet.repository.ChannelCategoryRepository;

@Service
public class ChannelCategoryHandler {

	@Autowired
	private ChannelCategoryRepository repository;

	public ChannelCategory getChannelCategoryOne(Long id) {
		Optional<ChannelCategory> categoryOptional = repository.findById(id);

		if (categoryOptional.isPresent()) {
			return null;
		}
		return categoryOptional.get();
	}

	public Iterator<ChannelCategory> getChannelCategory() {
		return repository.findAll().iterator();
	}

	public ChannelCategory saveChannelCategory(ChannelCategoryDto channelCategoryDto) {
		ChannelCategory channelCategory = new ChannelCategory();
		BeanUtils.copyProperties(channelCategoryDto, channelCategory);
		return repository.save(channelCategory);
	}

}
