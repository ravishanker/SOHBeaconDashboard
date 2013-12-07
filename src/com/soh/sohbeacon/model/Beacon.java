package com.soh.sohbeacon.model;

import java.io.File;

public class Beacon {
	private String type;
	
	private String beaconName;
	
	private File file;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beacon) {
			Beacon other = (Beacon) obj;
			
			return (other.type.equals(type) && other.beaconName.equals(beaconName));
		}
		return super.equals(obj);
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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
}
