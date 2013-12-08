package com.soh.sohbeacon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soh.sohbeacon.store.BeaconStore;

/**
 * Servlet implementation class OfferForBeacon
 */
public class UpdateUserRegistrationAtLocation extends HttpServlet {
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
		String userId = request.getParameter("userId");
		String beaconId = request.getParameter("beacon");
		boolean inbound = false;
		try {
			inbound = Integer.parseInt(request.getParameter("inbound")) > 0;
		}
		catch (NumberFormatException e)
		{
		}
		
		if (inbound)
		{
			BeaconStore.getInstance().addUserToBeacon(userId, beaconId);
		}
		else
		{
			BeaconStore.getInstance().removeUserFromBeacon(userId, beaconId);
		}
	}
}
