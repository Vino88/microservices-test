package com.microservice.vino.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.vino.entity.Produk;
import com.microservice.vino.repository.ProdukRepository;
import com.microservice.vino.service.ProdukService;

@Service
public class ProdukServiceImpl implements ProdukService{

	@Autowired
	ProdukRepository produkRepository;

	@Override
    public List<Produk> getAllCustomer(String searchParam) {
        Iterable<Produk> usersIterable= produkRepository.findAll();
        List<Produk> produkList = StreamSupport.stream(usersIterable.spliterator(),false).collect(Collectors.toList());
        return produkList;
    }
	
	@Override
	public void saveInitProduct() {
		Produk prod = new Produk();
		prod.setProductName("Redmi 7a");
		prod.setCategoryName("Mobile Phone");
		prod.setBrand("Xiaomi");
		prod.setProductCode(001);
		prod.setDescription("Specification ....");
		prod.setPrice(1000000);
		prod.setStoreName("Plaza");
		
		produkRepository.save(prod);
    }

	@Override
    public Produk findById(Integer id) {
        Optional<Produk> produkData = produkRepository.findById(id);
        Produk currentData = produkData.get();
        return currentData;
    }

  }
