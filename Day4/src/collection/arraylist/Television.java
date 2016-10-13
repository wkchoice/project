package collection.arraylist;

public class Television extends ProductDTO {
    private boolean threeD;
    private boolean smartTV;
    private boolean usb;

    public Television() {
	}

	public Television(String productId, String productName, int producePrice, 
			String productMaker, String productInfo, boolean threeD, boolean smartTV, boolean usb) {
		super(productId, productName, producePrice, productMaker, productInfo);
		this.threeD = threeD;
		this.smartTV = smartTV;
		this.usb = usb;
	}

	public boolean isThreeD() {
		return threeD;
	}

	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}

	public boolean isSmartTV() {
		return smartTV;
	}

	public void setSmartTV(boolean smartTV) {
		this.smartTV = smartTV;
	}

	public boolean isUsb() {
		return usb;
	}

	public void setUsb(boolean usb) {
		this.usb = usb;
	}

	@Override
	public String toString() {
		return super.toString();
	}
    
    
}
