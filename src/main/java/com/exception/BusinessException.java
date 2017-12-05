package com.exception;

import com.domain.base.BaseCode;
import com.domain.base.Response;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String COLON_SPLIT = ":";

	private String code;

	public BusinessException(BaseCode baseCode) {
		super( baseCode.getMessage());
		this.setCode(baseCode.getPCode());
	}

	public BusinessException(String code, String msg) {
		super(msg);
		this.setCode(code);
	}

	public BusinessException(Response<?> response) {
		super(response.getMsg());
		this.setCode(response.getCode());
	}

	public BusinessException(BaseCode baseCode, Response<?> response) {
		super(response.getMsg());
		this.setCode(baseCode.getPCode());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}