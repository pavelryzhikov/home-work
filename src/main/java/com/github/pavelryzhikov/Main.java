package com.github.pavelryzhikov;

import com.github.pavelryzhikov.dto.Account;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        log.debug("foo");

        String filePath = "src/main/resources/Accounts.txt";

        ArrayList<String> fileBytes = (ArrayList) Files.readAllLines(Paths.get(filePath));

        int i = 0;
        String number = null;
        Long clientid = null;
        for (String a : fileBytes) {
            a = a.trim().replace(",", "").replace("\"", "");

            if (a.trim().equals("{")) {
                System.out.println("start: " + a);
                i++;
            }
            if (a.contains("clientId")) {
                clientid = Long.parseLong(a.replace("clientId: ", ""));
            }
            if (a.contains("number")) {
                number = a.replace("number: ", "");
            }
            if (a.trim().replace(",", "").equals("}")) {
                System.out.println("end: " + a + " clientId=" + clientid + " number=" + number);
            }


        }

        Set<Account> setS = new HashSet();
        setS.add(new Account("one"));
        setS.add(new Account("two"));
        setS.add(new Account("three"));
        setS.add(new Account("one"));

        System.out.println(setS.toString());
//setS.stream().filter(new Account("one"));

//        for(String a: fileBytes){
//            System.out.println("---------");
//            do {
//                System.out.println(a);
//            } while (a.trim().equals("}"));
//        }

        //Map<String,>

        //System.out.println(fileBytes.toString());
//        Map<Long, String> setAcc = new HashMap<Long,String>();
//        ObjectMapper objectMappper = new ObjectMapper();
//
//        objectMappper.readValue(fileBytes, HashMap.class);
//
//        System.out.println("Map is: "+setAcc);

//        Gson g = new Gson();
//        Type type = new TypeToken<Map<String, Account>>(){}.getType();
//        Map<String, Account> myMap = g.fromJson(fileBytes.toString(), type);
//        System.out.println(myMap);

        JSONParser parser = new JSONParser();
        //JSONObject jsonObject;

        JSONArray obj = (JSONArray) parser.parse(new FileReader(filePath));

        //JSONObject jsonObject = (JSONObject) obj;

//        System.out.println(obj);
//        for(Object o: obj){
//            if ( o instanceof JSONObject ) {
//                System.out.println(o);
//               // System.out.println(o.get("number"));
//              //  System.out.println(o.get("clientId"));
//            }
//        }
        //obj.forEach();

        //out.println(jsonObject.get("from_excel"));

        //Array solutions = (JSONArray) jsonObject;

//        Iterator iterator = solutions.iterator();
//        while (iterator.hasNext()) {
//            out.println(iterator.next());
//        }

    }
}
