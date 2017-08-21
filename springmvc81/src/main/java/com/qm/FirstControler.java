package com.qm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstControler {
	// 此方法用于处理请求，添加RequestMapping注解
	// 请求映射，请求的路径和请求执行java代码方法之间
	// 路径最好与方法名一样

	// 有的时候我们处理请求的方法会添加限制，只接post请求
	// 方案1 通过@RequestMapping 中 的method来指定支持的请求类型
	// 如果不指定method那么就不限制请求方式
	@RequestMapping(path = "/login.do", method=RequestMethod.POST)

	public String first() {
		// 调用servie层代码
		System.out.println("first");
		// 最终需要跳转，默认转发到first.jsp
		// 要求通过重定向
		return "redirect:my.html";
	}

	// 通过httpservletrequest对象获取到前端页面中传递的数据
	@RequestMapping(path = "/login1.do")
	public String login1(HttpServletRequest req) {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		System.out.println(name);

		return "first";

	}

	//@RequestParam注解表示跟随在他后面的参数，对应着表单中的数据
	//value属性，表单中参数的键，springmvc会根据value当做键刦表单数据，并复制紧跟着注解的参数
	//required默认为true，表示请求参数中必须包含当前指定的参数
	//defaultValue如果传递参数没有对应的参数，则使用默认值
	@RequestMapping(path="/login2.do")
	public String login2(@RequestParam(value="username",required=true,defaultValue="默认")String name,
							@RequestParam(value="password")String pass,
							@RequestParam(value="age",required=false,defaultValue="20")int age){
		
		System.out.println(name);
		return "first";
		
	}
	//在入参数，按照前端表单参数的名字命名参数名
	@RequestMapping(path="/login3.do")
	public String login3(String username,String password){
		
		System.out.println("name"+username);
		return "first";
	}
	
	@RequestMapping(path="/login4.do")
	public String login4(User user){
		System.out.println(user);
	return "first";	
	}

@RequestMapping(path="/login5.do")

public String login5(HttpSession session,HttpServletRequest req){

	return "first";
}
}
