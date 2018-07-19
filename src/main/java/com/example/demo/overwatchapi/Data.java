package com.example.demo.overwatchapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	
	private List<PlayerData> data;

	public List<PlayerData> getData() {
		return data;
	}

	public void setData(List<PlayerData> data) {
		this.data = data;
	}
	
	@Override
    public String toString() {
        return "herro";
    }
}
