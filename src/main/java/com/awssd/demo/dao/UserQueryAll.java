package com.awssd.demo.dao;
import com.awssd.demo.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
public interface UserQueryAll {
    @Select("SELECT * FROM user WHERE username = #{username}")
    @ResultType(User.class)
    List<User> selectUser(String username);

    @Delete("DELETE FROM USER WHERE username = #{username}")

    int deleteUser(String username);
}
