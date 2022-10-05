package com.assignment.rental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registered")
public class Registered {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userid")
    private long userid;

    @Column(name = "outletid")
    private long outletid;

    @Column(name = "vehicleid")
    private long vehicleid;

    @Column(name = "pickuptime")
    private Date pickuptime;

    @Column(name = "pickuplat")
    private String pickuplat;

    @Column(name = "pickuplon")
    private String pickuplon;

    public long getId() {
        return id;
    }

    public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

    public long getOutletid() {
		return this.outletid;
	}

	public void setOutletid(long outletid) {
		this.outletid = outletid;
	}

    public long getVehicleid() {
		return this.vehicleid;
	}

	public void setVehicleid(long vehicleid) {
		this.vehicleid = vehicleid;
	}

    public Date getPickuptime() {
		return this.pickuptime;
	}

	public void setPickuptime(Date pickuptime) {
		this.pickuptime = pickuptime;
	}

    public String getPickuplat() {
		return this.pickuplat;
	}

	public void setPickuplat(String pickuplat) {
		this.pickuplat = pickuplat;
	}

	public String getPickuplon() {
		return this.pickuplon;
	}

	public void setPickuplon(String pickuplon) {
		this.pickuplon = pickuplon;
	}

}