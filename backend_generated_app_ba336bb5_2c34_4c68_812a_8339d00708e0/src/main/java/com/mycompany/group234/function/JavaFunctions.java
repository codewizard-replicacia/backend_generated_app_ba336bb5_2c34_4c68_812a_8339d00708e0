package com.mycompany.group234.function;

import com.mycompany.group234.model.FocusGroup;
import com.mycompany.group234.model.AdvertisingAgency;
import com.mycompany.group234.model.DataAnalysis;
import com.mycompany.group234.model.Survey;
import com.mycompany.group234.model.CompetativeAnalysis;
import com.mycompany.group234.model.MarketResearch;
import com.mycompany.group234.model.TargetMarketIdentification;
import com.mycompany.group234.model.BrandPerception;
import com.mycompany.group234.model.MediaPlanAndBuying;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import com.mycompany.group234.repository.CompetativeAnalysisRepository;
import com.mycompany.group234.repository.DataAnalysisRepository;
import com.mycompany.group234.repository.SurveyRepository;
import com.mycompany.group234.repository.AdvertisingAgencyRepository;
import com.mycompany.group234.repository.MediaPlanAndBuyingRepository;
import com.mycompany.group234.repository.BrandPerceptionRepository;
import com.mycompany.group234.repository.FocusGroupRepository;
import com.mycompany.group234.repository.MarketResearchRepository;
import com.mycompany.group234.repository.TargetMarketIdentificationRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaFunctions implements ODataFunction {


    
    
}
   
