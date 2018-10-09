package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.ChannelsDto;
import com.signet.model.Channels;
import com.signet.repository.ChannelsRepository;

@Service
public class ChannelsHandler {

	@Autowired
	private ChannelsRepository repository;

	public Channels getChannelsOne(Long id) {
		Optional<Channels> categoryOptional = repository.findById(id);

		if (categoryOptional.isPresent()) {
			return null;
		}
		return categoryOptional.get();
	}

	public Iterator<Channels> getchannels() {
		return repository.findAll().iterator();
	}

	public Channels saveChannel(ChannelsDto channelsDto) {
		Channels channels= new Channels();
		BeanUtils.copyProperties(channelsDto, channels);
		return repository.save(channels);
	}

}
