/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Cristopher
 */
@Entity
@Table(name = "OFERTALOCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertalocal.findAll", query = "SELECT o FROM Ofertalocal o")
    , @NamedQuery(name = "Ofertalocal.findByIdofertalocal", query = "SELECT o FROM Ofertalocal o WHERE o.ofertalocalPK.idofertalocal = :idofertalocal")
    , @NamedQuery(name = "Ofertalocal.findByDescripcion", query = "SELECT o FROM Ofertalocal o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Ofertalocal.findByOfertaIdOferta", query = "SELECT o FROM Ofertalocal o WHERE o.ofertalocalPK.ofertaIdOferta = :ofertaIdOferta")
    , @NamedQuery(name = "Ofertalocal.findByLocalIdLocal", query = "SELECT o FROM Ofertalocal o WHERE o.ofertalocalPK.localIdLocal = :localIdLocal")})
public class Ofertalocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OfertalocalPK ofertalocalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "LOCAL_ID_LOCAL", referencedColumnName = "ID_LOCAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Local local;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferta oferta;

    public Ofertalocal() {
    }

    public Ofertalocal(OfertalocalPK ofertalocalPK) {
        this.ofertalocalPK = ofertalocalPK;
    }

    public Ofertalocal(OfertalocalPK ofertalocalPK, String descripcion) {
        this.ofertalocalPK = ofertalocalPK;
        this.descripcion = descripcion;
    }

    public Ofertalocal(BigInteger idofertalocal, BigInteger ofertaIdOferta, BigInteger localIdLocal) {
        this.ofertalocalPK = new OfertalocalPK(idofertalocal, ofertaIdOferta, localIdLocal);
    }

    public OfertalocalPK getOfertalocalPK() {
        return ofertalocalPK;
    }

    public void setOfertalocalPK(OfertalocalPK ofertalocalPK) {
        this.ofertalocalPK = ofertalocalPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofertalocalPK != null ? ofertalocalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertalocal)) {
            return false;
        }
        Ofertalocal other = (Ofertalocal) object;
        if ((this.ofertalocalPK == null && other.ofertalocalPK != null) || (this.ofertalocalPK != null && !this.ofertalocalPK.equals(other.ofertalocalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ofertalocal[ ofertalocalPK=" + ofertalocalPK + " ]";
    }
    
}
