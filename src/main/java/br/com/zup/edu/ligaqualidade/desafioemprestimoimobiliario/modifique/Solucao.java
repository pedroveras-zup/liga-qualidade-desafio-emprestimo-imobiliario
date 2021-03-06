package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.ProposalData;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.domain.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service.EventParser;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.service.ProposalValidationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solucao {
	
  public static String processMessages(List<String> messages) {
      // verificar ordem de saída das proposta
      // verificar erro de proponents nulos a partir segundo teste
      EventParser eventParser = new EventParser();
      List<Event> events = messages.stream().map(event -> eventParser.parser(event))
              .map(Optional::get)
              .collect(Collectors.toList());

      ProposalData proposalData = new ProposalData(events);

      ProposalValidationService proposalValidationService = new ProposalValidationService();
      return proposalValidationService.validate(proposalData);
  }
}