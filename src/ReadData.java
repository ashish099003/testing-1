import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	private static XSSFSheet excelSheet;
	private static XSSFWorkbook wb;
	//private static XSSFCell cell;
//	private static XSSFRow row;
	public static  String ReadData( String path,int SheetNo, int rowNo, int cellNo) throws Exception{
		String str=null;
		
		try {
			File srs = new File(path);
			FileInputStream excelFile = new FileInputStream(srs);
			wb = new XSSFWorkbook(excelFile);
			excelSheet= wb.getSheetAt(SheetNo);
			str= excelSheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			//System.out.println("Enter Correct File Path");
		}
		return str;
	}
		
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			String path ="//Users//ashu//eclipse-workspace//testing1//test data//xapth_coviam.xlsx";
		for (int j=0;j<32;j++) {
			
			String xPath = ReadData(path,0,j,1);	
			System.out.println(xPath);
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//System.out.println("Enter Correct File Path");
		}
	}

}

	