package com.github.danieljahn.springcucumberexample.bdd;

import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
public class CucumberIT {
}
