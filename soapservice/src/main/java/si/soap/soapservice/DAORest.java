package si.soap.soapservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import si.soap.classes.Link;
import si.soap.classes.RestStudent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DAORest {
    public RestStudent getStudent(int id){

        RestStudent student;
        URL url;
        String out;
        int status;
        {
            try {
                url = new URL("http://localhost:8070/students/"+id);
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
                student = new ObjectMapper().readValue(content,RestStudent.class);
                return student;
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
    public RestStudent[] getStudents(){

        RestStudent students[];
        URL url;
        String out;
        int status;
        {
            try {
                url = new URL("http://localhost:8070/students");
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
                Link list = new ObjectMapper().readValue(content, Link.class);
                students = list.get_embedded().getStudents();
                return students;
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

