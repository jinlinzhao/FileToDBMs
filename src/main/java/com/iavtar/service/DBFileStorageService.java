package com.iavtar.service;

import java.io.ByteArrayInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iavtar.exception.FileStorageException;
import com.iavtar.model.CarrierHotelClliSheetTableData;
import com.iavtar.model.DBFile;
import com.iavtar.repository.CarrierHotelClliSheetTableDataRepository;
import com.iavtar.repository.DBFileRepository;

@Service
public class DBFileStorageService {

	private static final Logger log = LoggerFactory.getLogger(DBFileStorageService.class);

	@Autowired
	private DBFileRepository dbFileRepository;

	@Autowired
	private CarrierHotelClliSheetTableDataRepository carrierHotelClliSheetTableDataRepository;

	public DBFile storeFile(MultipartFile file) {

		log.info("Inside storeFile method");

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {

			if (fileName.contains(".."))
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);

			DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

			//uploadExcelSheetDataToDB(file.getBytes());

			return dbFileRepository.save(dbFile);

		} catch (Exception e) {
			throw new FileStorageException("Could not store file. " + fileName + ". Please try again");
		}

	}

	private void uploadExcelSheetDataToDB(byte[] bytes) {
		try {
			ByteArrayInputStream excelInputStream = new ByteArrayInputStream(bytes);

			Workbook workbook = WorkbookFactory.create(excelInputStream);

			Sheet sheet = workbook.getSheetAt(0);

			for (int j = 1; j <= sheet.getLastRowNum(); j++) {

				CarrierHotelClliSheetTableData newCarrierHotelClliSheetTableData = new CarrierHotelClliSheetTableData();

				Row row = sheet.getRow(j);

				newCarrierHotelClliSheetTableData.setrOADMConfiguration(row.getCell(0).toString());
				newCarrierHotelClliSheetTableData.setCarrierHotelCLLI(row.getCell(1).toString());
				newCarrierHotelClliSheetTableData.setCarrierHotelAddress(row.getCell(2).toString());
				newCarrierHotelClliSheetTableData.setFlrorSuite(row.getCell(3).toString());
				newCarrierHotelClliSheetTableData.setCity(row.getCell(4).toString());
				newCarrierHotelClliSheetTableData.setState(row.getCell(5).toString());
				newCarrierHotelClliSheetTableData.setsWC(row.getCell(6).toString());
				newCarrierHotelClliSheetTableData.setPrimaryPathATT_POP_A_ACTL(row.getCell(8).toString());
				newCarrierHotelClliSheetTableData.setDiversePath_ATT_POP_B_ACTL(row.getCell(9).toString());
				newCarrierHotelClliSheetTableData.setLocationType(row.getCell(10).toString());
				newCarrierHotelClliSheetTableData.setOperator(row.getCell(11).toString());
				newCarrierHotelClliSheetTableData.setrOADMDWIDOTU4TNID(row.getCell(12).toString());
				newCarrierHotelClliSheetTableData.setState(row.getCell(13).toString());
				newCarrierHotelClliSheetTableData.setNotes(row.getCell(14).toString());

				carrierHotelClliSheetTableDataRepository.save(newCarrierHotelClliSheetTableData);

			}

		} catch (Exception e) {
			throw new RuntimeException("Excel Read File System Unable To Create!");
		}

	}

	public DBFile getFile(String fileId) {

		return dbFileRepository.findById(fileId);

	}

}
