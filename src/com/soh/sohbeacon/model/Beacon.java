package com.soh.sohbeacon.model;

public class Beacon {
	private String type;
	
	private String beaconName;
	
	private String fileName;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beacon) {
			Beacon other = (Beacon) obj;
			
			return (other.type.equals(type) && other.beaconName.equals(beaconName));
		}
		return super.equals(obj);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBeaconName() {
		return beaconName;
	}

	public void setBeaconName(String beaconName) {
		this.beaconName = beaconName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
