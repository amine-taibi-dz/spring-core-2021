package dz.acs.remoting.service;

import dz.acs.remoting.common.Booking;
import dz.acs.remoting.common.BookingException;

public interface CabBookingService{

    public Booking bookRide(String pickUpLocation) throws BookingException; 
}
