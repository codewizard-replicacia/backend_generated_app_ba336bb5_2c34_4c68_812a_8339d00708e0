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

@Entity(name = "MarketResearch")
@Table(name = "\"MarketResearch\"", schema =  "\"generated_app\"")
@Data
                        
public class MarketResearch {
	public MarketResearch () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"MRID\"", nullable = true )
  private Integer mRID;
	  
  @Column(name = "\"ResearchObjective\"", nullable = true )
  private String researchObjective;
  
	  
  @Column(name = "\"ObjectiveQuestionnaireSet\"", nullable = true )
  private String objectiveQuestionnaireSet;
  
	  
  @Column(name = "\"TargetMarket\"", nullable = true )
  private String targetMarket;
  
	  
  @Column(name = "\"ResearchMethod\"", nullable = true )
  private Boolean researchMethod;
  
	  
  @Column(name = "\"MarketResearchReport\"", nullable = true )
  private String marketResearchReport;
  
	  
  @Column(name = "\"MarketTrends\"", nullable = true )
  private String marketTrends;
  
  
  
  
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"MarketResearchDoes\"",
            joinColumns = @JoinColumn( name="\"MRID\""),
            inverseJoinColumns = @JoinColumn( name="\"SurveyID\""), schema = "\"generated_app\"")
private List<Survey> does = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"MarketResearchConducts\"",
            joinColumns = @JoinColumn( name="\"MRID\""),
            inverseJoinColumns = @JoinColumn( name="\"FGID\""), schema = "\"generated_app\"")
private List<FocusGroup> conducts = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"MarketResearchAnalysis\"",
            joinColumns = @JoinColumn( name="\"MRID\""),
            inverseJoinColumns = @JoinColumn( name="\"DataAnalysisID\""), schema = "\"generated_app\"")
private List<DataAnalysis> analysis = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "MarketResearch [" 
  + "MRID= " + mRID  + ", " 
  + "ResearchObjective= " + researchObjective  + ", " 
  + "ObjectiveQuestionnaireSet= " + objectiveQuestionnaireSet  + ", " 
  + "TargetMarket= " + targetMarket  + ", " 
  + "ResearchMethod= " + researchMethod  + ", " 
  + "MarketResearchReport= " + marketResearchReport  + ", " 
  + "MarketTrends= " + marketTrends 
 + "]";
	}
	
}