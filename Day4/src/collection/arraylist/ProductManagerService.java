package collection.arraylist;

import java.util.ArrayList;

public class ProductManagerService {
	private ArrayList productList = new ArrayList(50);
	
	public ProductManagerService() {
	}

	
	private boolean isNUll(Object obj) {
		boolean isNull = false;
		if (obj == null) isNull = true;
		return isNull;
	}
	
	public void addProduct(ProductDTO productDTO) {
		if (this.isNUll(productDTO)) return;
		if (this.searchProductById(productDTO.getProductId()) != null) return;
	}
	
	public ProductDTO searchProductById(String productId) {
		ProductDTO returnproductDTO = null;
		
		for (int i = 0; i < productList.size();i++) {
			if (((ProductDTO) productList.get(i)).getProductId().equals(productId)) {
				returnproductDTO = (ProductDTO) productList.get(i);
				break;
			}
		}
		
		return returnproductDTO;
	}
}
