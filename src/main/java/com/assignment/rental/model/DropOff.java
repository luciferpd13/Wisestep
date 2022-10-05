package com.assignment.rental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "drop_off")
public class DropOff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "registeredid")
    private long registeredid;

    @Column(name = "droptime")
    private Date droptime;

    @Column(name = "distance")
    private String distance;

    @Column(name = "isvehiclerecovered")
    private boolean isvehiclerecovered;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;
 
    public long getId() {
        return id;
    }

    public long getRegisteredid() {
		return this.registeredid;
	}

	public void setRegisteredid(long registeredid) {
		this.registeredid = registeredid;
	}

    public Date getDroptime() {
		return this.droptime;
	}

	public void setDroptime(Date droptime) {
		this.droptime = droptime;
	}

    public String getDistance() {
		return this.distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

    public boolean isIsvehiclerecovered() {
		return this.isvehiclerecovered;
	}

	public void setIsvehiclerecovered(boolean isvehiclerecovered) {
		this.isvehiclerecovered = isvehiclerecovered;
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