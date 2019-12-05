package com.easy.common.vo;

import java.util.List;

public class BaseListRpcVo<T> extends BaseRpcVo {
	private static final long serialVersionUID = -4437062282448149961L;

	private List<T> listVo;

	private Integer count = 0;

	public List<T> getListVo() {
		return listVo;
	}

	public void setListVo(List<T> listVo) {
		this.listVo = listVo;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
