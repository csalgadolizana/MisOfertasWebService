/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LC1300XXXX
 */
@Entity
@Table(name = "INFORME_BI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformeBi.findAll", query = "SELECT i FROM InformeBi i")
    , @NamedQuery(name = "InformeBi.findByIdInformeBi", query = "SELECT i FROM InformeBi i WHERE i.idInformeBi = :idInformeBi")
    , @NamedQuery(name = "InformeBi.findByFechaCreacion", query = "SELECT i FROM InformeBi i WHERE i.fechaCreacion = :fechaCreacion")})
public class InformeBi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFORME_BI")
    private BigDecimal idInformeBi;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario usuarioIdUsuario;

    public InformeBi() {
    }

    public InformeBi(BigDecimal idInformeBi) {
        this.idInformeBi = idInformeBi;
    }

    public BigDecimal getIdInformeBi() {
        return idInformeBi;
    }

    public void setIdInformeBi(BigDecimal idInformeBi) {
        this.idInformeBi = idInformeBi;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformeBi != null ? idInformeBi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformeBi)) {
            return false;
        }
        InformeBi other = (InformeBi) object;
        if ((this.idInformeBi == null && other.idInformeBi != null) || (this.idInformeBi != null && !this.idInformeBi.equals(other.idInformeBi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.InformeBi[ idInformeBi=" + idInformeBi + " ]";
    }
    
}
