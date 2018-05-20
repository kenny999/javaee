import java.io.Serializable;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import annotations.NotLoggedIn;

@NotLoggedIn
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
public class NotLoggedInInterceptor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object authorize(InvocationContext ic) throws Exception {
		Method m = ic.getMethod();
		Object[] p = ic.getParameters();
		Object t = ic.getTarget();
		Object ti = ic.getTimer();
		return ic.proceed();
	}

}
