package com.jpmorgan.codingtest.developerTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jpmorgan.codingtest.developerTest.domain.Position;
import com.jpmorgan.codingtest.developerTest.domain.TradeEvent;
import com.jpmorgan.codingtest.developerTest.services.PositioningRulesServiceImpl;
import com.jpmorgan.codingtest.developerTest.writer.PositionAggregationWriter;
import com.poiji.bind.Poiji;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DeveloperTestApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		PositioningRulesServiceImpl positioningRulesServiceImpl = ctx.getBean("positioningRulesService", PositioningRulesServiceImpl.class);
		
		List<TradeEvent> tradeEvents = Poiji.fromExcel(new File("/Users/sandeep/Documents/Archu/jpmorganTest/TradeEventInput.xlsx"), TradeEvent.class);
		tradeEvents.size();

		List<Position> positions = positioningRulesServiceImpl.processTradesToPosition(tradeEvents);
		System.out.println("positions size=="+positions.size());
		
		PositionAggregationWriter positionAggregationWriter = new PositionAggregationWriter();
		try {
			positionAggregationWriter.writeToExcel(positions, "/Users/sandeep/Documents/Archu/jpmorganTest/TradeAggregationOutput.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
