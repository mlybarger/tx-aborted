package com.example.switchyard.switchyard_example;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(One.class)
public class OneBean implements One {
	
	Logger LOG = Logger.getLogger(OneBean.class);

	@Reference
	@Inject
	Two two;
	
	@Override
	public String process(String message) {
		LOG.info("process() - start :" + message);
		String ret = two.submit(message);
		LOG.info("process() - done:" + ret); 
		return ret;
	}

}
