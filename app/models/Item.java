package models;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public String id;

    public Double startDate;
    public Double endDate;
    public String address;
    public String city;
    public String postalCode;
    public String description;
    public String title;

    // public String validate() {
    //     if(authenticate(id,name) == null) {
    //         return "Invalid email or password";
    //     }
    //     return null;
    // }
}
