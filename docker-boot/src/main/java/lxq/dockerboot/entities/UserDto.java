package lxq.dockerboot.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author Yikair
 * @Create 2023/2/24 21:57
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户信息")
public class UserDto {

    @ApiModelProperty(value = "用户id")
    private int id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "性别 0=男 1=女")
    private int sex;
    @ApiModelProperty(value = "删除标志 0=不删除 1=删除")
    private int deleted;
    @ApiModelProperty(value = "创建时间")
    private Timestamp create_time;
    @ApiModelProperty(value = "更新时间")
    private Timestamp update_time;


}
