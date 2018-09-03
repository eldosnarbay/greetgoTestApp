package kz.eldos.eSchoolGreetgo.mapper;

import kz.eldos.eSchoolGreetgo.model.Group;
import kz.eldos.eSchoolGreetgo.model.Pupil;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import static org.testng.Assert.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PupilMapperTest extends AbstractTestNGSpringContextTests {
    @Autowired PupilMapper pupilMapper;
    @Autowired GroupMapper groupMapper;

    @Test
    public void testInsert() throws Exception{
        List<Group> list = groupMapper.getAll();
        if (list.size() == 0) {
            System.err.println("invalid test condition");
            return;
        }

        Pupil pupil = new Pupil();
        pupil.setBirthdate(new Date());
        pupil.setFirstName("TestFirstName");
        pupil.setLastName("TestLastName");
        pupil.setGroupId(list.get(0).getId());
        pupilMapper.insert(pupil);

        assertEquals("TestFirstName", pupilMapper.findById(pupil.getId()).getFirstName());
    }
}
