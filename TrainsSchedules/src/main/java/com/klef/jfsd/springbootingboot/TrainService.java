package com.klef.jfsd.springbootingboot;

import java.util.List;

public interface TrainService {
    List<Train> getAllTrains();
    Train getTrainByNumber(String trainNumber);
}
