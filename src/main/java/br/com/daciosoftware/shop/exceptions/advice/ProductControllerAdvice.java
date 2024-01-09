package br.com.daciosoftware.shop.exceptions.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.daciosoftware.shop.exceptions.CategoryNotFoundException;
import br.com.daciosoftware.shop.exceptions.ProductNotFoundException;
import br.com.daciosoftware.shop.exceptions.dto.ErrorDTO;

@ControllerAdvice(basePackages = { "br.com.daciosoftware.shop.product.controller" })
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

}
