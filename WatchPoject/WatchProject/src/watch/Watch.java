package watch;

import java.time.LocalDate;

import watchUtil.Brand;
import watchUtil.Category;
import watchUtil.Shape;
import watchUtil.Style;
import watchUtil.WatchBandMaterial;

public class Watch {
	private static int id = 100;
	private String name;
	private Category ctgy;
	private Brand watchBrand;
	private Shape watchShape;
	private Style watchStyle;
	private WatchBandMaterial watchMaterial;
	private int SQty;
	private LocalDate SLDate;
	private LocalDate SUDate;
	private double price;
	private double discount = 0.0;

	public Watch(String name, Category ctgy, Brand watchBrand, Shape watchShape, Style watchStyle,
			WatchBandMaterial watchMaterial, int sQty, LocalDate sLDate, LocalDate sUDate, double price) {
		super();
		this.name = name;
		this.ctgy = ctgy;
		this.watchBrand = watchBrand;
		this.watchShape = watchShape;
		this.watchStyle = watchStyle;
		this.watchMaterial = watchMaterial;
		SQty = sQty;
		SLDate = sLDate;
		SUDate = sUDate;
		this.price = price;
		++id;
	}

	@Override
	public String toString() {
		return "Watch [Name=" + name + ", ctgy=" + ctgy + ", watchBrand=" + watchBrand + ", watchShape=" + watchShape
				+ ", watchStyle=" + watchStyle + ", watchMaterial=" + watchMaterial + ", SQty=" + SQty + ", SLDate="
				+ SLDate + ", SUDate=" + SUDate + ", price=" + price + ", discount=" + discount + "]";
	}

	public static int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCtgy() {
		return ctgy;
	}

	public Brand getWatchBrand() {
		return watchBrand;
	}

	public Shape getWatchShape() {
		return watchShape;
	}

	public Style getWatchStyle() {
		return watchStyle;
	}

	public WatchBandMaterial getWatchMaterial() {
		return watchMaterial;
	}

	public int getSQty() {
		return SQty;
	}

	public LocalDate getSLDate() {
		return SLDate;
	}

	public LocalDate getSUDate() {
		return SUDate;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	public static void setId(int id) {
		Watch.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCtgy(Category ctgy) {
		this.ctgy = ctgy;
	}

	public void setWatchBrand(Brand watchBrand) {
		this.watchBrand = watchBrand;
	}

	public void setWatchShape(Shape watchShape) {
		this.watchShape = watchShape;
	}

	public void setWatchStyle(Style watchStyle) {
		this.watchStyle = watchStyle;
	}

	public void setWatchMaterial(WatchBandMaterial watchMaterial) {
		this.watchMaterial = watchMaterial;
	}

	public void setSQty(int sQty) {
		SQty = sQty;
	}

	public void setSLDate(LocalDate sLDate) {
		SLDate = sLDate;
	}

	public void setSUDate(LocalDate sUDate) {
		SUDate = sUDate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
