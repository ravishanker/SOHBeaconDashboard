package com.soh.sohbeacon.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.soh.sohbeacon.model.Beacon;

public class BeaconStore {
	public static final String STORES_PATH = "/Users/sushant/workspace-hackathon/stores/";
	
	private static BeaconStore _instance = new BeaconStore();
	
	private ArrayList<Beacon> notificationBeacon = new ArrayList<Beacon>();
	
	private HashMap<String, HashSet<String>> userTracking = new HashMap<String, HashSet<String>>();
	
	public static BeaconStore getInstance() {
		return _instance;
	}

	private BeaconStore() {
		addUserToBeacon("1", "beacon1");
		addUserToBeacon("2", "beacon2");
		addUserToBeacon("1", "beacon2");
		addUserToBeacon("1", "beacon3");
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
	
	public void addUserToBeacon(String userId, String beacon){
		if (userTracking.containsKey(beacon) == false)
		{
			userTracking.put(beacon, new HashSet<String>());
		}
		userTracking.get(beacon).add(userId);
	}
	
	public void removeUserFromBeacon(String userId, String beacon){
		try {
			userTracking.get(beacon).remove(userId);
			
		}catch (Exception e)
		{
			
		}
	}
	
	public HashSet<String> usersFromBeacon(String beacon){
		if (userTracking.containsKey(beacon))
		{
			return userTracking.get(beacon);
		}
		return new HashSet<String>();
	}
}
