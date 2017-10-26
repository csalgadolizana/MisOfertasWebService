/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LC1300XXXX
 */
@Entity
@Table(name = "LOCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")
    , @NamedQuery(name = "Local.findByIdLocal", query = "SELECT l FROM Local l WHERE l.idLocal = :idLocal")
    , @NamedQuery(name = "Local.findByDireccion", query = "SELECT l FROM Local l WHERE l.direccion = :direccion")
    , @NamedQuery(name = "Local.findByNombre", query = "SELECT l FROM Local l WHERE l.nombre = :nombre")})
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOCAL")
    private BigDecimal idLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;
    @JoinColumn(name = "EMPRESA_ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa empresaIdEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localIdLocal")
    private Collection<Reporte> reporteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private Collection<Ofertalocal> ofertalocalCollection;

    public Local() {
    }

    public Local(BigDecimal idLocal) {
        this.idLocal = idLocal;
    }

    public Local(BigDecimal idLocal, String direccion, String nombre) {
        this.idLocal = idLocal;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public BigDecimal getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(BigDecimal idLocal) {
        this.idLocal = idLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    public Empresa getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(Empresa empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    @XmlTransient
    public Collection<Reporte> getReporteCollection() {
        return reporteCollection;
    }

    public void setReporteCollection(Collection<Reporte> reporteCollection) {
        this.reporteCollection = reporteCollection;
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
        hash += (idLocal != null ? idLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Local[ idLocal=" + idLocal + " ]";
    }
    
}
