package com.daily_study_check.daily_study_check.controller.DTO.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Data
@ResponseBody
public class ResponseDTO <T>{
	private T data;
	private HttpStatus status;

	public ResponseDTO createSuccessfulResponse(T data) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setData(data);
		responseDTO.setStatus(HttpStatus.OK);
		return responseDTO;
	}
}
