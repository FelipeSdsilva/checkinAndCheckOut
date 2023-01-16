package application.model.controller;

import application.model.services.StaticService;
import application.views.MenuView;

import java.util.Scanner;

public class MenuControl {

    public static void InitMenu() {

        Scanner in = new Scanner(System.in);
        System.out.print(new MenuView().menuInit);
        int n = in.nextInt();

        switch (n) {
            case 1 -> StaticService.newReservation();
            case 2 -> StaticService.updateDateOfReservation();
            case 3 -> StaticService.removeReservation();
            case 0 -> System.out.println(new MenuView().menuEnd);
            default -> MenuControl.InitMenu();
        }


    }
}
