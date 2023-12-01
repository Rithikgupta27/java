package customer;

public enum ServicePlan {
SILVER(1000),GOLD(2000),PLATINUM(3000),DIAMOND(4000);

private int plan;

private ServicePlan(int plan) {
	this.plan = plan;
}

public int getPlan() {
	return plan;
}

@Override
public String toString() {
	return name() +"plan price"+ plan;
}


}
