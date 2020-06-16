package dynamic_proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyTest {
	
	public static void main(String[] args) {
		// we proxied a map
		Map proxyInstance = (Map) Proxy.newProxyInstance(
				DynamicProxyTest.class.getClassLoader(),
				new Class[] { Map.class },
				new DynamicInvocationHandler());
		
		/*
		* Proxy.newProxyInstance(
		* 	classloader,
		* 	what class to proxy,
		* 	what to do during proxy
		* )
		*
		* */
		proxyInstance.put("hello", "world");
		
		
		
		
		Map mapProxyInstance = (Map) Proxy.newProxyInstance(
				DynamicProxyTest.class.getClassLoader(), new Class[] { Map.class },
				new TimingDynamicInvocationHandler(new HashMap<>()));
		
		mapProxyInstance.put("hello", "world");
		
		CharSequence csProxyInstance = (CharSequence) Proxy.newProxyInstance(
				DynamicProxyTest.class.getClassLoader(),
				new Class[] { CharSequence.class },
				new TimingDynamicInvocationHandler("Hello World"));
		
		csProxyInstance.length();
	}
}
