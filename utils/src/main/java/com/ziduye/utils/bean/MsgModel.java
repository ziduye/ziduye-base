package com.ziduye.utils.bean;

public class MsgModel {
    private boolean succ ;// 是否成功
    private String msg ;// 提示信息
    
    public MsgModel() {
    	this.succ = true;
	}
    
    public MsgModel(boolean succ,String msg) {
		this.succ = succ;
		this.msg = msg;
	}
    
    public static MsgModel TrueBean(){
    	return new MsgModel(true,"");
    }
    
	public static MsgModel TrueBean(String msg){
    	return new MsgModel(true,msg);
    }
	
	public static MsgModel FalseBean(String msg){
		return new MsgModel(false,msg);
	}
	
	public boolean getSucc() {
		return succ;
	}
	public void setSucc(boolean succ) {
		this.succ = succ;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return JsonMapper.toJsonString(this);
	}
    
}
