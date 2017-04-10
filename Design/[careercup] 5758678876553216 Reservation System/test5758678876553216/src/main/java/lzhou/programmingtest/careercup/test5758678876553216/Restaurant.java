package lzhou.programmingtest.careercup.test5758678876553216;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Your goal is to write business logic for a very simple Restaurant booking system
//You are encouraged to refactor exisiting code, create other classes, write helper methods etc
//You also need to make sure that the implementation works correctly

class Reservation {
	public String name;
	public int partySize;
	public LocalTime startTime;
	public LocalTime endTime;
}

class Table {
	public int tableNumber;
	public int maxPartySize;
}

public class Restaurant {

	public List<Table> tables;
	public LocalTime openTime;
	public LocalTime closeTime;
	public Map<Integer, Duration> reservationDurationsPerPartySize;
	public Map<Reservation, Table> reservations;
	
	public Restaurant(LocalTime openTime, LocalTime closeTime) {
		this.openTime = openTime;
		this.closeTime = closeTime;
		tables= new ArrayList<Table>();
		reservationDurationsPerPartySize = new HashMap<Integer, Duration>();
		reservations = new HashMap<Reservation, Table>();
	}
	
	public Reservation buildReservation(String name,
			int partySize,
			LocalTime startTime) {
		Reservation r = new Reservation();
		r.name=name;
		r.partySize = partySize;
		r.startTime = startTime;
		if (reservationDurationsPerPartySize.containsKey(r.partySize)) {
			r.endTime = startTime.plus(reservationDurationsPerPartySize.get(r.partySize));
		} else {
			r.endTime = LocalTime.of(23,59);
		}
		return r;
	}

	// Returns a Table if Reservation could be booked, null otherwise
	// Booking rules:
	// 1) Reservation could be made only when the Restaurant is open.
	// 2) Only one Reservation can be seated a Table at any time.
	// 3) Reservation can be seated only at a Table of the same or a bigger
	// size.
	// 4) Reservation should stay on the same Table for the whole Duration.
	// 5) Reservation Duration is determined by PartySize.

	public Table bookReservation(Reservation reservation) {
		if (reservation.startTime.isAfter(openTime) && reservation.startTime.isBefore(closeTime)) {
			for (Table t : tables) {
				if (t.maxPartySize<reservation.partySize) {
					continue;
				}
				boolean isOk = true; 
				for (Reservation r : reservations.keySet()) {
					Table t2 = reservations.get(r);
					if (t2==t) {
						if (r.startTime.isAfter(reservation.endTime)
								|| r.endTime.isBefore(reservation.startTime)) {
						} else {
							isOk = false;
						}
					}
				}
				if (isOk) {
					reservations.put(reservation, t);
					return t;
				}
			}
			return null;
		} else {
			return null;
		}
	}
}