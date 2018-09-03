package com.jpmorgan.codingtest.developerTest.domain;


import com.jpmorgan.codingtest.developerTest.util.DirectionTypeEnum;
import com.jpmorgan.codingtest.developerTest.util.OperationTypeEnum;
import com.poiji.annotation.ExcelCellName;

public class TradeEvent implements Comparable<TradeEvent>{

	@ExcelCellName("TradeID") 
	private Integer tradeId;
	
	@ExcelCellName("Version")
	private Integer tradeVersion;
	
	@ExcelCellName("Security Identifier")
	private String tradeSecurity;
	
	@ExcelCellName("Trade quantity")
	private Integer quantity;
	
	@ExcelCellName("Trade Direction")
	private DirectionTypeEnum tradeDirection;
	
	@ExcelCellName("Account")
	private String accountNumber;
	
	@ExcelCellName("Operation")
	private OperationTypeEnum operation;
	
	
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}
	public Integer getTradeVersion() {
		return tradeVersion;
	}
	public void setTradeVersion(Integer tradeVersion) {
		this.tradeVersion = tradeVersion;
	}
	public String getTradeSecurity() {
		return tradeSecurity;
	}
	public void setTradeSecurity(String tradeSecurity) {
		this.tradeSecurity = tradeSecurity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public DirectionTypeEnum getTradeDirection() {
		return tradeDirection;
	}
	public void setTradeDirection(DirectionTypeEnum tradeDirection) {
		this.tradeDirection = tradeDirection;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public OperationTypeEnum getOperation() {
		return operation;
	}
	public void setOperation(OperationTypeEnum operation) {
		this.operation = operation;
	}
	
	@Override
	public int compareTo(TradeEvent tradeEvent){
	  return this.tradeId.compareTo(tradeEvent.tradeId);
	}
	
}
