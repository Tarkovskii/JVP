package com.example.workJVP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createTable() throws SQLException {
        userRepository.createTable();
    }

    public List<User> findAllUsers() throws SQLException {
        return userRepository.findAllUsers();
    }

    public User showUserById(Long id) throws SQLException {
        return userRepository.showUserById(id);
    }

    public User saveUser(User user) throws SQLException {
        return userRepository.saveUser(user);
    }

    public List<Vacation> findAllVacation() throws SQLException {
        return userRepository.findAllVacations();
    }

    public Vacation saveVacation(Vacation vacation) throws SQLException {
        return userRepository.saveVacation(vacation);
    }

    public List<UserVacationView> findAllVacationsForUser() throws SQLException {
        return userRepository.findAllVacationsForUsers();
    }

    public List<UserVacationView> findVacationsForUsersBuUserId(Long userId) throws SQLException {
        return userRepository.findVacationsForUsersBuUserId(userId);
    }

    public List<UserVacationView>deleteVacationByUserIdAndVacationId(Long userId, Long vacationId) throws SQLException {
        return userRepository.deleteVacationByUserIdAndVacationId(userId,vacationId);
    }

    public List<UserVacationView> findUserInVacationToDay(String dateToDay) throws SQLException {
        return userRepository.findUserInVacationToDay(dateToDay);
    }



}
