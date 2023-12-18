package com.homes.homesLocation.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "homes_details")
public class HomesDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String city;
	
	private String state;
	
	private String photo;
	
	private long availableUnits;
	
	private boolean wifi;
	
	private boolean laundry;

	public HomesDetails() {
		super();
	}

	public HomesDetails(long id, String name, String city, String state, String photo, long availableUnits,
			boolean wifi, boolean laundry) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.photo = photo;
		this.availableUnits = availableUnits;
		this.wifi = wifi;
		this.laundry = laundry;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public long getAvailableUnits() {
		return availableUnits;
	}

	public void setAvailableUnits(long availableUnits) {
		this.availableUnits = availableUnits;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isLaundry() {
		return laundry;
	}

	public void setLaundry(boolean laundry) {
		this.laundry = laundry;
	}

	@Override
	public String toString() {
		return "HomesDetails [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", photo=" + photo
				+ ", availableUnits=" + availableUnits + ", wifi=" + wifi + ", laundry=" + laundry + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableUnits, city, id, laundry, name, photo, state, wifi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HomesDetails other = (HomesDetails) obj;
		return availableUnits == other.availableUnits && Objects.equals(city, other.city) && id == other.id
				&& laundry == other.laundry && Objects.equals(name, other.name) && Objects.equals(photo, other.photo)
				&& Objects.equals(state, other.state) && wifi == other.wifi;
	}
	
	
	

}
//"id": 0,
//"name": "Acme Fresh Start Housing",
//"city": "Chicago",
//"state": "IL",
//"photo": "/assets/bernard-hermant-CLKGGwIBTaY-unsplash.jpg",
//"availableUnits": 4,
//"wifi": true,
//"laundry": true