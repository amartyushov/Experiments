package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimingDynamicInvocationHandler implements InvocationHandler {
	
	protected static final Logger LOGGER = LogManager.getLogger();
	
	private final Map<String, Method> methods = new HashMap<>();
	
	private Object target;
	
	
	public TimingDynamicInvocationHandler(Object target) {
		this.target = target;
		
		for (Method method : target.getClass().getDeclaredMethods()) {
			this.methods.put(method.getName(), method);
		}
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long start = System.nanoTime();
		Object result = methods.get(method.getName()).invoke(target, args);
		long elapsed = System.nanoTime() - start;
		
		LOGGER.info("Executing {} finished in {} ns", method.getName(),
				elapsed);
		
		return result;
	}
}