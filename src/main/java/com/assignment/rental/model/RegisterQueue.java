package com.assignment.rental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "register_queue")
public class RegisterQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userid")
    private long userid;

    @Column(name = "outletid")
    private long outletid;

    @Column(name = "vehicleid")
    private long vehicleid;

    @Column(name = "registeredtime")
    private Date registeredtime;
 
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

	public Date getRegisteredtime() {
		return this.registeredtime;
	}

	public void setRegisteredtime(Date registeredtime) {
		this.registeredtime = registeredtime;
	}
}