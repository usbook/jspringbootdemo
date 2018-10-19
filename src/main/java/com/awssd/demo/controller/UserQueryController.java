package com.awssd.demo.controller;

import com.awssd.demo.dao.UserQueryAll;

import com.awssd.demo.domain.User;
import com.awssd.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@EnableAutoConfiguration

public class UserQueryController {

  @Autowired
  UserService userService;
  @Autowired
  UserQueryAll mapper;


    @Autowired
    private int restTemplate;

    /**
     * @RestController代表这个类是用Restful风格来访问的，如果是普通的WEB页面访问跳转时，我们通常会使用@Controller
    value = "/users/{username}" 代表访问的URL是"http://host:PORT/users/实际的用户名"
    method = RequestMethod.GET 代表这个HTTP请求必须是以GET方式访问
    consumes="application/json" 代表数据传输格式是json
     @PathVariable将某个动态参数放到URL请求路径中
     @RequestParam指定了请求参数名称
     */
    @RequestMapping("/Index1")
    public Object tick(HttpServletRequest request)
    { HttpSession session = request.getSession();
        if (session.getAttribute("luji") == null) {
            session.setAttribute("luji", "zhangsan");
        }
        String dates=session.getId();

       int data= request.getSession().getMaxInactiveInterval();
        Object dat=session.getAttribute("luji");
        System.out.printf("controller");
        return dat;
    }
    @RequestMapping("/Index/1")
    public int ticks(HttpServletRequest request,HttpServletResponse response)
    {
        int i=restTemplate;
        HttpSession session = request.getSession();
        if (session.getAttribute("luji") == null) {
            session.setAttribute("luji", "zhangsan");
        }
        response.setHeader("lihua","133465");
        return i;

    }

    @RequestMapping("/Index2")
    public int tickss(HttpServletRequest request)
    {

        return 12;

    }
    @RequestMapping("queryU/{username}")
    public List<User> queryProduct(@PathVariable String username, HttpServletResponse httpServletResponse) {
        System.out.println(username);
        List<User> ulist = userService.queryUserByUserName(username);
        return ulist;
    }
    @RequestMapping("deleteU/{username}")
    public int deleteProduct(@PathVariable String username, HttpServletResponse httpServletResponse) {
        System.out.println(username);
        int i= mapper.deleteUser(username);
        return i;
    }


}
