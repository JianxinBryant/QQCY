package com.qqcy.util;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	private long start;

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}
	
	public void initPage(HttpServletRequest request){
		String str = request.getParameter("pager.offset");
		if(str != null && !str.equals("")){

			start = Long.parseLong(str);
		}else{
			start = 0;
		}
	}
	
}
