package com.soh.sohbeacon.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soh.sohbeacon.model.Beacon;
import com.soh.sohbeacon.store.BeaconStore;

/**
 * Servlet implementation class OfferForBeacon
 */
public class OfferForBeacon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String beaconId = request.getParameter("beacon");
		boolean inbound = false;
		try {
			inbound = Integer.parseInt(request.getParameter("inbound")) > 0;
		}
		catch (NumberFormatException e)
		{
		}
		
		Beacon beacon = BeaconStore.getInstance().findNotificationBeacon(beaconId, inbound);
		if (beacon != null)
		{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
			bw.write("/stores/"+beacon.getFileName());
			bw.flush();
			bw.close();
		}
	}
}
