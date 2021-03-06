package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain;

import java.math.BigDecimal;

public class Proponent extends Event {
    private String name;
    private Integer age;
    private BigDecimal income;
    private String eventAction;
    private boolean isMain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
