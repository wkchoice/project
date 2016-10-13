package collection.arraylist;

public class ProductDTO {
	private String productId;
	private String productName;
	private int producePrice;
	private String productMaker;
	private String productInfo;
	
	public ProductDTO() {	}
	
	public ProductDTO(String productId, String productName, int producePrice, String productMaker, String productInfo) {
		this.productId = productId;
		this.productName = productName;
		this.producePrice = producePrice;
		this.productMaker = productMaker;
		this.productInfo = productInfo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProducePrice() {
		return producePrice;
	}

	public void setProducePrice(int producePrice) {
		this.producePrice = producePrice;
	}

	public String getProductMaker() {
		return productMaker;
	}

	public void setProductMaker(String productMaker) {
		this.productMaker = productMaker;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	@Override
	public String toString() {
		String productPrice;
		return productId+" "+productName+" "+producePrice+" ";
		
	}
	
}