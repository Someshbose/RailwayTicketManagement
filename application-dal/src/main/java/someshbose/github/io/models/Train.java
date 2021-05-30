package someshbose.github.io.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Train {

    private Long id;

    private String name;

    private long capacity;

    @OneToMany
    private List<Ticket> confirmedList;

    @OneToMany
    private List<Ticket> waitingList;
}
