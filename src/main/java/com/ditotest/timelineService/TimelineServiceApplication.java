package com.ditotest.timelineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ditotest.timelineService.entity.Event;
import com.ditotest.timelineService.repository.EventRepository;

@SpringBootApplication
public class TimelineServiceApplication {

	@Autowired
	EventRepository eventRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TimelineServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			@SuppressWarnings("unchecked")
			List<Event> eventList = restTemplate.getForObject(
					"https://storage.googleapis.com/dito-questions/events.json", List.class);
			eventRepository.saveAll(eventList);
		};
	}
}
