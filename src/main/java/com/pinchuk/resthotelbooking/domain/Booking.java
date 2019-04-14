package com.pinchuk.resthotelbooking.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_room")
	private Room room;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
	private User user;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "booking_service",
				joinColumns = { @JoinColumn(name = "id_booking") },
				inverseJoinColumns = { @JoinColumn(name = "id_service") })
	private List<Service> services;
	
	public Booking() {
		
	}
	
	public Booking(Long id, LocalDate startDate, LocalDate endDate, Room room, User user, List<Service> services) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.user = user;
		this.services = services;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

}
