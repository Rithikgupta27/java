package watchValidationRule;

import java.time.DateTimeException;
import java.time.LocalDate;

import watch.Watch;
import watchUtil.Brand;
import watchUtil.Category;
import watchUtil.Shape;
import watchUtil.Style;
import watchUtil.WatchBandMaterial;

public class WatchValidationRule {

	public static Brand validateAndParseBrand(String nBrand)throws IllegalArgumentException,NullPointerException {
		String temp = nBrand.toUpperCase();
		return Brand.valueOf(temp);
		}
	
	public static Category validateAndParseCategory(String nCategory)throws IllegalArgumentException,NullPointerException {
		String temp = nCategory.toUpperCase();
		return Category.valueOf(temp);
		}
	
	public static Shape validateAndParseShape(String nShape)throws IllegalArgumentException,NullPointerException {
		String temp = nShape.toUpperCase();
		return Shape.valueOf(temp);
		}
	
	public static Style validateAndParseStyle(String nStyle)throws IllegalArgumentException,NullPointerException {
		String temp = nStyle.toUpperCase();
		return Style.valueOf(temp);
		}
	
	public static WatchBandMaterial validateAndParseWatchBandMaterial(String nWBMaterial)throws IllegalArgumentException,NullPointerException {
		String temp = nWBMaterial.toUpperCase();
		return WatchBandMaterial.valueOf(temp);
		}
	
	public static LocalDate validateAndParseDate(String date)throws DateTimeException {
		LocalDate temp = LocalDate.parse(date);
		return temp;		
	}
	
//	watchName, ,WatchCategory, watchBrand,  watchShape,  watchStyle,  watchMaterial,int sQty, LocalDate sLDate, LocalDate sUDate, double price
	public static Watch validateAllInput(String name,String ctgy,String  watchBrand,String  watchShape,String  watchStyle,String  watchBMaterial,int sQty, String sLDate,String sUDate, double price) {
		Brand br=validateAndParseBrand(watchBrand);
		Category ct= validateAndParseCategory(ctgy);
		Shape sh=validateAndParseShape(watchShape);
		 Style st= validateAndParseStyle(watchStyle);
		WatchBandMaterial bm= validateAndParseWatchBandMaterial(watchBMaterial);
		LocalDate sList=validateAndParseDate(sLDate);
		LocalDate sUpdate=validateAndParseDate(sUDate);
		
		Watch newWatch=new Watch(name, ct, br, sh, st, bm,sQty,sList,sUpdate, price);
		return newWatch;
	}
	
}
