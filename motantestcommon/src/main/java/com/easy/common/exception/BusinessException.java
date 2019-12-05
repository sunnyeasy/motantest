package com.easy.common.exception;

import com.easy.common.code.AnwserCode;

public class BusinessException extends BaseException{
	private String errDesc;
	
	public BusinessException(){
		
	}
	
	public BusinessException(AnwserCode anwserCode){
		super(anwserCode);
	}
	
	public BusinessException(AnwserCode anwserCode, String errDesc){
		super(anwserCode);
		this.errDesc = errDesc;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	
}
