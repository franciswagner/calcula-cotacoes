package com.ricardococati.service.statemachine.config;

import com.ricardococati.service.statemachine.enums.CalculaEvents;
import com.ricardococati.service.statemachine.enums.CalculaStates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Configuration
@EnableStateMachine
public class CalculaStateMachinaTransitionByEventConfig
    extends EnumStateMachineConfigurerAdapter<CalculaStates, CalculaEvents> {

  @Override
  public void configure(StateMachineTransitionConfigurer<CalculaStates, CalculaEvents> transitions)
      throws Exception {
    transitions
        .withExternal()
        .source(CalculaStates.MEDIA_MOVEL_SIMPLES).target(CalculaStates.MEDIA_MOVEL_EXPONENCIAL)
        .event(CalculaEvents.CALCULAR_MEDIA_MOVEL_EXPONENCIAL)
        .and().withExternal()
        .source(CalculaStates.MEDIA_MOVEL_EXPONENCIAL).target(CalculaStates.MACD)
        .event(CalculaEvents.CALCULAR_MACD)
        .and().withExternal()
        .source(CalculaStates.MACD).target(CalculaStates.SINAL_MACD)
        .event(CalculaEvents.CALCULAR_SINAL_MACD)
        .and().withExternal()
        .source(CalculaStates.SINAL_MACD).target(CalculaStates.HISTOGRAMA)
        .event(CalculaEvents.CALCULAR_HISTOGRAMA);
  }

  @Bean
  public StateMachineListener<CalculaStates, CalculaEvents> listener() {
    return new StateMachineListenerAdapter<CalculaStates, CalculaEvents>() {
      @Override
      public void stateChanged(State<CalculaStates, CalculaEvents> from, State<CalculaStates, CalculaEvents> to) {
        System.out.println("CalculaStates change from " + from.getId() + " to " + to.getId());
      }
    };
  }

}
