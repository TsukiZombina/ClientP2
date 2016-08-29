/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteP2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ammy_
 */
@Entity
@Table(name = "divisas", catalog = "practica2sd", schema = "")
@NamedQueries({
    @NamedQuery(name = "Divisas.findAll", query = "SELECT d FROM Divisas d"),
    @NamedQuery(name = "Divisas.findByIddivisas", query = "SELECT d FROM Divisas d WHERE d.iddivisas = :iddivisas"),
    @NamedQuery(name = "Divisas.findByDivisasNombre", query = "SELECT d FROM Divisas d WHERE d.divisasNombre = :divisasNombre"),
    @NamedQuery(name = "Divisas.findByDivisasValorDolar", query = "SELECT d FROM Divisas d WHERE d.divisasValorDolar = :divisasValorDolar")})
public class Divisas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddivisas")
    private Integer iddivisas;
    @Column(name = "divisasNombre")
    private String divisasNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "divisasValorDolar")
    private Double divisasValorDolar;

    public Divisas() {
    }

    public Divisas(Integer iddivisas) {
        this.iddivisas = iddivisas;
    }

    public Integer getIddivisas() {
        return iddivisas;
    }

    public void setIddivisas(Integer iddivisas) {
        Integer oldIddivisas = this.iddivisas;
        this.iddivisas = iddivisas;
        changeSupport.firePropertyChange("iddivisas", oldIddivisas, iddivisas);
    }

    public String getDivisasNombre() {
        return divisasNombre;
    }

    public void setDivisasNombre(String divisasNombre) {
        String oldDivisasNombre = this.divisasNombre;
        this.divisasNombre = divisasNombre;
        changeSupport.firePropertyChange("divisasNombre", oldDivisasNombre, divisasNombre);
    }

    public Double getDivisasValorDolar() {
        return divisasValorDolar;
    }

    public void setDivisasValorDolar(Double divisasValorDolar) {
        Double oldDivisasValorDolar = this.divisasValorDolar;
        this.divisasValorDolar = divisasValorDolar;
        changeSupport.firePropertyChange("divisasValorDolar", oldDivisasValorDolar, divisasValorDolar);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddivisas != null ? iddivisas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisas)) {
            return false;
        }
        Divisas other = (Divisas) object;
        if ((this.iddivisas == null && other.iddivisas != null) || (this.iddivisas != null && !this.iddivisas.equals(other.iddivisas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteP2.Divisas[ iddivisas=" + iddivisas + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    } 
}
