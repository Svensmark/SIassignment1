package si.soap.soapservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import si.soap.classes.exam.LinkEx;
import si.soap.classes.exam.RestExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DAORestEx {
    public RestExam getExam(int id){

        RestExam exam;
        URL url;
        String out;
        int status;
        {
            try {
                url = new URL("http://localhost:8071/exams/"+id);
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
                exam = new ObjectMapper().readValue(content, RestExam.class);
                return exam;
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
    public RestExam[] getExams(){

        RestExam exams[];
        URL url;
        String out;
        int status;
        {
            try {
                url = new URL("http://localhost:8071/exams");
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
                LinkEx list = new ObjectMapper().readValue(content, LinkEx.class);
                exams = list.get_embedded().getExams();
                return exams;
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
