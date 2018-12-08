package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.ChannelsDto;
import com.signet.exception.NotFoundException;
import com.signet.model.ChannelCategory;
import com.signet.model.Channels;
import com.signet.repository.ChannelCategoryRepository;
import com.signet.repository.ChannelsRepository;

@Service
public class ChannelsHandler {

	@Autowired
	private ChannelsRepository repository;
	
	@Autowired
	private ChannelCategoryRepository categoryRepository;

	public Channels getChannelsOne(Long id) {
		return repository.findById(id).
				orElseThrow(() -> new NotFoundException("channelId", String.valueOf(id)));
	}

	public Iterator<Channels> getchannels() {
		return repository.findAll().iterator();
	}

	public Channels saveChannel(ChannelsDto channelsDto) {
		Channels channels= new Channels();
		ChannelCategory channelCategoryEntity = categoryRepository.findById(channelsDto.getChannelCategoryId()).
				orElseThrow(() -> new NotFoundException("channelCategoryId", String.valueOf(channelsDto.getChannelCategoryId())));
		channels.setChannelCategory(channelCategoryEntity);
		BeanUtils.copyProperties(channelsDto, channels);
		return repository.save(channels);
	}
	
	public Channels updateChannel(long id, ChannelsDto channelDto) {
		Channels channelEnitity = getChannelsOne(id);
		channelEnitity.setChannelNo(channelDto.getChannelNo());
		ChannelCategory channelCategoryEntity = categoryRepository.findById(channelDto.getChannelCategoryId()).
				orElseThrow(() -> new NotFoundException("channelCategoryId", String.valueOf(channelDto.getChannelCategoryId())));
		channelEnitity.setChannelCategory(channelCategoryEntity);
		channelEnitity.setLogoCDNLink(channelDto.getLogoCDNLink());
		channelEnitity.setName(channelDto.getName());
		channelEnitity.setNetwork(channelDto.getNetwork());
		channelEnitity.setRate(channelDto.getRate());
		channelEnitity.setThumbnailCDNLink(channelDto.getThumbnailCDNLink());
	    return repository.save(channelEnitity);
	}

	public boolean deleteChannel(Long id) {
		Channels channelEnitity = getChannelsOne(id);
		repository.delete(channelEnitity);
		return true;
	}

}
