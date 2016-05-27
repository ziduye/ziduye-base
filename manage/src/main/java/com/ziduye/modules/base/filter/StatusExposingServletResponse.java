package com.ziduye.modules.base.filter;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Map;

public class StatusExposingServletResponse extends HttpServletResponseWrapper {

	private int httpStatus;  
	private Map<String,String> _header = Maps.newHashMap();
	
	public StatusExposingServletResponse(HttpServletResponse response) {
		super(response);
	}
	
	@Override  
    public void sendError(int sc) throws IOException {  
        httpStatus = sc;  
        super.sendError(sc);  
    }  
  
    @Override  
    public void sendError(int sc, String msg) throws IOException {  
        httpStatus = sc;  
        super.sendError(sc, msg);  
    }  
  
    @Override
	public void sendRedirect(String location) throws IOException {
		httpStatus = 302;
		_header.put("Location", location);
		super.sendRedirect(location);
	}
    
	@Override
	public void setHeader(String name, String value) {
		_header.put(name, value);
		super.setHeader(name, value);
	}
	@Override
	public void setStatus(int sc, String sm) {
		httpStatus = sc;  
		super.setStatus(sc, sm);
	}
	@Override  
    public void setStatus(int sc) {  
        httpStatus = sc;  
        super.setStatus(sc);  
    }  
  
    public int getStatus() {  
        return httpStatus;  
    }  
    public String getHeader(String headerName) {  
    	return _header.get(headerName);  
    }  
}
