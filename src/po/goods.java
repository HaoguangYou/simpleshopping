package po;

public class goods {
 private int id;
 private String  gid;
 private String broadId;
 private String goodsName;
 private String start;
 private String manufacturer;
 private String price;
 private String image;
 private String describe;
 
 //引进其他实体类
 private goodsDetails goodsdetails;
 
 
 
public goodsDetails getGoodsdetails() {
	return goodsdetails;
}
public void setGoodsdetails(goodsDetails goodsdetails) {
	this.goodsdetails = goodsdetails;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGid() {
	return gid;
}
public void setGid(String gid) {
	this.gid = gid;
}
public String getBroadId() {
	return broadId;
}
public void setBroadId(String broadId) {
	this.broadId = broadId;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getDescribe() {
	return describe;
}
public void setDescribe(String describe) {
	this.describe = describe;
}
 
}
