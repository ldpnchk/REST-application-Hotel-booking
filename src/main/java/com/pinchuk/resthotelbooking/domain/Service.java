package com.pinchuk.resthotelbooking.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private BigDecimal price;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "booking_service",
				joinColumns = { @JoinColumn(name = "id_service") },
				inverseJoinColumns = { @JoinColumn(name = "id_booking") })
	private List<Booking> bookings;
	
	public Service() {
		
	}
	
	public Service(Long id, String name, BigDecimal price, List<Booking> bookings) {
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
