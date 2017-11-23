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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC-Cristopher
 */
@Entity
@Table(name = "PUNTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntos.findAll", query = "SELECT p FROM Puntos p")
    , @NamedQuery(name = "Puntos.findByIdPuntos", query = "SELECT p FROM Puntos p WHERE p.idPuntos = :idPuntos")
    , @NamedQuery(name = "Puntos.findByTotalPuntos", query = "SELECT p FROM Puntos p WHERE p.totalPuntos = :totalPuntos")
    , @NamedQuery(name = "Puntos.findByFechaActualizacion", query = "SELECT p FROM Puntos p WHERE p.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Puntos.findByPuntosCanjeados", query = "SELECT p FROM Puntos p WHERE p.puntosCanjeados = :puntosCanjeados")})
public class Puntos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PUNTOS")
    private BigDecimal idPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_PUNTOS")
    private BigInteger totalPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUNTOS_CANJEADOS")
    private BigInteger puntosCanjeados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntos1")
    private Collection<CargarPuntos> cargarPuntosCollection;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public Puntos() {
    }

    public Puntos(BigDecimal idPuntos) {
        this.idPuntos = idPuntos;
    }

    public Puntos(BigDecimal idPuntos, BigInteger totalPuntos, Date fechaActualizacion, BigInteger puntosCanjeados) {
        this.idPuntos = idPuntos;
        this.totalPuntos = totalPuntos;
        this.fechaActualizacion = fechaActualizacion;
        this.puntosCanjeados = puntosCanjeados;
    }

    public BigDecimal getIdPuntos() {
        return idPuntos;
    }

    public void setIdPuntos(BigDecimal idPuntos) {
        this.idPuntos = idPuntos;
    }

    public BigInteger getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(BigInteger totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public BigInteger getPuntosCanjeados() {
        return puntosCanjeados;
    }

    public void setPuntosCanjeados(BigInteger puntosCanjeados) {
        this.puntosCanjeados = puntosCanjeados;
    }

    @XmlTransient
    public Collection<CargarPuntos> getCargarPuntosCollection() {
        return cargarPuntosCollection;
    }

    public void setCargarPuntosCollection(Collection<CargarPuntos> cargarPuntosCollection) {
        this.cargarPuntosCollection = cargarPuntosCollection;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuntos != null ? idPuntos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntos)) {
            return false;
        }
        Puntos other = (Puntos) object;
        if ((this.idPuntos == null && other.idPuntos != null) || (this.idPuntos != null && !this.idPuntos.equals(other.idPuntos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Puntos[ idPuntos=" + idPuntos + " ]";
    }
    
}
