package kz.eldos.eSchoolGreetgo.controller;

import kz.eldos.eSchoolGreetgo.mapper.GroupMapper;
import kz.eldos.eSchoolGreetgo.mapper.PupilMapper;
import kz.eldos.eSchoolGreetgo.model.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pupils")
public class PupilController {

    private final PupilMapper pupilMapper;
    private final GroupMapper groupMapper;


    @Autowired
    public PupilController(PupilMapper pupilMapper, GroupMapper groupMapper) {
        this.pupilMapper = pupilMapper;
        this.groupMapper = groupMapper;
    }

    @GetMapping("")
    public Map<String, Object> getAll() {
        // TODO select in one query
        Map<String, Object> map = new HashMap<>();
        for (Pupil pupil: pupilMapper.getAll()) {
            map.put("id", pupil.getId());
            map.put("firstName", pupil.getFirstName());
            map.put("lastName", pupil.getLastName());
            map.put("birthdate", pupil.getBirthdate());
            map.put("groupName", groupMapper.findById(pupil.getGroupId()).getName());
        }
        return map;
    }

}
