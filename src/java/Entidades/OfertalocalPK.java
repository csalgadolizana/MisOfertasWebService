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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author LC1300XXXX
 */
@Embeddable
public class OfertalocalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOFERTALOCAL")
    private BigInteger idofertalocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFERTA_ID_OFERTA")
    private BigInteger ofertaIdOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCAL_ID_LOCAL")
    private BigInteger localIdLocal;

    public OfertalocalPK() {
    }

    public OfertalocalPK(BigInteger idofertalocal, BigInteger ofertaIdOferta, BigInteger localIdLocal) {
        this.idofertalocal = idofertalocal;
        this.ofertaIdOferta = ofertaIdOferta;
        this.localIdLocal = localIdLocal;
    }

    public BigInteger getIdofertalocal() {
        return idofertalocal;
    }

    public void setIdofertalocal(BigInteger idofertalocal) {
        this.idofertalocal = idofertalocal;
    }

    public BigInteger getOfertaIdOferta() {
        return ofertaIdOferta;
    }

    public void setOfertaIdOferta(BigInteger ofertaIdOferta) {
        this.ofertaIdOferta = ofertaIdOferta;
    }

    public BigInteger getLocalIdLocal() {
        return localIdLocal;
    }

    public void setLocalIdLocal(BigInteger localIdLocal) {
        this.localIdLocal = localIdLocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idofertalocal != null ? idofertalocal.hashCode() : 0);
        hash += (ofertaIdOferta != null ? ofertaIdOferta.hashCode() : 0);
        hash += (localIdLocal != null ? localIdLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertalocalPK)) {
            return false;
        }
        OfertalocalPK other = (OfertalocalPK) object;
        if ((this.idofertalocal == null && other.idofertalocal != null) || (this.idofertalocal != null && !this.idofertalocal.equals(other.idofertalocal))) {
            return false;
        }
        if ((this.ofertaIdOferta == null && other.ofertaIdOferta != null) || (this.ofertaIdOferta != null && !this.ofertaIdOferta.equals(other.ofertaIdOferta))) {
            return false;
        }
        if ((this.localIdLocal == null && other.localIdLocal != null) || (this.localIdLocal != null && !this.localIdLocal.equals(other.localIdLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OfertalocalPK[ idofertalocal=" + idofertalocal + ", ofertaIdOferta=" + ofertaIdOferta + ", localIdLocal=" + localIdLocal + " ]";
    }
    
}
