package com.dp.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByDepartureTimeAfterAndDepartureTimeBeforeOrderByPriceAscSeatsAvailableACDescDepartureTimeDesc(long currentTime, long twelveHoursLater);
    Train findByTrainNumber(String trainNumber);
}

