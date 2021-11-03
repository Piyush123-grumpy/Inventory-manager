
public class registration {
	private int sn;
		private String user_name,first_name,last_name,password,confirm_password,Email,contact;
		registration(int sn, String user_name,String first_name,String last_name,String password,String confirm_password,String Email,String contact){
			this.sn=sn;
			this.user_name=user_name;
			this.first_name=first_name;
			this.last_name=last_name;
			this.password=password;
			this.confirm_password=confirm_password;
			this.Email=Email;
			this.contact=contact;
		}
		public String getUser_name() {
			return user_name;
		}
		public String getFirst_name() {
			return first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public String getPassword() {
			return password;
		}
		public String getConfirm_password() {
			return confirm_password;
		}
		public String getEmail() {
			return Email;
		}
		public String getContact() {
			return contact;
		}
		public int getSn() {
			return sn;
		}
		
	}
