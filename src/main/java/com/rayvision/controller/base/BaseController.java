package com.rayvision.controller.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rayvision.util.Page;
import com.rayvision.model.Msg;
import com.rayvision.service.BaseServiceI;

import net.sf.json.JSONSerializer;

public class BaseController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected Log log=LogFactory.getLog(this.getClass());
	@Autowired
	protected BaseServiceI baseService;
	public void _Save(Object o){
		baseService.save(o);
		Msg msg=new Msg("success","true");
		renderJson(msg);
	}
	public void _Delete(Class clazz,String ids){
		String []values=ids.split(",");
		if(values !=null && values.length>0){
			for(String id:values){		
				baseService.delete(clazz,Long.valueOf(id));
			}	
		}
		Msg msg=new Msg("success","true");
		renderJson(msg);
		
	}
	public void _Update(Object o){
		baseService.update(o);
		Msg msg=new Msg("success","true");
		renderJson(msg);
	}
	public Object _findById(Class clazz,Long id){
		return baseService.findById(clazz,id);
	}
	public List<Object> _findAll(Class clazz){
		return baseService.findAll(clazz);
	}
	/**
	 * 返回json字符串
	 * @param o
	 * @throws IOException
	 */
	public void renderJson(Object o){
		try{
			JSONSerializer js =new JSONSerializer();
			response.getWriter().write(js.toJSON(o).toString());
		}catch(IOException e){
			log.info(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	/**
	 * 注入 http request response对象
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response){
		this.request=request;
		this.response=response;
		
	}
	/**
	 * 获取前台请求参数
	 * @return
	 */
	public Map<String,Object> getRequestParams(){
		HttpServletRequest request=this.request;
		Map map=request.getParameterMap();		
		Map <String,Object> params= new HashMap();
		Set<String> keySet=map.keySet();
		for(String key:keySet){
			String [] values=(String[])map.get(key);
			String sum="";
			for(String value:values){
				sum+=value;
				System.out.println(value);
			}			
			params.put(key, sum);			
			
		}
		return params;
	}
	public void _Seacrh(Class clazz){
		Map<String,Object> params=getRequestParams();
		Page page=baseService.find(clazz,params);
		renderJson(page);
	}
}
