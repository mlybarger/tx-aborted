package com.example.switchyard.switchyard_example;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Service;

@Service(Three.class)
public class ThreeBean implements Three {
	
	private static final Logger LOG = Logger.getLogger(ThreeBean.class);
	private static final int SLEEP_SECONDS = 15;

	@Override
	public String process(String message) {
		LOG.info("process() - start :" + message);
		try {
		    Thread.sleep(SLEEP_SECONDS * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		LOG.info("process() - done ");
		return message + " " + this.getClass();
	}

}
