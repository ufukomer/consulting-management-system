/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.screens;

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

/**
 *
 * @author MelihKerman
 */
@Entity
@Table(name = "project", catalog = "consultingmanagementsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Project_1.findAll", query = "SELECT p FROM Project_1 p"),
    @NamedQuery(name = "Project_1.findById", query = "SELECT p FROM Project_1 p WHERE p.id = :id"),
    @NamedQuery(name = "Project_1.findByName", query = "SELECT p FROM Project_1 p WHERE p.name = :name"),
    @NamedQuery(name = "Project_1.findBySector", query = "SELECT p FROM Project_1 p WHERE p.sector = :sector"),
    @NamedQuery(name = "Project_1.findByMin", query = "SELECT p FROM Project_1 p WHERE p.min = :min"),
    @NamedQuery(name = "Project_1.findByMax", query = "SELECT p FROM Project_1 p WHERE p.max = :max"),
    @NamedQuery(name = "Project_1.findByReadyToStart", query = "SELECT p FROM Project_1 p WHERE p.readyToStart = :readyToStart"),
    @NamedQuery(name = "Project_1.findByStartedDate", query = "SELECT p FROM Project_1 p WHERE p.startedDate = :startedDate"),
    @NamedQuery(name = "Project_1.findByProjectManagerNumber", query = "SELECT p FROM Project_1 p WHERE p.projectManagerNumber = :projectManagerNumber"),
    @NamedQuery(name = "Project_1.findByAnalistNumber", query = "SELECT p FROM Project_1 p WHERE p.analistNumber = :analistNumber"),
    @NamedQuery(name = "Project_1.findByDesignerNumber", query = "SELECT p FROM Project_1 p WHERE p.designerNumber = :designerNumber"),
    @NamedQuery(name = "Project_1.findByDeveloperNumber", query = "SELECT p FROM Project_1 p WHERE p.developerNumber = :developerNumber"),
    @NamedQuery(name = "Project_1.findByTesterNumber", query = "SELECT p FROM Project_1 p WHERE p.testerNumber = :testerNumber")})
public class Project_1 implements Serializable {
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

    public Project_1() {
    }

    public Project_1(Integer id) {
        this.id = id;
    }

    public Project_1(Integer id, String name, String sector, int projectManagerNumber, int analistNumber, int designerNumber, int developerNumber, int testerNumber) {
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
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Boolean getReadyToStart() {
        return readyToStart;
    }

    public void setReadyToStart(Boolean readyToStart) {
        this.readyToStart = readyToStart;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public int getProjectManagerNumber() {
        return projectManagerNumber;
    }

    public void setProjectManagerNumber(int projectManagerNumber) {
        this.projectManagerNumber = projectManagerNumber;
    }

    public int getAnalistNumber() {
        return analistNumber;
    }

    public void setAnalistNumber(int analistNumber) {
        this.analistNumber = analistNumber;
    }

    public int getDesignerNumber() {
        return designerNumber;
    }

    public void setDesignerNumber(int designerNumber) {
        this.designerNumber = designerNumber;
    }

    public int getDeveloperNumber() {
        return developerNumber;
    }

    public void setDeveloperNumber(int developerNumber) {
        this.developerNumber = developerNumber;
    }

    public int getTesterNumber() {
        return testerNumber;
    }

    public void setTesterNumber(int testerNumber) {
        this.testerNumber = testerNumber;
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
        if (!(object instanceof Project_1)) {
            return false;
        }
        Project_1 other = (Project_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.consulting.management.system.screens.Project_1[ id=" + id + " ]";
    }
    
}
