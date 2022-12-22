package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.dto.BusBookingDTO;
import com.spring.entity.Bus;
import com.spring.entity.BusBooking;
import com.spring.entity.Cities;

/****
 * 
 * @author shubh-sinha
 * @project Multi-ticket booking
 *
 */
public interface BusServiceDAO {
	
	public Bus giveBusRouteByJoining();
	
	public List<Bus> findAllBus();
	
	public List<Bus> findAllBusbySrcnDstns(String name);
	
	public String bookBus(BusBookingDTO booking);
	
	public List<BusBooking> viewAllBookingsById(String userId);
	
	public List<Cities> listCities();
	
	public Optional<Bus> getBusById(int busId);
	

}
