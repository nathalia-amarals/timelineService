package com.ditotest.timelineService.repository;

import org.springframework.data.repository.CrudRepository;

import com.ditotest.timelineService.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

}
