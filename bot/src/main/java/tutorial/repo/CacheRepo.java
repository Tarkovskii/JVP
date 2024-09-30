package tutorial.repo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import tutorial.controller.VacationController;
import tutorial.model.User;
import tutorial.model.UserVacationView;
import tutorial.model.Vacation;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheRepo {
    private ConcurrentHashMap<User, VacationController> cacheRepo;

    private Repository repository = new Repository();

    public CacheRepo() {
        this.cacheRepo = new ConcurrentHashMap<>();
    }

    public void add(User user) {
        cacheRepo.put(user, new VacationController());

    }


    public synchronized void setDateBufferPersonByID(Long id, String newString) {
        User currentPerson = findUserByID(id);
        VacationController nowVacControl = cacheRepo.get(currentPerson);

        if (!nowVacControl.isValidStartVac()) {
            System.out.println("Valid start size" + nowVacControl.getStartVac());
            nowVacControl.addElemStartVac(newString);
            cacheRepo.put(currentPerson, nowVacControl);
        } else {
            nowVacControl.addElemEndVac(newString);
            cacheRepo.put(currentPerson, nowVacControl);
        }
        System.out.println(cacheRepo.get(findUserByID(id)));
    }


    public VacationController getBufferPersonByID(Long id) {
        return cacheRepo.get(findUserByID(id));
    }


    public User findUserByID(Long id) {
        for (User person : cacheRepo.keySet()) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public boolean personIsExist(Long id) {

        for (User person : cacheRepo.keySet()) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void deleteUserToCache(User user) {
        cacheRepo.remove(user);
        System.out.println("User removed");
    }

    public void saveUserInDB(User user) {
        try {
            repository.saveUser(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveVacationInDB(User user) {
        Vacation vac = cacheRepo.get(user).mapperVacationControllerToVacation(user);
        try {
            repository.saveVacation(vac);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(vac);
    }

    public UserVacationView loaderVacationsForUserFromDB(Long forUser) {

        User user = new User();
        user.setId(forUser);

        ArrayList<Vacation> vacations = new ArrayList<>();
        UserVacationView userVacationView = new UserVacationView(user,vacations);

        try {
            String buffer = repository.foundVacationById(forUser.toString());
            if (buffer.isEmpty()) {
                return null;
            }

            JSONParser parser = new JSONParser();
            Object unitsObj = parser.parse(buffer);

            JSONArray unitsJson = (JSONArray) unitsObj;

            for (Object obj : unitsJson) {
                JSONObject line = (JSONObject) obj;
                Long vacId = (Long) line.get("vacationId");
                Date vacStart = Date.valueOf(line.get("vacationStart").toString());
                Date vacEnd = Date.valueOf(line.get("vacationEnd").toString());


                user.setName(line.get("nameUser").toString());
                Vacation vacation = new Vacation(vacId, user.getId(), vacStart, vacEnd);
                vacations.add(vacation);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
        return userVacationView;

    }


    @Override
    public String toString() {
        return "CacheRepo{" +
                "cachePerson=" + cacheRepo +
                '}';
    }
}
