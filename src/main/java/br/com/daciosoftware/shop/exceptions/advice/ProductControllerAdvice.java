package br.com.daciosoftware.shop.exceptions.advice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.daciosoftware.shop.exceptions.CategoryNotFoundException;
import br.com.daciosoftware.shop.exceptions.ProductNotFoundException;
import br.com.daciosoftware.shop.exceptions.dto.ErrorDTO;

@ControllerAdvice(basePackages = {"br.com.daciosoftware.shop.product.controller"})
public class ProductControllerAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handleProductNotFound(ProductNotFoundException productNotFoundException) {
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("Produto não encontrado");
		error.setDate(LocalDateTime.now());
		return error;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CategoryNotFoundException.class)
	public ErrorDTO handleCategoryNotFount(CategoryNotFoundException categoryNotFoundException) {
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("Categoria não encontrada");
		error.setDate(LocalDateTime.now());
		return error;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDTO handleValidationError(MethodArgumentNotValidException ex) {
		
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldsErrors = result.getFieldErrors();
		StringBuilder sb = new StringBuilder("Error de Validação: ");
		for (FieldError fieldError: fieldsErrors) {
			sb.append(fieldError.getDefaultMessage()+" ");
		}
		error.setMessage(sb.toString());
		error.setDate(LocalDateTime.now());
		return error;
	}
	
}
