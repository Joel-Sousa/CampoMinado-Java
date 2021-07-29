package com.proj.cm.view;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.proj.cm.model.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{
	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.paraCadaCampo(e -> add(new BotaoCampo(e)));
		tabuleiro.registrarObservadores(e ->{
			
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou())
					JOptionPane.showMessageDialog(this, "Ganhou :)");
				else
					JOptionPane.showMessageDialog(this, "Perdeu :(");
				
				tabuleiro.reiniciar();
			});
		});
	}

}
