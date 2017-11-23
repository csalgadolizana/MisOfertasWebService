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
 * @author PC-Cristopher
 */
@Entity
@Table(name = "OFERTAVISI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertavisi.findAll", query = "SELECT o FROM Ofertavisi o")
    , @NamedQuery(name = "Ofertavisi.findByFechaVisita", query = "SELECT o FROM Ofertavisi o WHERE o.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "Ofertavisi.findByIdofertav", query = "SELECT o FROM Ofertavisi o WHERE o.idofertav = :idofertav")})
public class Ofertavisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOFERTAV")
    private BigDecimal idofertav;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA")
    @ManyToOne(optional = false)
    private Oferta ofertaIdOferta;

    public Ofertavisi() {
    }

    public Ofertavisi(BigDecimal idofertav) {
        this.idofertav = idofertav;
    }

    public Ofertavisi(BigDecimal idofertav, Date fechaVisita) {
        this.idofertav = idofertav;
        this.fechaVisita = fechaVisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public BigDecimal getIdofertav() {
        return idofertav;
    }

    public void setIdofertav(BigDecimal idofertav) {
        this.idofertav = idofertav;
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
        hash += (idofertav != null ? idofertav.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertavisi)) {
            return false;
        }
        Ofertavisi other = (Ofertavisi) object;
        if ((this.idofertav == null && other.idofertav != null) || (this.idofertav != null && !this.idofertav.equals(other.idofertav))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ofertavisi[ idofertav=" + idofertav + " ]";
    }
    
}
