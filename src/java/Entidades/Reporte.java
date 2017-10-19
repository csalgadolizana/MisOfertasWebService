/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Cristopher
 */
@Entity
@Table(name = "REPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")
    , @NamedQuery(name = "Reporte.findByIdReporte", query = "SELECT r FROM Reporte r WHERE r.idReporte = :idReporte")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPORTE")
    private BigDecimal idReporte;
    @JoinColumn(name = "LOCAL_ID_LOCAL", referencedColumnName = "ID_LOCAL")
    @ManyToOne(optional = false)
    private Local localIdLocal;

    public Reporte() {
    }

    public Reporte(BigDecimal idReporte) {
        this.idReporte = idReporte;
    }

    public BigDecimal getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(BigDecimal idReporte) {
        this.idReporte = idReporte;
    }

    public Local getLocalIdLocal() {
        return localIdLocal;
    }

    public void setLocalIdLocal(Local localIdLocal) {
        this.localIdLocal = localIdLocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporte != null ? idReporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idReporte == null && other.idReporte != null) || (this.idReporte != null && !this.idReporte.equals(other.idReporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Reporte[ idReporte=" + idReporte + " ]";
    }
    
}
