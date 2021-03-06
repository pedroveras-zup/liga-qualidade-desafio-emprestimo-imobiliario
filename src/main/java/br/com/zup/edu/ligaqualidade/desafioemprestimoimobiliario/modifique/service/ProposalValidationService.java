package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.ProposalData;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Proponent;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Proposal;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class ProposalValidationService {

    public String validate(ProposalData proposalData) {
        return proposalData.getProposals()
                .entrySet()
                .stream()
                .filter(p -> validateLoanValue(p.getValue()))
                .filter(p -> validateLoanTime(p.getValue()))
                .filter(p -> validateNumberOfProponents(p.getValue()))
                .filter(p -> validateNumberOfMainProponents(p.getValue()))
                .filter(p -> validateProponentsMinAge(p.getValue()))
                .map(p -> p.getKey())
                .collect(Collectors.joining(","));
    }

    private boolean validateLoanValue(Proposal proposal) {
        return (proposal.getProposalLoanValue().compareTo(new BigDecimal(30000)) >= 0) &&
                (proposal.getProposalLoanValue().compareTo(new BigDecimal(3000001)) < 0);
    }

    private boolean validateLoanTime(Proposal proposal) {
        int numberOfYears = proposal.getNumberOfMonthlyInstallments()/12;
        return numberOfYears >= 2 && numberOfYears <= 15;
    }

    private boolean validateNumberOfProponents(Proposal proposal) {
        return proposal.getProponents().size() >= 2;
    }

    private boolean validateNumberOfMainProponents(Proposal proposal) {
        return proposal.getProponents().stream().anyMatch(Proponent::isMain);
    }

    private boolean validateProponentsMinAge(Proposal proposal) {
        return proposal.getProponents().stream().allMatch(proponent -> proponent.getAge() >= 18);
    }
}
