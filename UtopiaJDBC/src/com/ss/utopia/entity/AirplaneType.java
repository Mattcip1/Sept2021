package com.ss.utopia.entity;

import java.util.List;

public class AirplaneType {

	private Integer TypeId;
	private Integer maxCapacity;
	private List<Airplane> airplanes;
	
	public Integer getTypeId() {
		return TypeId;
	}
	public void setTypeId(Integer typeId) {
		TypeId = typeId;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public List<Airplane> getAirplanes() {
		return airplanes;
	}
	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TypeId == null) ? 0 : TypeId.hashCode());
		result = prime * result + ((maxCapacity == null) ? 0 : maxCapacity.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirplaneType other = (AirplaneType) obj;
		if (TypeId == null) {
			if (other.TypeId != null)
				return false;
		} else if (!TypeId.equals(other.TypeId))
			return false;
		if (maxCapacity == null) {
			if (other.maxCapacity != null)
				return false;
		} else if (!maxCapacity.equals(other.maxCapacity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AirplaneType [TypeId=" + TypeId + ", maxCapacity=" + maxCapacity + ", airplanes=" + airplanes + "]";
	}
}
