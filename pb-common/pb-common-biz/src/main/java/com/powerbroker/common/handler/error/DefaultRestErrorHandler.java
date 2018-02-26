package com.powerbroker.common.handler.error;

import com.powerbroker.common.exception.AppException;
import com.powerbroker.common.handler.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.JdkIdGenerator;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * @author william
 *
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class DefaultRestErrorHandler {

	@ExceptionHandler(AppException.class)
	@ResponseStatus(HttpStatus.OK)
	public GenericResponse<Void> handleHZCException(AppException exception) {

		GenericResponse<Void> response = new GenericResponse<Void>();

		response.setResult(false);
		response.getError().setCode(StringUtils.isEmpty(exception.getMessage())
				? String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR) : exception.getMessage());
		String message = exception.getMessage();
		if (StringUtils.hasText(message)) {
			response.getError().setMessage(message);
		}

		log.error("!!! ERROR: error occurs code {}, message {} !!!", response.getError().getCode(),
				response.getError().getMessage());

		return response;
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.OK)
	public GenericResponse<Void> handleRuntimeException(RuntimeException exception) {

		GenericResponse<Void> response = new GenericResponse<Void>();

		response.setResult(false);
		response.getError().setCode("RUNTIME_EXCEPTION");

		String identifier = new JdkIdGenerator().generateId().toString().replace("-", "");
		response.getError().setMessage(MessageFormat.format("{0}-{1}", identifier, exception.toString()));
		log.error("!!! ERROR: error occurs identifier {}, code {}, message {} !!!", identifier,
				response.getError().getCode(), exception.getMessage());

		return response;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.OK)
	public GenericResponse<Void> handleNoSuchRequestException(HttpServletRequest req, NoHandlerFoundException ex) {

		GenericResponse<Void> response = new GenericResponse<Void>();

		response.setResult(false);
		response.getError().setCode(String.valueOf(HttpStatus.NOT_FOUND));
		response.getError().setMessage("Page not exit");

		log.error("!!! ERROR: page not exist !!!");

		return response;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public <RS> GenericResponse<RS> handleTimeoutRequestException(HttpServletRequest req, Exception ex) {

		GenericResponse<RS> response = new GenericResponse<RS>();

		response.setResult(false);
		response.getError().setCode(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE));
		response.getError().setMessage("Handler request timeout");

		log.error("!!! ERROR: handler request timeout !!!");

		return response;
	}

}
