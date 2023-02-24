package lxq.dockerboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.tools.JavaCompiler;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author Yikair
 * @Create 2023/2/24 21:57
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private int sex;
    private int deleted;
    private Timestamp create_time;
    private Timestamp update_time;


}
