package cn.demo.entity;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 	实体类
 * @author 黄震
 *
 */
public class User {
	/**
	 * id 
	 */
	private Integer id; 
	
	/**
	 * 	用户编码
	 */
	@NotEmpty(message="登录名称不能为空")
	private String userCode; 
	
	/**
	 * 	用户名称
	 */
	@NotEmpty(message="用户名称不能为空")
	private String userName;
	
	/**
	 * 	用户密码
	 */
	@NotEmpty(message="用户密码不能为空")
	@Length(min=6,max=10,message="密码长度为6-10位")
	private String userPassword;
	
	/**
	 * 	性别
	 */
	private Integer gender;
	
	/**
	 * 	出生日期
	 */
	@Past(message="出生日期必须是一个过去的时间")
	/*@DateTimeFormat(pattern="yyy-MM-dd")*/
	@JSONField(format="yyyy-MM-dd")
	private Date birthday;
	
	/**
	 * 	电话
	 */
	private String phone; 
	
	/**
	 * 	地址
	 */
	private String address; 
	
	/**
	 * 	用户角色
	 */
	private Integer userRole;
	
	/**
	 * 	用户角色名称
	 */
	private String userRoleName;
	
	/**
	 * 	创建者
	 */
	private Integer createdBy;
	
	/**
	 * 	创建时间
	 */
	private Date creationDate;
	
	/**
	 * 	更新者
	 */
	private Integer modifyBy;
	
	/**
	 * 	更新时间
	 * @return
	 */
	private Date modifyDate;
	
	/**
	 * 个人证件照
	 * @return
	 */
	private String idPicPath;
	
	
	/**
	 * 	工作证件照
	 * @return
	 */
	private String wokPicPath;
	
	
	public String getWokPicPath() {
		return wokPicPath;
	}
	public void setWokPicPath(String wokPicPath) {
		this.wokPicPath = wokPicPath;
	}
	public String getIdPicPath() {
		return idPicPath;
	}
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
