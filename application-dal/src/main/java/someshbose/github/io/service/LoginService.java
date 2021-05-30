package someshbose.github.io.service;

import someshbose.github.io.dto.BookingDto;
import someshbose.github.io.models.Booking;
import someshbose.github.io.models.Ticket;
import someshbose.github.io.models.Train;

import java.util.List;

public class LoginService {

    public Booking createBooking(BookingDto bookingDto){
        return null;
    }

    public Train status(long train_id){
        return null;
    }

    public Booking checkByPnr(long pnr_no){
        return null;
    }

    public Ticket checkTicketStatus(long ticket_id){
        return null;
    }

    public Ticket cancelTicket(long ticketId){
        return null;
    }

    public List<Ticket> cancelBooking(long pnr_no){
        return null;
    }
}
