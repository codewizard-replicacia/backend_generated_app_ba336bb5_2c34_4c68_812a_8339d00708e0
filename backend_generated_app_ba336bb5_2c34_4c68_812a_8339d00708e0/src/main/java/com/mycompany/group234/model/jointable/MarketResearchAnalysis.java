package com.mycompany.group234.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.mycompany.group234.model.FocusGroup;
import com.mycompany.group234.model.AdvertisingAgency;
import com.mycompany.group234.model.DataAnalysis;
import com.mycompany.group234.model.Survey;
import com.mycompany.group234.model.CompetativeAnalysis;
import com.mycompany.group234.model.MarketResearch;
import com.mycompany.group234.model.TargetMarketIdentification;
import com.mycompany.group234.model.BrandPerception;
import com.mycompany.group234.model.MediaPlanAndBuying;

@Entity(name = "MarketResearchAnalysis")
@Table(schema = "\"generated_app\"", name = "\"MarketResearchAnalysis\"")
@Data
public class MarketResearchAnalysis{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"MRID\"")
	private Integer mRID;

    
    @Column(name = "\"DataAnalysisID\"")
    private String dataAnalysisID;
 
}