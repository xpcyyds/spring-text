package com.cdcompany.dao;

import com.cdcompany.domain.User;
import org.apache.ibatis.annotations.*;

//TODO 添加@Mapper
@Mapper
public interface UserDao {

    @Select("select count(id) from studentregister where sname=#{username} and spassword=#{password}")
    public boolean selectUser(User user);

    @Insert("insert into studentregister (sname,spassword) values(#{username},#{password})")
    public boolean insertUser(User user);

    @Delete("delete from studentregister where sname=#{username} and spassword=#{password}")
    public boolean deleteUser(User user);

    @Update("update studentregister set spassword=#{password} where sname=#{username}")
    public boolean updateUser(User user);
}
