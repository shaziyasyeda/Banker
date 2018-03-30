package banker.domain;

import javax.persistence.*;


/**
 * Created by shaziya on 25/3/18.
 */

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    private String ifsc;

    @ManyToOne
    @JoinColumn(name="bank_id")
    private Bank bank;

    @Column(nullable = false, name="branch")
    private String branchName;

    @Column(nullable = false,  name="address")
    private String address;

    @Column(nullable = false,  name="city")
    private String city;

    @Column(nullable = false,  name="district")
    private String district;

    @Column(nullable = false,  name="state")
    private String state;

    public String getIfsc() {
        return this.ifsc;
    }

    public Bank getBank() { return this.bank; }

    public String getBranchName() {
        return this.branchName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getState() {
        return this.state;
    }
}
