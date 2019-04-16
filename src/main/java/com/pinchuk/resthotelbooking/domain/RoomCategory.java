package com.pinchuk.resthotelbooking.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "room_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RoomCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "roomCategory", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Room> rooms;
	
	public RoomCategory() {
		
	}
	
	public RoomCategory(Long id) {
		this.id = id;
	}

	public RoomCategory(Long id, String name, List<Room> rooms) {
		this.id = id;
		this.name = name;
		this.rooms = rooms;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
}
