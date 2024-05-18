package top.ztf.boot.files.service;

import org.springframework.web.multipart.MultipartFile;
import top.ztf.boot.files.entity.dto.User;

import java.io.Serializable;


public interface UserService {
    boolean addUser(User user);
    boolean login(User user);
    User getUserById(Serializable id);
    User getUserByUsername(String username);
    boolean updateUser(User user);
    boolean deleteUserById(Serializable id);
    boolean updateUserAvatarByUsername(User user, MultipartFile file);
    boolean uploadAvatar(User user, MultipartFile file);
}
