package kz.eldos.eSchoolGreetgo.mapper;

import kz.eldos.eSchoolGreetgo.model.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("SELECT * FROM groups")
    List<Group> getAll();

    @Select("SELECT * FROM groups WHERE id = #{id}")
    Group findById(Integer id);
}
