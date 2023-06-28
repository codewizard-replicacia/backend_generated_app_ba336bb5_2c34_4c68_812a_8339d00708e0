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

@Entity(name = "MediaPlanAndBuying")
@Table(name = "\"MediaPlanAndBuying\"", schema =  "\"generated_app\"")
@Data
                        
public class MediaPlanAndBuying {
	public MediaPlanAndBuying () {   
  }
	  
  @Column(name = "\"MostEffectiveMediaChannel\"", nullable = true )
  private Boolean mostEffectiveMediaChannel;
  
	  
  @Column(name = "\"BudgetAllocation\"", nullable = true )
  private String budgetAllocation;
  
	  
  @Column(name = "\"Flighting\"")
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date flighting;  
  
	  
  @Column(name = "\"ClientMessagetoaudience\"", nullable = true )
  private String clientMessagetoaudience;
  
	  
  @Column(name = "\"AdPlacementsforclientcost\"", nullable = true )
  private String adPlacementsforclientcost;
  
	  
  @Column(name = "\"TrackPlannedAds\"", nullable = true )
  private Boolean trackPlannedAds;
  
	  
  @Column(name = "\"Monitoredperformance\"", nullable = true )
  private Boolean monitoredperformance;
  
	  
  @Column(name = "\"KPIsAre\"", nullable = true )
  private Boolean kPIsAre;
  
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", nullable = true )
  private Integer iD;
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "MediaPlanAndBuying [" 
  + "MostEffectiveMediaChannel= " + mostEffectiveMediaChannel  + ", " 
  + "BudgetAllocation= " + budgetAllocation  + ", " 
  + "Flighting= " + flighting  + ", " 
  + "ClientMessagetoaudience= " + clientMessagetoaudience  + ", " 
  + "AdPlacementsforclientcost= " + adPlacementsforclientcost  + ", " 
  + "TrackPlannedAds= " + trackPlannedAds  + ", " 
  + "Monitoredperformance= " + monitoredperformance  + ", " 
  + "KPIsAre= " + kPIsAre  + ", " 
  + "ID= " + iD 
 + "]";
	}
	
}