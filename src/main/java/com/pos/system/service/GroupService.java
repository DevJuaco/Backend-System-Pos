package com.pos.system.service;

import com.pos.system.persistence.entity.GroupEntity;
import com.pos.system.persistence.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupEntity> getAll() {
        return this.groupRepository.findAllByOrderByIdGroupAsc();
    }

    public GroupEntity save (GroupEntity group) {
        return this.groupRepository.save(group);
    }

    public void delete (int idGroup) {
        this.groupRepository.deleteById(idGroup);
    }

    public boolean exists (int idGroup) {
        return this.groupRepository.existsById(idGroup);
    }
}
