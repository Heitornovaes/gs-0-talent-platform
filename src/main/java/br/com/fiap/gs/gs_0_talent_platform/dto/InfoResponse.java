package br.com.fiap.gs.gs_0_talent_platform.dto;

public class InfoResponse {

    private String tema;
    private String membro1;
    private String membro2;
    private String descricao;

    public InfoResponse() {
    }

    public InfoResponse(String tema, String membro1, String membro2, String descricao) {
        this.tema = tema;
        this.membro1 = membro1;
        this.membro2 = membro2;
        this.descricao = descricao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getMembro1() {
        return membro1;
    }

    public void setMembro1(String membro1) {
        this.membro1 = membro1;
    }

    public String getMembro2() {
        return membro2;
    }

    public void setMembro2(String membro2) {
        this.membro2 = membro2;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
