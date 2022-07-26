package org.sofka.ApiCrudTienda.controller.Utils;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Data
@Component
public class CustomResponse {
	private Boolean error;

	private Integer status;

	private String message;

	private Object data;


	public CustomResponse fillFields(Boolean error, String message, Object data, HttpStatus status) {
		this.error = error;
		this.message = message;
		this.data = data;
		this.status = status.value();
		return this;
	}
}
