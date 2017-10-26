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
public class ValoracionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VALORACION")
    private BigInteger idValoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_ID_CLIENTE")
    private BigInteger clienteIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFERTA_ID_OFERTA")
    private BigInteger ofertaIdOferta;

    public ValoracionPK() {
    }

    public ValoracionPK(BigInteger idValoracion, BigInteger clienteIdCliente, BigInteger ofertaIdOferta) {
        this.idValoracion = idValoracion;
        this.clienteIdCliente = clienteIdCliente;
        this.ofertaIdOferta = ofertaIdOferta;
    }

    public BigInteger getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(BigInteger idValoracion) {
        this.idValoracion = idValoracion;
    }

    public BigInteger getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(BigInteger clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
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
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        hash += (clienteIdCliente != null ? clienteIdCliente.hashCode() : 0);
        hash += (ofertaIdOferta != null ? ofertaIdOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionPK)) {
            return false;
        }
        ValoracionPK other = (ValoracionPK) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        if ((this.clienteIdCliente == null && other.clienteIdCliente != null) || (this.clienteIdCliente != null && !this.clienteIdCliente.equals(other.clienteIdCliente))) {
            return false;
        }
        if ((this.ofertaIdOferta == null && other.ofertaIdOferta != null) || (this.ofertaIdOferta != null && !this.ofertaIdOferta.equals(other.ofertaIdOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ValoracionPK[ idValoracion=" + idValoracion + ", clienteIdCliente=" + clienteIdCliente + ", ofertaIdOferta=" + ofertaIdOferta + " ]";
    }
    
}
