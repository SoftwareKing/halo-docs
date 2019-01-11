package org.xujin.halo.docs.Controller;

import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser( @RequestBody @ApiParam(name="用户",value="传入json格式",required=true) User user){
		return " 添加成功";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser( @RequestBody @ApiParam(name="用户",value="传入json格式",required=true) User user){
		return " 修改成功";
	}

}
