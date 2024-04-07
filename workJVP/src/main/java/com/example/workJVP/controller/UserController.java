package com.example.workJVP.controller;

import com.example.workJVP.model.*;
import com.example.workJVP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api-table")

public class UserController {
    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public void createTable() throws SQLException {
        userService.createTable();
    }

    @GetMapping("/show-users")
    public List<User> findAllUsers() throws SQLException {
        return userService.findAllUsers();
    }

    @GetMapping("/show-user/{id}")
    public User showUserById(@PathVariable Long id) throws SQLException {
        return userService.showUserById(id);
    }

    @GetMapping("/show-vacations")
    public List<Vacation> findAllVacations() throws SQLException {
        return userService.findAllVacation();
    }

    @GetMapping("/show-vfu")
    public List<UserVacationView> findAllVacationsForUser() throws SQLException {
        return userService.findAllVacationsForUser();
    }

    @GetMapping("/show-vfui/{userId}")
    public List<UserVacationView> findVacationsForUsersBuUserId(@PathVariable Long userId) throws SQLException {
        return userService.findVacationsForUsersBuUserId(userId);
    }

    @GetMapping("/show-in-vacation")
    public List<UserVacationView> findUserInVacationToDay(@RequestParam(value="dateToday", required = false) String dateToDay) throws SQLException {
        return userService.findUserInVacationToDay(dateToDay);
    }

    @PostMapping(path = "/delete-vac")
    public List<UserVacationView> deleteVacationByUserIdAndVacationId(@RequestParam(value = "userId", required = false) Long userId,
                                                                      @RequestParam(value = "vacationId", required = false) Long vacationId) throws SQLException {
        return userService.deleteVacationByUserIdAndVacationId(userId, vacationId);
    }

    @PostMapping(path = "/save-vacation")
    public Result<?> saveVacation(@RequestBody Vacation vacation) throws SQLException {
        Result<Vacation> res = userService.saveVacation(vacation);
        if(res.getErr().getOk()){
            return res;
        }else {
            return new Result<>(null, res.getErr()); //userService.saveVacation(vacation);
        }
    }

    @PostMapping(path = "/save-user")
    public User saveUser(@RequestBody User user) throws SQLException {
        return userService.saveUser(user);
    }


}
