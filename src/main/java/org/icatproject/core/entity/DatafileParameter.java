package org.icatproject.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * The persistent class for the DATAFILEPARAMETER nosql database table.
 * 
 */
@Entity()
@NoSql(dataFormat=DataFormatType.MAPPED, dataType="DATAFILEPARAMETERNOSQL")
public class DatafileParameter extends EntityBaseBean implements Serializable {
	
	@Basic
	@Field(name="CREATE_ID")
	protected String createId;
	
	@Basic
	@Field(name="CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createTime;
	
	@Basic
	@Field(name="MOD_ID")
	protected String modId;
	
	@Basic
	@Field(name="MOD_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modTime;

	@Field(name="DATAFILE_ID")
	private Long datafile;

	@Basic
	@Field(name="PARAMETER_TYPE_ID")
	ParameterType type;

	@Basic
	private String stringValue;

	@Basic
	private Double numericValue;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTimeValue;

	@Basic
	private Double rangeTop;

	@Basic
	private Double rangeBottom;

	@Basic
	private Double error;
	
	@Id
	@GeneratedValue
	@Field(name="_id")
	protected Long id;

	public DatafileParameter() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getDatafile() {
		return datafile;
	}

	public void setDatafile(Long datafile) {
		this.datafile = datafile;
	}

	public ParameterType getType() {
		return type;
	}

	public void setType(ParameterType type) {
		this.type = type;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Double getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(Double numericValue) {
		this.numericValue = numericValue;
	}

	public Date getDateTimeValue() {
		return dateTimeValue;
	}

	public void setDateTimeValue(Date dateTimeValue) {
		this.dateTimeValue = dateTimeValue;
	}

	public Double getRangeTop() {
		return rangeTop;
	}

	public void setRangeTop(Double rangeTop) {
		this.rangeTop = rangeTop;
	}

	public Double getRangeBottom() {
		return rangeBottom;
	}

	public void setRangeBottom(Double rangeBottom) {
		this.rangeBottom = rangeBottom;
	}

	public Double getError() {
		return error;
	}

	public void setError(Double error) {
		this.error = error;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

}
