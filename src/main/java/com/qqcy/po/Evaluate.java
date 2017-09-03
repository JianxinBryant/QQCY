package com.qqcy.po;

import com.qqcy.util.BaseBean;

public class Evaluate extends BaseBean{
	private Integer e_id;
	
	private String e_content;
	
	private String e_createtime;

	public Integer getE_id() {
		return e_id;
	}

	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}

	public String getE_content() {
		return e_content;
	}

	public void setE_content(String e_content) {
		this.e_content = e_content;
	}

	public String getE_createtime() {
		return e_createtime;
	}

	public void setE_createtime(String e_createtime) {
		this.e_createtime = e_createtime;
	}
}
