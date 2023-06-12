package com.dp.springboot;

import java.util.List;

public interface TrainService {
    List<Train> getAllTrains();
    Train getTrainByNumber(String trainNumber);
}
