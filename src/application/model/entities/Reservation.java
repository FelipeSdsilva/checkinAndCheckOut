package application.model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Reservation {

    private Integer roomOfNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

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

    public Duration durationOfDaysBetweenCheckINAndCheckOut() {
        return Duration.between(getCheckIn().atTime(0, 0), getCheckOut().atTime(0, 0));
    }

    public void updateDate(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
