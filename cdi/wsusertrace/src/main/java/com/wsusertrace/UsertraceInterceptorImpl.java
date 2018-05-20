package com.wsusertrace;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.wsusertrace.vetoed.CurrentCustomerExecution;
import com.wsusertrace.vetoed.LevelBean;
import com.wsusertrace.vetoed.TraceManager;

@Interceptor
@UsertraceInterceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
public class UsertraceInterceptorImpl implements Serializable {

	@Inject
	TraceManager traceManager;

	@Inject
	CurrentCustomerExecution currentCustomerExecution;

	@Inject
	LevelBean levelBean;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		boolean debugResult = traceManager.traceActive(currentCustomerExecution.getKundnr());
		long time = 0;

		if (debugResult) {
			time = System.currentTimeMillis();
			logBeforeInvocation(ic);
		}
		Object proceed = ic.proceed();
		if (debugResult) {
			long time2 = System.currentTimeMillis();
			logAfterInvocation(ic, time, time2, proceed);

		}
		return proceed;
	}

	private void logBeforeInvocation(InvocationContext ic) throws Exception {
		try {
			String spaces = getSpacesBeforeInvocation();
			String paramStr = paramsToString(ic.getParameters());
			System.out.println(spaces + currentCustomerExecution.getKundnr() + ":C "
					+ getPrettyClassName(ic.getTarget().getClass()) + ":" + ic.getMethod().getName() + ":" + paramStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void logAfterInvocation(InvocationContext ic, long time, long time2, Object o) throws Exception {
		try {
			String spaces = getSpacesAfterInvocaton();
			String rVal = objectToString(o);
			System.out.println(spaces + currentCustomerExecution.getKundnr() + ":R "
					+ getPrettyClassName(ic.getTarget().getClass()) + ":" + ic.getMethod().getName() + ", R " + rVal
					+ " (" + (time2 - time) + " ms)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getSpacesAfterInvocaton() {
		int level = levelBean.getLevel();
		int oldLevel = level;
		level = level - 1;
		if (level < 0) {
			level = -1;
		}
		levelBean.setLevel(level);
		String spaces = "";
		for (int i = 0; i < oldLevel; i++) {
			spaces += "    ";
		}
		return spaces;
	}

	private String getSpacesBeforeInvocation() {
		String spaces = "";
		int level = levelBean.getLevel();
		if (level == -1) {
			level = 0;
		} else {
			level = level + 1;
		}
		levelBean.setLevel(level);
		int myLevel = level;
		for (int i = 0; i < myLevel; i++) {
			spaces += "    ";
		}
		return spaces;
	}

	private static String paramsToString(Object[] parameters) throws Exception {
		String res = "";
		for (Object o : parameters) {
			if (o == null) {
				res += null + ",";
			} else {
				res += objectToString(o);
			}
		}
		return res;
	}

	private static String objectToString(Object o) throws Exception {
		if (o != null) {
			if (o.getClass().getMethod("toString").getDeclaringClass().equals(Object.class)) {
				return toString(o);
			} else {
				return o.toString() + ",";
			}
		}
		return "";
	}

	private static String getPrettyClassName(Class<? extends Object> class1) {
		String name = class1.getSimpleName();
		int i = name.indexOf('$');
		if (i == -1) {
			return name;
		}
		return name.substring(0, i);
	}

	public static String toString(Object object) throws Exception {
		if (object == null) {
			return "null";
		}
		Class<?> clazz = object.getClass();
		StringBuilder sb = new StringBuilder(clazz.getSimpleName()).append(" {");

		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			if (!Modifier.isStatic(f.getModifiers())) {
				try {
					f.setAccessible(true);
					Object obj = f.get(object);
					if (obj == null) {
						sb.append(f.getName()).append(" = ").append("null,");
					} else {
						sb.append(f.getName()).append(" = ").append(obj).append(",");
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		int lastIndexOf = sb.lastIndexOf(",");
		if (lastIndexOf != -1) {
			sb.deleteCharAt(lastIndexOf);
		}
		return sb.append("}").toString();
	}

	private static final long serialVersionUID = 1L;
}
