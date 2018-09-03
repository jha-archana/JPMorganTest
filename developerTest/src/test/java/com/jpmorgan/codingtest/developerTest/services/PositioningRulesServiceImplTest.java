package com.jpmorgan.codingtest.developerTest.services;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.jpmorgan.codingtest.developerTest.domain.Position;
import com.jpmorgan.codingtest.developerTest.domain.TradeEvent;
import com.poiji.bind.Poiji;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

@RunWith(EasyMockRunner.class)
public class PositioningRulesServiceImplTest {
	
	@TestSubject
	PositioningRulesServiceImpl positioningRulesServiceImpl = new PositioningRulesServiceImpl();
	
	List<TradeEvent> tradeEvents = new ArrayList<TradeEvent>();
	List<Position> positions = new ArrayList<Position>();

	@Before
	public void setUp(){
		tradeEvents = Poiji.fromExcel(new File("/Users/sandeep/Documents/Archu/jpmorganTest/TradeEventInput.xlsx"), TradeEvent.class);
		positions = Poiji.fromExcel(new File("/Users/sandeep/Documents/Archu/jpmorganTest/TradeAggregationOutput.xls"), Position.class);
	}
	
	@Test
	public void processTradesToPositionNotNull(){
		List<Position> positions = positioningRulesServiceImpl.processTradesToPosition(tradeEvents);
		positions.size();
		assertFalse(positions.isEmpty());
	}
	
	@Test
	public void processTradesToPositionValidateResultSize(){
		List<Position> actualPositions = positioningRulesServiceImpl.processTradesToPosition(tradeEvents);
		Collections.sort(actualPositions);
		assertEquals(positions.size(), actualPositions.size());
		}
	
	@Test
	public void processTradesToPositionValidateResult(){
		List<Position> actualPositions = positioningRulesServiceImpl.processTradesToPosition(tradeEvents);
		assertThat(actualPositions, hasItems(
				new Position("ACC-5678", "HJK", 50, "6363,7666"),
				new Position("ACC-1234", "XYZ", 150, "1234"),
				new Position("ACC-4567", "YUI", 200, "6638,8896"),
				new Position("ACC-2345", "QED", 0, "5678"),
				new Position("ACC-3456", "RET", 0, "2233"),
				new Position("ACC-7789", "JKL", 100, "1036,1025"),
				new Position("ACC-6789", "FVB", 200, "8686,9654"),
				new Position("ACC-9045", "HJK", 0, "1122"),
				new Position("ACC-9045", "KLO", 300, "1155,1144,1122"),
				new Position("ACC-6789", "GBN", 100, "8686"),
				new Position("ACC-8877", "JKL", -100, "1025")
        ));
		}
	
}
