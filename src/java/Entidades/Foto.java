/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LC1300XXXX
 */
@Entity
@Table(name = "FOTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foto.findAll", query = "SELECT f FROM Foto f")
    , @NamedQuery(name = "Foto.findByIdFoto", query = "SELECT f FROM Foto f WHERE f.idFoto = :idFoto")
    , @NamedQuery(name = "Foto.findByLinkFoto", query = "SELECT f FROM Foto f WHERE f.linkFoto = :linkFoto")})
public class Foto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FOTO")
    private BigDecimal idFoto;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "LINK_FOTO")
    private String linkFoto;

    public Foto() {
    }

    public Foto(BigDecimal idFoto) {
        this.idFoto = idFoto;
    }

    public BigDecimal getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(BigDecimal idFoto) {
        this.idFoto = idFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFoto != null ? idFoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foto)) {
            return false;
        }
        Foto other = (Foto) object;
        if ((this.idFoto == null && other.idFoto != null) || (this.idFoto != null && !this.idFoto.equals(other.idFoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Foto[ idFoto=" + idFoto + " ]";
    }
    
}
