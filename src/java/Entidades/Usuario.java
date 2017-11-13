/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC-Cristopher
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByFechacreado", query = "SELECT u FROM Usuario u WHERE u.fechacreado = :fechacreado")
    , @NamedQuery(name = "Usuario.findByActualizacion", query = "SELECT u FROM Usuario u WHERE u.actualizacion = :actualizacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @Column(name = "FECHACREADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreado;
    @Column(name = "ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Usuariooferta> usuarioofertaCollection;
    @OneToMany(mappedBy = "usuarioIdUsuario")
    private Collection<InformeBi> informeBiCollection;
    @JoinColumn(name = "CARGO_IDCARGO", referencedColumnName = "IDCARGO")
    @ManyToOne(optional = false)
    private Cargo cargoIdcargo;
    @JoinColumn(name = "ESTADO_ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private Estado estadoIdEstado;
    @JoinColumn(name = "PERSONA_IDPERSONA", referencedColumnName = "IDPERSONA")
    @ManyToOne(optional = false)
    private Persona personaIdpersona;

    public Usuario() {
    }

    public Usuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(BigDecimal idUsuario, String correo, String contrasena, BigInteger telefono) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public Date getFechacreado() {
        return fechacreado;
    }

    public void setFechacreado(Date fechacreado) {
        this.fechacreado = fechacreado;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }

    @XmlTransient
    public Collection<Usuariooferta> getUsuarioofertaCollection() {
        return usuarioofertaCollection;
    }

    public void setUsuarioofertaCollection(Collection<Usuariooferta> usuarioofertaCollection) {
        this.usuarioofertaCollection = usuarioofertaCollection;
    }

    @XmlTransient
    public Collection<InformeBi> getInformeBiCollection() {
        return informeBiCollection;
    }

    public void setInformeBiCollection(Collection<InformeBi> informeBiCollection) {
        this.informeBiCollection = informeBiCollection;
    }

    public Cargo getCargoIdcargo() {
        return cargoIdcargo;
    }

    public void setCargoIdcargo(Cargo cargoIdcargo) {
        this.cargoIdcargo = cargoIdcargo;
    }

    public Estado getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(Estado estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    public Persona getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(Persona personaIdpersona) {
        this.personaIdpersona = personaIdpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
