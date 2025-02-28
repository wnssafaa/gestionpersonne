package models;

public class personne {
	private int id;
	private String nom;
	
	private int age;
	public personne(int id,String nom,int age) {
		this.id = id;
		this.nom = nom;
		
		this.age = age;
	}
	
	public personne(String nom,int age) {
		this.nom = nom;
		
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "personne [nom=" + nom + ", age=" + age + "]";
	}

}
