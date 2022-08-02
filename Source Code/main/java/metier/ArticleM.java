package metier;

public class ArticleM {
	private Integer code;
	private String Nom;
	private String desc;
	private Integer prix;
	private Integer qte;
	private String image;
	
	public ArticleM(Integer code, String nom, String desc, Integer prix,Integer qte,String image) {
		super();
		this.code = code;
		this.Nom = nom;
		this.desc = desc;
		this.prix = prix;
		this.qte=qte;
		this.image=image;
		
	}
	//Getter et Setters
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ArticleM() {
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
}
