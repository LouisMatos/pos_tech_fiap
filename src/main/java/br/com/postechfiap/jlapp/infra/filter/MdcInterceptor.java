package br.com.postechfiap.jlapp.infra.filter;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MdcInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MDC.put("X-ReqId", getXReqId());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex)
			throws Exception {
		MDC.remove("X-ReqId");
	}

	private String getXReqId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}