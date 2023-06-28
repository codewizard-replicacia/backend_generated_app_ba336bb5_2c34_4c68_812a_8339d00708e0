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

@Entity(name = "TargetMarketIdentification")
@Table(name = "\"TargetMarketIdentification\"", schema =  "\"generated_app\"")
@Data
                        
public class TargetMarketIdentification {
	public TargetMarketIdentification () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"TargetMarketID\"", nullable = true )
  private Integer targetMarketID;
	  
  @Column(name = "\"TargetGroupName\"", nullable = true )
  private String targetGroupName;
  
	  
  @Column(name = "\"TargetGroupAge\"", nullable = true )
  private Integer targetGroupAge;
  
	  
  @Column(name = "\"TarggetGroupGender\"", nullable = true )
  private Boolean targgetGroupGender;
  
	  
  @Column(name = "\"EducationLevel\"", nullable = true )
  private Boolean educationLevel;
  
	  
  @Column(name = "\"Occupation\"", nullable = true )
  private Boolean occupation;
  
	  
  @Column(name = "\"IncomeLevel\"", nullable = true )
  private Boolean incomeLevel;
  
	  
  @Column(name = "\"MaritalStatus\"", nullable = true )
  private Boolean maritalStatus;
  
	  
  @Column(name = "\"GeographicLoc\"", nullable = true )
  private String geographicLoc;
  
	  
  @Column(name = "\"Hobbies\"", nullable = true )
  private String hobbies;
  
	  
  @Column(name = "\"BehaviorNature\"", nullable = true )
  private String behaviorNature;
  
	  
  @Column(name = "\"PaintPointOrNeeds\"", nullable = true )
  private Boolean paintPointOrNeeds;
  
	  
  @Column(name = "\"Needs\"", nullable = true )
  private String needs;
  
	  
  @Column(name = "\"Technologybeingused\"", nullable = true )
  private Boolean technologybeingused;
  
	  
  @Column(name = "\"CurlturalBG\"", nullable = true )
  private String curlturalBG;
  
	  
  @Column(name = "\"InfluencerChoosed\"", nullable = true )
  private String influencerChoosed;
  
	  
  @Column(name = "\"Summary\"", nullable = true )
  private String summary;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "TargetMarketIdentification [" 
  + "TargetMarketID= " + targetMarketID  + ", " 
  + "TargetGroupName= " + targetGroupName  + ", " 
  + "TargetGroupAge= " + targetGroupAge  + ", " 
  + "TarggetGroupGender= " + targgetGroupGender  + ", " 
  + "EducationLevel= " + educationLevel  + ", " 
  + "Occupation= " + occupation  + ", " 
  + "IncomeLevel= " + incomeLevel  + ", " 
  + "MaritalStatus= " + maritalStatus  + ", " 
  + "GeographicLoc= " + geographicLoc  + ", " 
  + "Hobbies= " + hobbies  + ", " 
  + "BehaviorNature= " + behaviorNature  + ", " 
  + "PaintPointOrNeeds= " + paintPointOrNeeds  + ", " 
  + "Needs= " + needs  + ", " 
  + "Technologybeingused= " + technologybeingused  + ", " 
  + "CurlturalBG= " + curlturalBG  + ", " 
  + "InfluencerChoosed= " + influencerChoosed  + ", " 
  + "Summary= " + summary 
 + "]";
	}
	
}