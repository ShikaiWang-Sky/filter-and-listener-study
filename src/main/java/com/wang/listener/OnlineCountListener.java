package com.wang.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.awt.*;

//统计网站在线人数:统计session
public class OnlineCountListener implements HttpSessionListener {

    //创建session监听
    //一旦创建一个session,就会触发一次这个事件!
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //每次来一个session,取出上下文
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        //将上下文中的OnlineCount属性取出!
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        //如果一开始没有人,第一个session来的时候将onlineCount设定为1
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        }else {
            //如果之前有人,来一个session就将onlineCount加1
            int count = onlineCount;
            onlineCount = new Integer(count + 1);
        }

        //将计算得到的onlineCount值放入OnlineCount属性中!
        ctx.setAttribute("OnlineCount", onlineCount);

    }

    //销毁session监听
    //一旦session销毁,就会触发这个事件!
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //每次来一个session,取出上下文
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        //将上下文中的OnlineCount属性取出!
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null) {
            onlineCount = new Integer(0);
        }else {
            //如果之前有人,来一个session就将onlineCount减1
            int count = onlineCount;
            onlineCount = new Integer(count - 1);
        }

        //将计算得到的onlineCount值放入OnlineCount属性中!
        ctx.setAttribute("OnlineCount", onlineCount);
    }

    /*
    session销毁:
    1. 手动销毁     httpSessionEvent.getSession().invalidate();
    2. 自动销毁     在web.xml下配置:设定1分钟后自动销毁
                    <session-config>
                        <session-timeout>1</session-timeout>
                    </session-config>
     */
}
