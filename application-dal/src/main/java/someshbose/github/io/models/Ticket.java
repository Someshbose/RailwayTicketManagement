package someshbose.github.io.models;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import java.time.Instant;

public class Ticket {

    private Long ticketId;

    @ManyToOne
    private Long trainId;

    @Embedded
    private BookingDetails bookingDetails;

    private double amount;

    private Instant travelDate;

    @ManyToOne
    private Booking booking;
}
