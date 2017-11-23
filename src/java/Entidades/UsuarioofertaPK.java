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
public class UsuarioofertaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIOOFERTA")
    private BigInteger idusuariooferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID_USUARIO")
    private BigInteger usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFERTA_ID_OFERTA")
    private BigInteger ofertaIdOferta;

    public UsuarioofertaPK() {
    }

    public UsuarioofertaPK(BigInteger idusuariooferta, BigInteger usuarioIdUsuario, BigInteger ofertaIdOferta) {
        this.idusuariooferta = idusuariooferta;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.ofertaIdOferta = ofertaIdOferta;
    }

    public BigInteger getIdusuariooferta() {
        return idusuariooferta;
    }

    public void setIdusuariooferta(BigInteger idusuariooferta) {
        this.idusuariooferta = idusuariooferta;
    }

    public BigInteger getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(BigInteger usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
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
        hash += (idusuariooferta != null ? idusuariooferta.hashCode() : 0);
        hash += (usuarioIdUsuario != null ? usuarioIdUsuario.hashCode() : 0);
        hash += (ofertaIdOferta != null ? ofertaIdOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioofertaPK)) {
            return false;
        }
        UsuarioofertaPK other = (UsuarioofertaPK) object;
        if ((this.idusuariooferta == null && other.idusuariooferta != null) || (this.idusuariooferta != null && !this.idusuariooferta.equals(other.idusuariooferta))) {
            return false;
        }
        if ((this.usuarioIdUsuario == null && other.usuarioIdUsuario != null) || (this.usuarioIdUsuario != null && !this.usuarioIdUsuario.equals(other.usuarioIdUsuario))) {
            return false;
        }
        if ((this.ofertaIdOferta == null && other.ofertaIdOferta != null) || (this.ofertaIdOferta != null && !this.ofertaIdOferta.equals(other.ofertaIdOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioofertaPK[ idusuariooferta=" + idusuariooferta + ", usuarioIdUsuario=" + usuarioIdUsuario + ", ofertaIdOferta=" + ofertaIdOferta + " ]";
    }
    
}
