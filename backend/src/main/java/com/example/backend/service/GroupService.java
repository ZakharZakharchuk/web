package com.example.backend.service;

import com.example.backend.dto.GroupDto;
import com.example.backend.mapper.GroupMapper;
import com.example.backend.repository.GroupRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<GroupDto> getAllGroups() {
        return groupRepository.findAll().stream()
            .map(groupMapper::groupToDto).collect(
                Collectors.toList());
    }

    public GroupDto saveGroup(GroupDto groupDto) {
        return groupMapper.groupToDto(
            groupRepository.save(groupMapper.dtoToGroup(groupDto)));
    }

    public GroupDto updateGroup(GroupDto groupDto) {
        return groupMapper.groupToDto(
            groupRepository.save(groupMapper.dtoToGroup(groupDto)));
    }

    public void deleteGroupById(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
