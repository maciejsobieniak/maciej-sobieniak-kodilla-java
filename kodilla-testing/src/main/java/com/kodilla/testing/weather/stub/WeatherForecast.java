package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    /**
     * adding 1 celsius degree to all available temperature value as a temporary weather forecast
     *
     * @return new map where each value is + 1.0
     */

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    /**
     * Calculate the average of all available temperature readings.
     *
     * @return average temperature
     */
    public double calculateAvgTemperature() {
        double avgTemperature = 0;
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            avgTemperature += temperature.getValue();
        }

        if (avgTemperature == 0) {
            return 0;
        } else {
            return avgTemperature / temperatures.getTemperatures().size();
        }
    }

    /**
     * Calculates the median of all temperature readings.
     *
     * The values are sorted. For an odd count the middle element is returned.
     * For an even count the average of the two middle elements is returned.
     *
     * @return median temperature
     */

    public double calculateMedianTemperature() {
        double medianTemperature = 0;
        ArrayList<Double> temperaturesValue = new ArrayList<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            temperaturesValue.add(temperature.getValue());
        }

        if (temperaturesValue.isEmpty()) {
            throw new RuntimeException("temperatures is empty");
        }

        Collections.sort(temperaturesValue);
        double result = 0;
        if (temperaturesValue.size() % 2 != 0) {
            result = temperaturesValue.get(temperaturesValue.size() / 2);
            return result;
        } else {
            result = (temperaturesValue.get(temperaturesValue.size() / 2 - 1) + temperaturesValue.get(temperaturesValue.size() / 2)) / 2.0;
            return result;
        }

    }
}
