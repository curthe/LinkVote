package net.bingo.vote.model.users;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回到页面的通用json的数据
 * 
 * @author 初坤
 *
 */
public class JspModel {

	// code: 100:成功,200:失败
	private Integer code;
	private String msg;
	private Map<String, Object> extend = new HashMap<>();
	
	

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static JspModel  success(){
		JspModel model = new JspModel();
		model.setCode(100);
		model.setMsg("处理成功");
		return model;
	}
	
	public static JspModel  failure(){
		JspModel model = new JspModel();
		model.setCode(200);
		model.setMsg("处理失败");
		return model;
	}
	
	//链式存储数据
	
	public JspModel add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
}
