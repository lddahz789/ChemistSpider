package com.lyn.ChemistSpider.service;

import org.apache.commons.lang.StringUtils;

import com.lyn.ChemistSpider.bean.Product;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class ChemistPageProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

	public void process(Page page) {

		String productName = page.getHtml()
				.xpath("//*[@id=Left-Content]/div[@class=productDetail]/div/table/tbody/tr/td/div[@class=product-name]/h1/text()")
				.toString();
		String productPrice = StringUtils.substringAfterLast(page.getHtml()
				.xpath("//*[@id=Left-Content]/div[@class=productDetail]/div/table/tbody/tr/td/div[@class=Price]/text()")
				.toString(), "$");
		String retailPrice = StringUtils.substringAfterLast(page.getHtml()
				.xpath("//*[@id=Left-Content]/div[@class=productDetail]/div/table/tbody/tr/td/div[@class=retailPrice]/text()")
				.toString(), "$");
		String productId = StringUtils.substringAfter(page.getHtml()
				.xpath("//*[@id=Left-Content]/div[@class=productDetail]/div/table/tbody/tr/td/div[@class=product-id]/text()")
				.toString(), "Product ID: ");
		
		String brand = page.getHtml()
				.xpath("//*[@id=Left-Content]/div[@class=breadcrumbs]/a/text()").all().get(3);
		
		Product product = new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setRetailPrice(retailPrice);
		product.setBrand(brand);
		product.setProductId(productId);
		page.putField("product", product);
		
		if (productName == null) {
			page.setSkip(true);
		}

		// 部分三：从页面发现后续的url地址来抓取
		 page.addTargetRequests(page.getHtml().links().regex("(https://www\\.chemistwarehouse\\.com\\.au/buy/[\\w\\-]+/[\\w\\-]+)").all());
	}

	public Site getSite() {
		return site;
	}

	
}
