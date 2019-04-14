package com.pinchuk.resthotelbooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "greeting")
public class Greeting {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	@Column(name = "name")
	private String name;
	
	public Greeting () {
		
	}
	
	public Greeting (long id, String name) {
		this.name = "Hello " + name;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Greeting [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
