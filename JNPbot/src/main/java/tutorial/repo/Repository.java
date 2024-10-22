package tutorial.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tutorial.model.User;
import tutorial.model.Vacation;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Repository {

    private static final String SaveUser = "http://localhost:8080/api-table/save-user";
    private static final String SearchUserById = "http://localhost:8080/api-table/show-user/";
    private static final String SaveVacation = "http://localhost:8080/api-table/save-vacation";
    private static final String ShowVacation = "http://localhost:8080/api-table/show-vfui/";

    public boolean thisUserExist(User user) throws IOException, ParseException {
        Long id = user.getId();

        StringBuffer urlSearchUserById = new StringBuffer(SearchUserById);
        urlSearchUserById.append(id);

        HttpURLConnection con = callApi(urlSearchUserById);
        try (InputStream inputStream = con.getInputStream()) {

            byte[] buffer = inputStream.readAllBytes();
            String inputString = new String(buffer);


            JSONParser parser = new JSONParser();
            Object unitsObj = parser.parse(inputString);


            JSONObject jo = (JSONObject) unitsObj;

            System.out.println(jo);
            Long userId = (Long) jo.get("id");
            System.out.println("Id this user = " + userId);

            if (userId == null) {
                System.out.println("userId = null");
                return false;
            } else {
                System.out.println("userId = " + userId);
                return true;
            }
        }
    }

    private static HttpURLConnection callApi(StringBuffer endpoint) throws IOException {
        URL url = new URL(endpoint.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        return con;
    }

    public void saveUser(User user) throws IOException {
        try {
            if (!thisUserExist(user)) {
                ObjectMapper objectMapper = new ObjectMapper();
                URL url = new URL(SaveUser);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("API-KEY", "123123123sdfkjsdlfj");
                con.setRequestProperty("Content-type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setDoOutput(true);

                String jsonInput = objectMapper.writeValueAsString(user);

                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println(response.toString());
                }
                System.out.println("Save ok;");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User exist!");

    }

    public void saveVacation(Vacation vacation) throws IOException, java.text.ParseException {
        ObjectMapper objectMapper = new ObjectMapper();


        URL url = new URL(SaveVacation);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);


        String jsonInput = objectMapper.writeValueAsString(vacation);
        System.out.println(jsonInput);

        try (
                OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInput.getBytes(Charset.defaultCharset());
            os.write(input, 0, input.length);
        }

        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

    }

    public String foundVacationById(String userId) throws IOException {
        URL url = null;
        try {
            url = new URL(ShowVacation + userId);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder stringResponse = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            stringResponse.append(inputLine);
        }
        return stringResponse.toString();
    }


}
