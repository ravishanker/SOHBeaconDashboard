package com.soh.sohbeacon.store;

import java.util.ArrayList;

import com.soh.sohbeacon.model.Beacon;

public class BeaconStore {
	private static BeaconStore _instance = new BeaconStore();
	
	private Beacon dynamicBeacon;

	private ArrayList<Beacon> notificationBeacon = new ArrayList<Beacon>();
	
	public static BeaconStore getInstance() {
		return _instance;
	}

	private BeaconStore() {
	}

	public Beacon getDynamicBeacon() {
		return dynamicBeacon;
	}

	public void setDynamicBeacon(Beacon dynamicBeacon) {
		this.dynamicBeacon = dynamicBeacon;
	}

	public void addNotificationBeacon(Beacon newBeacon) {
		this.notificationBeacon.add(newBeacon);
	}
	
	public ArrayList<Beacon> getNotificationBeacons() {
		return notificationBeacon;
	}
}
