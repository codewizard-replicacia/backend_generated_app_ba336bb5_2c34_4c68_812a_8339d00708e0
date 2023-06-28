package com.mycompany.group234.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.mycompany.group234.model.FocusGroup;
import com.mycompany.group234.model.AdvertisingAgency;
import com.mycompany.group234.model.DataAnalysis;
import com.mycompany.group234.model.Survey;
import com.mycompany.group234.model.CompetativeAnalysis;
import com.mycompany.group234.model.MarketResearch;
import com.mycompany.group234.model.TargetMarketIdentification;
import com.mycompany.group234.model.BrandPerception;
import com.mycompany.group234.model.MediaPlanAndBuying;
import com.mycompany.group234.converter.DurationConverter;
import com.mycompany.group234.converter.UUIDToByteConverter;
import com.mycompany.group234.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "AdvertisingAgency")
@Table(name = "\"AdvertisingAgency\"", schema =  "\"generated_app\"")
@Data
                        
public class AdvertisingAgency {
	public AdvertisingAgency () {   
  }
	  
  @Column(name = "\"AgencyName\"", nullable = true )
  private String agencyName;
  
	  
  @Column(name = "\"Field\"", nullable = true )
  private String field;
  
	  
  @Column(name = "\"Phnum\"", nullable = true )
  private Long phnum;
  
	  
  @Column(name = "\"Address\"", nullable = true )
  private String address;
  
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", nullable = true )
  private Integer iD;
  
  
  
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AdvertisingAgencyPerforms\"",
            joinColumns = @JoinColumn( name="\"ID\""),
            inverseJoinColumns = @JoinColumn( name="\"MRID\""), schema = "\"generated_app\"")
private List<MarketResearch> performs = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AdvertisingAgencyCompetitorAnalysis\"",
            joinColumns = @JoinColumn( name="\"ID\""),
            inverseJoinColumns = @JoinColumn( name="\"ID\""), schema = "\"generated_app\"")
private List<CompetativeAnalysis> competitorAnalysis = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AdvertisingAgencyBrandevaluation\"",
            joinColumns = @JoinColumn( name="\"ID\""),
            inverseJoinColumns = @JoinColumn( name="\"ID\""), schema = "\"generated_app\"")
private List<BrandPerception> brandevaluation = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"AdvertisingAgencyMediabuying\"",
            joinColumns = @JoinColumn( name="\"ID\""),
            inverseJoinColumns = @JoinColumn( name="\"ID\""), schema = "\"generated_app\"")
private List<MediaPlanAndBuying> mediabuying = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "AdvertisingAgency [" 
  + "AgencyName= " + agencyName  + ", " 
  + "Field= " + field  + ", " 
  + "Phnum= " + phnum  + ", " 
  + "Address= " + address  + ", " 
  + "ID= " + iD 
 + "]";
	}
	
}