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

    private Scanner in = new Scanner(System.in);
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private char continues = 'y';
    public Reservation reservation = new Reservation();

    public void newReservation() {

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


                if (!checkOut.isAfter(checkIn)) {
                    System.out.println(new TextView().errorInCheckOutDate);
                } else if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
                    System.out.println(new TextView().errorInPastDate);
                } else {
                    reservation.addNewReservation(new Reservation(room, checkIn, checkOut));
                }
            }

            System.out.print(new TextView().viewAllReservation);
            continues = in.next().charAt(0);

            if (continues == 'y') {
                reservation.viewAllReservations(reservation.getReservations());
            }

            System.out.print(new TextView().continuationOfRegister);
            continues = in.next().charAt(0);
        }

        MenuControl.InitMenu();

    }

    public void updateDateOfReservation() {

        System.out.println(new TextView().updateCheckInAndCheckOut);

        System.out.print(new TextView().checkIn);
        String checkInDate = in.nextLine();
        LocalDate checkIn = LocalDate.parse(checkInDate, fmt);

        System.out.print(new TextView().checkOut);
        String checkOutDate = in.nextLine();
        LocalDate checkOut = LocalDate.parse(checkOutDate, fmt);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println(new TextView().errorInCheckOutDate);
        } else if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
            System.out.println(new TextView().errorInPastDate);
        } else {
            reservation.updateDate(checkIn, checkOut);
        }
    }

    public static void removeReservation() {
    }


}
