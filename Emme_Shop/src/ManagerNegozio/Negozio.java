package ManagerNegozio;

public class Negozio {

	public Negozio(String nome, String design, String descrizione, String via, String citt�, int cap, String logo) {
		this.nome = nome;
		this.design = design;
		this.descrizione = descrizione;
		this.via = via;
		this.citt� = citt�;
		this.cap = cap;
		this.logo = logo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitt�() {
		return citt�;
	}
	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	private String nome;
	private String design;
	private String descrizione;
	private String via;
	private String citt�;
	private int cap;
	private String logo;

}
