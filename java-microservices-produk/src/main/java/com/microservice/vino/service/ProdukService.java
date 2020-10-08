package com.microservice.vino.service;

import java.util.List;

import com.microservice.vino.entity.Produk;

public interface ProdukService {

	List<Produk> getAllCustomer(String searchParam);

    /* Example function save(create/update) */
    void saveInitProduct();
    /* Example pencarian berdasarkan Id */
    Produk findById(Integer id);
}
