package dz.acs.remoting.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dz.acs.remoting.common.Booking;
import dz.acs.remoting.common.BookingException;
import dz.acs.remoting.service.CabBookingService;

public class Client {

	public static void main(String[] args) throws BookingException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigClient.class);
		CabBookingService service = ctx.getBean(CabBookingService.class);
		Booking bookingOutcome = service.bookRide("ELIT , GUAI de CONSTATINE ALGER");
		System.out.println(bookingOutcome);

	}

}
