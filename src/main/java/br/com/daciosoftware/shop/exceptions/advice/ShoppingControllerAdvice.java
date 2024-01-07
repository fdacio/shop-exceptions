package br.com.daciosoftware.shop.exceptions.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.daciosoftware.shop.exceptions.InvalidUserKeyException;
import br.com.daciosoftware.shop.exceptions.ProductNotFoundException;
import br.com.daciosoftware.shop.exceptions.ShopNotFoundException;
import br.com.daciosoftware.shop.exceptions.UserNotFoundException;
import br.com.daciosoftware.shop.exceptions.dto.ErrorDTO;

@ControllerAdvice(basePackages = {"br.com.daciosoftware.shop.shopping.controller"})
public class ShoppingControllerAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ShopNotFoundException.class)
	public ErrorDTO handleUserNotFound(ShopNotFoundException shopNotFoundException) {
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("SHOP - Venda não encontrado");
		error.setDate(LocalDateTime.now());
		return error;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("SHOP - Usuário não encontrado");
		error.setDate(LocalDateTime.now());
		return error;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handleProductNotFound(ProductNotFoundException productNotFoundException) {
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("SHOP - Produto não encontrado");
		error.setDate(LocalDateTime.now());
		return error;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidUserKeyException.class)
	public ErrorDTO handleProductNotFound(InvalidUserKeyException invalidUserKeyException) {
		ErrorDTO error = new ErrorDTO();
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setMessage("Token Inválido");
		error.setDate(LocalDateTime.now());
		return error;
	}
	
}
