package com.dp.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> getAllTrains() {
        long currentTime = System.currentTimeMillis();
        long twelveHoursLater = currentTime + (12 * 60 * 60 * 1000);
        return trainRepository.findByDepartureTimeAfterAndDepartureTimeBeforeOrderByPriceAscSeatsAvailableACDescDepartureTimeDesc(currentTime, twelveHoursLater);
    }

    @Override
    public Train getTrainByNumber(String trainNumber) {
        return trainRepository.findByTrainNumber(trainNumber);
    }
}
