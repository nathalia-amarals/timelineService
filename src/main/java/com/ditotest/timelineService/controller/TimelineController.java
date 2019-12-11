package com.ditotest.timelineService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ditotest.timelineService.entity.Event;
import com.ditotest.timelineService.repository.EventRepository;

@RestController
public class TimelineController {

	@Autowired
	EventRepository eventRepository;
	
	@GetMapping
	public String getTimeline(Model model) {
		
		
		model.addAttribute("events", eventRepository.findAll());
		return "Timeline";
	}
}
