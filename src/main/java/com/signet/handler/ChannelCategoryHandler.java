package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.ChannelCategoryDto;
import com.signet.exception.NotFoundException;
import com.signet.model.ChannelCategory;
import com.signet.repository.ChannelCategoryRepository;

@Service
public class ChannelCategoryHandler {

	@Autowired
	private ChannelCategoryRepository repository;

	public ChannelCategory getChannelCategoryOne(Long id) {
		return repository.findById(id).
		orElseThrow(() -> new NotFoundException("channelCategoryId", String.valueOf(id)));
	}

	public Iterator<ChannelCategory> getChannelCategory() {
		return repository.findAll().iterator();
	}

	public ChannelCategory saveChannelCategory(ChannelCategoryDto channelCategoryDto) {
		ChannelCategory channelCategory = new ChannelCategory();
		BeanUtils.copyProperties(channelCategoryDto, channelCategory);
		return repository.save(channelCategory);
	}
	
	public ChannelCategory updateChannelCategory(long id, ChannelCategoryDto channelCategoryDto) {
		ChannelCategory channelCategoryEntity = repository.findById(id).
				orElseThrow(() -> new NotFoundException("channelCategoryId", String.valueOf(id)));
		channelCategoryEntity.setCategoryName(channelCategoryDto.getCategoryName());

	    return repository.save(channelCategoryEntity);
	}

	public boolean deleteChannelCategory(Long id) {
		ChannelCategory channelCategoryEntity = repository.findById(id).
				orElseThrow(() -> new NotFoundException("channelCategoryId", String.valueOf(id)));
		repository.delete(channelCategoryEntity);
		return true;
	}

}
