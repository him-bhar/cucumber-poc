package com.himanshu.poc.cucumber.poc.spring;

import org.springframework.context.annotation.Bean;

import com.himanshu.poc.cucumber.poc.calculator.Calculator;

public class SpringBeansConfig {
  
  @Bean
  public Calculator getCalculator() {
    return new Calculator();
  }

}
