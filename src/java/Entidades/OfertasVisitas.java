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
@Table(name = "OFERTAS_VISITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertasVisitas.findAll", query = "SELECT o FROM OfertasVisitas o")
    , @NamedQuery(name = "OfertasVisitas.findByIdOfertasVisitas", query = "SELECT o FROM OfertasVisitas o WHERE o.idOfertasVisitas = :idOfertasVisitas")
    , @NamedQuery(name = "OfertasVisitas.findByFechaVisita", query = "SELECT o FROM OfertasVisitas o WHERE o.fechaVisita = :fechaVisita")})
public class OfertasVisitas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OFERTAS_VISITAS")
    private BigDecimal idOfertasVisitas;
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente clienteIdCliente;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA")
    @ManyToOne
    private Oferta ofertaIdOferta;

    public OfertasVisitas() {
    }

    public OfertasVisitas(BigDecimal idOfertasVisitas) {
        this.idOfertasVisitas = idOfertasVisitas;
    }

    public BigDecimal getIdOfertasVisitas() {
        return idOfertasVisitas;
    }

    public void setIdOfertasVisitas(BigDecimal idOfertasVisitas) {
        this.idOfertasVisitas = idOfertasVisitas;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Oferta getOfertaIdOferta() {
        return ofertaIdOferta;
    }

    public void setOfertaIdOferta(Oferta ofertaIdOferta) {
        this.ofertaIdOferta = ofertaIdOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertasVisitas != null ? idOfertasVisitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertasVisitas)) {
            return false;
        }
        OfertasVisitas other = (OfertasVisitas) object;
        if ((this.idOfertasVisitas == null && other.idOfertasVisitas != null) || (this.idOfertasVisitas != null && !this.idOfertasVisitas.equals(other.idOfertasVisitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OfertasVisitas[ idOfertasVisitas=" + idOfertasVisitas + " ]";
    }
    
}
