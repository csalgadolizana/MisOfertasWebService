/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "DESCUENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d")
    , @NamedQuery(name = "Descuento.findByIdDescuento", query = "SELECT d FROM Descuento d WHERE d.descuentoPK.idDescuento = :idDescuento")
    , @NamedQuery(name = "Descuento.findByCodigo", query = "SELECT d FROM Descuento d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Descuento.findByTope", query = "SELECT d FROM Descuento d WHERE d.tope = :tope")
    , @NamedQuery(name = "Descuento.findByValor", query = "SELECT d FROM Descuento d WHERE d.descuentoPK.valor = :valor")
    , @NamedQuery(name = "Descuento.findByPuntosUsados", query = "SELECT d FROM Descuento d WHERE d.puntosUsados = :puntosUsados")
    , @NamedQuery(name = "Descuento.findByInicio", query = "SELECT d FROM Descuento d WHERE d.inicio = :inicio")
    , @NamedQuery(name = "Descuento.findByActualizacion", query = "SELECT d FROM Descuento d WHERE d.actualizacion = :actualizacion")
    , @NamedQuery(name = "Descuento.findByEstadoIdEstado", query = "SELECT d FROM Descuento d WHERE d.descuentoPK.estadoIdEstado = :estadoIdEstado")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DescuentoPK descuentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOPE")
    private BigInteger tope;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUNTOS_USADOS")
    private BigInteger puntosUsados;
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descuento")
    private Collection<CargarPuntos> cargarPuntosCollection;
    @JoinColumn(name = "CATEGORIA_ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria categoriaIdCategoria;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @JoinColumn(name = "ESTADO_ID_ESTADO", referencedColumnName = "ID_ESTADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estado estado;

    public Descuento() {
    }

    public Descuento(DescuentoPK descuentoPK) {
        this.descuentoPK = descuentoPK;
    }

    public Descuento(DescuentoPK descuentoPK, String codigo, BigInteger tope, BigInteger puntosUsados) {
        this.descuentoPK = descuentoPK;
        this.codigo = codigo;
        this.tope = tope;
        this.puntosUsados = puntosUsados;
    }

    public Descuento(BigInteger idDescuento, BigInteger valor, BigInteger estadoIdEstado) {
        this.descuentoPK = new DescuentoPK(idDescuento, valor, estadoIdEstado);
    }

    public DescuentoPK getDescuentoPK() {
        return descuentoPK;
    }

    public void setDescuentoPK(DescuentoPK descuentoPK) {
        this.descuentoPK = descuentoPK;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigInteger getTope() {
        return tope;
    }

    public void setTope(BigInteger tope) {
        this.tope = tope;
    }

    public BigInteger getPuntosUsados() {
        return puntosUsados;
    }

    public void setPuntosUsados(BigInteger puntosUsados) {
        this.puntosUsados = puntosUsados;
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
    public Collection<CargarPuntos> getCargarPuntosCollection() {
        return cargarPuntosCollection;
    }

    public void setCargarPuntosCollection(Collection<CargarPuntos> cargarPuntosCollection) {
        this.cargarPuntosCollection = cargarPuntosCollection;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descuentoPK != null ? descuentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.descuentoPK == null && other.descuentoPK != null) || (this.descuentoPK != null && !this.descuentoPK.equals(other.descuentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Descuento[ descuentoPK=" + descuentoPK + " ]";
    }
    
}
