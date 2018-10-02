package io.mart.restasync;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

@Service
public class CheckProcessorImpl implements CheckProcessor {
	
	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		//logic
		new Thread() {
			public void run() {
				if (checksList == null || checksList.getChecks() == null || checksList.getChecks().size()==0) {
					response.resume(new BadRequestException());
				}
				response.resume(true);	// actually it is a return value -> Boolean. Despite processChecks is declared a void
			}
		}.start();
	}
}
