/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Cristopher
 */
@Entity
@Table(name = "VALORACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByIdValoracion", query = "SELECT v FROM Valoracion v WHERE v.valoracionPK.idValoracion = :idValoracion")
    , @NamedQuery(name = "Valoracion.findByNota", query = "SELECT v FROM Valoracion v WHERE v.nota = :nota")
    , @NamedQuery(name = "Valoracion.findByBoletaAdjunta", query = "SELECT v FROM Valoracion v WHERE v.boletaAdjunta = :boletaAdjunta")
    , @NamedQuery(name = "Valoracion.findByFechavaloracion", query = "SELECT v FROM Valoracion v WHERE v.fechavaloracion = :fechavaloracion")
    , @NamedQuery(name = "Valoracion.findByClienteIdCliente", query = "SELECT v FROM Valoracion v WHERE v.valoracionPK.clienteIdCliente = :clienteIdCliente")
    , @NamedQuery(name = "Valoracion.findByOfertaIdOferta", query = "SELECT v FROM Valoracion v WHERE v.valoracionPK.ofertaIdOferta = :ofertaIdOferta")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValoracionPK valoracionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA")
    private BigInteger nota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BOLETA_ADJUNTA")
    private String boletaAdjunta;
    @Column(name = "FECHAVALORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavaloracion;
    @JoinColumn(name = "CATEGORIA_ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria categoriaIdCategoria;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "OFERTA_ID_OFERTA", referencedColumnName = "ID_OFERTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferta oferta;

    public Valoracion() {
    }

    public Valoracion(ValoracionPK valoracionPK) {
        this.valoracionPK = valoracionPK;
    }

    public Valoracion(ValoracionPK valoracionPK, BigInteger nota, String boletaAdjunta) {
        this.valoracionPK = valoracionPK;
        this.nota = nota;
        this.boletaAdjunta = boletaAdjunta;
    }

    public Valoracion(BigInteger idValoracion, BigInteger clienteIdCliente, BigInteger ofertaIdOferta) {
        this.valoracionPK = new ValoracionPK(idValoracion, clienteIdCliente, ofertaIdOferta);
    }

    public ValoracionPK getValoracionPK() {
        return valoracionPK;
    }

    public void setValoracionPK(ValoracionPK valoracionPK) {
        this.valoracionPK = valoracionPK;
    }

    public BigInteger getNota() {
        return nota;
    }

    public void setNota(BigInteger nota) {
        this.nota = nota;
    }

    public String getBoletaAdjunta() {
        return boletaAdjunta;
    }

    public void setBoletaAdjunta(String boletaAdjunta) {
        this.boletaAdjunta = boletaAdjunta;
    }

    public Date getFechavaloracion() {
        return fechavaloracion;
    }

    public void setFechavaloracion(Date fechavaloracion) {
        this.fechavaloracion = fechavaloracion;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valoracionPK != null ? valoracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.valoracionPK == null && other.valoracionPK != null) || (this.valoracionPK != null && !this.valoracionPK.equals(other.valoracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Valoracion[ valoracionPK=" + valoracionPK + " ]";
    }
    
}
