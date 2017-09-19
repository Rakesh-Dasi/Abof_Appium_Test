package com.abof.test;

import org.testng.annotations.Test;

import com.abof.utils.Constant;
import com.abof.utils.ExcelUtils;




public class ExcelTest 
{

	
	@Test
	public void main() throws Exception
	{
		   ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		   String sUserName = ExcelUtils.getCellData(1, 1);
		   System.out.println(sUserName);
	}

}
