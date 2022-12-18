package com.example.backend.controller;

import com.example.backend.dto.GroupDto;
import com.example.backend.service.impl.GroupServiceImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupServiceImpl groupService;

    @GetMapping("/getAll")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping("/save")
    public GroupDto saveGroup(@RequestBody GroupDto groupDto) {
        return groupService.saveGroup(groupDto);
    }

    @PostMapping("/update")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupService.updateGroup(groupDto);
    }

    @PostMapping("/delete")
    public void deleteGroup(@RequestBody Long groupId) {
        groupService.deleteGroupById(groupId);
    }
}
