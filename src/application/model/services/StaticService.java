package application.model.services;

import application.model.controller.MenuControl;
import application.model.entities.Reservation;
import application.views.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticService {

    public static void newReservation() {

        Scanner in = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Reservation> reservations = new ArrayList<>();
        char continues = 'y';

        while (continues != 'n') {
            System.out.print(new TextView().numberOfReservations);
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {

                System.out.print(new TextView().room);
                Integer room = in.nextInt();
                in.nextLine();

                System.out.print(new TextView().checkIn);
                String checkInDate = in.nextLine();
                LocalDate checkIn = LocalDate.parse(checkInDate, fmt);

                System.out.print(new TextView().checkOut);
                String checkOutDate = in.nextLine();
                LocalDate checkOut = LocalDate.parse(checkOutDate, fmt);

                reservations.add(new Reservation(room, checkIn, checkOut));

            }

            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }

            System.out.print(new TextView().continuationOfRegister);
            continues = in.next().charAt(0);
        }

        MenuControl.InitMenu();
    }

    public static void updateDateOfReservation() {
        Scanner in = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(new TextView().updateCheckInAndCheckOut);

        System.out.print(new TextView().checkIn);
        String checkInDate = in.nextLine();
        LocalDate checkIn = LocalDate.parse(checkInDate, fmt);

        System.out.print(new TextView().checkOut);
        String checkOutDate = in.nextLine();
        LocalDate checkOut = LocalDate.parse(checkOutDate, fmt);


    }

    public static void removeReservation() {
    }
}
