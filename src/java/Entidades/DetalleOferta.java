/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Cristopher
 */
@Entity
@Table(name = "DETALLE_OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleOferta.findAll", query = "SELECT d FROM DetalleOferta d")
    , @NamedQuery(name = "DetalleOferta.findByIdDetOferta", query = "SELECT d FROM DetalleOferta d WHERE d.detalleOfertaPK.idDetOferta = :idDetOferta")
    , @NamedQuery(name = "DetalleOferta.findByProductoIdProducto", query = "SELECT d FROM DetalleOferta d WHERE d.detalleOfertaPK.productoIdProducto = :productoIdProducto")
    , @NamedQuery(name = "DetalleOferta.findByOfertaIdOferta", query = "SELECT d FROM DetalleOferta d WHERE d.detalleOfertaPK.ofertaIdOferta = :ofertaIdOferta")})
public class DetalleOferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleOfertaPK detalleOfertaPK;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferta oferta;
    @JoinColumn(name = "PRODUCTO_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public DetalleOferta() {
    }

    public DetalleOferta(DetalleOfertaPK detalleOfertaPK) {
        this.detalleOfertaPK = detalleOfertaPK;
    }

    public DetalleOferta(BigInteger idDetOferta, BigInteger productoIdProducto, BigInteger ofertaIdOferta) {
        this.detalleOfertaPK = new DetalleOfertaPK(idDetOferta, productoIdProducto, ofertaIdOferta);
    }

    public DetalleOfertaPK getDetalleOfertaPK() {
        return detalleOfertaPK;
    }

    public void setDetalleOfertaPK(DetalleOfertaPK detalleOfertaPK) {
        this.detalleOfertaPK = detalleOfertaPK;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleOfertaPK != null ? detalleOfertaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOferta)) {
            return false;
        }
        DetalleOferta other = (DetalleOferta) object;
        if ((this.detalleOfertaPK == null && other.detalleOfertaPK != null) || (this.detalleOfertaPK != null && !this.detalleOfertaPK.equals(other.detalleOfertaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleOferta[ detalleOfertaPK=" + detalleOfertaPK + " ]";
    }
    
}
