package manageraccouting;

import java.sql.SQLException;

import dao.VenditoreDAO;
import eccezione.ParametroNonCorrettoException;
import eccezione.UtenteNonTrovatoException;

public class Venditore extends Utente {

	private static final long serialVersionUID = 1L;
	
	static VenditoreDAO model= new VenditoreDAO();
	
	private String nome;
	private String cognome;
	private String email;
	private String sesso;
	private String telefono;
	private String via;
	private String citta;
	private String cap;
	
	public Venditore()
	{
		super();
		this.nome = "";
		this.cognome = "";
		this.email = "";
		this.sesso = "";
		this.telefono = "";
		this.via = "";
		this.citta = "";
		this.cap = "";
	}
	
	public Venditore(String username, String password, String nome, String cognome, String email, String sesso,
			String telefono, String via, String citta, String cap)
	{
		super(username, password);
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.telefono = telefono;
		this.via = via;
		this.citta = citta;
		this.cap = cap;
	}

	
	/**
	 * verifica se i dati inseriti corrispondono ad un utente nel database
	 * 
	 * @param username
	 * @param password
	 * @return Utente Ritorna un istanza utente
	 * @throws SQLException
	 * @throws UtenteNonTrovatoException 
	 * @throws ParametroNonCorrettoException 
	 */
	public Utente checkLogin(String username, String password) throws SQLException, UtenteNonTrovatoException, ParametroNonCorrettoException {
			if(username==null || password==null)
				throw new ParametroNonCorrettoException("Username e Password inseriti errati");
			
			Utente utente= model.checkLoginSeller(username, password);
			
			if(utente==null)
				throw new UtenteNonTrovatoException("Venditore non trovato, non esiste");
			else 
				return utente;
	}
	
	/**
	 * Crea un nuovo venditore, i parametri sono controllati da javascript e espressioni regolari direttamente all'inserimento.
	 * @param username
	 * @param password
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param sesso
	 * @param telefono
	 * @param via
	 * @param citta
	 * @param cap
	 * @return Venditore conferma avvenuta creazione e aggiunta al database
	 * @throws SQLException
	 */
	public Venditore addVenditore(String username, String password, String nome, String cognome, String email, String sesso,
			String telefono, String via, String citta, String cap) throws SQLException {
			
		Venditore venditore=new Venditore(username, password, nome, cognome, email, sesso, telefono, via, citta,  cap);
		try {
			model.addVenditore(venditore);
			return venditore;
		}
		catch(SQLException e) {
			throw new SQLException("Creazione venditore fallita, errore: "+e.getMessage());
		}
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	
	
	
}
