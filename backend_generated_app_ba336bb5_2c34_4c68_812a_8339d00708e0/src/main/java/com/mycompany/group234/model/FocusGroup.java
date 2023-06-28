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

@Entity(name = "FocusGroup")
@Table(name = "\"FocusGroup\"", schema =  "\"generated_app\"")
@Data
                        
public class FocusGroup {
	public FocusGroup () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"FGID\"", nullable = true )
  private Integer fGID;
	  
  @Column(name = "\"NoOfFocusGroups\"", nullable = true )
  private Integer noOfFocusGroups;
  
	  
  @Column(name = "\"FocusGroupNames\"", nullable = true )
  private Boolean focusGroupNames;
  
	  
  @Column(name = "\"FG1ParticipantCount\"", nullable = true )
  private Integer fG1ParticipantCount;
  
	  
  @Column(name = "\"FG1ParticipantNames\"", nullable = true )
  private Boolean fG1ParticipantNames;
  
	  
  @Column(name = "\"FG2ParticipantCount\"", nullable = true )
  private Integer fG2ParticipantCount;
  
	  
  @Column(name = "\"FG2ParticipantNames\"", nullable = true )
  private Boolean fG2ParticipantNames;
  
	  
  @Column(name = "\"FGTopic\"", nullable = true )
  private String fGTopic;
  
	  
  @Column(name = "\"FG1Responses\"", nullable = true )
  private String fG1Responses;
  
	  
  @Column(name = "\"FG2Responses\"", nullable = true )
  private String fG2Responses;
  
	  
  @Column(name = "\"ConceptTesting\"", nullable = true )
  private String conceptTesting;
  
	  
  @Column(name = "\"IdeaGenerated\"", nullable = true )
  private String ideaGenerated;
  
  
  
  
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"FocusGroupFeedback2\"",
            joinColumns = @JoinColumn( name="\"FGID\""),
            inverseJoinColumns = @JoinColumn( name="\"TargetMarketID\""), schema = "\"generated_app\"")
private List<TargetMarketIdentification> feedback2 = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "FocusGroup [" 
  + "FGID= " + fGID  + ", " 
  + "NoOfFocusGroups= " + noOfFocusGroups  + ", " 
  + "FocusGroupNames= " + focusGroupNames  + ", " 
  + "FG1ParticipantCount= " + fG1ParticipantCount  + ", " 
  + "FG1ParticipantNames= " + fG1ParticipantNames  + ", " 
  + "FG2ParticipantCount= " + fG2ParticipantCount  + ", " 
  + "FG2ParticipantNames= " + fG2ParticipantNames  + ", " 
  + "FGTopic= " + fGTopic  + ", " 
  + "FG1Responses= " + fG1Responses  + ", " 
  + "FG2Responses= " + fG2Responses  + ", " 
  + "ConceptTesting= " + conceptTesting  + ", " 
  + "IdeaGenerated= " + ideaGenerated 
 + "]";
	}
	
}