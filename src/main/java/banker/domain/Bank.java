package banker.domain;

import javax.persistence.*;
/**
 * Created by shaziya on 25/3/18.
 */
@Entity
public class Bank {

    @Id
    private long id;

    @Column(nullable = false, name="name")
    private String name;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
