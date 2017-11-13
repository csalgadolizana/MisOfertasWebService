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
public class CargarPuntosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGAR_PUNTOS")
    private BigInteger idCargarPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUNTOS_ID_PUNTOS")
    private BigInteger puntosIdPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO_ID_DESCUENTO")
    private BigInteger descuentoIdDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO_VALOR")
    private BigInteger descuentoValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO_ESTADO_ID_ESTADO")
    private BigInteger descuentoEstadoIdEstado;

    public CargarPuntosPK() {
    }

    public CargarPuntosPK(BigInteger idCargarPuntos, BigInteger puntosIdPuntos, BigInteger descuentoIdDescuento, BigInteger descuentoValor, BigInteger descuentoEstadoIdEstado) {
        this.idCargarPuntos = idCargarPuntos;
        this.puntosIdPuntos = puntosIdPuntos;
        this.descuentoIdDescuento = descuentoIdDescuento;
        this.descuentoValor = descuentoValor;
        this.descuentoEstadoIdEstado = descuentoEstadoIdEstado;
    }

    public BigInteger getIdCargarPuntos() {
        return idCargarPuntos;
    }

    public void setIdCargarPuntos(BigInteger idCargarPuntos) {
        this.idCargarPuntos = idCargarPuntos;
    }

    public BigInteger getPuntosIdPuntos() {
        return puntosIdPuntos;
    }

    public void setPuntosIdPuntos(BigInteger puntosIdPuntos) {
        this.puntosIdPuntos = puntosIdPuntos;
    }

    public BigInteger getDescuentoIdDescuento() {
        return descuentoIdDescuento;
    }

    public void setDescuentoIdDescuento(BigInteger descuentoIdDescuento) {
        this.descuentoIdDescuento = descuentoIdDescuento;
    }

    public BigInteger getDescuentoValor() {
        return descuentoValor;
    }

    public void setDescuentoValor(BigInteger descuentoValor) {
        this.descuentoValor = descuentoValor;
    }

    public BigInteger getDescuentoEstadoIdEstado() {
        return descuentoEstadoIdEstado;
    }

    public void setDescuentoEstadoIdEstado(BigInteger descuentoEstadoIdEstado) {
        this.descuentoEstadoIdEstado = descuentoEstadoIdEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargarPuntos != null ? idCargarPuntos.hashCode() : 0);
        hash += (puntosIdPuntos != null ? puntosIdPuntos.hashCode() : 0);
        hash += (descuentoIdDescuento != null ? descuentoIdDescuento.hashCode() : 0);
        hash += (descuentoValor != null ? descuentoValor.hashCode() : 0);
        hash += (descuentoEstadoIdEstado != null ? descuentoEstadoIdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargarPuntosPK)) {
            return false;
        }
        CargarPuntosPK other = (CargarPuntosPK) object;
        if ((this.idCargarPuntos == null && other.idCargarPuntos != null) || (this.idCargarPuntos != null && !this.idCargarPuntos.equals(other.idCargarPuntos))) {
            return false;
        }
        if ((this.puntosIdPuntos == null && other.puntosIdPuntos != null) || (this.puntosIdPuntos != null && !this.puntosIdPuntos.equals(other.puntosIdPuntos))) {
            return false;
        }
        if ((this.descuentoIdDescuento == null && other.descuentoIdDescuento != null) || (this.descuentoIdDescuento != null && !this.descuentoIdDescuento.equals(other.descuentoIdDescuento))) {
            return false;
        }
        if ((this.descuentoValor == null && other.descuentoValor != null) || (this.descuentoValor != null && !this.descuentoValor.equals(other.descuentoValor))) {
            return false;
        }
        if ((this.descuentoEstadoIdEstado == null && other.descuentoEstadoIdEstado != null) || (this.descuentoEstadoIdEstado != null && !this.descuentoEstadoIdEstado.equals(other.descuentoEstadoIdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CargarPuntosPK[ idCargarPuntos=" + idCargarPuntos + ", puntosIdPuntos=" + puntosIdPuntos + ", descuentoIdDescuento=" + descuentoIdDescuento + ", descuentoValor=" + descuentoValor + ", descuentoEstadoIdEstado=" + descuentoEstadoIdEstado + " ]";
    }
    
}
