package models;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	/*public String id;
	public String name;*/
	
	public Int id;
    public String name;
    public Int startDate;
    public Int endDate;
    public String street;
    public String city;
    public String postalCode;
    public String description;
    public String title;
}
