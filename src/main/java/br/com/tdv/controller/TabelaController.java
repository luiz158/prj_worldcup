package br.com.tdv.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.tdv.dao.ClassificacaoDao;
import br.com.tdv.dao.TabelaDao;
import br.com.tdv.model.Classificacao;
import br.com.tdv.model.Tabela;

@Controller
public class TabelaController {

	@RequestMapping(value="/classificacao", method=RequestMethod.GET)
	public ModelAndView getClassificacao() {
		ModelAndView mv = new ModelAndView("classificacao");
		ClassificacaoDao dao = new ClassificacaoDao();
		List<Classificacao> list = dao.getClassificacao();
		mv.addObject("classificacao", list);	
		mv.addObject("qtdeJogos", 48);
		mv.addObject("qtdeJogosFinalizados", dao.getQtdeJogoFinalizados());
		return mv;
	}
	
	@RequestMapping(value="/tabela", method=RequestMethod.GET)
	public ModelAndView getTabela() {
		ModelAndView mv = new ModelAndView("tabela");
		List<Tabela> tabela = new TabelaDao().getTabela();
		mv.addObject("tabela", tabela);	
		return mv;
	}	
	
	@RequestMapping(value="/get_class_simulacao", method=RequestMethod.GET)
	@ResponseBody
	public List<Classificacao> getSimulacao() {
		List<Classificacao> list = new ClassificacaoDao().getClassificacao();	
		return list;
	}		
	
	@RequestMapping(value="/simulacao_classificacao2", method=RequestMethod.GET)
	public String getClassificacaoSimulada() {
		return "simulacao";
	}	
	
	@RequestMapping(value="/simulacao_classificacao", method=RequestMethod.GET)
	public String getClassificacaoSimulada2() {
		return "simulacao2";
	}		
	
	@RequestMapping(value="/jogos_pendentes", method=RequestMethod.GET)
	@ResponseBody
	public List<Tabela> getJogosPendentes(int qtde) {
		return new TabelaDao().getJogosPendentes(qtde);
	}
	
	@RequestMapping(value="/jogo_pendente", method=RequestMethod.GET)
	@ResponseBody
	public List<Tabela> getJogoPendente(int codigo) {
		return new TabelaDao().getJogoPendente(codigo); 
	}	
	
	@RequestMapping(value="/plus_info", method=RequestMethod.GET)
	public String plusInfo() {
		return "plus_info";
	}
	
	@RequestMapping(value="/jogos_all", method=RequestMethod.GET)
	@ResponseBody
	public List<Tabela> getTabelaJson() {
		List<Tabela> tabela = new TabelaDao().getTabela(); 
		return tabela;
	}		
	
}