package top.ztf.boot.files.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ztf.boot.files.entity.dto.User;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
