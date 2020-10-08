package com.microservice.vino.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBL_M_PRODUK")
public class Produk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_code")
	private Integer productCode;
	
	@Column(name = "product_name")
	private String productName;
	
	private String brand;
	
	@Column(name = "store_name")
	private String storeName;
	
	@Column(name = "product_price")
	private double price;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "product_description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
}
