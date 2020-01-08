package entities;

import java.util.ArrayList;
import java.util.List;

public class ArticleStorage<T extends Article> {
	private int capacity;
	private List<T> storageList = new ArrayList<>();

	public ArticleStorage(int capacity) {
		this.capacity = capacity;
	}

	public boolean addItem(T item) {
		return this.storageList.size() < this.capacity ? this.storageList.add(item) : false;
	}

	public boolean removeItem(T itemToBeRemoved) {
		return this.storageList.remove(itemToBeRemoved);
	}

	public int getCapacity() {
		return this.capacity;
	}

	public List<T> getStorageList() {
		return this.storageList;
	}
}
