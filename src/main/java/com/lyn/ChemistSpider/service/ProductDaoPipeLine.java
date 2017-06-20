package com.lyn.ChemistSpider.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.lyn.ChemistSpider.bean.Product;
import com.lyn.ChemistSpider.dao.ProductMapper;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;


@Component("productDaoPipeLine")
public class ProductDaoPipeLine implements Pipeline{
	
	@Resource
	private ProductMapper productMapper;

	public void process(ResultItems resultItems, Task task) {
		
		Product product = resultItems.get("product");
		productMapper.add(product);		
	}


}
