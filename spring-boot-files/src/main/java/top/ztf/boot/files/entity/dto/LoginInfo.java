package top.ztf.boot.files.entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;


@Data
@Builder
@Setter
public class LoginInfo {
    private String username;
    private String token;
}
