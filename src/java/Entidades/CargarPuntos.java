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
import javax.persistence.JoinColumns;
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
@Table(name = "CARGAR_PUNTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargarPuntos.findAll", query = "SELECT c FROM CargarPuntos c")
    , @NamedQuery(name = "CargarPuntos.findByIdCargarPuntos", query = "SELECT c FROM CargarPuntos c WHERE c.cargarPuntosPK.idCargarPuntos = :idCargarPuntos")
    , @NamedQuery(name = "CargarPuntos.findByPuntos", query = "SELECT c FROM CargarPuntos c WHERE c.puntos = :puntos")
    , @NamedQuery(name = "CargarPuntos.findByPuntosIdPuntos", query = "SELECT c FROM CargarPuntos c WHERE c.cargarPuntosPK.puntosIdPuntos = :puntosIdPuntos")
    , @NamedQuery(name = "CargarPuntos.findByDescuentoIdDescuento", query = "SELECT c FROM CargarPuntos c WHERE c.cargarPuntosPK.descuentoIdDescuento = :descuentoIdDescuento")
    , @NamedQuery(name = "CargarPuntos.findByDescuentoValor", query = "SELECT c FROM CargarPuntos c WHERE c.cargarPuntosPK.descuentoValor = :descuentoValor")
    , @NamedQuery(name = "CargarPuntos.findByDescuentoEstadoIdEstado", query = "SELECT c FROM CargarPuntos c WHERE c.cargarPuntosPK.descuentoEstadoIdEstado = :descuentoEstadoIdEstado")})
public class CargarPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CargarPuntosPK cargarPuntosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUNTOS")
    private BigInteger puntos;
    @JoinColumns({
        @JoinColumn(name = "DESCUENTO_ID_DESCUENTO", referencedColumnName = "ID_DESCUENTO", insertable = false, updatable = false)
        , @JoinColumn(name = "DESCUENTO_VALOR", referencedColumnName = "VALOR", insertable = false, updatable = false)
        , @JoinColumn(name = "DESCUENTO_ESTADO_ID_ESTADO", referencedColumnName = "ESTADO_ID_ESTADO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Descuento descuento;
    @JoinColumn(name = "PUNTOS_ID_PUNTOS", referencedColumnName = "ID_PUNTOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Puntos puntos1;

    public CargarPuntos() {
    }

    public CargarPuntos(CargarPuntosPK cargarPuntosPK) {
        this.cargarPuntosPK = cargarPuntosPK;
    }

    public CargarPuntos(CargarPuntosPK cargarPuntosPK, BigInteger puntos) {
        this.cargarPuntosPK = cargarPuntosPK;
        this.puntos = puntos;
    }

    public CargarPuntos(BigInteger idCargarPuntos, BigInteger puntosIdPuntos, BigInteger descuentoIdDescuento, BigInteger descuentoValor, BigInteger descuentoEstadoIdEstado) {
        this.cargarPuntosPK = new CargarPuntosPK(idCargarPuntos, puntosIdPuntos, descuentoIdDescuento, descuentoValor, descuentoEstadoIdEstado);
    }

    public CargarPuntosPK getCargarPuntosPK() {
        return cargarPuntosPK;
    }

    public void setCargarPuntosPK(CargarPuntosPK cargarPuntosPK) {
        this.cargarPuntosPK = cargarPuntosPK;
    }

    public BigInteger getPuntos() {
        return puntos;
    }

    public void setPuntos(BigInteger puntos) {
        this.puntos = puntos;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public Puntos getPuntos1() {
        return puntos1;
    }

    public void setPuntos1(Puntos puntos1) {
        this.puntos1 = puntos1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargarPuntosPK != null ? cargarPuntosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargarPuntos)) {
            return false;
        }
        CargarPuntos other = (CargarPuntos) object;
        if ((this.cargarPuntosPK == null && other.cargarPuntosPK != null) || (this.cargarPuntosPK != null && !this.cargarPuntosPK.equals(other.cargarPuntosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CargarPuntos[ cargarPuntosPK=" + cargarPuntosPK + " ]";
    }
    
}
