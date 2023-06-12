package com.klef.jfsd.springbootingboot;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {
    private static final int DELAY_THRESHOLD = 30;
    private static final int NEXT_12_HOURS = 12 * 60 * 60 * 1000; // 12 hours in milliseconds

    @Autowired
    private TrainService trainService;

    @GetMapping("/trains")
    public List<Train> getTrains() {
        List<Train> allTrains = trainService.getAllTrains();
        List<Train> filteredTrains = new ArrayList<>();

        long currentTime = System.currentTimeMillis();
        long twelveHoursLater = currentTime + NEXT_12_HOURS;

        for (Train train : allTrains) {
            long departureTime = calculateDepartureTime(train.getDepartureTime());
            if (departureTime > currentTime && departureTime <= twelveHoursLater) {
                filteredTrains.add(train);
            }
        }

        filteredTrains.sort(Comparator.comparingInt(Train::getPrice)
                .thenComparing(Train::getSeatsAvailable, Comparator.comparing(SeatsAvailable::getTotalSeats).reversed())
                .thenComparing(Train::getDepartureTime, Comparator.comparing(this::calculateDepartureTime)));

        return filteredTrains;
    }

    private long calculateDepartureTime(DepartureTime departureTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime trainDepartureDateTime = currentDateTime.withHour(departureTime.getHours())
                .withMinute(departureTime.getMinutes()).withSecond(departureTime.getSeconds());
        if (trainDepartureDateTime.isBefore(currentDateTime)) {
            trainDepartureDateTime = trainDepartureDateTime.plusDays(1);
        }
        return trainDepartureDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
