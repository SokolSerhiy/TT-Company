package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int money;
	@Transient
	private int allmoney;
	
	private int level;
	@ManyToOne(fetch=FetchType.LAZY)
	private Company parent;
	@OneToMany(mappedBy="parent")
	private List<Company> childs = new ArrayList<>();
	
	public int getAllmoney() {
		return allmoney;
	}

	public void setAllmoney(int allmoney) {
		this.allmoney = allmoney;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getParent() {
		return parent;
	}

	public void setParent(Company parent) {
		this.parent = parent;
		if(parent!=null){
			setLevel(parent.level+1);
		}
	}

	public List<Company> getChilds() {
		return childs;
	}

	public void setChilds(List<Company> childs) {
		this.childs = childs;
	}
}
