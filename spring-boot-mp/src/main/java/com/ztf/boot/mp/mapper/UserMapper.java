package com.ztf.boot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztf.boot.mp.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
