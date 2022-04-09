package com.company;

import Java.Car;
import Java.Driver;
import Java.State;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String data = new String(Files.readAllBytes(Paths.get("cars.json")));
        JSONArray  jsonArray = new JSONArray(data);
        Car [] cars = new Car[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            cars [i] = new Car();
            String str = jsonArray.getString(i).toString();
            JSONObject object = new JSONObject(str);
            cars [i].setId(object.getInt("id"));
            cars [i].setAutoName(object.getString("name"));
            cars [i].setDriver(object.getString("driver"));
            cars [i].setState(State.BASE);
        }

        String driverData = new String(Files.readAllBytes(Paths.get("drivers.json")));
        JSONArray json = new JSONArray(driverData);
        Driver [] drivers = new Driver[json.length()];
        for (int i = 0; i < drivers.length; i++) {
            drivers [i] = new Driver();
            String st = json.get(i).toString();
            JSONObject object = new JSONObject(st);
            drivers [i].setId(object.getInt("id"));
            drivers [i].setName(object.getString("name"));
        }

        Car.print(cars);
        while (true){
            System.out.println("выбрать один из машин");
            int choice = scanner.nextInt();
            scanner.nextLine();
            Car.getInfo(cars[choice -1]);
            Car.injection();
            String action = scanner.nextLine();
            Car.action(action,cars[choice -1],drivers);
            Car.print(cars);
            Driver.print(drivers);
        }

    }
}

