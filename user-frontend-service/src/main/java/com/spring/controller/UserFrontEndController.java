package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.Booking;
import com.spring.entity.Bus;
import com.spring.entity.BusBooking;
import com.spring.entity.Cities;
import com.spring.entity.Hotel;
import com.spring.entity.HotelBooking;
import com.spring.entity.Login;
import com.spring.entity.Order;
import com.spring.entity.Registration;
import com.spring.entity.SourceDestination;
import com.spring.entity.Trains;
/****
 * 
 * @author shusinha5
 * @project Employee-Management
 * @Description Full Stack Application
 * 		with devops.
 *
 */
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/user")
@Controller
public class UserFrontEndController {
	
	@Autowired
	private RestTemplate rt;
	
	@GetMapping(value = "/booking/{username}")
	public ResponseEntity<Order> userOrders(@PathVariable("username") String username){
		ResponseEntity<Order> orderDetails = rt.exchange("http://user-order-api-gateway/user/booking/" + username,
				HttpMethod.GET, null, new ParameterizedTypeReference<Order>() {
				});
		return orderDetails;
	}
	
	@PostMapping(value="/registration")
	public ResponseEntity<Registration> userRegistration(@RequestBody Registration registration) {
		ResponseEntity<Registration> user = rt.postForEntity("http://user-microservice/user/add", registration, Registration.class);
		return user;
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<String> userLoign(@RequestBody Login login) {
		ResponseEntity<String> user = rt.getForEntity("http://user-microservice/user/"+login.getUsername()+"/"+login.getPassword(), String.class);
		if(user.getStatusCodeValue()!=201) {
			return ResponseEntity.ok("Logged-In");
		}
		else {
			return ResponseEntity.ok("Wrong username or password");
		}
		

	}
	
	
	@GetMapping(value="/cities/list")
	public ResponseEntity<List<Cities>> cityList(){
		ResponseEntity<List<Cities>> cityList =rt.exchange(
				"http://user-bus-microservice/list/cities", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Cities>>() {
				});
		return cityList;
		
	}
	
	@GetMapping(value="/hotel/list/{cityName}")
	public ResponseEntity<List<Hotel>> hotelList(@PathVariable("cityName") String cityName){
		ResponseEntity<List<Hotel>> hotelList =rt.exchange(
				"http://user-hotels-microservice/hotel/list/"+cityName, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Hotel>>() {
				});
		return hotelList;
		
	}
	
	@PostMapping(value = "/book/hotel")
	public ResponseEntity<String> bookHotel(@RequestBody HotelBooking hotel){
		ResponseEntity<String> booking = rt.postForEntity("http://user-hotels-microservice/hotel/book", hotel, String.class);
		return booking;
	}
	
	@GetMapping(value="/get/hotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id){
		ResponseEntity<Hotel> hotelList =rt.getForEntity(
				"http://user-hotels-microservice/get/hotel/"+id, Hotel.class);
		return hotelList;
		
	}
	
	@GetMapping(value = "/sd/list")
	public ResponseEntity<List<SourceDestination>> sdList(){
		ResponseEntity<List<SourceDestination>> sdList =rt.exchange(
				"http://localhost:9192/sd/list", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<SourceDestination>>() {
				});
		return sdList;
		
	}
	
	@PostMapping(value = "/train/list")
	public ResponseEntity<List<Trains>> trainsList(@RequestBody Trains train){
		ResponseEntity<List<Trains>> trainList = rt.exchange("http://localhost:9192/trains/"+train.getSourceId()+"/"+train.getDestinationId()+"/"+train.getDeparture(), HttpMethod.POST,null, new ParameterizedTypeReference<List<Trains>>() {
		});
		return trainList;
		
	}
	
	@PostMapping(value = "/book/train")
	public ResponseEntity<String> bookTrain(@RequestBody Booking train){
		ResponseEntity<String> booking = rt.postForEntity("http://localhost:9192/bookings", train, String.class);
		return booking;
	}
	
	@GetMapping(value="/get/train/{id}")
	public ResponseEntity<Trains> getTrain(@PathVariable("id") String id){
		ResponseEntity<Trains> trainList =rt.getForEntity(
				"http://localhost:9192/get/train/"+id, Trains.class);
		return trainList;
		
	}
	
	@GetMapping(value = "/bus/list")
	public ResponseEntity<List<Bus>> trainsList(@RequestParam("srcdstn") String srcdstn){
		ResponseEntity<List<Bus>> trainList = rt.exchange("http://user-bus-microservice/bus/list/"+srcdstn, HttpMethod.GET,null, new ParameterizedTypeReference<List<Bus>>() {
		});
		return trainList;
		
	}
	
	@GetMapping(value="/get/bus/{id}")
	public ResponseEntity<Bus> getBus(@PathVariable("id") int id){
		ResponseEntity<Bus> bus =rt.getForEntity(
				"http://user-bus-microservice/get/bus/"+id, Bus.class);
		return bus;
		
	}
	
	@PostMapping(value = "/book/bus")
	public ResponseEntity<String> bookBus(@RequestBody BusBooking bus){
		ResponseEntity<String> booking = rt.postForEntity("http://user-bus-microservice/bus/book", bus, String.class);
		return booking;
	}
	

}
