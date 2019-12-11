package com.ditotest.timelineService.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Timestamp timestamp;
	@ManyToMany (fetch = FetchType.EAGER)
	private Map<String,String> customData = new HashMap<>();
	private BigDecimal revenue;
	
	public String getName() {
		return name;
	}
	public void setName(String event) {
		this.name = event;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Map<String,String> getCustomData() {
		return customData;
	}
	public void setCustomData(Map<String,String> customData) {
		this.customData = customData;
	}
	
	public void addCustomData(String key, String value) {
		this.customData.put(key,value);
	}
	
	public BigDecimal getRevenue() {
		return revenue;
	}
	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}
	
}
