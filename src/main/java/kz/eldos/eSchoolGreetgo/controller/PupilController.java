package kz.eldos.eSchoolGreetgo.controller;

import kz.eldos.eSchoolGreetgo.mapper.GroupMapper;
import kz.eldos.eSchoolGreetgo.mapper.PupilMapper;
import kz.eldos.eSchoolGreetgo.model.Group;
import kz.eldos.eSchoolGreetgo.model.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Pupil pupil: pupilMapper.getAll()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", pupil.getId());
            map.put("firstName", pupil.getFirstName());
            map.put("lastName", pupil.getLastName());
            map.put("birthdate", pupil.getBirthdate());
            Group group = groupMapper.findById(pupil.getGroupId());
            map.put("groupId", group.getId());
            map.put("groupName", group.getName());
            list.add(map);
        }
        return list;
    }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Pupil pupil) {
        if (pupil == null) {
            return ResponseEntity.notFound().build();
        }

        pupilMapper.insert(pupil);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Integer delId = pupilMapper.delete(id);
        if (delId == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
