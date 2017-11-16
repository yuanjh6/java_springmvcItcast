package cn.itcast.ssm.po;

import java.util.List;

public class QueryVo {

	private Orders orders;
	private Items items;
	
	private List<Items> itemsList;

	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public List<Items> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	
}
