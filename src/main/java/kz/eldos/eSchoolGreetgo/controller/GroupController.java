package kz.eldos.eSchoolGreetgo.controller;

import kz.eldos.eSchoolGreetgo.mapper.GroupMapper;
import kz.eldos.eSchoolGreetgo.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupMapper groupMapper;

    @Autowiredan
    public GroupController(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @GetMapping("")
    public List<Group> getAll() {
        return groupMapper.getAll();
    }
}
