package com.pos.system.persistence.repository;

import com.pos.system.persistence.entity.GroupEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface GroupRepository extends ListCrudRepository<GroupEntity, Integer> {
    List<GroupEntity> findAllByOrderByIdGroupAsc();
}
