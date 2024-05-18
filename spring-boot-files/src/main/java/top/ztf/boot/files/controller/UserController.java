package top.ztf.boot.files.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.ztf.boot.files.common.RestResponse;
import top.ztf.boot.files.entity.dto.User;
import top.ztf.boot.files.entity.dto.LoginInfo;
import top.ztf.boot.files.enums.ErrorCode;
import top.ztf.boot.files.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public RestResponse<User> add(@RequestBody User user) {
        boolean res = userService.addUser(user);
        if (!res) {
            return RestResponse.error(ErrorCode.INTERNAL_SERVICE_ERROR);
        }
        return RestResponse.ok(user);
    }

    @PostMapping("/login")
    public RestResponse<LoginInfo> login(@RequestParam String username, @RequestParam String password) {
        User user = User.builder().username(username).password(password).build();
        boolean res = userService.login(user);
        if (!res) {
            return RestResponse.error(ErrorCode.UNAUTHORIZED.getCode(), "登录失败");
        }
        // TODO: Redis 认证
        String token = "";
        return RestResponse.ok(LoginInfo.builder().username(username).token(token).build());
    }

    @GetMapping("/info")
    public RestResponse<User> info(@RequestParam String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return RestResponse.error(ErrorCode.NOT_FOUND);
        }
        return RestResponse.ok(user);
    }

    @PostMapping("/update")
    public RestResponse<User> update(@RequestBody User user) {
        boolean res = userService.updateUser(user);
        if (!res) {
            return RestResponse.error(ErrorCode.INTERNAL_SERVICE_ERROR);
        }
        return RestResponse.ok(user);
    }

    @PostMapping("/avatar")
    public RestResponse<User> avatar(@RequestParam String username, @RequestParam("file") MultipartFile file) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return RestResponse.error(ErrorCode.NOT_FOUND);
        }
        boolean res = userService.updateUserAvatarByUsername(user, file);
        if (!res) {
            return RestResponse.error(ErrorCode.INTERNAL_SERVICE_ERROR);
        }
        return RestResponse.ok(user);
    }

    @PostMapping("/uploadAvatar")
    public RestResponse<User> uploadAvatar(@RequestParam String username, @RequestParam("file") MultipartFile file) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return RestResponse.error(ErrorCode.NOT_FOUND);
        }
        boolean res = userService.uploadAvatar(user, file);
        if (!res) {
            return RestResponse.error(ErrorCode.INTERNAL_SERVICE_ERROR);
        }
        return RestResponse.ok(user);
    }


}
