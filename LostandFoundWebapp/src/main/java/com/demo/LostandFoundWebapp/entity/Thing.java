package com.demo.LostandFoundWebapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name =  "Thing")
public class Thing {
	
	public Thing() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Size(max = 20)
	@Column(name = "NAME")
	private String name;
	
	@NotEmpty
	@Size(max = 30)
	@Column(name = "PLACE")
	private String place;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Please provide a date.")
	@Column(name = "DATE")
	private Date date;

	@NotEmpty
	@Size(min=0,max=10)
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@NotEmpty
	@Column(name="lost_or_found")
	private String lost_or_found;

	

	public Thing(int id, @NotEmpty @Size(max = 20) String name, @NotEmpty @Size(max = 30) String place,
			@NotNull(message = "Please provide a date.") Date date,
			@NotEmpty @Size(min = 0, max = 10) String phoneNumber, @NotEmpty String lost_or_found) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.lost_or_found = lost_or_found;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLost_or_found() {
		return lost_or_found;
	}

	public void setLost_or_found(String lost_or_found) {
		this.lost_or_found = lost_or_found;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((lost_or_found == null) ? 0 : lost_or_found.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thing other = (Thing) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (lost_or_found == null) {
			if (other.lost_or_found != null)
				return false;
		} else if (!lost_or_found.equals(other.lost_or_found))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Thing [id=" + id + ", name=" + name + ", place=" + place + ", date=" + date + ", phoneNumber="
				+ phoneNumber + ", lost_or_found=" + lost_or_found + "]";
	}

}
