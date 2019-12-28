package br.com.contmatic.utilidades;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ProxyClassTeste {
	
	public static void main(String[] args) {
		Map proxyInstance = (Map) Proxy.newProxyInstance(null, new Class[] {Map.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName());
				return null;
			}
		});
		proxyInstance.put("ff", "aa");
		proxyInstance.entrySet();
		//proxyInstance.isEmpty();
		//proxyInstance.putAll(proxyInstance);
	}

}
