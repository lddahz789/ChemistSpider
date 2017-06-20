package com.lyn.ChemistSpider.dao;

import org.apache.ibatis.annotations.Insert;

import com.lyn.ChemistSpider.bean.Product;

public interface ProductMapper {

	 @Insert("insert into product (productName,productPrice,retailPrice) values (#{productName},#{productPrice},#{retailPrice}) on duplicate key update productPrice=#{productPrice}")
    public int add(Product product);  
}
