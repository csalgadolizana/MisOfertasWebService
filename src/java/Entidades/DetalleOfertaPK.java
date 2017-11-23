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
 * @author PC-Cristopher
 */
@Embeddable
public class DetalleOfertaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DET_OFERTA")
    private BigInteger idDetOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO_ID_PRODUCTO")
    private BigInteger productoIdProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFERTA_ID_OFERTA")
    private BigInteger ofertaIdOferta;

    public DetalleOfertaPK() {
    }

    public DetalleOfertaPK(BigInteger idDetOferta, BigInteger productoIdProducto, BigInteger ofertaIdOferta) {
        this.idDetOferta = idDetOferta;
        this.productoIdProducto = productoIdProducto;
        this.ofertaIdOferta = ofertaIdOferta;
    }

    public BigInteger getIdDetOferta() {
        return idDetOferta;
    }

    public void setIdDetOferta(BigInteger idDetOferta) {
        this.idDetOferta = idDetOferta;
    }

    public BigInteger getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(BigInteger productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    public BigInteger getOfertaIdOferta() {
        return ofertaIdOferta;
    }

    public void setOfertaIdOferta(BigInteger ofertaIdOferta) {
        this.ofertaIdOferta = ofertaIdOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetOferta != null ? idDetOferta.hashCode() : 0);
        hash += (productoIdProducto != null ? productoIdProducto.hashCode() : 0);
        hash += (ofertaIdOferta != null ? ofertaIdOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOfertaPK)) {
            return false;
        }
        DetalleOfertaPK other = (DetalleOfertaPK) object;
        if ((this.idDetOferta == null && other.idDetOferta != null) || (this.idDetOferta != null && !this.idDetOferta.equals(other.idDetOferta))) {
            return false;
        }
        if ((this.productoIdProducto == null && other.productoIdProducto != null) || (this.productoIdProducto != null && !this.productoIdProducto.equals(other.productoIdProducto))) {
            return false;
        }
        if ((this.ofertaIdOferta == null && other.ofertaIdOferta != null) || (this.ofertaIdOferta != null && !this.ofertaIdOferta.equals(other.ofertaIdOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleOfertaPK[ idDetOferta=" + idDetOferta + ", productoIdProducto=" + productoIdProducto + ", ofertaIdOferta=" + ofertaIdOferta + " ]";
    }
    
}
