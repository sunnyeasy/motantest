package com.easy.common.vo;

import com.easy.common.code.AnwserCode;

import java.io.Serializable;

public class BaseRpcVo implements Serializable{
	private static final long serialVersionUID = -993862472376945799L;
	protected AnwserCode anwserCode = AnwserCode.SUCCESS;

	public boolean isSuccess(){
		return anwserCode.getCode() == AnwserCode.SUCCESS.getCode();
	}
	
	public AnwserCode getAnwserCode() {
		return anwserCode;
	}

	public void setAnwserCode(AnwserCode anwserCode) {
		this.anwserCode = anwserCode;
	}

	public static boolean isFail(BaseRpcVo vo) {
		if (null == vo) {
			return true;
		}

		if (!vo.isSuccess()) {
			return true;
		}

		return false;
	}

	public static boolean isSuccess(BaseRpcVo vo) {
		if (null != vo && vo.isSuccess()) {
			return true;
		}

		return false;
	}
}
