package co.yiiu.pybbs.interceptor;

import co.yiiu.pybbs.model.User;
import co.yiiu.pybbs.util.HttpUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("_user");
    if (user == null) {
      HttpUtil.responseWrite(request, response);
      return false;
    } else {
      return true;
    }
  }
}
