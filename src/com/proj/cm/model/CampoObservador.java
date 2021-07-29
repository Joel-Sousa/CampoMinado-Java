package com.proj.cm.model;

@FunctionalInterface
public interface CampoObservador {
	public void eventoOcorreu(Campo campo, CampoEvento evento);
}
