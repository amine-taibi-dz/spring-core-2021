package dz.acs.remoting.service;




import static java.lang.Math.random;
import static java.util.UUID.randomUUID;

import org.springframework.stereotype.Service;

import dz.acs.remoting.common.Booking;
import dz.acs.remoting.common.BookingException;
@Service
public class CabBookingServiceImpl implements CabBookingService {

    @Override public Booking bookRide(String pickUpLocation) throws BookingException {
        if (random() < 0.3) throw new BookingException("Cab unavailable");
        return new Booking(randomUUID().toString());
    }
}
