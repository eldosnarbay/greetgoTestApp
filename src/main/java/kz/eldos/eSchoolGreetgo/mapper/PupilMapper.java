package kz.eldos.eSchoolGreetgo.mapper;

import kz.eldos.eSchoolGreetgo.model.Pupil;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PupilMapper {
    @Select("SELECT * FROM pupils")
    @Results({
            @Result(property = "firstName", column = "fname"),
            @Result(property = "lastName", column = "lname"),
            @Result(property = "groupId", column = "group_id")
    })
    List<Pupil> getAll();

    @Select("SELECT * FROM pupils WHERE id = #{id}")
    @Results({
            @Result(property = "firstName", column = "fname"),
            @Result(property = "lastName", column = "lname"),
            @Result(property = "groupId", column = "group_id")
    })
    Pupil findById(Integer id);

    @Insert("INSERT INTO pupils(fname, lname, birthdate, group_id) VALUES(#{firstName}, #{lastName}, #{birthdate}, #{groupId})")
    void insert(Pupil pupil);

    @Update("UPDATE pupils SET fname = #{firstName}, lname = #{lastName}, birthdate = #{birthdate}, " +
            "group_id = #{groupId} WHERE id = #{id}")
    void update(Pupil pupil);

    @Delete("DELETE FROM pupils WHEREid = #{id}")
    Integer delete();
}
