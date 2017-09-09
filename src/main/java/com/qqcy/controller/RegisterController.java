package com.qqcy.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qqcy.po.User;
import com.qqcy.util.BaseController;
/**
 * 提供用户注册界面
 * @author 张舰心
 *
 */
public class RegisterController extends BaseController {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.getRequestDispatcher("/webapp/WEB-INF/register.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		doGet(request, response);
	}

	private String u_userName;

	private String u_password;

	private String confirmpassword;

	private String u_email;
	
	private String u_truename;

	private String u_telephone;
	/**
	* 存储校验不通过时给用户的错误提示信息
	*/
	private Map<String, String> errors = new HashMap<String, String>();
	private Object u_username;
	public Map<String, String> getErrors() {
	return errors;
	}
	public void setErrors(Map<String, String> errors) {
	this.errors = errors;
	}
	/**
	* validate方法负责校验表单输入项
	* 表单输入项校验规则：
	* private String u_username; 用户名不能为空 
	* private String u_password; 密码不能为空，并且要是-的数字
	* private String confirmpassword; 两次密码要一致
	* private String u_email; 可以为空，不为空要是一个合法的邮箱 
	* private String u_telephone;可以为空，不为空要是一个合法的电话号码
	* private String u_truename;
	*/
	public boolean validate() {
		boolean isOk = true;
		if (this.u_username == null || ((String) this.u_username).trim().equals("")) {
			isOk = false;
			errors.put("u_username", "�û�����Ϊ�գ���");
			} 
		else {
			if (!((String) this.u_username).matches("[a-zA-Z]{3,8}")) {
				isOk = false;
				errors.put("u_username", "�û��������-λ����ĸ����");
				}
	}
		if (this.u_password == null || this.u_password.trim().equals("")) {
			isOk = false;
			errors.put("upassword", "���벻��Ϊ�գ���");
			}
		else {
			if (!this.u_password.matches("\\d{,}")) {
				isOk = false;
				errors.put("password", "���������-λ�����֣���");
				}
			}
		// private String u_password; 两次密码要一致
		if (this.confirmpassword != null) {
			if (!this.confirmpassword.equals(this.u_password)) {
				isOk = false;
				errors.put("confirmPwd", "�������벻һ�£���");
				}
			}
		// private String u_email; 可以为空，不为空要是一个合法的邮箱
		if (this.u_email != null && !this.u_email.trim().equals("")) {
			if (!this.u_email.matches("\\w+@\\w+(\\.\\w+)+")) {
	isOk = false;
	errors.put("email", "���䲻��һ���Ϸ����䣡��");
	}
			}
		// private String u_telephone; 可以为空，不为空时，要是一个合法的手机号
		if (this.u_telephone != null && !this.u_telephone.trim().equals("")) {
			if (!this.u_telephone.matches("1\\d{10}"))
			{
				isOk = false;
				errors.put("telephone", "��ϵ�绰����Ҫ��һ���ֻ���룡��");
				}
			}
		return isOk;
		}
	public String get_username() {
		return u_userName;
		}
	public void setu_username(String userName) {
		this.u_userName =u_userName;
		}
	public String getu_password() {
		return u_password;
		}
	public void setu_password(String u_password) {
		this.u_password = u_password;
		}
	public String getconfirmpassword() {
	    return u_password;
		}
	public void setConfirmpassword(String Confirmpassword) {
		this.confirmpassword = u_password;
		}
	public String getu_email() {
		return u_email;
		}
	public void setEmail(String u_email) {
		this.u_email = u_email;
		}
	public String getu_telephone() {
		return u_telephone;
		}
	public void setu_telephone(String u_telephone) {
		this.u_telephone = u_telephone;
		}
	}


