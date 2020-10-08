package com.microservice.vino.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.vino.entity.Produk;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Integer>{

	@Query(
            value = "select us from Produk us where us.productName like :param or us.brand like :param"
    )
    Page<Produk> getPagingAllData(@Param("param")String searchParam, Pageable pageable);
}
