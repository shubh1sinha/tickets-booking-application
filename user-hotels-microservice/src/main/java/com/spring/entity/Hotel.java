package com.spring.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/***
 * 
 * @author shubh-sinha
 * @project Multi-tour-booking
 *
 */
@Document(collection = "hotel")
public class Hotel {

	@Id
	private String hotelId;

	private String name;

	private String city;

	private String facilities;

	public Hotel() {
	}

	public Hotel(String hotelId, String name, String city, String facilities) {
		this.hotelId = hotelId;
		this.name = name;
		this.city = city;
		this.facilities = facilities;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
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

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

}
