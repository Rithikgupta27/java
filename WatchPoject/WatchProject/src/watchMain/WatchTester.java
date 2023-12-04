package watchMain;

import static watchValidationRule.WatchValidationRule.validateAllInput;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import watch.Watch;

public class WatchTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Watch> watches = new ArrayList<>();
			boolean exit = false;

			while (!exit) {
				try {
					System.out.println("1 Add new Watch\n2 Update stock of watch\n3 set discount of 10% for all the watch which are 1 year old\n4 Remove watches which are never sold once listed in 18 months\n5 display all");
					switch (sc.nextInt()) {
					case 1:
//						System.out.println("Enter Watch Deatils");
//				watchName, ,WatchCategory, watchBrand,  watchShape,  watchStyle,  watchMaterial,int sQty, LocalDate sLDate, LocalDate sUDate, double price
//				String name,Category ctgy, Brand watchBrand, Shape watchShape, Style watchStyle, WatchBandMaterial watchMaterial,
//				int sQty, LocalDate sLDate, LocalDate sUDate, double price
						System.out.println("Enter your Name\n");
						String name = sc.next();
						System.out.println("Select Category {Men,Women}\n");
						String ctgy = sc.next();
						System.out.println("Select Watch Brand {CASIO,TITAN}\n");
						String watchBrand = sc.next();
						System.out.println("Select Watch Shape {SQUARE,RECTANGLE,ROUND}\n");
						String watchShape = sc.next();
						System.out.println("Select Watch Style {CASUAL,SPORT,WEDDING}");
						String watchStyle = sc.next();
						System.out.println("Select Watch Band Material {CREAMIC,STEEL,SILVER}");
						String watchMaterial = sc.next();
						System.out.println("Enter Watch Stock Quantity");
						int sQty = sc.nextInt();
						System.out.println("Enter Watch List Date{yyyy-mm-dd}");
						String sLDate = sc.next();
//				System.out.println("Enter Watch update Date");
						System.out.println("Enter Watch Price");
						double price = sc.nextDouble();
//				String name,String ctgy,String  watchBrand,String  watchShape,String  watchStyle,String  watchBMaterial,int sQty, String sLDate,String sUDate, double price
						Watch watch = validateAllInput(name, ctgy, watchBrand, watchShape, watchStyle, watchMaterial,
								sQty, sLDate, sLDate, price);
						watches.add(watch);
						break;
					case 2:
						System.out.println("Enter watch id");
						int id = sc.nextInt();
						System.out.println("Enter new Stock Quantity");
						int newSQty = sc.nextInt();
						for (Watch w : watches) {
							if (Watch.getId() == id) {
								w.setSQty(newSQty);
								w.setSUDate(LocalDate.now());
							}
						}
						System.out.println("Stock Quantity update...");
						break;
					case 3:
						double distPrice;

						for (Watch w : watches) {
							distPrice = w.getPrice() * (0.1);
							LocalDate listDate = w.getSLDate();
							LocalDate today = LocalDate.now();
							Period p = Period.between(listDate, today);
							long totalMonth = p.toTotalMonths();
							if (totalMonth > 12) {
								w.setDiscount(10);
								w.setPrice(w.getPrice() - distPrice);
								System.out.println("succefully discount");
							}
						}
						break;
					case 4:
						Iterator<Watch> itr = watches.iterator();
						while (itr.hasNext()) {
							LocalDate listDate = itr.next().getSLDate();
							LocalDate today = LocalDate.now();
							Period p = Period.between(listDate, today);
							long totalMonth = p.toTotalMonths();
							if (totalMonth >= 18) {
								itr.remove();
								System.out.println("succefully remove");
							}
						}
						
						break;
					case 5:
						for(Watch w:watches) {
							System.out.println(w);
						}
						break;

					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println("Exception:" + e);
					e.printStackTrace();

				}
			}

		}

	}
}
