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
@Table(name = "INFORMATIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informativo.findAll", query = "SELECT i FROM Informativo i")
    , @NamedQuery(name = "Informativo.findByIdInformativo", query = "SELECT i FROM Informativo i WHERE i.idInformativo = :idInformativo")})
public class Informativo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFORMATIVO")
    private BigDecimal idInformativo;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA")
    @ManyToOne(optional = false)
    private Oferta ofertaIdOferta;

    public Informativo() {
    }

    public Informativo(BigDecimal idInformativo) {
        this.idInformativo = idInformativo;
    }

    public BigDecimal getIdInformativo() {
        return idInformativo;
    }

    public void setIdInformativo(BigDecimal idInformativo) {
        this.idInformativo = idInformativo;
    }

    public Oferta getOfertaIdOferta() {
        return ofertaIdOferta;
    }

    public void setOfertaIdOferta(Oferta ofertaIdOferta) {
        this.ofertaIdOferta = ofertaIdOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformativo != null ? idInformativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informativo)) {
            return false;
        }
        Informativo other = (Informativo) object;
        if ((this.idInformativo == null && other.idInformativo != null) || (this.idInformativo != null && !this.idInformativo.equals(other.idInformativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Informativo[ idInformativo=" + idInformativo + " ]";
    }
    
}
