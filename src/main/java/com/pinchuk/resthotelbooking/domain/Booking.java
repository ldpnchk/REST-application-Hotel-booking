package com.pinchuk.resthotelbooking.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "booking")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room", nullable = false)
	private Room room;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "booking_hotel_service",
				joinColumns = { @JoinColumn(name = "id_booking") },
				inverseJoinColumns = { @JoinColumn(name = "id_hotel_service") })
	private List<HotelService> hotelServices;
	
	public Booking() {
		
	}
	
	public Booking(Long id, LocalDate startDate, LocalDate endDate, Room room, User user, List<HotelService> hotelServices) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.user = user;
		this.hotelServices = hotelServices;
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

	public List<HotelService> getHotelServices() {
		return hotelServices;
	}

	public void setHotelServices(List<HotelService> hotelServices) {
		this.hotelServices = hotelServices;
	}
	
}
