package com.qqcy.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qqcy.po.Message;
import com.qqcy.po.Species;
import com.qqcy.po.Vegetable;
import com.qqcy.service.SpeciesService;
import com.qqcy.service.VegetableService;
import com.qqcy.util.BaseController;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * 蔬菜管理的控制器
 * 
 * @author 张舰心
 *
 */
@Controller
@RequestMapping("/vegetable/")
public class VegetableController extends BaseController {
	/**
	 * 在controller层中加入一段数据绑定代码
	 * 
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		simpleDateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
	}

	@Autowired
	private VegetableService vegetableService;
	@Autowired
	private SpeciesService speciesService;
	private String addr="localhost";
	/**
	 * 删除蔬菜信息
	 * @param vegetable
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("delete.do")
	public String delete(Vegetable vegetable,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		vegetableService.deleteVegetable(vegetable);
		
		 return list(new Vegetable(),model,request);
	}
	@RequestMapping("add.do")
	public String add(Vegetable vegetable, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		// 调用业务层的方法添加蔬菜
		vegetableService.addVegetable(vegetable);
		return list(new Vegetable(), model, request);
	}

	/**
	 * 查询出所有蔬菜的信息
	 * @param vegetable
	 * @param model
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("list.do")
	public String list(Vegetable vegetable,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		
		//处理乱码
		if(vegetable.getV_name() !=null && !vegetable.getV_name().equals("")){
			vegetable.setV_name(URLDecoder.decode(vegetable.getV_name(),"UTF-8"));
		}		
		//model中设置查询条件
		if(vegetable.getV_name() !=null && !vegetable.getV_name().equals("")){
			model.addAttribute("vegetablenamequery",URLDecoder.decode(vegetable.getV_name(),"UTF-8"));
		}
		if(vegetable.getSpecies()!=null){
			model.addAttribute("vegetablespeciesidquery", vegetable.getSpecies().getSp_id());
					
		}
		
		//初始化分页信息
		this.initPage(request);
		vegetable.setStart(getStart());//设置起始记录数
		//按条件查询蔬菜总数
		long total=vegetableService.getCount(vegetable);
		model.addAttribute("total", total);
		//按条件/分页查询所有蔬菜信息
		List<Vegetable> vegetables= vegetableService.getVegetableList(vegetable);
		vegetable.setStart(getStart());//设置起始记录数
		model.addAttribute("vegetables", vegetables);
		//查询出所有的种类
		List<Species> specieses=speciesService.getSpeciesList();
		model.addAttribute("specieses", specieses);
		return "All";
	}
	/**
	 * 修改商品信息
	 * @param vegetable
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("update.do")
	public String update(Vegetable vegetable,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		vegetableService.updateVegetable(vegetable);
		return list(new Vegetable(),model,request);
		
	}
	/**
	 * 预加载修改页面
	 * @param vegetable
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadUpdate(Vegetable vegetable,Model model)
	{
		Vegetable pvegetable=vegetableService.getVegetable(vegetable);
		model.addAttribute("vegetable", pvegetable);
		//查询出所有的种类
		List<Species> specieses=speciesService.getSpeciesList();
		model.addAttribute("specieses", specieses);
		return "vegetableUpdate";
		
	}
	/**
	 *通过id得到vegetable实体
	 * @param id
	 * @return
	 */
	@RequestMapping("getVegetableById.do")
	public String getVegetableById(Vegetable vegetable,Model model,HttpServletRequest request)
	{
		Vegetable pvegetable=vegetableService.getVegetable(vegetable);
		model.addAttribute("DisplayOfVegetable", pvegetable);
		String str=request.getParameter("v_id");
		HttpSession session=request.getSession();
		session.setAttribute("vid", str);
		return "More";
	}
	/**
	 * 上传图片
	 * @return
	 * @throws IOException 
	 * @throws ClientHandlerException 
	 * @throws UniformInterfaceException 
	 */
	@RequestMapping("upload.do")
	public @ResponseBody String loadupImg(@RequestParam(required=false) MultipartFile file,HttpServletRequest request) throws UniformInterfaceException, ClientHandlerException, IOException{
		//这里需要使用put方法，需要服务器web.xml配置使其支持put方法
		//System.out.println(file);//判断文件是否取到
		String fileName=String.valueOf(new Date().getTime());
		fileName +=new Random().nextLong();
		String url="/upload/"+fileName+".jpg";//图片保存地址D://.....jpg
		String httpurl="http://"+addr+":8080/fileServer"+url;//灵异台服务器的地址,工程名为fileServer
		//向另一台服务器的upload文件夹发送文件
		Client client=new Client();
		WebResource resource=client.resource(httpurl);
		resource.put(String.class,file.getBytes());//以put方式向httpUrl发送文件
		return httpurl;
	}
	/**
	 * 通过ckeditor上传图片
	 * @param upload
	 * @throws UniformInterfaceException
	 * @throws ClientHandlerException
	 * @throws IOException
	 */
	@RequestMapping("uploadfile.do")
	public void uploadFile(@RequestParam(required=false) MultipartFile upload,HttpServletRequest request,HttpServletResponse response) throws UniformInterfaceException, ClientHandlerException, IOException
	{
		//System.out.println("upload = "+upload);
		String fileName=String.valueOf(new Date().getTime());
		fileName +=new Random().nextLong();
		String url="/upload/"+fileName+".jpg";//图片保存地址D://.....jpg
		String httpurl="http://"+addr+":8080/fileServer"+url;//灵异台服务器的地址,工程名为fileServer
		//向另一台服务器的upload文件夹发送文件
		Client client=new Client();
		WebResource resource=client.resource(httpurl);
		resource.put(String.class,upload.getBytes());//以put方式向httpUrl发送文件
		//响应
		PrintWriter out = response.getWriter();
		//获取路径
		String callback=request.getParameter("CKEditorFuncNum");
		out.print("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+httpurl+"')</script>");		
	}
	/**
	 * 添加蔬菜的页面（查询出所有的种类）
	 * 
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadAdd(Model model) {
		// 查询出所有的蔬菜种类
		List<Species> specieses = speciesService.getSpeciesList();
		model.addAttribute("specieses", specieses);
		return "Add";
	}

	/**
	 * 根据种类查询所有蔬菜
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("lists.do")
	public String lists(Vegetable vegetable, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

		//处理乱码
		if(vegetable.getV_name() !=null && !vegetable.getV_name().equals("")){
			vegetable.setV_name(URLDecoder.decode(vegetable.getV_name(),"UTF-8"));
		}		
		//model中设置查询条件
		if(vegetable.getV_name() !=null && !vegetable.getV_name().equals("")){
			model.addAttribute("vegetablenamequery",URLDecoder.decode(vegetable.getV_name(),"UTF-8"));
		}
		if(vegetable.getSpecies()!=null){
			model.addAttribute("vegetablespeciesidquery", vegetable.getSpecies().getSp_id());
					
		}
		//初始化分页信息
		this.initPage(request);
		vegetable.setStart(getStart());//设置起始记录数
		//按条件查询蔬菜总数
		long total=vegetableService.getCount(vegetable);
		model.addAttribute("total", total);
		//查询出所有的种类
		List<Species> specieses=speciesService.getSpeciesList();
		model.addAttribute("specieses", specieses);
		return "GuanliIndex";
	}

	/**
	 * 根据种类查询所有蔬菜
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("listbyid.do")
	public String listbyid(Vegetable vegetable, Model model, HttpServletRequest request) {
		Integer sp_id =Integer.parseInt(request.getParameter("sp_id"));
		Species species=new Species();
		species.setSp_id(sp_id);
		vegetable.setSpecies(species);
		vegetable.setStart(0);
		
		// 按种类名称查询
		if (vegetable.getSpecies() != null) {
			model.addAttribute("vegetablespeciesidquery", vegetable.getSpecies().getSp_id());
		}
		
		// 初始化分页信息
		this.initPage(request);
		vegetable.setStart(getStart());// 设置起始记录数

		// 按条件查询所有蔬菜记录数
		Long total = vegetableService.getCount(vegetable);
		model.addAttribute("total", total);

		// 查询出所有相同种类的蔬菜
		List<Vegetable> vegetables = vegetableService.getVegetableList(vegetable);
		model.addAttribute("vegetables", vegetables);
		
		return "All";
	}
	/**
	 * 验证蔬菜是否已上架
	 * @return
	 */
	@RequestMapping("validate.do")
	public @ResponseBody Message validate(Vegetable vegetable){
		boolean flag=vegetableService.validate(vegetable);
		if(flag){
			//唯一
			Message message=new Message();
			message.setContent("该商品可上架");
			message.setDate(new Date());
			return message;
		}else{
			//已存在
			Message message=new Message();
			message.setContent("该商品已上架");
			message.setDate(new Date());
			return message;
		}
	}
	@RequestMapping("userList.do")
	public String userList(Vegetable vegetable, Model model, HttpServletRequest request){
		//按条件/分页查询所有蔬菜信息
		List<Vegetable> vegetables= vegetableService.getVegetableList(vegetable);
		model.addAttribute("vegetables", vegetables);
		//查询出所有的种类
		List<Species> specieses=speciesService.getSpeciesList();
		model.addAttribute("specieses", specieses);
		return "userAll";
	}
	
}
