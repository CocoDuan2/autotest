package com.xingxing.user.filter;

import com.google.common.base.Strings;
import com.xingxing.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "UserFilter")
@Component("UserFilter")
@Order(1)
public class UserFilter extends OncePerRequestFilter implements Filter {
    @Autowired
    private UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        dumpRequest(httpServletRequest);
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private void dumpRequest(HttpServletRequest req) {
        try {
            String ipAddr = getIpAddr(req);
            String uri = req.getRequestURI();
            String projectId = req.getHeader("projectId");
            if (Strings.isNullOrEmpty(projectId)) {
                projectId = req.getParameter("projectId");
            }
            String companyId = req.getHeader("companyId");
            if (Strings.isNullOrEmpty(companyId)) {
                companyId = req.getParameter("companyId");
            }
            String userId = req.getHeader("userId");
            if (Strings.isNullOrEmpty(userId)) {
                userId = req.getParameter("userId");
            }
            String method = req.getMethod();


        } catch (Exception e) {
            log.error("********dumpRequest(request) error********", e);
        }
    }

    /**
     * 查询Service
     *
     * @param req
     */
    private void selectService(HttpServletRequest req) {
        ServletContext sc = req.getSession().getServletContext();
        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);
        if (cxt != null && cxt.getBean("userService") != null && userService == null) {
            userService = (UserService) cxt.getBean("userService");
        }
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");

        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
