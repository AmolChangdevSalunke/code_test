package com.code.test.employee.detail.Employee.Exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class Exception extends ResponseEntityExceptionHandler{
	
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	Map<String, Object>map=new LinkedHashMap<>();
	map.put("Current Timestamp", new Date());
	map.put("Status", status.value());
	List<String>exceptionalList=ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
		map.put("Error", exceptionalList);	
	return new ResponseEntity<>(map,status);
}
}
