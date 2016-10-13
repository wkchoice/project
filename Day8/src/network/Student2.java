package network;

	import java.io.Serializable;

	public class Student2 implements Serializable {
	 private String name;
	 private String addr;

	 public Student2(String name, String addr) {
	  this.name = name;
	  this.addr = addr;
	 }

	 public String getName() {
	  return name;
	 }
	 public String getAddr() {
	  return addr;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }
	 public void setAddr(String addr) {
	  this.addr = addr;
	 }

	 public String toString() {
	  StringBuffer sb = new StringBuffer();
	  sb.append("이름: " + name);
	  sb.append("\n");
	  sb.append("주소: " + addr);

	  return sb.toString();
	  }
	}
