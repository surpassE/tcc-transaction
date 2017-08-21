package org.mengyun.tcctransaction.sample.dubbo.capital;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartCap {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:config/spring/local/appcontext-service-dao.xml",
				"classpath:config/spring/local/appcontext-service-datasource.xml",
				"classpath:config/spring/local/appcontext-service-provider.xml",
				"classpath:config/spring/local/appcontext-web-servlet.xml",
				"classpath:tcc-transaction-dubbo.xml",
				"classpath:tcc-transaction.xml"
				);
		context.start();
		synchronized (Thread.currentThread()) {
			Thread.currentThread().wait();
		}
		context.close();
	}
}
