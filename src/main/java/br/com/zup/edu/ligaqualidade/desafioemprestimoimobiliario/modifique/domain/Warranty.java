package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain;

import java.math.BigDecimal;

public class Warranty extends Event {
    private BigDecimal value;
    private String province;
    private String eventAction;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }
}
