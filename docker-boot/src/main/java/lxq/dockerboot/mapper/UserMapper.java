package lxq.dockerboot.mapper;

import lxq.dockerboot.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author Yikair
 * @Create 2023/2/24 21:56
 * @Description
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(String id);

    @Insert("insert into user(`username`, `password`, `sex`, `deleted`, `create_time`, `update_time`) " +
            "values ( #{username}, #{password}, #{sex}, #{deleted}, #{create_time}, #{update_time} ) "
    )
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int Insert(User user);

}
