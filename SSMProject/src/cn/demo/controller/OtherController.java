package cn.demo.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import cn.demo.service.UserService;

/**
 * 	不被拦截的请求
 * @author 黄震
 *
 */

@Controller
public class OtherController {
	private Logger log = Logger.getLogger(OtherController.class);

	@Resource
	private UserService userService;
	

}
