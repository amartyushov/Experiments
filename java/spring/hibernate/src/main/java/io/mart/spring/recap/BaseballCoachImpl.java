package io.mart.spring.recap;

/**
 * Created by Aleksandr Martiushov.
 */
public class BaseballCoachImpl implements Coach {

    private FortuneService fortuneService;

    public BaseballCoachImpl(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
