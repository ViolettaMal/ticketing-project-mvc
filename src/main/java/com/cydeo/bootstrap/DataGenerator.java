package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.dto.UserRoleDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.enums.TaskStatus;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserRoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    UserRoleService roleService; // always do injection through interfaces
    UserService userService;
    ProjectService projectService;
    TaskService taskService;

    public DataGenerator(UserRoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        // User Roles
        UserRoleDTO adminRole = new UserRoleDTO(1L, "Admin");
        UserRoleDTO managerRole = new UserRoleDTO(2L, "Manager");
        UserRoleDTO employeeRole = new UserRoleDTO(3L, "Employee");


        // .save()
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        // Users
        UserDTO user1 = new UserDTO("John", "Kesy", "john@cydeo.com",
                "7348592058", "asd122", true, Gender.MALE, managerRole);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com","7459684532" , "Abc2", true, Gender.MALE, adminRole);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "8567412358", "Avc",true, Gender.FEMALE, managerRole);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com","7777775566", "Abc3", true, Gender.MALE, employeeRole);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "3256987412", "Abc4", true ,  Gender.MALE, managerRole);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "5306987412", "Abc4", true ,  Gender.FEMALE, employeeRole);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "9996987412", "Abc4", true ,  Gender.FEMALE, employeeRole);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "8881239846", "Abc4", true, Gender.MALE, employeeRole);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user1, LocalDate.now(),LocalDate.now().plusDays(32),"Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDTO task1 = new TaskDTO(project1, user8, "Controller", "Request Mapping", TaskStatus.IN_PROGRESS, LocalDate.now().minusDays(4));
        TaskDTO task2 = new TaskDTO(project3, user6, "Configuration", "Database Connection", TaskStatus.COMPLETE, LocalDate.now().minusDays(12));
        TaskDTO task3 = new TaskDTO(project3, user6, "Mapping", "One-To-Many", TaskStatus.UAT_TEST, LocalDate.now().minusDays(8));
        TaskDTO task4 = new TaskDTO(project2, user7, "Dependency Injection", "Autowired", TaskStatus.IN_PROGRESS, LocalDate.now().minusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

    }
}
