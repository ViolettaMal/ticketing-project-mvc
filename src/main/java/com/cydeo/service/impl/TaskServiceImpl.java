package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.TaskStatus;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {

        if (object.getAssignedDate()==null){
            object.setAssignedDate(LocalDate.now());
        }

        if (object.getTaskStatus() == null){
            object.setTaskStatus(TaskStatus.OPEN);
        }

        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO findBy(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO foundTask = findBy(object.getId());
        object.setTaskStatus(foundTask.getTaskStatus());
        object.setAssignedDate(foundTask.getAssignedDate());

        super.update(object.getId(), object);
    }


    @Override
    public void updateStatus(TaskDTO taskDTO) {
        findBy(taskDTO.getId()).setTaskStatus(taskDTO.getTaskStatus());
        update(taskDTO);
    }
}
