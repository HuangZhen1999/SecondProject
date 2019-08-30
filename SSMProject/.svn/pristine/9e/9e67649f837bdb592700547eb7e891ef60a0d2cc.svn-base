package cn.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.lang.model.type.ErrorType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.demo.dao.UserMapper;
import cn.demo.entity.Role;
import cn.demo.entity.User;
import cn.demo.service.RoleService;
import cn.demo.service.UserService;

/**
 * User控制器
 * 
 * @author 黄震
 *
 */

@Controller
@RequestMapping("/sys/user")
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@Resource
	private RoleService roleService;

	/**
	 * 查询用户列表,参数可有可无
	 * 
	 * @param model
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(Model model,
			@RequestParam(value = "userName", required = false, defaultValue = "") String userName) {
		log.info("进入userList,userName=" + userName);
		// int i=1/0;
		User user = new User();
		user.setUserName(userName);
		List<User> userlist = userService.getUserList(user);
		model.addAttribute("userList", userlist);
		log.info("userList执行结束, userList=" + userlist);
		return "user/userList";
	}

	/**
	 * 跳转到添加用户界面
	 * 
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/userAdd", method = RequestMethod.GET)*/
	@RequestMapping(value = "/userAdd")
	public String userAdd(Model model, @ModelAttribute("user") User user) {
		List<Role> rolelist = roleService.getRoleList();
		System.out.println(rolelist);
		model.addAttribute("roleList", rolelist);
		return "user/userAdd";
	}

	/**
	 * 保存添加的用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userAddSave", method = RequestMethod.POST)
	public String userAddSave(User user, HttpServletRequest request, HttpSession session,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		log.info("保存添加的用户user" + user);

		String errorInfo = "";// 存储错误信息
		String errotType = ""; //哪个文件出错
		boolean isResult = true; // 是否返回添加页码,false返回
		String fileName = ""; // 生成新的文件名称
		String idPicPath = "";
		String workPicPath= "";
		// 保存路径
		String savePath = session.getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
		File saveFile = new File(savePath);
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}
		
		log.info("savePath:" + savePath);
		
		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];
			if (i == 0) {
				errotType = "idError";
			}else {
				errotType = "workError";
			}
			// 判断是否上传了文件
			if (!attach.isEmpty()) {
				// 获取文件名称
				String oldName = attach.getOriginalFilename();
				// 获取文件后缀
				String oldSuffix = FilenameUtils.getExtension(oldName);
				// 设置文件大小
				int fileSize = 500000;
				if (attach.getSize() > fileSize) {
					errorInfo = "文件不得超过500KB";
					isResult = false;
				} else if (oldSuffix.equalsIgnoreCase("jpg") 
						|| oldSuffix.equalsIgnoreCase("png")
						|| oldSuffix.equalsIgnoreCase("gif")) {
					// 生成新的文件名
					fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_person.jsp";
					File targetFile = new File(savePath, fileName);

					// 将MultipartFile 对象中的流输出到目标文件
					try {
						attach.transferTo(targetFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
						errorInfo = "文件添加";
			 			isResult = false;
					}
					if (i == 0) {
						idPicPath = fileName;
					}else {
						workPicPath = fileName;
					}
				} else {
					errorInfo = "文件格式必须位jsp、png、gif";
					isResult = false;
				}
			}
		}
		
		if (isResult) {
			/*((User)session.getAttribute("user")).getId();*/
			user.setCreatedBy(1);
			user.setCreationDate(new Date());
			user.setIdPicPath(idPicPath);
			user.setWokPicPath(workPicPath);
			Integer result = userService.userAdd(user);
			if (result == 1) {
				return "redirect:/sys/user/userList";
			}
		}
		request.setAttribute(errotType, errorInfo);
		return "forward:/sys/user/userAdd";
	}

	/**
	 * 保存添加的用户
	 * 
	 * @param user
	 * @return
	 */
/*	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public String userAdd2(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/userAdd2";
		}
		log.info("保存添加的用户user" + user);
		user.setCreatedBy(1);
		user.setCreationDate(new Date());
		Integer result = userService.userAdd(user);
		if (result == 1) {
			return "redirect:/sys/user/userList";
		} else {
			return "user/userAdd2";
		}
	}*/

	/**
	 * 跳转到修改页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
	public String userUpdate(@PathVariable Integer id, Model model) {
		log.info("进入userUpdate,id=" + id);
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		List<Role> roles = roleService.getRoleList();
		model.addAttribute("roles", roles);
		return "user/userUpdate";
	}

	/**
	 * 保存修改的用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userUpdateSave", method = RequestMethod.POST)
	@ResponseBody
	public String userUpdateSave(User user) {
		log.info("进入userUpdateSave,user=" + user);
		user.setModifyBy(1);
		user.setModifyDate(new Date());
		Integer result = userService.userUpdate(user);
		return JSON.toJSONString(result);
	}
	
	
	/**
	 * 异步查询用户信息
	 * @param id
	 * @return
	 */
	/*@RequestMapping(value="/showDetail",produces={"application/json;charset=utf-8"})*/
	@RequestMapping(value="/showDetail")
	@ResponseBody
	public User showDetail(Integer id) {
		log.info("showDetail,id="+id);
		User user = userService.getUserById(id);
		log.info("showDetail,user:"+user);
		return user;
	}

	
	/**
	 * 局部异常处理
	 * 
	 * @param exception
	 * @param request
	 * @return
	 */
	/*
	 * @ExceptionHandler(value= {RuntimeException.class}) public String
	 * handelerException(RuntimeException exception,HttpServletRequest request) {
	 * request.setAttribute("exception", exception); return "error"; }
	 */

}
