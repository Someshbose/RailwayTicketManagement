package someshbose.github.io.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "R_USERS")
public class User {

    @Id
    private int id;

    private List<UserRoles> roles;

    private String mailId;

    private String firstName;

    private String lastName;

    private String password;

    private String contact;

    private Date dob;

    @OneToMany
    private List<Booking> bookingList;
}
