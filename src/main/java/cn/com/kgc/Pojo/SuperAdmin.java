package cn.com.kgc.Pojo;


public class SuperAdmin {

  private long admin;
  private String adminName;
  private String adminPwd;

  public SuperAdmin() {
  }

  public SuperAdmin(long admin, String adminName, String adminPwd) {
    this.admin = admin;
    this.adminName = adminName;
    this.adminPwd = adminPwd;
  }

  public long getAdmin() {
    return admin;
  }

  public void setAdmin(long admin) {
    this.admin = admin;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getAdminPwd() {
    return adminPwd;
  }

  public void setAdminPwd(String adminPwd) {
    this.adminPwd = adminPwd;
  }

}
