package com.hbgc.springbootdemo.controller;

import com.hbgc.springbootdemo.domain.Users;
import com.hbgc.springbootdemo.json.Json;
import com.hbgc.springbootdemo.service.UsersService;
import com.hbgc.springbootdemo.util.token.TokenUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/*验证验证码和token是否正确；验证用户名和密码是否正确*/
//Get 配 @RequestParam  URL传参方式来接收。http://localhost:8888/mooddemo/user/login?username=xxxxx&password=xxx
//Post 配 @RequestBody

@RestController
@RequestMapping("users")
public class UsersController extends BaseController {

    @Resource
    private UsersService usersService;

    //用户登录
    //对接口进行详细描述
    @ApiOperation(value = "用户登录接口", notes = "URL传入用户名和密码执行用户登录")
    //对参数进行详细描述
    @ApiImplicitParam(name = "token", value = "token值", required = true)
    @GetMapping("login") //@RequestParam
    public Map<String, Object> loginByMathCode(String token, String username, String password, String validateCode) {
        System.out.println("接收的token值为token=" + token);
        System.out.println("username：" + username);
        System.out.println("password：" + password);
        System.out.println("validateCode：" + validateCode);

        Users loginUser = null;
        try {
            //1.先检查验证码

            //检查redis缓存中是否有token这个键
            if (!redisTemplate.hasKey(token)) {
                return Json.fail("验证码不正确");
            }
            //根据token键在redsi缓存中获取对应的值
            Integer redis_ValidateCode = (Integer) redisTemplate.opsForValue().get(token);

            //比较redis缓存的值和用户输入的值是否相等
            if (redis_ValidateCode != Integer.valueOf(validateCode)) {
                return Json.fail("验证码不正确");
            }
            System.out.println("验证码验证成功！");

            //2.再检验用户名和密码
            loginUser = usersService.login(username, password);

            //用登录成功的用户生成一个token值并返还给浏览器，用以维护用户登录状态
            String auth_token = TokenUtils.getToken(username);
            loginUser.setToken(auth_token);

            if (loginUser != null) {
                System.out.println("用户登录成功！");
                return Json.success(loginUser, "登录成功!");
            }
            return Json.fail("登录失败!");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("登录失败!");
        }
    }

    //用户手机注册
    @PostMapping("reg")
    public Map<String, Object> reg(String token, @RequestBody Users user) {
        //Users regUser = null;
        try {
            //检查验证码？
            if (!checkValidateCode(token, user.getValidateCode())) {
                return Json.fail("验证码不正确！");
            }
            usersService.save(user);
            return Json.success(null, "注册成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("注册失败！");
        }
    }

    //用户直接注册
    @PostMapping("reg2")
    @ApiOperation(value = "用户直接注册的接口")
    public Map<String, Object> reg2(@RequestBody Users user) {
        //Users regUser = null;
        try {
            if(user!=null){
                usersService.save(user);
                return Json.success(null, "注册成功！");
            }
            return Json.fail("用户不能为空！");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("注册失败！");
        }
    }

    //查询用户资料
    @GetMapping("select")
    @ApiOperation(value = "查询用户资料的接口")
    public Map<String, Object> selectUserData(int uid) {
        Users user = null;

        try {
            user = usersService.getOne(uid);
            if (user != null) {
                return Json.success(user, "查询资料成功");
            }
            return Json.fail("查询资料失败");
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("查询资料失败");
        }
    }

    //用户资料更改
    @PostMapping("update")
    @ApiOperation(value = "更改用户资料的接口")
    public Map<String, Object> updateUserData(@RequestBody Users user) {
        try {
            usersService.update(user);
            return Json.success(null, "用户资料更改成功");

        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("用户资料更改失败");
        }
    }

}
