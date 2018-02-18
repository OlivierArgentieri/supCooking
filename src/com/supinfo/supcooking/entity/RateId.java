 /*package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class RateId implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private String ip;
	
	
	
	public Long getId() {
		return id;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateId)) return false;
        RateId that = (RateId) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getIp(), that.getIp());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIp());
    }
}
*/