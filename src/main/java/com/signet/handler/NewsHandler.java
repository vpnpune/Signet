package com.signet.handler;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.NewsDto;
import com.signet.exception.NotFoundException;
import com.signet.model.Area;
import com.signet.model.News;
import com.signet.repository.AreaRepository;
import com.signet.repository.NewsRepository;

@Service
public class NewsHandler {

	@Autowired
	private NewsRepository repository;
	
	@Autowired
	private AreaRepository areaRepository;

	public News getNewsOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("newsId", String.valueOf(id)));
	}

	public Iterator<News> getNewss() {
		return repository.findAll().iterator();
	}

	public News saveNews(NewsDto newsDto) {
		News newsEntity = new News();
		Area areaEntity = areaRepository.findById(newsDto.getAreaId()).
				orElseThrow(() -> new NotFoundException("areaId", String.valueOf(newsDto.getAreaId())));
		newsEntity.setArea(areaEntity);
		BeanUtils.copyProperties(newsDto, newsEntity);
		return repository.save(newsEntity);
	}
	
	public News updateNews(long id, NewsDto newsDto) {
		News newsEntity = getNewsOne(id);
		Area areaEntity = areaRepository.findById(newsDto.getAreaId()).
				orElseThrow(() -> new NotFoundException("areaId", String.valueOf(newsDto.getAreaId())));
		
		newsEntity.setArea(areaEntity);
		newsEntity.setTitle(newsDto.getTitle());
		newsEntity.setDescription(newsDto.getDescription());
		newsEntity.setAddedOn(newsDto.getAddedOn());
		newsEntity.setEndTime(newsDto.getEndTime());
		newsEntity.setStartTime(newsDto.getStartTime());
		newsEntity.setAlert(newsDto.isAlert());
		newsEntity.setArchived(newsDto.isArchived());
		
	    return repository.save(newsEntity);
	}

	public boolean deleteNews(Long id) {
		News newsEntity = getNewsOne(id);
		repository.delete(newsEntity);
		return true;
	}

}
