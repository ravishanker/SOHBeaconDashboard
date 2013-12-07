package com.soh.sohbeacon.store;

import java.util.ArrayList;

import com.soh.sohbeacon.model.Beacon;

public class BeaconStore {
	public static final String STORES_PATH = "/Users/sushant/workspace-hackathon/stores/";
	
	private static BeaconStore _instance = new BeaconStore();
	
	private ArrayList<Beacon> notificationBeacon = new ArrayList<Beacon>();
	
	public static BeaconStore getInstance() {
		return _instance;
	}

	private BeaconStore() {
	}

	public void addNotificationBeacon(Beacon newBeacon) {
		for (int i = 0; i<notificationBeacon.size(); i++)
		{
			Beacon b = notificationBeacon.get(i);
			
			if (b.equals(newBeacon))
			{
				notificationBeacon.remove(i);
				
				break;
			}
		}
		this.notificationBeacon.add(newBeacon);
	}
	
	public ArrayList<Beacon> getNotificationBeacons() {
		return notificationBeacon;
	}

	public Beacon findNotificationBeacon(
			String beaconId, boolean inbound) {
		for (int i = 0; i<notificationBeacon.size(); i++)
		{
			Beacon b = notificationBeacon.get(i);
			
			if (b.getBeaconName().equals(beaconId)
					&& b.isInbound() == inbound)
			{
				return b;
			}
		}
		return null;
	}
}
