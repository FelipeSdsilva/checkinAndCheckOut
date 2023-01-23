package application.model.entities;

import application.views.TextView;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private Integer roomOfNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private List<Reservation> reservations = new ArrayList<>();

    private final static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomOfNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomOfNumber = roomOfNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomOfNumber() {
        return roomOfNumber;
    }

    public void setRoomOfNumber(Integer roomOfNumber) {
        this.roomOfNumber = roomOfNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addNewReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Integer roomOfNumber) {
        reservations.remove(getRoomOfNumber());
    }

    public Duration durationOfDaysBetweenCheckINAndCheckOut() {
        return Duration.between(getCheckIn().atTime(0, 0), getCheckOut().atTime(0, 0));
    }


    public String updateDate(LocalDate checkIn, LocalDate checkOut) {

        if (!checkOut.isAfter(checkIn)) {
            return new TextView().errorInCheckOutDate;
        }
        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
            return new TextView().errorInPastDate;
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    public static void viewAllReservations(List<Reservation> reservations) {
        for (Reservation reservation1 : reservations) {
            System.out.println(reservation1);
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "Room= " + getRoomOfNumber() +
                ", check-In= " + getCheckIn().format(fmt) +
                ", check-Out= " + getCheckOut().format(fmt) + ", " +
                durationOfDaysBetweenCheckINAndCheckOut().toDays() + " nights }";
    }
}
