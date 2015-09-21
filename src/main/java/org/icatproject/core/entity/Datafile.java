package org.icatproject.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * The persistent class for the DATAFILE nosql database table.
 * 
 */
@Entity()
@NoSql(dataFormat = DataFormatType.MAPPED, dataType = "DATAFILENOSQL")
public class Datafile extends EntityBaseBean implements Serializable {

	private static final Logger logger = Logger.getLogger(Datafile.class);

	@Basic
	protected String createId;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createTime;

	@Basic
	protected String modId;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modTime;

	@Basic
	protected String checksum;

	@Basic
	private String description;

	@Basic
	private String doi;

	@Basic
	private Long fileSize;

	@Basic
	private String location;

	@Basic
	private String name;

	@Field(name = "DATASET_ID")
	private Long dataset;

	@Id
	@GeneratedValue
	@Field(name = "_id")
	protected Long id;

	public Datafile() {
		// TODO Auto-generated constructor stub
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	@Override
	public Date getCreateTime() {
		// TODO Auto-generated method stub
		return super.getCreateTime();
	}

	@Override
	public void setCreateTime(Date createTime) {
		// TODO Auto-generated method stub
		super.setCreateTime(createTime);
	}

	@Override
	public String getModId() {
		// TODO Auto-generated method stub
		return super.getModId();
	}

	@Override
	public void setModId(String modId) {
		// TODO Auto-generated method stub
		super.setModId(modId);
	}

	@Override
	public Date getModTime() {
		// TODO Auto-generated method stub
		return super.getModTime();
	}

	@Override
	public void setModTime(Date modTime) {
		// TODO Auto-generated method stub
		super.setModTime(modTime);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChecksum() {
		return checksum;
	}

	public Long getDataset() {
		return dataset;
	}

	public String getDescription() {
		return description;
	}

	public String getDoi() {
		return doi;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public void setDataset(Long dataset) {
		this.dataset = dataset;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Document getDoc() {
		Document doc = new Document();
		/*StringBuilder sb = new StringBuilder(name);
		if (description != null) {
			sb.append(" " + description);
		}
		if (doi != null) {
			sb.append(" " + doi);
		}
		if (datafileFormat != null) {
			sb.append(" " + datafileFormat.getName());

		}
		doc.add(new TextField("text", sb.toString(), Store.NO));
		if (datafileModTime != null) {
			doc.add(new StringField("date", DateTools.dateToString(datafileModTime, Resolution.MINUTE), Store.NO));
		} else if (datafileCreateTime != null) {
			doc.add(new StringField("date", DateTools.dateToString(datafileCreateTime, Resolution.MINUTE), Store.NO));
		} else {
			doc.add(new StringField("date", DateTools.dateToString(modTime, Resolution.MINUTE), Store.NO));
		}
		doc.add(new StringField("dataset", "Dataset:" + dataset.getId(), Store.YES));*/
		return doc;
	}
}
