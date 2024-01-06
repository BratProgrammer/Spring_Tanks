package org.example.Tanks;
import org.example.Tanks.Vehicles.ArmoredVehicle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("Бронетанковое соединение")
public class ArmoredFormation {
    private LinkedList<ArmoredVehicle> listOfVehicles = new LinkedList<ArmoredVehicle>();

    public void addVehicle(ArmoredVehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    public void removeVehicle(int index) {
        if (index >= 0 && index < listOfVehicles.size()) {
            try {
                listOfVehicles.remove(index);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Машины с таким индесом в колонне нет");
            }
        } else {
            System.out.println("Машины с таким индесом в колонне нет");
        }
    }
    public void removeVehicle(String name) {
        boolean removeCheck = false;
        for (ArmoredVehicle vehicle : listOfVehicles) {
            if (vehicle.whoIs() == name) {
                listOfVehicles.remove(vehicle);
                removeCheck = true;
            }
        }
        if (!removeCheck) {
            System.out.println("Машины с таким именем в колонне нет");
        }
    }

    public ArmoredVehicle getVehicle(int index) {
        try {
            return listOfVehicles.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Машины с таким индесом в колонне нет");
            return null;
        }

    }


    public boolean moveToPoint(String pointName, int distance) throws InterruptedException {
        boolean checkFuelLevel = true;
        LinkedList<Integer> indexesOfNotReadyToMoveVehicles = new LinkedList<Integer>();

        int index = 0;
        for (ArmoredVehicle vehicle : listOfVehicles) {
            if (!vehicle.canGoToPoint(distance)) {
                checkFuelLevel = false;
                indexesOfNotReadyToMoveVehicles.add(index);
            }
            index++;
        }

        if (checkFuelLevel) {
            for (ArmoredVehicle vehicle : listOfVehicles) {
                vehicle.goToPoint(pointName, distance);
            }
        } else {
            for (int i : indexesOfNotReadyToMoveVehicles) {
                System.out.println("Машине " + listOfVehicles.get(i).whoIs() + " не хватит топлива");
            }
        }

        System.out.println("");
        return checkFuelLevel;
    }
}
