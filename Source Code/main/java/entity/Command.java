package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Table;
@Entity
@Table(name = "commande",catalog="gvente")
public class Command {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codeCmd",updatable = false, nullable = false)
	private Integer codeCmd;
	@Column(name="client")
    private String client;
	@Column(name="qteCmd")
    private Integer qteCmd;
	@Column(name="dateCmd")
    private Date dateCmd;
	@Column(name="codeArt")
    private Integer codeArt;
	@Column(name="PrixTotal")
	private Integer PrixTotal;

	//Getter et Setters

	public Integer getPrixTotal() {
		return PrixTotal;
	}

	public void setPrixTotal(Integer prixTotal) {
		PrixTotal = prixTotal;
	}

	public Integer getCodeCmd() {
        return codeCmd;
    }

    public void setCodeCmd(Integer id) {
        this.codeCmd = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

	public Integer getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(Integer qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Integer getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(Integer codeArt) {
		this.codeArt = codeArt;
	}

   
}
