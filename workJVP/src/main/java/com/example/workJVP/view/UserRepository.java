package com.example.workJVP;

import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private Connection connection;


    public UserRepository() throws SQLException {
        System.out.println("constructor start");
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root");
        System.out.println("constructor end");
    }

    //@Autowired
    //private JdbcTemplate jdbcTemplate;


    public void createTable() throws SQLException {
        /**jdbcTemplate.execute*/
        try (Statement st = this.connection.createStatement()) {
            st.execute("""
                    create table if not exists employees(
                    id bigserial primary key,
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
        //return findAll();*/
        //List<User> users = new ArrayList<>();
        //return users;
    }

    public User saveUser(User user) throws SQLException {
        if (user.checkOnValidationUser(user)) {

            try (PreparedStatement ps = connection.prepareStatement("insert into employees (name_user) values (?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getName());
                ps.execute();
                System.out.println("Добавил данные");
                ResultSet resultSet = ps.getGeneratedKeys();
                return userSetForUser(resultSet);
            }
        }

        /**return jdbcTemplate.execute(new ConnectionCallback<User>() {
        @Override public User doInConnection(Connection con) throws SQLException, DataAccessException {
        PreparedStatement ps = con.prepareStatement(
        "insert into testjvp (name_user) values (?)",
        Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, user.getName());
        ps.execute();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        return userSet(generatedKeys);
        }
        });*/

        /**User newUser = jdbcTemplate.query(
         con -> con.prepareStatement("insert into testjvp (name_user) values (?)", Statement.RETURN_GENERATED_KEYS),
         pss -> pss.setString(1, user.getName()),
         rs -> rs.next() ? userSet(rs) : null
         );*/

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

        /**List<User> users = new ArrayList<>();
         try (Statement statement = jdbcTemplate.getDataSource().getConnection().createStatement()) {
         ResultSet resultSet = statement.executeQuery("select id , name_user, date_registration from testjvp");
         while (resultSet.next()) {
         User user = userSet(resultSet);
         users.add(user);
         }
         }
         return users;*/
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
        /**return jdbcTemplate.query(
         con -> con.prepareStatement("select * from testjvp where id =(?)"),
         pss -> pss.setLong(1, id),
         rs -> rs.next() ? userSet(rs) : null
         );*/
        return null;
    }

    public Vacation saveVacation(Vacation vacation) throws SQLException {
        if (vacation.checkValidVacation(vacation)) {
            try (PreparedStatement ps = connection.prepareStatement("insert into vacations (user_id, date_start, date_end) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            )) {
                ps.setLong(1, vacation.getUserId());
                ps.setDate(2, vacation.getStartVacation());
                ps.setDate(3, vacation.getEndVacation());
                ps.execute();
                ResultSet resultSet = ps.getGeneratedKeys();
                return vacationSetForVacation(resultSet);
            }
        } else {
            return null;
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

    public List<UserVacationView> deleteVacationByUserIdAndVacationId(Long userId, Long vacationId) throws SQLException {

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
            ps.setString(2,dateToDay);
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

}





