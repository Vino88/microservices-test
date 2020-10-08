package com.microservice.vino.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdukDto {
	private Integer id;
	private String productName;
	private String description;
	private String categoryName;
	private String storeName;
	private String brand;
	private double price;
	private double priceTotal;
}
