/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2;

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
@Table(name = "ciudad", catalog = "practica2sd", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdciudad", query = "SELECT c FROM Ciudad c WHERE c.idciudad = :idciudad"),
    @NamedQuery(name = "Ciudad.findByCiudadNombre", query = "SELECT c FROM Ciudad c WHERE c.ciudadNombre = :ciudadNombre"),
    @NamedQuery(name = "Ciudad.findByCiudadClima", query = "SELECT c FROM Ciudad c WHERE c.ciudadClima = :ciudadClima"),
    @NamedQuery(name = "Ciudad.findByDivisasIddivisas", query = "SELECT c FROM Ciudad c WHERE c.divisasIddivisas = :divisasIddivisas"),
    @NamedQuery(name = "Ciudad.findByCiudadTimeZone", query = "SELECT c FROM Ciudad c WHERE c.ciudadTimeZone = :ciudadTimeZone")})
public class Ciudad implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idciudad")
    private Integer idciudad;
    @Column(name = "ciudadNombre")
    private String ciudadNombre;
    @Column(name = "ciudadClima")
    private String ciudadClima;
    @Basic(optional = false)
    @Column(name = "divisas_iddivisas")
    private int divisasIddivisas;
    @Column(name = "ciudadTimeZone")
    private String ciudadTimeZone;

    public Ciudad() {
    }

    public Ciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public Ciudad(Integer idciudad, int divisasIddivisas) {
        this.idciudad = idciudad;
        this.divisasIddivisas = divisasIddivisas;
    }

    public Integer getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Integer idciudad) {
        Integer oldIdciudad = this.idciudad;
        this.idciudad = idciudad;
        changeSupport.firePropertyChange("idciudad", oldIdciudad, idciudad);
    }

    public String getCiudadNombre() {
        return ciudadNombre;
    }

    public void setCiudadNombre(String ciudadNombre) {
        String oldCiudadNombre = this.ciudadNombre;
        this.ciudadNombre = ciudadNombre;
        changeSupport.firePropertyChange("ciudadNombre", oldCiudadNombre, ciudadNombre);
    }

    public String getCiudadClima() {
        return ciudadClima;
    }

    public void setCiudadClima(String ciudadClima) {
        String oldCiudadClima = this.ciudadClima;
        this.ciudadClima = ciudadClima;
        changeSupport.firePropertyChange("ciudadClima", oldCiudadClima, ciudadClima);
    }

    public int getDivisasIddivisas() {
        return divisasIddivisas;
    }

    public void setDivisasIddivisas(int divisasIddivisas) {
        int oldDivisasIddivisas = this.divisasIddivisas;
        this.divisasIddivisas = divisasIddivisas;
        changeSupport.firePropertyChange("divisasIddivisas", oldDivisasIddivisas, divisasIddivisas);
    }

    public String getCiudadTimeZone() {
        return ciudadTimeZone;
    }

    public void setCiudadTimeZone(String ciudadTimeZone) {
        String oldCiudadTimeZone = this.ciudadTimeZone;
        this.ciudadTimeZone = ciudadTimeZone;
        changeSupport.firePropertyChange("ciudadTimeZone", oldCiudadTimeZone, ciudadTimeZone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idciudad != null ? idciudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idciudad == null && other.idciudad != null) || (this.idciudad != null && !this.idciudad.equals(other.idciudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteP2.Ciudad[ idciudad=" + idciudad + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
