package com.pinchuk.resthotelbooking.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hotel_service")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HotelService {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "booking_hotel_service",
				joinColumns = { @JoinColumn(name = "id_hotel_service") },
				inverseJoinColumns = { @JoinColumn(name = "id_booking") })
	@JsonIgnore
	private List<Booking> bookings;
	
	public HotelService() {
		
	}
	
	public HotelService(Long id, String name, BigDecimal price, List<Booking> bookings) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.bookings = bookings;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}	

}
