package someshbose.github.io.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "R_BOOKING")
public class Booking {

    private long pnrNo;

    @OneToMany
    private List<Ticket> ticketList;

    private Instant bookedDate;
}
