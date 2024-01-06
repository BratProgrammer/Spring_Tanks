package org.example;

import org.example.Tanks.ArmoredFormation;
import org.example.Tanks.Vehicles.Acstracts.Btr_Bmp.BMP_2;
import org.example.Tanks.Vehicles.Acstracts.Tanks.T90_M;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Поднимаем Application context
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.Tanks");
        ArmoredFormation fightGroup = (ArmoredFormation) context.getBean("Бронетанковое соединение");

        for (int i = 0; i < 10; i++) {
            fightGroup.addVehicle(new T90_M());
        }

        for (int i = 0; i < 15; i++) {
            fightGroup.addVehicle(new BMP_2());
        }

        if (fightGroup.getVehicle(10) != null) {
            System.out.println(fightGroup.getVehicle(10).whoIs());
        }


    }
}