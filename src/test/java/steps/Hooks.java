package steps;

import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestStep;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import static base.RequestManager.shared;

public class Hooks {
    private List<String> steps = new ArrayList<>();
    int currentStepIndex = 0;


    @After
    public void teardown() {
        shared().tearDownRequest();
        shared().tearDownResponse();
    }
}
