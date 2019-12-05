package com.easy.common.vo;

import com.easy.common.code.AnwserCode;

import java.io.Serializable;

public class BaseRpcDataVo implements Serializable{
	private static final long serialVersionUID = 4826358032578468363L;
	protected AnwserCode anwserCode = AnwserCode.SUCCESS;
	private String data;

	public boolean isSuccess(){
		return anwserCode.getCode() == AnwserCode.SUCCESS.getCode();
	}
	
	public AnwserCode getAnwserCode() {
		return anwserCode;
	}

	public void setAnwserCode(AnwserCode anwserCode) {
		this.anwserCode = anwserCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
