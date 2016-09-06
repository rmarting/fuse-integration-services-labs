package com.redhat.fis.processor;

import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("myProcessor")
public class MyProcessor implements Processor {
	
	private Logger logger = LoggerFactory.getLogger(MyProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("Executing my processor for exchange id {}", exchange.getExchangeId());
		
		Message message = exchange.getIn();
		String body = message.getBody(String.class);
		if (null == body || "".equals(body)) {
			body = "Text from my processor";
		}
		message.setBody(body);
		exchange.setOut(message);
		
		logger.info("Processor executed");
	}

}
