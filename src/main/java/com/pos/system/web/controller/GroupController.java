package com.pos.system.web.controller;

import com.pos.system.persistence.entity.GroupEntity;
import com.pos.system.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<GroupEntity>> getAll () {
        return ResponseEntity.ok(this.groupService.getAll());
    }

    @PostMapping
    public ResponseEntity<GroupEntity> create (@RequestBody GroupEntity group) {
        if (group.getIdGroup() == null || !this.groupService.exists(group.getIdGroup())) {
            return ResponseEntity.ok(this.groupService.save(group));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idGroup}")
    public ResponseEntity<Void> delete (@PathVariable int idGroup) {
        if(this.groupService.exists(idGroup)) {
            this.groupService.delete(idGroup);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<GroupEntity> update (@RequestBody GroupEntity group) {
        if(group.getIdGroup() != null && this.groupService.exists(group.getIdGroup())) {
            return ResponseEntity.ok(this.groupService.save(group));
        }

        return ResponseEntity.badRequest().build();
    }

}
