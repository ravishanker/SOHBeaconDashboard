package com.soh.sohbeacon.model;

public class Beacon {
	private boolean inbound;

	private String beaconName;

	private String beaconAlertText;

	public String getBeaconAlertText() {
		return beaconAlertText;
	}

	public void setBeaconAlertText(String beaconAlertText) {
		this.beaconAlertText = beaconAlertText;
	}

	private String fileName;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beacon) {
			Beacon other = (Beacon) obj;

			return (other.inbound == inbound && other.beaconName
					.equals(beaconName));
		}
		return super.equals(obj);
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

	public boolean isInbound() {
		return inbound;
	}

	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}
}
