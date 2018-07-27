package com.clubExcelTests;

import java.util.ArrayList;

import com.ClubsExcelData.ExcelColumn;

public class ExcelColumnTest {

		public static void main(String[] args) throws Throwable {

			String excelPath="./TestData/WebTable Test Data.xlsx";
			ArrayList<String> ColumnValue= new ArrayList<String>();
			
			ColumnValue=ExcelColumn.columnValue(excelPath, 0);
			System.out.println("Value:"+ColumnValue);
		}

	}


