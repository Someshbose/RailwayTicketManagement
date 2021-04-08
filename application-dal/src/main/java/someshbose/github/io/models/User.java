package someshbose.github.io.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {
    @Column(name="USER_ID",nullable = false)
    @SequenceGenerator(name = "CORE_FILE_STORE_SEQ", sequenceName = "CORE_FILE_STORE_SEQ", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CORE_FILE_STORE_SEQ")
    @Id
    private int id;

    @Column(name="USER_MAIL_ID",nullable = false,unique = true,length = 240)
    private String mailId;

    @Column(name="USER_FIRST_NAME",nullable = false,length = 100)
    private String firstName;

    @Column(name="USER_MIDDLE_NAME",nullable = true,length = 100)
    private String middleName;

    @Column(name="USER_LAST_NAME",nullable = false,length = 100)
    private String lastName;

    @Column(name="USER_SECRET",nullable = false,length = 100)
    private String password;

    @Column(name="USER_CONTACT",nullable = false,length = 100)
    private String contact;

    @Column(name="USER_DOB",nullable = false)
    private Date dob;
}
