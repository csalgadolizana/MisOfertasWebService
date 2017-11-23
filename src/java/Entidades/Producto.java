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
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByInicio", query = "SELECT p FROM Producto p WHERE p.inicio = :inicio")
    , @NamedQuery(name = "Producto.findByActualizacion", query = "SELECT p FROM Producto p WHERE p.actualizacion = :actualizacion")
    , @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private BigInteger precio;
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "IMAGEN")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<DetalleOferta> detalleOfertaCollection;
    @JoinColumn(name = "CATEGORIA_ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria categoriaIdCategoria;

    public Producto() {
    }

    public Producto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(BigDecimal idProducto, String nombre, String descripcion, BigInteger precio, String imagen) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
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

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<DetalleOferta> getDetalleOfertaCollection() {
        return detalleOfertaCollection;
    }

    public void setDetalleOfertaCollection(Collection<DetalleOferta> detalleOfertaCollection) {
        this.detalleOfertaCollection = detalleOfertaCollection;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
