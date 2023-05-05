package com.tsoft.bot.frontend.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
		features={"src//main//resources//features"},
		glue={
				"com.tsoft.bot.frontend.steps",
				"com.tsoft.bot.frontend.helpers"
		},
		plugin = {"pretty", "html:target/cucumber"},
		tags = {"@1125-ConsultaCodigoCCIAhorrosMNME"},
		strict =  false,
		monochrome = false
	)

@Test
public class RunPruebas extends AbstractTestNGCucumberTests{ }

