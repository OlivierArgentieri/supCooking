package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.Objects;

public class RateId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
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
