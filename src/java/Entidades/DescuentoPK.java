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
public class DescuentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DESCUENTO")
    private BigInteger idDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigInteger valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_ID_ESTADO")
    private BigInteger estadoIdEstado;

    public DescuentoPK() {
    }

    public DescuentoPK(BigInteger idDescuento, BigInteger valor, BigInteger estadoIdEstado) {
        this.idDescuento = idDescuento;
        this.valor = valor;
        this.estadoIdEstado = estadoIdEstado;
    }

    public BigInteger getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(BigInteger idDescuento) {
        this.idDescuento = idDescuento;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public BigInteger getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(BigInteger estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescuento != null ? idDescuento.hashCode() : 0);
        hash += (valor != null ? valor.hashCode() : 0);
        hash += (estadoIdEstado != null ? estadoIdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoPK)) {
            return false;
        }
        DescuentoPK other = (DescuentoPK) object;
        if ((this.idDescuento == null && other.idDescuento != null) || (this.idDescuento != null && !this.idDescuento.equals(other.idDescuento))) {
            return false;
        }
        if ((this.valor == null && other.valor != null) || (this.valor != null && !this.valor.equals(other.valor))) {
            return false;
        }
        if ((this.estadoIdEstado == null && other.estadoIdEstado != null) || (this.estadoIdEstado != null && !this.estadoIdEstado.equals(other.estadoIdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DescuentoPK[ idDescuento=" + idDescuento + ", valor=" + valor + ", estadoIdEstado=" + estadoIdEstado + " ]";
    }
    
}
