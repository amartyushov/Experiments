package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DynamicInvocationHandler implements InvocationHandler {
	
	protected static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		LOGGER.info("Invoked method: {}", method.getName());
		
		return 42;
	}
}