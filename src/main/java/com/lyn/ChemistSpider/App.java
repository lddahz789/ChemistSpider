package com.lyn.ChemistSpider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lyn.ChemistSpider.service.ChemistPageProcessor;
import com.lyn.ChemistSpider.service.ProductDaoPipeLine;

import us.codecraft.webmagic.Spider;

@Component
public class App {

	private static final String URL1 = "https://www.chemistwarehouse.com.au/buy/66556/Bio-Organics-Glucosamine-750mg-and-Chondroitin-400mg-180-Tablets";
	private static final String URL2 = "https://www.chemistwarehouse.com.au/buy/64405/Wagner-Glucosamine-1000mg-plus-MSM-200-Capsules";
	private static final String URL3 = "https://www.chemistwarehouse.com.au/buy/70735/Blackmores-Pregnancy-Iron-30-Tablets";
	private static final String URL4 = "https://www.chemistwarehouse.com.au/buy/62725/Musashi-P-High-Protein-900g-Chocolate";
	
	
    @Autowired
    private ProductDaoPipeLine productDaoPipeLine;
	
	public void crawl() {
		System.out.println("开始爬取药房数据....");
		System.out.println("Crawler strated....");
		
		Spider.create(new ChemistPageProcessor())
		.addUrl(URL1, URL2, URL3, URL4)
		.addPipeline(productDaoPipeLine)
		.thread(20).run();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
		App app = applicationContext.getBean(App.class);
		app.crawl();
	}

}
