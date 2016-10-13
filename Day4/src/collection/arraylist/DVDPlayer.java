package collection.arraylist;

public class DVDPlayer extends ProductDTO {
	private String areaCode;
    private boolean bluelay;
    
    public DVDPlayer() {
	}

	public DVDPlayer(String productId, String productName, int producePrice, String productMaker, String productInfo,
			String areaCode, boolean bluelay) {
		super(productId, productName, producePrice, productMaker, productInfo);
		this.areaCode = areaCode;
		this.bluelay = bluelay;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public boolean isBluelay() {
		return bluelay;
	}

	public void setBluelay(boolean bluelay) {
		this.bluelay = bluelay;
	}

    
}
