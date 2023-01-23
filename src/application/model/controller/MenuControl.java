package application.model.controller;

import application.model.entities.Reservation;
import application.model.exceptions.DomainException;
import application.model.services.StaticService;
import application.views.MenuView;

import java.util.Scanner;

public class MenuControl {

    public static void InitMenu() throws DomainException {

        Scanner in = new Scanner(System.in);
        StaticService svc = new StaticService();


        System.out.print(new MenuView().menuInit);
        int n = in.nextInt();

        switch (n) {
            case 1 -> svc.newReservation();
            case 2 -> svc.updateDateOfReservation();
            case 3 -> StaticService.removeReservation();
            case 0 -> System.out.println(new MenuView().menuEnd);
            default -> MenuControl.InitMenu();
        }


    }
}
