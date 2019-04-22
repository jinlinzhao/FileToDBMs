package com.iavtar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarrierHotelClliSheetTableData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rOADMConfiguration;
	private String carrierHotelCLLI;
	private String carrierHotelAddress;
	private String flrorSuite;
	private String city;
	private String state;
	private String sWC;
	private String npaNxx;
	private String primaryPathATT_POP_A_ACTL;
	private String diversePath_ATT_POP_B_ACTL;
	private String locationType;
	private String Operator;
	private String rOADMDWIDOTU4TNID;
	private String status;
	private String Notes;
	private String bCAT;

	public CarrierHotelClliSheetTableData() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getrOADMConfiguration() {
		return rOADMConfiguration;
	}

	public void setrOADMConfiguration(String rOADMConfiguration) {
		this.rOADMConfiguration = rOADMConfiguration;
	}

	public String getCarrierHotelCLLI() {
		return carrierHotelCLLI;
	}

	public void setCarrierHotelCLLI(String carrierHotelCLLI) {
		this.carrierHotelCLLI = carrierHotelCLLI;
	}

	public String getCarrierHotelAddress() {
		return carrierHotelAddress;
	}

	public void setCarrierHotelAddress(String carrierHotelAddress) {
		this.carrierHotelAddress = carrierHotelAddress;
	}

	public String getFlrorSuite() {
		return flrorSuite;
	}

	public void setFlrorSuite(String flrorSuite) {
		this.flrorSuite = flrorSuite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getsWC() {
		return sWC;
	}

	public void setsWC(String sWC) {
		this.sWC = sWC;
	}

	public String getNpaNxx() {
		return npaNxx;
	}

	public void setNpaNxx(String npaNxx) {
		this.npaNxx = npaNxx;
	}

	public String getPrimaryPathATT_POP_A_ACTL() {
		return primaryPathATT_POP_A_ACTL;
	}

	public void setPrimaryPathATT_POP_A_ACTL(String primaryPathATT_POP_A_ACTL) {
		this.primaryPathATT_POP_A_ACTL = primaryPathATT_POP_A_ACTL;
	}

	public String getDiversePath_ATT_POP_B_ACTL() {
		return diversePath_ATT_POP_B_ACTL;
	}

	public void setDiversePath_ATT_POP_B_ACTL(String diversePath_ATT_POP_B_ACTL) {
		this.diversePath_ATT_POP_B_ACTL = diversePath_ATT_POP_B_ACTL;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getOperator() {
		return Operator;
	}

	public void setOperator(String operator) {
		Operator = operator;
	}

	public String getrOADMDWIDOTU4TNID() {
		return rOADMDWIDOTU4TNID;
	}

	public void setrOADMDWIDOTU4TNID(String rOADMDWIDOTU4TNID) {
		this.rOADMDWIDOTU4TNID = rOADMDWIDOTU4TNID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public String getbCAT() {
		return bCAT;
	}

	public void setbCAT(String bCAT) {
		this.bCAT = bCAT;
	}

}
