package com.microservice.vino.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.vino.entity.Produk;
import com.microservice.vino.repository.ProdukRepository;
import com.microservice.vino.service.ProdukService;

@RestController
public class ProdukApiController {

	@Autowired
	ProdukRepository produkRepository;
	@Autowired
	ProdukService produkService;
	
	@GetMapping(value = "/product")
	public List<Produk> allCustomer(){
		List<Produk> listing = new ArrayList<Produk>();
		List<Produk> listProd = produkRepository.findAll();
		for(Produk prod : listProd) {
			listing.add(prod);
		}
		return listing;
	}	
}
