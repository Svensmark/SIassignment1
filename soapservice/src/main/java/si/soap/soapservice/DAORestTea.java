package si.soap.soapservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import si.soap.classes.exam.RestExam;
import si.soap.classes.teacher.LinkTea;
import si.soap.classes.teacher.RestTeacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DAORestTea {
    public RestTeacher getTeacher(int id){

        RestTeacher teacher;
        URL url;
        String out;
        int status;
        {
            try {
                url = new URL("http://localhost:8069/teachers/"+id);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                status = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                String content = "";
                while ((inputLine = in.readLine()) != null) {
                    content = content +inputLine;
                }
                in.close();
                con.disconnect();
                teacher = new ObjectMapper().readValue(content, RestTeacher.class);
                return teacher;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public RestTeacher[] getTeachers(){

        RestTeacher[] teachers;
        URL url;
        String out;
        int status;
        {
            try {
                url = new URL("http://localhost:8069/teachers");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                status = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                String content = "";
                while ((inputLine = in.readLine()) != null) {
                    content = content +inputLine;
                }
                in.close();
                con.disconnect();
                LinkTea list = new ObjectMapper().readValue(content, LinkTea.class);
                teachers = list.get_embedded().getTeachers();
                return teachers;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
