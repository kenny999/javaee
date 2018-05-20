package interceptors;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpSession;

@UserDebugLog
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
public class UserDebugLogImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String debugUserName;

	@Inject
	private LevelBean levelBean;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		DebugResult debugResult = checkIfDebug();
		long time = 0;
		String spaces = "";
		int myLevel = 0;

		if (debugResult.debug) {
			int level = levelBean.getLevel();
			if (level == -1) {
				level = 0;
			} else {
				level = level + 1;
			}
			levelBean.setLevel(level);
			myLevel = level;
			for (int i = 0; i < myLevel; i++) {
				spaces += "    ";
			}
		}
		if (debugResult.debug) {
			time = System.currentTimeMillis();
			Object[] params = ic.getParameters();
			String paramStr = "";
			for (Object o : params) {
				if (o == null) {
					paramStr += null + ",";
				} else {
					paramStr += o.toString() + ",";
				}
			}
			System.out.println(spaces + debugResult.userName + ":C " + ic.getTarget().getClass().getSimpleName() + ":"
					+ ic.getMethod().getName() + ":" + paramStr);
		}
		Object proceed = ic.proceed();
		if (debugResult.debug) {
			long time2 = System.currentTimeMillis();
			int level = levelBean.getLevel();
			level = level - 1;
			if (level < 0) {
				level = -1;
			}
			levelBean.setLevel(level);
			spaces = "";
			for (int i = 0; i < myLevel; i++) {
				spaces += "    ";
			}
			String rVal = proceed == null ? "" : proceed.toString();
			System.out.println(spaces + debugResult.userName + ":R " + ic.getTarget().getClass().getSimpleName() + ":"
					+ ic.getMethod().getName() + ", R " + rVal + " (" + (time2 - time) + " ms)");

		}
		return proceed;
	}

	private DebugResult checkIfDebug() {
		DebugResult debugResult = new DebugResult();
		if (debugUserName != null) {
			FacesContext currentInstance = FacesContext.getCurrentInstance();
			if (currentInstance != null) {
				ExternalContext externalContext = currentInstance.getExternalContext();
				if (externalContext != null) {
					HttpSession session = (HttpSession) externalContext.getSession(false);
					if (session != null) {
						String userName = (String) session.getAttribute("USER_NAME");
						if (userName != null) {
							if (userName.equals(debugUserName)) {
								debugResult.debug = true;
								debugResult.userName = debugUserName;
							}
						}
					}
				}
			}
		}
		return debugResult;
	}

	private static class DebugResult {
		boolean debug;
		String userName;
	}
}
