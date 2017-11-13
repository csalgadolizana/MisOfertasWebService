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
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta")
    , @NamedQuery(name = "Oferta.findByNombre", query = "SELECT o FROM Oferta o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Oferta.findByDescripcion", query = "SELECT o FROM Oferta o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Oferta.findByPrecioNormal", query = "SELECT o FROM Oferta o WHERE o.precioNormal = :precioNormal")
    , @NamedQuery(name = "Oferta.findByPrecioOferta", query = "SELECT o FROM Oferta o WHERE o.precioOferta = :precioOferta")
    , @NamedQuery(name = "Oferta.findByNumeroVisitas", query = "SELECT o FROM Oferta o WHERE o.numeroVisitas = :numeroVisitas")
    , @NamedQuery(name = "Oferta.findByMinimoCompra", query = "SELECT o FROM Oferta o WHERE o.minimoCompra = :minimoCompra")
    , @NamedQuery(name = "Oferta.findByMaximoCompra", query = "SELECT o FROM Oferta o WHERE o.maximoCompra = :maximoCompra")
    , @NamedQuery(name = "Oferta.findByInicio", query = "SELECT o FROM Oferta o WHERE o.inicio = :inicio")
    , @NamedQuery(name = "Oferta.findByActualizacion", query = "SELECT o FROM Oferta o WHERE o.actualizacion = :actualizacion")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OFERTA")
    private BigDecimal idOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_NORMAL")
    private BigInteger precioNormal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_OFERTA")
    private BigInteger precioOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_VISITAS")
    private BigInteger numeroVisitas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINIMO_COMPRA")
    private BigInteger minimoCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAXIMO_COMPRA")
    private BigInteger maximoCompra;
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<DetalleOferta> detalleOfertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertaIdOferta")
    private Collection<Informativo> informativoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertaIdOferta")
    private Collection<Ofertavisi> ofertavisiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<Usuariooferta> usuarioofertaCollection;
    @OneToMany(mappedBy = "ofertaIdOferta")
    private Collection<DetalleNewsletter> detalleNewsletterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<Valoracion> valoracionCollection;
    @JoinColumn(name = "ESTADO_ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private Estado estadoIdEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<Ofertalocal> ofertalocalCollection;

    public Oferta() {
    }

    public Oferta(BigDecimal idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(BigDecimal idOferta, String nombre, String descripcion, BigInteger precioNormal, BigInteger precioOferta, BigInteger numeroVisitas, BigInteger minimoCompra, BigInteger maximoCompra) {
        this.idOferta = idOferta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioNormal = precioNormal;
        this.precioOferta = precioOferta;
        this.numeroVisitas = numeroVisitas;
        this.minimoCompra = minimoCompra;
        this.maximoCompra = maximoCompra;
    }

    public BigDecimal getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(BigDecimal idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(BigInteger precioNormal) {
        this.precioNormal = precioNormal;
    }

    public BigInteger getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigInteger precioOferta) {
        this.precioOferta = precioOferta;
    }

    public BigInteger getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(BigInteger numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public BigInteger getMinimoCompra() {
        return minimoCompra;
    }

    public void setMinimoCompra(BigInteger minimoCompra) {
        this.minimoCompra = minimoCompra;
    }

    public BigInteger getMaximoCompra() {
        return maximoCompra;
    }

    public void setMaximoCompra(BigInteger maximoCompra) {
        this.maximoCompra = maximoCompra;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }

    @XmlTransient
    public Collection<DetalleOferta> getDetalleOfertaCollection() {
        return detalleOfertaCollection;
    }

    public void setDetalleOfertaCollection(Collection<DetalleOferta> detalleOfertaCollection) {
        this.detalleOfertaCollection = detalleOfertaCollection;
    }

    @XmlTransient
    public Collection<Informativo> getInformativoCollection() {
        return informativoCollection;
    }

    public void setInformativoCollection(Collection<Informativo> informativoCollection) {
        this.informativoCollection = informativoCollection;
    }

    @XmlTransient
    public Collection<Ofertavisi> getOfertavisiCollection() {
        return ofertavisiCollection;
    }

    public void setOfertavisiCollection(Collection<Ofertavisi> ofertavisiCollection) {
        this.ofertavisiCollection = ofertavisiCollection;
    }

    @XmlTransient
    public Collection<Usuariooferta> getUsuarioofertaCollection() {
        return usuarioofertaCollection;
    }

    public void setUsuarioofertaCollection(Collection<Usuariooferta> usuarioofertaCollection) {
        this.usuarioofertaCollection = usuarioofertaCollection;
    }

    @XmlTransient
    public Collection<DetalleNewsletter> getDetalleNewsletterCollection() {
        return detalleNewsletterCollection;
    }

    public void setDetalleNewsletterCollection(Collection<DetalleNewsletter> detalleNewsletterCollection) {
        this.detalleNewsletterCollection = detalleNewsletterCollection;
    }

    @XmlTransient
    public Collection<Valoracion> getValoracionCollection() {
        return valoracionCollection;
    }

    public void setValoracionCollection(Collection<Valoracion> valoracionCollection) {
        this.valoracionCollection = valoracionCollection;
    }

    public Estado getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(Estado estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    @XmlTransient
    public Collection<Ofertalocal> getOfertalocalCollection() {
        return ofertalocalCollection;
    }

    public void setOfertalocalCollection(Collection<Ofertalocal> ofertalocalCollection) {
        this.ofertalocalCollection = ofertalocalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
