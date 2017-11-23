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
@Table(name = "USUARIOOFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariooferta.findAll", query = "SELECT u FROM Usuariooferta u")
    , @NamedQuery(name = "Usuariooferta.findByIdusuariooferta", query = "SELECT u FROM Usuariooferta u WHERE u.usuarioofertaPK.idusuariooferta = :idusuariooferta")
    , @NamedQuery(name = "Usuariooferta.findByDescripcion", query = "SELECT u FROM Usuariooferta u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "Usuariooferta.findByUsuarioIdUsuario", query = "SELECT u FROM Usuariooferta u WHERE u.usuarioofertaPK.usuarioIdUsuario = :usuarioIdUsuario")
    , @NamedQuery(name = "Usuariooferta.findByOfertaIdOferta", query = "SELECT u FROM Usuariooferta u WHERE u.usuarioofertaPK.ofertaIdOferta = :ofertaIdOferta")})
public class Usuariooferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioofertaPK usuarioofertaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferta oferta;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Usuariooferta() {
    }

    public Usuariooferta(UsuarioofertaPK usuarioofertaPK) {
        this.usuarioofertaPK = usuarioofertaPK;
    }

    public Usuariooferta(UsuarioofertaPK usuarioofertaPK, String descripcion) {
        this.usuarioofertaPK = usuarioofertaPK;
        this.descripcion = descripcion;
    }

    public Usuariooferta(BigInteger idusuariooferta, BigInteger usuarioIdUsuario, BigInteger ofertaIdOferta) {
        this.usuarioofertaPK = new UsuarioofertaPK(idusuariooferta, usuarioIdUsuario, ofertaIdOferta);
    }

    public UsuarioofertaPK getUsuarioofertaPK() {
        return usuarioofertaPK;
    }

    public void setUsuarioofertaPK(UsuarioofertaPK usuarioofertaPK) {
        this.usuarioofertaPK = usuarioofertaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioofertaPK != null ? usuarioofertaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariooferta)) {
            return false;
        }
        Usuariooferta other = (Usuariooferta) object;
        if ((this.usuarioofertaPK == null && other.usuarioofertaPK != null) || (this.usuarioofertaPK != null && !this.usuarioofertaPK.equals(other.usuarioofertaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuariooferta[ usuarioofertaPK=" + usuarioofertaPK + " ]";
    }
    
}
