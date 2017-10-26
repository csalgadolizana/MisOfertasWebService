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
 * @author LC1300XXXX
 */
@Entity
@Table(name = "DETALLE_NEWSLETTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleNewsletter.findAll", query = "SELECT d FROM DetalleNewsletter d")
    , @NamedQuery(name = "DetalleNewsletter.findByIdDetNewsletter", query = "SELECT d FROM DetalleNewsletter d WHERE d.idDetNewsletter = :idDetNewsletter")})
public class DetalleNewsletter implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DET_NEWSLETTER")
    private BigDecimal idDetNewsletter;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA")
    @ManyToOne
    private Oferta ofertaIdOferta;

    public DetalleNewsletter() {
    }

    public DetalleNewsletter(BigDecimal idDetNewsletter) {
        this.idDetNewsletter = idDetNewsletter;
    }

    public BigDecimal getIdDetNewsletter() {
        return idDetNewsletter;
    }

    public void setIdDetNewsletter(BigDecimal idDetNewsletter) {
        this.idDetNewsletter = idDetNewsletter;
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
        hash += (idDetNewsletter != null ? idDetNewsletter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleNewsletter)) {
            return false;
        }
        DetalleNewsletter other = (DetalleNewsletter) object;
        if ((this.idDetNewsletter == null && other.idDetNewsletter != null) || (this.idDetNewsletter != null && !this.idDetNewsletter.equals(other.idDetNewsletter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleNewsletter[ idDetNewsletter=" + idDetNewsletter + " ]";
    }
    
}
