package com.ztf.boot.fi.service;

import com.ztf.boot.fi.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UserService {

    String updateUserAvatar(File file);
}
