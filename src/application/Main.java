package application;

import application.model.controller.MenuControl;
import application.model.entities.Reservation;
import application.model.exceptions.DomainException;
import application.model.services.StaticService;
import application.views.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws DomainException {

        List<Reservation> reservations = new ArrayList<>();

        Locale.setDefault(Locale.US);

        MenuControl.InitMenu();

    }
}