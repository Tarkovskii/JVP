package com.example.workJVP.view;

import com.example.workJVP.model.*;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private Connection connection;


    public UserRepository() {
        System.out.println("constructor start");
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("constructor end");
    }


    public void createTable() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            try (Statement st = this.connection.createStatement()) {
                st.execute("""
                        create table if not exists employees(
                        id bigint primary key,
                        name_user varchar(255),
                        date_registration date default current_date);
                                            
                        create table if not exists vacations(
                        id bigserial primary key,
                        user_id bigint not null,
                        date_start date,
                        date_end date,
                        foreign key (user_id) references employees (id))""");

            }
            System.out.println("создал базу -employees- and -vacations-");
        } else {
            System.out.println("Ошибка соединения");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root");
            System.out.println("Вот тебе новое");
            createTable();
        }

    }

    public User saveUser(User user) throws SQLException {
        if (user.checkOnValidationUser(user)) {

            try (PreparedStatement ps = connection.prepareStatement("insert into employees (id,name_user) values (?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setLong(1,user.getId());
                ps.setString(2, user.getName());
                ps.execute();
                System.out.println("Добавил данные");
                ResultSet resultSet = ps.getGeneratedKeys();
                return userSetForUser(resultSet);
            }
        }

        return null;
    }


    public List<User> findAllUsers() throws SQLException {
        List<User> listAllUsers = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet allUsers = statement.executeQuery("select id, name_user, date_registration from employees");
            while (allUsers.next()) {
                User user = userSetForUserList(allUsers);
                listAllUsers.add(user);
            }
        }

        return listAllUsers;
    }

    public User showUserById(Long id) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement("select * from employees where id=(?)")) {
            ps.setLong(1, id);
            ps.execute();
            ResultSet foundUser = ps.getResultSet();
            if (foundUser != null) {
                return userSetForUser(foundUser);
            }
        }

        return null;
    }

    public Result<Vacation> saveVacation(Vacation vacation) throws SQLException {

        if (checkValidConnection(connection)) {

            Erorr erorr = vacation.checkValidVacation(vacation);
            if (erorr.getOk()) {
                try (PreparedStatement ps = connection.prepareStatement("insert into vacations (user_id, date_start, date_end) values (?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                )) {
                    ps.setLong(1, vacation.getUserId());
                    ps.setDate(2, vacation.getStartVacation());
                    ps.setDate(3, vacation.getEndVacation());
                    ps.execute();
                    ResultSet resultSet = ps.getGeneratedKeys();
                    return new Result<>(vacationSetForVacation(resultSet), erorr);

                }
            } else {
                return new Result<>(null, new Erorr(false, "Date invalid"));
            }

        }else {
            return new Result<>(null,new Erorr(false,"Error in connection"));
        }
    }

    public List<Vacation> findAllVacations() throws SQLException {
        List<Vacation> vacationList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("select * from vacations");
            while (resultSet.next()) {
                Vacation vacation = vacationSetForVacationList(resultSet);
                vacationList.add(vacation);
            }
        }
        return vacationList;
    }

    public List<UserVacationView> findAllVacationsForUsers() throws SQLException {
        List<UserVacationView> res = new ArrayList<>();

        try (Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("""
                    select emp.name_user, vac.id, vac.date_start, vac.date_end
                    from employees emp
                    join vacations vac on emp.id=vac.user_id;""");

            while (resultSet.next()) {
                UserVacationView vacationView = userVacationViewSet(resultSet);
                res.add(vacationView);
            }
        }
        return res;
    }

    //I have idea, write value for some peoples can change criteria search by column in table
    public List<UserVacationView> findVacationsForUsersBuUserId(Long userId) throws SQLException {
        List<UserVacationView> res = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement("""
                select emp.name_user, vac.id, vac.date_start, vac.date_end
                from employees emp
                join vacations vac on emp.id=vac.user_id and emp.id=(?);""")) {
            ps.setLong(1, userId);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();

            while (resultSet.next()) {
                UserVacationView vacationView = userVacationViewSet(resultSet);
                res.add(vacationView);
            }
        }
        return res;
    }

    public List<UserVacationView> deleteVacationByUserIdAndVacationId(Long userId, Long vacationId) throws
            SQLException {

        try (PreparedStatement ps = connection.prepareStatement("""
                delete from vacations where user_id=(?) and id=(?);""")) {
            ps.setLong(1, userId);
            ps.setLong(2, vacationId);
            ps.execute();
        }
        return findVacationsForUsersBuUserId(userId);
    }

    public List<UserVacationView> findUserInVacationToDay(String dateToDay) throws SQLException {
        List<UserVacationView> res = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("""
                 select emp.name_user, vac.id, vac.date_start, vac.date_end
                from employees emp
                join vacations vac on emp.id=vac.user_id and vac.date_start<=(?)::date and (?)::date<=vac.date_end;""")) {
            ps.setString(1, dateToDay);
            ps.setString(2, dateToDay);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();

            while (resultSet.next()) {
                UserVacationView vacationView = userVacationViewSet(resultSet);
                res.add(vacationView);
            }
        }
        return res;
    }


    private UserVacationView userVacationViewSet(ResultSet resultSet) throws SQLException {
        UserVacationView res = new UserVacationView();

        res.setNameUser(resultSet.getString("name_user"));
        res.setVacationId(resultSet.getLong("id"));
        res.setVacationStart(resultSet.getDate("date_start"));
        res.setVacationEnd(resultSet.getDate("date_end"));

        return res;

    }

    private Vacation vacationSetForVacation(ResultSet generatedKeys) throws SQLException {
        //Vacation vacation = new Vacation();
        //while (generatedKeys.next()) {
        //    vacation.setId(generatedKeys.getLong("id"));
        //    vacation.setUserId(generatedKeys.getLong("user_id"));
        //    vacation.setStartVacation(generatedKeys.getDate("date_start"));
        //    vacation.setEndVacation(generatedKeys.getDate("date_end"));
        //}
        generatedKeys.next();
//        if (!generatedKeys.isLast()) {
//            throw new RuntimeException("Expected only one vacation");
//        }

        Vacation vacation = new Vacation(
                generatedKeys.getLong("id"),
                generatedKeys.getLong("user_id"),
                generatedKeys.getDate("date_start"),
                generatedKeys.getDate("date_end")
        );


        return vacation;
    }

    private Vacation vacationSetForVacationList(ResultSet generatedKeys) throws SQLException {
        Vacation vacation = new Vacation();

        vacation.setId(generatedKeys.getLong("id"));
        vacation.setUserId(generatedKeys.getLong("user_id"));
        vacation.setStartVacation(generatedKeys.getDate("date_start"));
        vacation.setEndVacation(generatedKeys.getDate("date_end"));

        return vacation;
    }

    private User userSetForUserList(ResultSet generatedKeys) throws SQLException {
        User user = new User();

        user.setId(generatedKeys.getLong(1));
        user.setName(generatedKeys.getString(2));
        user.setDateRegistration(generatedKeys.getDate(3));

        return user;
    }

    private User userSetForUser(ResultSet generatedKeys) throws SQLException {
        User user = new User();
        while (generatedKeys.next()) {
            user.setId(generatedKeys.getLong(1));
            user.setName(generatedKeys.getString(2));
            user.setDateRegistration(generatedKeys.getDate(3));
        }
        return user;
    }

    private boolean checkValidConnection(Connection connection) {

        try {

            if (!connection.isClosed()) {
                System.out.println("Test query!");
                PreparedStatement ps = connection.prepareStatement("select 1");
                ps.execute();
            }else {
                System.out.println("Open connection in block else");
                this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root");
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error in query");
            try {
                System.out.println("New connection");
                this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root");
                return true;
            } catch (SQLException ex) {
                System.out.println("Что-то пошло не так. Проверь Connection");
                return false;
            }

        }

    }

}





