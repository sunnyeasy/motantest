package com.easy.common.vo;

import com.easy.common.code.AnwserCode;

import java.io.Serializable;

public class BaseRecordRpcVo<T> implements Serializable{
	private static final long serialVersionUID = 7685249699465007353L;
	protected AnwserCode anwserCode = AnwserCode.SUCCESS;
	private T data;

	public boolean isSuccess(){
		return anwserCode.getCode() == AnwserCode.SUCCESS.getCode();
	}
	
	public AnwserCode getAnwserCode() {
		return anwserCode;
	}

	public void setAnwserCode(AnwserCode anwserCode) {
		this.anwserCode = anwserCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
