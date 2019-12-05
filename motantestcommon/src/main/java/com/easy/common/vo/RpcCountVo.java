package com.easy.common.vo;

public class RpcCountVo extends BaseRpcVo{
	private static final long serialVersionUID = 1L;
	private Integer count = 0;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public RpcCountVo(Integer count) {
		super();
		this.count = count;
	}
	
	public RpcCountVo(){}
}
