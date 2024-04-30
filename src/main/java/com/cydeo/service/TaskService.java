package com.cydeo.service;

import com.cydeo.dto.TaskDTO;

public interface TaskService extends CrudService<TaskDTO, Long> {

    void updateStatus(TaskDTO taskDTO);
}
