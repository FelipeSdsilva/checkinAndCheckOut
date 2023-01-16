package application;

import application.model.controller.MenuControl;
import application.model.services.StaticService;
import application.views.MenuView;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        MenuControl.InitMenu();
    }
}