package br.com.daciosoftware.shop.exceptions.dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidErrorDTO extends ErrorDTO {

	private Map<String, String> fields;
}
