package net.bingo.vote.common;

/**
 * ajax 交互传递的JSON数据
 * @author wangsz
 *
 */
public class JsonData {

	private boolean success = false;

	private String msg = "";

	private Object obj = null;
	
	private String code = "";
	
	private Object data = null;
	
	public JsonData(){
		
	}
	
	public JsonData(boolean success,String msg,Object obj){
		this.success=success;
		this.msg=msg;
		this.obj=obj;
	}
	
	public JsonData(boolean success,String msg,Object obj,String code){
		this.success=success;
		this.msg=msg;
		this.obj=obj;
		this.code = code;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "JsonData [success=" + success + ", msg=" + msg + ", obj=" + obj + ", code=" + code + ", data=" + data
				+ "]";
	}
	
}
