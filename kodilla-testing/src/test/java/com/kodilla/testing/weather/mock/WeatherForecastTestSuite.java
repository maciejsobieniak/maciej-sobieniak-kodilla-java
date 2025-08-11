package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.round;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests for WeatherForecast")
class WeatherForecastTestSuite {

    private static Map<String, Double> temperaturesMap = new HashMap<>();
    private static int testCounter = 0;

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;


    @BeforeAll
    public static void beforeAllTests () {
        System.out.println("Start tests weather module");
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }


    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);

        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests for weather module are finished.");
    }

    @Test
    @DisplayName("Tests calculate forecast")
    void testCalculateForecastWithMock() {

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    @DisplayName("Tests calculate forecast avg temperature")
    void testCalculateForecastAvgTemperatureWithMock() {


        //When
        double avgTemperature = weatherForecast.calculateAvgTemperature();

        //Then
        Assertions.assertEquals(25.56, avgTemperature);
    }

    @Test
    @DisplayName("Tests calculate forecast median temperature")
    void testCalculateForecastMedianTemperatureWithMock () {

        //When
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        //Then
        Assertions.assertEquals(25.5, medianTemperature);
    }
}
