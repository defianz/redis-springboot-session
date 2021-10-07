package me.defian.sessionspringboot.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionInterceptor implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    Long idx = 0L;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String domainName = request.getServerName();
        String uri = request.getRequestURI();
        String contentType = request.getContentType();
        String queryString = request.getQueryString();
        HttpSession session = request.getSession(false);
        if(session != null) {
            logger.info("세션이 존재합니다");
            logger.info("*** session = " + session.getId());
        }


        if (session == null || session.getAttribute("usrSeq") == null || !request.isRequestedSessionIdValid()) {
           // 로그인 정보 확인하여 세션 저장
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(username != null && password != null && username.equals("defian") && password.equals("defian")){
                session = request.getSession(true);
                session.setAttribute("usrSeq",idx++);
                logger.info("세션을 새로 생성합니다");
            } else {
                logger.error("로그인 정보가 올바르지 않습니다");
                response.sendRedirect("/");
                return false;
            }
        }
 

        logger.info("============ Request Domain       \t:  " + domainName);
        logger.info("============ Request URI          \t:  " + uri);
        logger.info("============ Request Content-Type \t:  " + contentType);
        logger.info("============ Request queryString \t:  " + queryString);
        if(session != null) logger.info("============ session \t: "+  session.getId());

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
