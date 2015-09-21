package org.icatproject.core.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.JoinField;
import org.eclipse.persistence.nosql.annotations.NoSql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DATASET nosql database table.
 * 
 */
@Entity
@NoSql(dataFormat=DataFormatType.MAPPED, dataType="DATASETNOSQL")
public class Dataset extends EntityBaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Field(name="_id")
	protected Long id;

	@Basic
	private String createId;

	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	private Date createTime;

	@Basic
	private String description;

	@Basic
	private String doi;

	@Basic
	private String location;

	@Basic
	private String modId;

	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	private Date modTime;

	private String name;

	@Field(name="INVESTIGATION_ID")
	private Long investigationId;
	
	private Long sampleId;
	
	private Long typeId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private boolean complete;
	
	//@OneToMany
	@JoinField(name="DATAFFILE_IDS")
	private List<Long> datafiles = new ArrayList<Long>();
	
	public Dataset() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateId() {
		return this.createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoi() {
		return this.doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getModId() {
		return this.modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public Date getModTime() {
		return this.modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(Long investigation_id) {
		this.investigationId = investigation_id;
	}

	public Long getSampleId() {
		return sampleId;
	}

	public void setSampleId(Long sample_id) {
		this.sampleId = sample_id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long type_id) {
		this.typeId = type_id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Long> getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(List<Long> datafiles) {
		this.datafiles = datafiles;
	}

}