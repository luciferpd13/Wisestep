package com.assignment.rental.model;

import javax.persistence.*;

@Entity
@Table(name = "outlets")
public class Outlets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "companyid")
    private long companyid;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    public long getId() {
        return id;
    }

    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

    public String getLon() {
		return this.lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}


}