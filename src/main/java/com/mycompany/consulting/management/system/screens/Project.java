/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.screens;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Ufuk
 */
@Entity
@Table(name = "project", catalog = "consultingmanagementsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findBySector", query = "SELECT p FROM Project p WHERE p.sector = :sector"),
    @NamedQuery(name = "Project.findByMin", query = "SELECT p FROM Project p WHERE p.min = :min"),
    @NamedQuery(name = "Project.findByMax", query = "SELECT p FROM Project p WHERE p.max = :max"),
    @NamedQuery(name = "Project.findByReadyToStart", query = "SELECT p FROM Project p WHERE p.readyToStart = :readyToStart"),
    @NamedQuery(name = "Project.findByStartedDate", query = "SELECT p FROM Project p WHERE p.startedDate = :startedDate"),
    @NamedQuery(name = "Project.findByProjectManagerNumber", query = "SELECT p FROM Project p WHERE p.projectManagerNumber = :projectManagerNumber"),
    @NamedQuery(name = "Project.findByAnalistNumber", query = "SELECT p FROM Project p WHERE p.analistNumber = :analistNumber"),
    @NamedQuery(name = "Project.findByDesignerNumber", query = "SELECT p FROM Project p WHERE p.designerNumber = :designerNumber"),
    @NamedQuery(name = "Project.findByDeveloperNumber", query = "SELECT p FROM Project p WHERE p.developerNumber = :developerNumber"),
    @NamedQuery(name = "Project.findByTesterNumber", query = "SELECT p FROM Project p WHERE p.testerNumber = :testerNumber")})
public class Project implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "sector")
    private String sector;
    @Column(name = "min")
    private Integer min;
    @Column(name = "max")
    private Integer max;
    @Column(name = "readyToStart")
    private Boolean readyToStart;
    @Column(name = "startedDate")
    @Temporal(TemporalType.DATE)
    private Date startedDate;
    @Basic(optional = false)
    @Column(name = "projectManagerNumber")
    private int projectManagerNumber;
    @Basic(optional = false)
    @Column(name = "analistNumber")
    private int analistNumber;
    @Basic(optional = false)
    @Column(name = "designerNumber")
    private int designerNumber;
    @Basic(optional = false)
    @Column(name = "developerNumber")
    private int developerNumber;
    @Basic(optional = false)
    @Column(name = "testerNumber")
    private int testerNumber;

    public Project() {
    }

    public Project(Integer id) {
        this.id = id;
    }

    public Project(Integer id, String name, String sector, int projectManagerNumber, int analistNumber, int designerNumber, int developerNumber, int testerNumber) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.projectManagerNumber = projectManagerNumber;
        this.analistNumber = analistNumber;
        this.designerNumber = designerNumber;
        this.developerNumber = developerNumber;
        this.testerNumber = testerNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        String oldSector = this.sector;
        this.sector = sector;
        changeSupport.firePropertyChange("sector", oldSector, sector);
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        Integer oldMin = this.min;
        this.min = min;
        changeSupport.firePropertyChange("min", oldMin, min);
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        Integer oldMax = this.max;
        this.max = max;
        changeSupport.firePropertyChange("max", oldMax, max);
    }

    public Boolean getReadyToStart() {
        return readyToStart;
    }

    public void setReadyToStart(Boolean readyToStart) {
        Boolean oldReadyToStart = this.readyToStart;
        this.readyToStart = readyToStart;
        changeSupport.firePropertyChange("readyToStart", oldReadyToStart, readyToStart);
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        Date oldStartedDate = this.startedDate;
        this.startedDate = startedDate;
        changeSupport.firePropertyChange("startedDate", oldStartedDate, startedDate);
    }

    public int getProjectManagerNumber() {
        return projectManagerNumber;
    }

    public void setProjectManagerNumber(int projectManagerNumber) {
        int oldProjectManagerNumber = this.projectManagerNumber;
        this.projectManagerNumber = projectManagerNumber;
        changeSupport.firePropertyChange("projectManagerNumber", oldProjectManagerNumber, projectManagerNumber);
    }

    public int getAnalistNumber() {
        return analistNumber;
    }

    public void setAnalistNumber(int analistNumber) {
        int oldAnalistNumber = this.analistNumber;
        this.analistNumber = analistNumber;
        changeSupport.firePropertyChange("analistNumber", oldAnalistNumber, analistNumber);
    }

    public int getDesignerNumber() {
        return designerNumber;
    }

    public void setDesignerNumber(int designerNumber) {
        int oldDesignerNumber = this.designerNumber;
        this.designerNumber = designerNumber;
        changeSupport.firePropertyChange("designerNumber", oldDesignerNumber, designerNumber);
    }

    public int getDeveloperNumber() {
        return developerNumber;
    }

    public void setDeveloperNumber(int developerNumber) {
        int oldDeveloperNumber = this.developerNumber;
        this.developerNumber = developerNumber;
        changeSupport.firePropertyChange("developerNumber", oldDeveloperNumber, developerNumber);
    }

    public int getTesterNumber() {
        return testerNumber;
    }

    public void setTesterNumber(int testerNumber) {
        int oldTesterNumber = this.testerNumber;
        this.testerNumber = testerNumber;
        changeSupport.firePropertyChange("testerNumber", oldTesterNumber, testerNumber);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.consulting.management.system.screens.Project[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
