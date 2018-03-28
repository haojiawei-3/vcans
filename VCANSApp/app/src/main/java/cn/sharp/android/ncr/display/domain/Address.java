package cn.sharp.android.ncr.display.domain;

public class Address extends BaseDomain {
	private static int ID = 0;

	public Address() {
		super(ID++);
	}
	public int type;
	public String value;
	public String postcode;

}
