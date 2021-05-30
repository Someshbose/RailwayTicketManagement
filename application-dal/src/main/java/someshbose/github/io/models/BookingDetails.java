package someshbose.github.io.models;

import javax.persistence.Embeddable;

@Embeddable
public class BookingDetails {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
}
