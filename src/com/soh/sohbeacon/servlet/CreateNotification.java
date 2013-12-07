package com.soh.sohbeacon.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.soh.sohbeacon.model.Beacon;
import com.soh.sohbeacon.store.BeaconStore;

/**
 * Servlet implementation class UploadBeacon
 */
public class CreateNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		String notificationType1 = null;
		String beaconChooser1 = null;
		Beacon dynamicBeacon = null;
		for (FileItem fi : items)
		{
			if (fi.isFormField())
			{
			    String name = fi.getFieldName();
			    String value = fi.getString();
			    if (name.equals("notificationType1"))
			    {
			    	notificationType1 = value;
			    }
			    else if (name.equals("beaconChooser1"))
			    {
			    	beaconChooser1 = value;
			    }
			}
			else if (fi.getFieldName().equals("upload_file"))
			{
				String orginalName = fi.getName();
				String parts[] = orginalName.split("\\.");
				String suffix = "";
				if (parts.length >= 2)
				{
					suffix = "."+parts[parts.length - 1];
				}
				
				File uploadedFile = File.createTempFile("notifBeacon", suffix, new File(BeaconStore.STORES_PATH));
				
				dynamicBeacon = new Beacon();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(uploadedFile));
				try {
					fi.write(uploadedFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				dynamicBeacon.setFileName(uploadedFile.getName());
				System.out.println(uploadedFile);
			}

			System.out.println(fi);
		}
		
		dynamicBeacon.setType(notificationType1);
		dynamicBeacon.setBeaconName(beaconChooser1);
		
		BeaconStore.getInstance().addNotificationBeacon(dynamicBeacon);
	}

}
