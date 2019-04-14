package com.pinchuk.resthotelbooking.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "number")
	private String number;
	@Column(name = "price")
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_room_category")
	private RoomCategory roomCategory;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private List<Booking> bookings;
	
	public Room() {
		
	}
	
	public Room(Long id, String number, BigDecimal price, RoomCategory roomCategory, List<Booking> bookings) {
		this.id = id;
		this.number = number;
		this.price = price;
		this.roomCategory = roomCategory;
		this.bookings = bookings;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public RoomCategory getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(RoomCategory roomCategory) {
		this.roomCategory = roomCategory;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
