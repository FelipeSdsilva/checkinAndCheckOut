package application.model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private Integer roomOfNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private final static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/HH/yyyy");

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

    public Duration durationOfDaysBetweenCheckINAndChecOut() {
        return Duration.between(checkIn, checkOut);
    }

    public void updateDate(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "Room= " + getRoomOfNumber() +
                ", check-In= " + fmt.format(getCheckIn()) +
                ", check-Out= " + fmt.format(getCheckOut()) +
                durationOfDaysBetweenCheckINAndChecOut().toDays() + " nights ";
    }
}
