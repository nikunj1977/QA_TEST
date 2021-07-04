package com.forex.cucumber.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="Features",
        glue={"com.forex"})
public class CucumberTestRunner
{

}