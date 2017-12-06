package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sprint")
public class Sprint implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String typeSprint;
	private int duree;
	private int nbrPersonnes;
	private int nbrPoints;
	private int nbrAnomalies;
	private int charge;
	private double velocity;
	private double anomaly;
	
	
	

	
	
	public Sprint(String typeSprint, int duree, int nbrPersonnes, int nbrPoints, int nbrAnomalies, int charge,
			double velocity, double anomaly) {
		super();
		this.typeSprint = typeSprint;
		this.duree = duree;
		this.nbrPersonnes = nbrPersonnes;
		this.nbrPoints = nbrPoints;
		this.nbrAnomalies = nbrAnomalies;
		this.charge = charge;
		this.velocity = velocity;
		this.anomaly = anomaly;
	}


	public Sprint() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNbrPersonnes() {
		return nbrPersonnes;
	}

	public void setNbrPersonnes(int nbrPersonnes) {
		this.nbrPersonnes = nbrPersonnes;
	}

	public int getNbrPoints() {
		return nbrPoints;
	}

	public void setNbrPoints(int nbrPoints) {
		this.nbrPoints = nbrPoints;
	}

	public int getNbrAnomalies() {
		return nbrAnomalies;
	}

	public void setNbrAnomalies(int nbrAnomalies) {
		this.nbrAnomalies = nbrAnomalies;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getAnomaly() {
		return anomaly;
	}

	public void setAnomaly(double anomaly) {
		this.anomaly = anomaly;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTypeSprint() {
		return typeSprint;
	}

	public void setTypeSprint(String typeSprint) {
		this.typeSprint = typeSprint;
	}
	

}
