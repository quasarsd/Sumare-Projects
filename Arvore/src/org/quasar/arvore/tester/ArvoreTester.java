package org.quasar.arvore.tester;

import java.util.LinkedList;

import org.quasar.arvore.No;

public class ArvoreTester {

	public static void main(String[] args) {
		No<String> root = criadorArvore();
		buscar(root, "ES");
	}

	private static No<String> criadorArvore() {
		No<String> root = new No<String>();

		root.setConsultado(false);
		root.setPai(null);
		root.setProfundidade(1L);
		root.setFilhos(new LinkedList<No<String>>());
		root.setValor("SP");

		// MG
		No<String> noMG = new No<String>();
		noMG.setPai(root);
		noMG.setProfundidade(2L);
		noMG.setValor("MG");
		noMG.setFilhos(new LinkedList<No<String>>());

		// RJ
		No<String> noRJ = new No<String>();
		noRJ.setPai(root);
		noRJ.setProfundidade(2L);
		noRJ.setValor("RJ");
		noRJ.setFilhos(new LinkedList<No<String>>());

		// PR
		No<String> noPR = new No<String>();
		noPR.setPai(root);
		noPR.setProfundidade(2L);
		noPR.setValor("PR");
		noPR.setFilhos(new LinkedList<No<String>>());

		// ES
		No<String> noES = new No<String>();
		noES.setPai(root);
		noES.setProfundidade(3L);
		noES.setValor("ES");
		noES.setFilhos(new LinkedList<No<String>>());

		// BA
		No<String> noBA = new No<String>();
		noBA.setPai(root);
		noBA.setProfundidade(4L);
		noBA.setValor("BA");
		noBA.setFilhos(new LinkedList<No<String>>());

		// SC
		No<String> noSC = new No<String>();
		noSC.setPai(root);
		noSC.setProfundidade(3L);
		noSC.setValor("SC");
		noSC.setFilhos(new LinkedList<No<String>>());

		// RS
		No<String> noRS = new No<String>();
		noRS.setPai(root);
		noRS.setProfundidade(4L);
		noRS.setValor("RS");
		noRS.setFilhos(new LinkedList<No<String>>());

		root.getFilhos().add(noPR);
		root.getFilhos().add(noMG);
		root.getFilhos().add(noRJ);

		noPR.getFilhos().add(noSC);
		noSC.getFilhos().add(noRS);

		noMG.getFilhos().add(noES);
		noRJ.getFilhos().add(noES);

		noMG.getFilhos().add(noBA);
		noES.getFilhos().add(noBA);

		return root;
	}

	private static void buscar(No<String> root, String alvo) {

		StringBuffer sb1 = new StringBuffer();
		sb1.append(root.getProfundidade() + " | " + root.getValor() + " | ");
		if (root.getValor().equals(alvo))
			sb1.append(" ACHOU");

		//System.out.println(sb1);

		for (No<String> no : root.getFilhos()) {

			no.setPai(root);
			
			StringBuffer sb2 = new StringBuffer();
			sb2.append(no.getProfundidade() + " | " + no.getValor() + " |  " + no.getPai().getValor());
			if (no.getValor().equals(alvo))
			{
				mostrarArvorePai(no);
				sb2.append(" ACHOU");
			}

			//System.out.println(sb2);

		}
		for (No<String> no : root.getFilhos()) {
			if(no.getFilhos().size() > 0)
				buscar(no, alvo);
		}
	}
	private static void mostrarArvorePai(No<String> no)
	{
		if(no.getPai() != null)
		{
			mostrarArvorePai(no.getPai());
		}
			
		System.out.println(no.getValor());
		
	}

}
