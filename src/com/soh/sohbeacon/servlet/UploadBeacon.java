package com.soh.sohbeacon.servlet;

import java.awt.PageAttributes.OriginType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.soh.sohbeacon.model.DynamicBeacon;

/**
 * Servlet implementation class UploadBeacon
 */
public class UploadBeacon extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		for (FileItem fi : items)
		{
			if (fi.getFieldName().equals("upload_file"))
			{
				String orginalName = fi.getName();
				String parts[] = orginalName.split("\\.");
				String suffix = "";
				if (parts.length >= 2)
				{
					suffix = "."+parts[parts.length - 1];
				}
				
				File uploadedFile = File.createTempFile("dyBeacon", suffix);
				
				DynamicBeacon dynamicBeacon = new DynamicBeacon();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(uploadedFile));
				try {
					fi.write(uploadedFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				dynamicBeacon.setFile(uploadedFile);
//				dynamicBeacon.setFile(file);
				System.out.println(uploadedFile);
			}

			
			System.out.println(fi);
		}
	}

}
