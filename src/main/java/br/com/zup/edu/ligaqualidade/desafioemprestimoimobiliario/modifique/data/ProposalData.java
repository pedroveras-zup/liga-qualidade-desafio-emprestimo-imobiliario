package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Proponent;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Proposal;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Warranty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ProposalData {
    private static Map<String, Proposal> proposals = new HashMap<>();
    private Map<String, List<Proponent>> proponents;
    private Map<String, List<Warranty>> warranties;

    public ProposalData(List<Event> events) {
        constructProposalData(events);
    }

    public Map<String, Proposal> getProposals() {
        return proposals;
    }

    private void constructProposalData(List<Event> events) {
        events.stream()
                .filter(Proposal.class :: isInstance)
                .forEach(entry -> proposals.put(entry.getProposalId(), (Proposal) entry));

        buildProponents(events);
        buildWarranties(events);

        setProponentsAndWarrantiesOnProposals();
    }

    private void buildProponents(List<Event> events) {
        proponents = events.stream().filter(Proponent.class::isInstance)
                .map(e -> (Proponent) e)
                .collect(groupingBy(Proponent::getProposalId));
    }

    private void buildWarranties(List<Event> events) {
        warranties = events.stream().filter(Warranty.class::isInstance)
                .map(e -> (Warranty) e)
                .collect(groupingBy(Warranty::getProposalId));
    }

    private void setProponentsAndWarrantiesOnProposals() {
        proposals.entrySet().stream().map(proposal -> {
            Proposal proposalSelected = proposal.getValue();
            proposalSelected.setProponents(proponents.get(proposal.getKey()));
            proposalSelected.setWarranties(warranties.get(proposal.getKey()));

            return proposal;
        }).collect(Collectors.toMap(Map.Entry::getKey, proposal -> proposal));
    }
}
