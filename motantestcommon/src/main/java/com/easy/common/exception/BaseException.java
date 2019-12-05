package com.easy.common.exception;

import com.easy.common.code.AnwserCode;

import java.text.ParseException;

public class BaseException extends RuntimeException{
	private int code;
	
    private String errMessage;
	
	public BaseException(){
		code = AnwserCode.ERROR.getCode();
		errMessage = AnwserCode.ERROR.getMessage();
	}
	
	public BaseException(AnwserCode anwserCode){
		super(anwserCode.getMessage());
		
		this.code = anwserCode.getCode();
		this.errMessage = anwserCode.getMessage();
	}
	
	public BaseException(AnwserCode anwserCode, String errmsg){
		super(errmsg);
		
		this.code = anwserCode.getCode();
		this.errMessage = anwserCode.getMessage();
	}

	public AnwserCode getAnwserCode() {
		return new AnwserCode(code, errMessage);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	
	public static AnwserCode getExceptionInfo(Throwable e){
		
		if( ParseException.class.isAssignableFrom(e.getClass()) ){
			return AnwserCode.ARGS_ERRORS;
		}
		
		Throwable parentCause = e;
		Throwable cause = parentCause.getCause();
		while( null != cause ){
			parentCause = cause;
			cause = cause.getCause();
		}
		
		if(parentCause instanceof BaseException ){
			return ((BaseException) parentCause).getAnwserCode();
		}else {
			return AnwserCode.APPLICATION_EXCEPTIONS;
		}
	}
}
