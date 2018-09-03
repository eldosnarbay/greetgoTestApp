package kz.eldos.eSchoolGreetgo;

import kz.eldos.eSchoolGreetgo.model.Group;
import kz.eldos.eSchoolGreetgo.model.Pupil;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes({Group.class, Pupil.class})
@MapperScan("kz.eldos.eSchoolGreetgo.mapper")
@SpringBootApplication
public class ESchoolGreetgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESchoolGreetgoApplication.class, args);
	}
}
