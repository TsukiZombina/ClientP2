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
@Table(name = "museo", catalog = "practica2sd", schema = "")
@NamedQueries({
    @NamedQuery(name = "Museo.findAll", query = "SELECT m FROM Museo m"),
    @NamedQuery(name = "Museo.findByIdmuseo", query = "SELECT m FROM Museo m WHERE m.idmuseo = :idmuseo"),
    @NamedQuery(name = "Museo.findByMuseoNombre", query = "SELECT m FROM Museo m WHERE m.museoNombre = :museoNombre"),
    @NamedQuery(name = "Museo.findByMuseoHorario", query = "SELECT m FROM Museo m WHERE m.museoHorario = :museoHorario")})
public class Museo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmuseo")
    private Integer idmuseo;
    @Column(name = "museoNombre")
    private String museoNombre;
    @Column(name = "museoHorario")
    private String museoHorario;

    public Museo() {
    }

    public Museo(Integer idmuseo) {
        this.idmuseo = idmuseo;
    }

    public Integer getIdmuseo() {
        return idmuseo;
    }

    public void setIdmuseo(Integer idmuseo) {
        Integer oldIdmuseo = this.idmuseo;
        this.idmuseo = idmuseo;
        changeSupport.firePropertyChange("idmuseo", oldIdmuseo, idmuseo);
    }

    public String getMuseoNombre() {
        return museoNombre;
    }

    public void setMuseoNombre(String museoNombre) {
        String oldMuseoNombre = this.museoNombre;
        this.museoNombre = museoNombre;
        changeSupport.firePropertyChange("museoNombre", oldMuseoNombre, museoNombre);
    }

    public String getMuseoHorario() {
        return museoHorario;
    }

    public void setMuseoHorario(String museoHorario) {
        String oldMuseoHorario = this.museoHorario;
        this.museoHorario = museoHorario;
        changeSupport.firePropertyChange("museoHorario", oldMuseoHorario, museoHorario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmuseo != null ? idmuseo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Museo)) {
            return false;
        }
        Museo other = (Museo) object;
        if ((this.idmuseo == null && other.idmuseo != null) || (this.idmuseo != null && !this.idmuseo.equals(other.idmuseo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proyecto2.Museo[ idmuseo=" + idmuseo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
