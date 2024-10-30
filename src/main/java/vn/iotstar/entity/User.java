package vn.iotstar.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor

@AllArgsConstructor

@Data

@Entity

@Table(name = "users")

@NamedQuery(name = "User.findAll", query = "SELECT v FROM User v")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")

	private int id;

	@Column(name = "username", columnDefinition = "nvarchar(50) null")

	private String username;

	@Column(name = "password", columnDefinition = "nvarchar(50) null")

	private String password;

	@Column(name = "images", columnDefinition = "nvarchar(50) null")

	private String images;

	@Column(name = "fullname", columnDefinition = "nvarchar(50) null")

	private String fullname;

	@Column(name = "email", columnDefinition = "nvarchar(50) null")

	private String email;

	@Column(name = "phone", columnDefinition = "nvarchar(50) null")

	private String phone;

	@Column(name = "createDate")

	private Date createDate;

}