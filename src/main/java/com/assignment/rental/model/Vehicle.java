package com.assignment.rental.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "outletid")
    private long outletid;

    public long getId() {
        return id;
    }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public long getOutletid() {
		return this.outletid;
	}

	public void setOutlet_id(long outletid) {
		this.outletid = outletid;
	}

}