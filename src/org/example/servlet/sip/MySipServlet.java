package org.example.servlet.sip;

import java.io.IOException;

import gov.nist.javax.sip.header.CallID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.sip.Address;
import javax.servlet.sip.Proxy;
import javax.servlet.sip.SipServlet;
import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import javax.servlet.sip.TooManyHopsException;
import javax.servlet.sip.URI;


public class MySipServlet extends SipServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("v2 SIP Server Started");
		super.init(config);
	}
	public void doInvite(SipServletRequest request) {
		// TODO: Add logic
		
	}
	
	public void doBye(SipServletRequest request) {
		// TODO: Add logic
	
	}
	
	public void doRequest(SipServletRequest request) {
		Address addr = request.getFrom();
		System.out.println( "Address is: " + addr.toString() );
		
		String callid = request.getCallId();
		System.out.println( "CallId is: " +  callid);
		
		URI uri = request.getRequestURI();
		
//		SipServletResponse resp = request.createResponse(411, "Response occured");
//		System.out.println("Rejection: " + resp);
		
//		resp.addHeader("ModifiedHeader", "IAmModified");
		
		try {
			Proxy proxy = request.getProxy();
			proxy.proxyTo(uri);
		} catch (TooManyHopsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
//		try {
//			resp.send();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
