package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain;

import java.math.BigDecimal;
import java.util.List;

public class Proposal extends Event {
    private BigDecimal proposalLoanValue;
    private Integer numberOfMonthlyInstallments;
    private String eventAction;
    private List<Proponent> proponents;
    private List<Warranty> warranties;

    public BigDecimal getProposalLoanValue() {
        return proposalLoanValue;
    }

    public void setProposalLoanValue(BigDecimal proposalLoanValue) {
        this.proposalLoanValue = proposalLoanValue;
    }

    public Integer getNumberOfMonthlyInstallments() {
        return numberOfMonthlyInstallments;
    }

    public void setNumberOfMonthlyInstallments(Integer numberOfMonthlyInstallments) {
        this.numberOfMonthlyInstallments = numberOfMonthlyInstallments;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public List<Proponent> getProponents() {
        return proponents;
    }

    public void setProponents(List<Proponent> proponents) {
        this.proponents = proponents;
    }

    public List<Warranty> getWarranties() {
        return warranties;
    }

    public void setWarranties(List<Warranty> warranties) {
        this.warranties = warranties;
    }
}
