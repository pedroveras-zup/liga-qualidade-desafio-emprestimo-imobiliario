package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Proponent;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Proposal;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Warranty;

import java.math.BigDecimal;
import java.util.Optional;

public class EventParser {
    public Optional<Event> parser(String event) {
        if (event.contains("proposal")) {
            return setUpProposal(event.split(","));
        } else if (event.contains("proponent")) {
            return setUpProponent(event.split(","));
        } else if (event.contains("warranty")) {
            return setUpWarranty(event.split(","));
        }

        return Optional.empty();
    }

    public Optional<Event> setUpProposal(String[] eventSplitted) {
        Proposal proposal = new Proposal();
        proposal.setProposalId(eventSplitted[4]);
        proposal.setEventId(eventSplitted[0]);
        proposal.setEventAction(eventSplitted[2]);
        proposal.setProposalLoanValue(new BigDecimal(eventSplitted[5]));
        proposal.setNumberOfMonthlyInstallments(Integer.valueOf(eventSplitted[6]));

        return Optional.of(proposal);
    }

    public Optional<Event> setUpWarranty(String[] eventSplitted) {
        Warranty warranty = new Warranty();
        warranty.setProposalId(eventSplitted[4]);
        warranty.setEventId(eventSplitted[0]);
        warranty.setEventAction(eventSplitted[2]);
        warranty.setValue(new BigDecimal(eventSplitted[6]));
        warranty.setProvince(eventSplitted[7]);

        return Optional.of(warranty);
    }

    public Optional<Event> setUpProponent(String[] eventSplitted) {
        Proponent proponent = new Proponent();
        proponent.setProposalId(eventSplitted[4]);
        proponent.setEventId(eventSplitted[0]);
        proponent.setEventAction(eventSplitted[2]);
        proponent.setName(eventSplitted[6]);
        proponent.setAge(Integer.valueOf(eventSplitted[7]));
        proponent.setIncome(new BigDecimal(eventSplitted[8]));
        proponent.setMain(Boolean.valueOf(eventSplitted[9]));

        return Optional.of(proponent);
    }
}
